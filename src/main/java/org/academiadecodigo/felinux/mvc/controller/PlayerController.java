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
        view.setMessage("Your Play?");
        view.show();
        System.out.print("Room service " + room.getRoomService());
        room.getRoomService().gameLoop();
      //  gameLoop();
    }

    private void gameLoop(){
        this.room = player.getRoom();
        System.out.println(player + " " +player.isYourTurn());

        if(player.isYourTurn()){
            System.out.println(Thread.currentThread().getName());
            listenToPlayer();
            notifyAll();
            room.changeTurns();
        }else{

       // player.changeTurns();
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        gameLoop();
        }
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
