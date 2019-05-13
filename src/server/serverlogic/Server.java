package server.serverlogic;

import server.IndexController;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread{
    private IndexController controller;
    public static final int PORT = 9000;

    private ServerSocket serverSocket;
    private boolean online;

    public Server(IndexController controller) {
        this.controller = controller;
        online = true;
        start();
    }

    public synchronized void shutDown(){
        online = false;
        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run(){
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server listening on port: " + PORT);
            while(online){
                Socket socket = serverSocket.accept();
                // make response thread
                new Responder(socket,controller);
            }
        } catch (IOException e) {
            if(serverSocket.isClosed())
                System.out.println("Connection closed");
        }
        System.out.println("Server shutdown");
    }
}
