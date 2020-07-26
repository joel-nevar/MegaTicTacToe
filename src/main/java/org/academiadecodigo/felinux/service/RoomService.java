package org.academiadecodigo.felinux.service;

import org.academiadecodigo.felinux.mvc.controller.PlayerController;
import org.academiadecodigo.felinux.mvc.model.PlayerHandler;
import org.academiadecodigo.felinux.mvc.model.Room;
import org.academiadecodigo.felinux.mvc.view.GameView;

public class RoomService {
    private Room room;
    private PlayerController playerController1;
    private PlayerController playerController2;


    public RoomService(Room room){
        this.room =room;
    }

    public void gameLoop(){

        PlayerHandler player1 = room.getPlayer1();
        PlayerHandler player2 = room.getPlayer2();

        playerController1 = player1.getController();
        playerController2 = player2.getController();


        while(true) {

            if(player1.isYourTurn()) {
                playerController1.listenToPlayer();
                player1.setYourTurn(false);
                player2.setYourTurn(true);
            }

           if(player2.isYourTurn()) {
               playerController2.listenToPlayer();
               player2.setYourTurn(false);
               player1.setYourTurn(true);
           }
        }
    }
}
