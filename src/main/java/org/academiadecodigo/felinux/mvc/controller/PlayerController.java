package org.academiadecodigo.felinux.mvc.controller;

import org.academiadecodigo.felinux.mvc.model.PlayerHandler;
import org.academiadecodigo.felinux.mvc.view.GameView;

public class PlayerController implements Controller {


    private GameView playerScreen;
    private PlayerHandler player;

    @Override
    public void init() {

        //todo flag to stop this
        while (true){

            System.out.println("hm");
            startGame();
        }
    }

    private void startGame() {

        if(player.isYourTurn()){

            receive();
            player.setYourTurn();
            return;
        }

        playerScreen.show();
        player.setYourTurn();
    }

    public void setView(GameView playerScreen) {

        this.playerScreen = playerScreen;
    }

    public void setPlayer(PlayerHandler playerHandler) {

        this.player = playerHandler;
    }

    public void receive(){

        String message = player.getRoom().removeFromQueue();
        System.out.println(message);
        playerScreen.setMessage(message);
        playerScreen.show();
    }

    public void transmit(String message){

        player.getRoom().addToQueue(message);
        System.out.println(message);
    }
}
