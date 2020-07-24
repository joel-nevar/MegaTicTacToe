package org.academiadecodigo.felinux.mvc.model;

import org.academiadecodigo.felinux.mvc.controller.player.PlayerController;

import java.net.Socket;

/**
 * Player Mini Main, start everything on PlayerController
 */
public class PlayerHandler implements Runnable{


    private Socket socket;

    public PlayerHandler(Socket socket){

        this.socket = socket;
    }

    @Override
    public void run() {

        PlayerController playerController = new PlayerController();
        playerController.setSocket(socket);
        playerController.init();
    }
}
