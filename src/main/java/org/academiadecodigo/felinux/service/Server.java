package org.academiadecodigo.felinux.service;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {
    ServerSocket serverSocket;

    public Server() throws IOException {
        this.serverSocket = new ServerSocket();
    }
}
