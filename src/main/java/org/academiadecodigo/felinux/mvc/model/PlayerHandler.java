package org.academiadecodigo.felinux.mvc.model;

import org.academiadecodigo.felinux.service.BootStrap;

import java.net.Socket;

public class PlayerHandler implements Runnable{


    private Socket socket;

    public PlayerHandler(Socket socket) {

        this.socket = socket;
    }

    @Override
    public void run() {

        BootStrap.initPlayer(this).init();
    }

    public Socket getSocket() {
        return socket;
    }
}
