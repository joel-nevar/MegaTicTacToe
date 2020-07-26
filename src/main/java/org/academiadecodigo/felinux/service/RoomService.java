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

        PlayerController[] players = new PlayerController[]{playerController1,playerController2};

        //todo change this loop's condition

        while(true) {

            playARound(players);
        }
    }

    private void playARound(PlayerController[] players) {

        for(PlayerController player: players){

            player.resetMove();
            player.listenToPlayer();
            room.broadcast(player.getLastMove());
        }
    }
}
