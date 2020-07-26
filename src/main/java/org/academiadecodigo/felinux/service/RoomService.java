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
        multiPlayerController1.setPlayerNumber(CellValueType.PLAYER_1);

        multiPlayerController2 = player2.getMultiPlayerController();
        multiPlayerController2.setPlayerNumber(CellValueType.PLAYER_2);

        MultiPlayerController[] players = new MultiPlayerController[]{multiPlayerController1, multiPlayerController2};

        //todo change this loop's condition

        while(playARound(players)) { }
    }

    private boolean playARound(MultiPlayerController[] players) {

        for(MultiPlayerController player: players){

            room.broadcast(room.getGrid().drawGameBoard());
            getPlayerInput(player);

            if(GameService.hasWon(room.getGrid(),player.getPlayerNumber())){

                room.broadcast(room.getGrid().drawGameBoard());
                player.receive("You won!");
                room.broadcast(player.getPlayerNumber() + " has won the game!");
                return false;
            }

            if(GameService.hasTied(room.getGrid())){
                room.broadcast(room.getGrid().drawGameBoard());
                room.broadcast("The game ended in a draw");
                return false;
            }
        }

        return true;
    }

    private void getPlayerInput(MultiPlayerController player) {

        player.listenToPlayer();
        applyMove(player,player.getLastMove());
    }

    private void applyMove(MultiPlayerController player, String lastMove) {

        if (!GameService.setValue(room.getGrid(), lastMove, player.getPlayerNumber())){

            player.receive("That position is full!\n");
            getPlayerInput(player);
        }
    }
}
