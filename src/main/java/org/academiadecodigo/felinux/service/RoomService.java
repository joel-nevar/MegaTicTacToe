package org.academiadecodigo.felinux.service;

import org.academiadecodigo.felinux.mvc.controller.MultiPlayerController;
import org.academiadecodigo.felinux.mvc.model.PlayerHandler;
import org.academiadecodigo.felinux.mvc.model.Room;
import org.academiadecodigo.felinux.mvc.model.cell.CellValueType;

public class RoomService {


    private Room room;
    private MultiPlayerController multiPlayerController1;
    private MultiPlayerController multiPlayerController2;

    public RoomService(Room room){

        this.room =room;
    }

    public void gameLoop(){

        PlayerHandler player1 = room.getPlayer1();
        PlayerHandler player2 = room.getPlayer2();

        multiPlayerController1 = player1.getMultiPlayerController();
        multiPlayerController2 = player2.getMultiPlayerController();

        MultiPlayerController[] players = new MultiPlayerController[]{multiPlayerController1, multiPlayerController2};

        //todo change this loop's condition

        while(player1.getSocket().isBound()&&player2.getSocket().isBound()) {

            playARound(players);
        }

        room.broadcast("Player Disconnected");
    }

    private void playARound(MultiPlayerController[] players) {

        for(MultiPlayerController player: players){

            room.broadcast(room.getGrid().drawGameBoard());


            player.listenToPlayer();

            applyMove(player,player.getLastMove()); //todo gameLOGIC HERE

            while(player.getLastMove()!= null){
                player.resetMove();
            }
        }
    }

    private void applyMove(MultiPlayerController player, String lastMove) {

        if(player == multiPlayerController1) {

            if (!GameService.setValue(room.getGrid(), lastMove, CellValueType.PLAYER_1)){


            }
            return;
        }

        if (!GameService.setValue(room.getGrid(), lastMove, CellValueType.PLAYER_2)){

        }
    }
}
