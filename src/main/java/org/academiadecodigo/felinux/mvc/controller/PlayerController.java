package org.academiadecodigo.felinux.mvc.controller;

import org.academiadecodigo.felinux.mvc.model.PlayerHandler;
import org.academiadecodigo.felinux.mvc.view.GameView;

public class PlayerController implements Controller {


    private GameView playerScreen;
    private PlayerHandler player;

    @Override
    public void init() {

        //todo flag to stop this

        player.getRoom().broadcast("Player has joined the room");

        while (true){

            startGame();
        }
    }

    private void startGame() {

        System.out.println("maybe");
        playerScreen.show();
    }

    public void setView(GameView playerScreen) {

        this.playerScreen = playerScreen;
    }

    public void setPlayer(PlayerHandler playerHandler) {

        this.player = playerHandler;
    }

    public void receive(String message){

        playerScreen.setMessage(message);
        playerScreen.show();
    }

    public void transmit(String message){

        player.getRoom().broadcast(message);
    }
}
