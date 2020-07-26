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

        playerController1 = player1.getPlayerController();
        playerController2 = player2.getPlayerController();

        PlayerController[] players = new PlayerController[]{playerController1,playerController2};

        //todo change this loop's condition

        while(player1.getSocket().isBound()&&player2.getSocket().isBound()) {

            playARound(players);
        }

        room.broadcast("Player Disconnected");
    }

    private void playARound(PlayerController[] players) {

        for(PlayerController player: players){

            room.broadcast(room.getGrid().drawGameBoard());
            player.listenToPlayer();
            room.broadcast(player.getLastMove()); //todo gameLOGIC HERE

            while(player.getLastMove()!= null){
                player.resetMove();
            }
        }
    }
}
