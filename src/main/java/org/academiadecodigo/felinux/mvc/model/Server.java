package org.academiadecodigo.felinux.mvc.model;

import org.academiadecodigo.felinux.mvc.controller.CentralService;
import org.academiadecodigo.felinux.service.BootStrap;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {


    private ServerSocket serverSocket;
    public static final ExecutorService THREAD_POOL = Executors.newCachedThreadPool();
    private int playerCount = 0;


    public Server(int port) throws IOException {

        this.serverSocket = new ServerSocket(port);
        //threadPool = Executors.newCachedThreadPool();
    }

    public void start() throws IOException{

        System.out.println("Server Online, Waiting connection\n");
        acceptConnection();
    }

    private void acceptConnection() throws IOException {

        if(THREAD_POOL.isShutdown() || THREAD_POOL.isTerminated()){
            System.out.println("Players connected: " + --playerCount + "/2");
        }

        //serverLoop
        PlayerHandler playerHandler = new PlayerHandler(serverSocket.accept());
        BootStrap.initPlayer(playerHandler);
        //centralController.registerPlayer(playerHandler);

        THREAD_POOL.submit(playerHandler);
        System.out.println("Players connected: " + ++playerCount);
        acceptConnection();
    }
    public void subtractPlayerCount(){
        playerCount--;
        System.out.println("Player left server. \nPlayers connected: " + playerCount);
    }
}
