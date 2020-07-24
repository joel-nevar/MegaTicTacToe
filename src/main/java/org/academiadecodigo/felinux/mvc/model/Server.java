package org.academiadecodigo.felinux.mvc.model;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {


    private ServerSocket serverSocket;
    private ExecutorService threadPool;
    private final int THREAD_COUNT = 5;

    public Server(int port) throws IOException {

        this.serverSocket = new ServerSocket(port);
        threadPool = Executors.newFixedThreadPool(THREAD_COUNT);
    }

    public void start() throws IOException{

        System.out.println("Server Online, Waiting connection\n");
        acceptConnection();
    }

    private void acceptConnection() throws IOException {

        //serverLoop
        threadPool.submit(new PlayerHandler(serverSocket.accept()));
        System.out.println("Client Found");
        acceptConnection();
    }
}
