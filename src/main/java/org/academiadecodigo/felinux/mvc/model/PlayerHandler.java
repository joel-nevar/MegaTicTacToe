package org.academiadecodigo.felinux.mvc.model;

import org.academiadecodigo.felinux.mvc.controller.PlayerController;
import org.academiadecodigo.felinux.service.BootStrap;

import java.net.Socket;

public class PlayerHandler implements Runnable{


    private Socket socket;
    private PlayerController controller;
    private Room room;
    private boolean yourTurn;

    public PlayerHandler(Socket socket) {

        this.socket = socket;
    }

    @Override
    public void run() {

        System.out.println("ta aqui uma bela merda");
        controller = BootStrap.initPlayer(this);
        System.out.println("reeeeeeeeeeee");
        controller.init();
    }

    public Socket getSocket() {
        return socket;
    }

    public PlayerController getController() {
        return controller;
    }

    public boolean isYourTurn() {
        return yourTurn;
    }

    public void setYourTurn() {

        if(yourTurn){
            yourTurn=false;
            return;
        }

        yourTurn = true;
    }

    public void setRoom(Room room) {
        this.room = room;
        System.out.println(room);
    }

    public Room getRoom() {
        return room;
    }
}
