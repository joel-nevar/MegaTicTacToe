package org.academiadecodigo.felinux.mvc.model;

import java.net.Socket;

public class PlayerHandler implements Runnable{


    private Socket socket;

    public PlayerHandler(Socket socket){

        this.socket = socket;
    }

    @Override
    public void run() {

    }
}
