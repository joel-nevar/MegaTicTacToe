package org.academiadecodigo.felinux.mvc.controller;

import org.academiadecodigo.felinux.mvc.model.PlayerHandler;
import org.academiadecodigo.felinux.mvc.view.GameView;

public class PlayerController implements Controller {


    private GameView view;
    private PlayerHandler player;

    @Override
    public void init() {

        view.setMessage("Your Play?");

        gameLoop();
    }

    private void gameLoop(){

        while(player.getSocket().isBound()){

            System.out.println(player + " " +player.isYourTurn());

            while (!player.isYourTurn()){

                try {

                    wait();
                    player.changeTurns();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            listenToPlayer();
            notifyAll();
            System.out.println(player.isYourTurn());
        }
    }

    private void listenToPlayer() {

        view.show();
    }

    public void setView(GameView playerScreen) {

        this.view = playerScreen;
    }

    public void setPlayer(PlayerHandler playerHandler) {

        this.player = playerHandler;
    }

    public void receive(String message){

        view.sendMessage(message);
    }

    public void transmit(String message){

        player.getRoom().broadcast(message);
    }
}
