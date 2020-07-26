package org.academiadecodigo.felinux.service;

import org.academiadecodigo.felinux.mvc.controller.MultiPlayerController;
import org.academiadecodigo.felinux.mvc.model.AbstractRoom;
import org.academiadecodigo.felinux.mvc.model.Room;

public class RoomService extends AbstractRoomService{


    private Room room;

    public RoomService(AbstractRoom room){

        super(room);
        this.room = (Room) room;
    }

    @Override
    protected boolean playARound(MultiPlayerController[] players) {

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

    protected void applyMove(MultiPlayerController player, String lastMove) {

        if (!GameService.setValue(room.getGrid(), lastMove, player.getPlayerNumber())){

            player.receive("That position is full!\n");
            getPlayerInput(player);
        }
    }
}
