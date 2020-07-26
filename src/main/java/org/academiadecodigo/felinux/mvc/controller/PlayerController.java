package org.academiadecodigo.felinux.mvc.controller;

import org.academiadecodigo.felinux.mvc.model.PlayerHandler;
import org.academiadecodigo.felinux.mvc.model.Room;
import org.academiadecodigo.felinux.mvc.view.GameView;
import org.w3c.dom.ls.LSOutput;

public class PlayerController implements Controller {

    private Room room;
    private GameView view;
    private PlayerHandler player;

    @Override
    public void init() {
        this.room = player.getRoom();

        view.setMessage("Your Move?");

        view.show();

        room.getRoomService().gameLoop();
      //gameLoop();
    }

    public void listenToPlayer() {
        System.out.println(Thread.currentThread().getName());
        view.show();
    }

    public void receive(String message){

        view.sendMessage(message);
    }

    public void transmit(String message){

        player.getRoom().broadcast(message);
    }
    public void setView(GameView playerScreen) {

        this.view = playerScreen;
    }

    public void setPlayer(PlayerHandler playerHandler) {

        this.player = playerHandler;
    }


}
