package org.academiadecodigo.felinux.mvc.model;

import org.academiadecodigo.felinux.mvc.controller.MainController;
import org.academiadecodigo.felinux.mvc.controller.MultiPlayerController;

import java.net.Socket;

public class PlayerHandler implements Runnable{


    private Socket socket;
    private MainController controller;
    private MultiPlayerController multiPlayerController;
    private Room room;

    public PlayerHandler(Socket socket) {

        this.socket = socket;
    }

    @Override
    public void run() {
        controller.init();
        System.out.println(Thread.currentThread().getName());
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

    public MultiPlayerController getMultiPlayerController() {
        return multiPlayerController;
    }

    public void setMultiPlayerController(MultiPlayerController multiPlayerController) {
        this.multiPlayerController = multiPlayerController;
    }
}
