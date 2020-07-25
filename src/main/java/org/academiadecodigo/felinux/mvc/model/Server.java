package org.academiadecodigo.felinux.mvc.model;

import org.academiadecodigo.felinux.mvc.controller.CentralController;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {


    private ServerSocket serverSocket;
    private ExecutorService threadPool;
    private final int THREAD_COUNT = 5;
    private CentralController centralController;

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
        PlayerHandler playerHandler = new PlayerHandler(serverSocket.accept());
        centralController.registerPlayer(playerHandler);
        threadPool.submit(playerHandler);

        System.out.println("Client Found");
        acceptConnection();
    }

    public void setCentralController(CentralController centralController) {
        this.centralController = centralController;
    }
}
