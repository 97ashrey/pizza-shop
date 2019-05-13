package requesthandler;

import com.sun.org.apache.xpath.internal.operations.Or;
import order.Order;
import order.PaymentMethod;
import pizza.Pizza;
import pizza.decorations.DecorationType;
import pizza.factories.PizzaFactory;
import pizza.pizas.PizzaType;
import serializeobject.SerializeController;
import server.serverlogic.Server;
import server.serverlogic.ServerRoute;

import java.io.*;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class RequestHandler {
    private BufferedReader in;
    private PrintWriter out;
    private InetAddress address;
    private Socket socket;
    private int port = Server.PORT;

    private boolean openConnection(){
        try {
            address = InetAddress.getByName("127.0.0.1");
            socket = new Socket(address,port);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);
            return socket.isConnected();
        } catch (UnknownHostException e) {
           e.printStackTrace();
        } catch (ConnectException e){
            System.out.println("Server not online");
        }
        catch (IOException e) {
             e.printStackTrace();
        }
        return false;
    }

    public String order(Order order){
        boolean connected = openConnection();
        if(!connected)
            return "Server not online connection refused";

        String data = SerializeController.serialize(order);
        String route = ServerRoute.ORDER;
        String request = route + ":" + data;
        // send request
        out.println(request);
        return getResponse();
    }

    private String getResponse(){
        String response = "";
        try {
            response = in.readLine();
            System.out.println("Server responded with " + response);
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            close();
            return response;
        }
    }

    private void close(){
        try {
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
