package org.academiadecodigo.felinux.mvc.model;

import org.academiadecodigo.felinux.mvc.controller.MainController;

import java.net.Socket;

public class PlayerHandler implements Runnable{


    private Socket socket;
    private MainController controller;
    private Room room;

    public PlayerHandler(Socket socket) {

        this.socket = socket;
    }

    @Override
    public void run() {
        controller.init();
    }

    public void setController(MainController controller) {

        this.controller = controller;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Room getRoom() {
        return room;
    }

    public Socket getSocket() {
        return socket;
    }

    public MainController getController() {
        return controller;
    }
}
