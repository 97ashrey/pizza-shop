package server.serverlogic;

import order.CookOrder;
import order.Order;
import serializeobject.SerializeController;
import server.IndexController;

import java.io.*;
import java.net.Socket;

public class Responder extends Thread {
    private IndexController controller;
    private Socket clinetSocket;

    private BufferedReader in;
    private PrintWriter out;

    public Responder(Socket socket, IndexController controller){
        this.controller = controller;
        this.clinetSocket = socket;
        try {
            in = new BufferedReader(new InputStreamReader(clinetSocket.getInputStream()));
            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(clinetSocket.getOutputStream())),true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        start();
    }

    private void router(String route,String data){
        System.out.println("Route is " + route);
        switch (route){
            case ServerRoute.ORDER:
                orderHandler(data);
            break;
            default:
                out.println("The route \"" +  route + "\" you provided was wrong");
        }
    }

    private void orderHandler(String data){
        System.out.println("Order handler");
        Order order = (Order) SerializeController.deserialize(data);
        if(order != null){
            CookOrder cookOrder = new CookOrder(order,controller);
            int time = order.getTime();
            cookOrder.start();
            out.println("Your order will be done in " + time + " minutes");

        } else{
            out.println("Something was wrong with the order you provided please try again");
        }
    }

    public void run(){
        // Read the request
        try {
            String request = in.readLine();
            String[] splitRequest = request.split(":");
            String route = splitRequest[0];
            String data = splitRequest[1];
            router(route,data);

            in.close();
            out.close();
            clinetSocket.close();
            System.out.println("Connection closed");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
