package org.academiadecodigo.felinux.mvc.controller.player;

import org.academiadecodigo.felinux.mvc.controller.Controller;

import java.net.Socket;

public class PlayerController implements Controller {


    private Socket playerSocket;

    @Override
    public void init() {

        //initialize everything here that goes with the player
    }

    public void setSocket(Socket socket) {

        this.playerSocket = socket;
    }
}
