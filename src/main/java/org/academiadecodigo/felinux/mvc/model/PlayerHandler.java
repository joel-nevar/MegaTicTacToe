package org.academiadecodigo.felinux.mvc.model;

import org.academiadecodigo.felinux.mvc.controller.PlayerController;

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

        controller.init();
    }

    public Socket getSocket() {
        return socket;
    }

    public PlayerController getController() {
        return controller;
    }

    public boolean checkTurn() {
        return yourTurn;
    }

    public void setController(PlayerController controller) {

        this.controller = controller;
    }

    public void changeTurns() {

        if(yourTurn){
            yourTurn=false;
            return;
        }

        yourTurn = true;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Room getRoom() {
        return room;
    }
}
