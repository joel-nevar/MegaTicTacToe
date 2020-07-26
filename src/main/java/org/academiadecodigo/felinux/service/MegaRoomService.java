package org.academiadecodigo.felinux.service;

import org.academiadecodigo.felinux.mvc.controller.MegaModeController;
import org.academiadecodigo.felinux.mvc.controller.MultiPlayerController;
import org.academiadecodigo.felinux.mvc.model.AbstractRoom;
import org.academiadecodigo.felinux.mvc.model.MegaRoom;
import org.academiadecodigo.felinux.mvc.model.cell.CellValueType;
import org.academiadecodigo.felinux.mvc.model.grid.Grid;

public class MegaRoomService extends AbstractRoomService {


    private Grid currentPlayableGrid;
    private boolean completedGrid;
    private MegaRoom room;

    public MegaRoomService(AbstractRoom room) {

        super(room);
        this.room = (MegaRoom) room;

    }

    @Override
    protected boolean playARound(MultiPlayerController[] players) {

        for(MultiPlayerController player: players){

            room.broadcast(room.getSuperGrid().drawGameBoard());
            getPlayerInput(player);
        }

        return true;
    }

    protected void applyMove(MultiPlayerController player, String lastMove) {

        Grid currentTarget = GameService.changeGrid(room.getSuperGrid(),lastMove);

        if(!checkValidGrid(currentTarget,player,lastMove)){

            getPlayerInput(player);
        }

        completedGrid = false;

        if (!GameService.setValue(currentTarget, lastMove, player.getPlayerNumber())){

            player.receive("That position is full!\n");
            getPlayerInput(player);
        }
    }

    public void setCurrentGrid(Grid grid){

        this.currentPlayableGrid = grid;
    }

    protected boolean PlayOnGrid(){

        if(GameService.hasWon(room.getSuperGrid(),player.getPlayerNumber())){

            room.broadcast(room.getGrid().drawGameBoard());
            player.receive("You won!");
            room.broadcast(player.getPlayerNumber() + " has won the game!");
            return false;
        }

        if(GameService.hasTied(room.getGrid())){
            room.broadcast(room.getSuperGrid().drawGameBoard());
            room.broadcast("The game ended in a draw");
            return false;
        }
    }

    protected boolean checkValidGrid(Grid currentTarget, MegaModeController player, String lastMove){

        if(currentTarget.getValue() != CellValueType.EMPTY){

            player.receive("That square is already complete");
            getPlayerInput(player);
            return false;
        }

        if(completedGrid){

            if(currentTarget != currentPlayableGrid) {
                player.receive("You cannot play in that square");
                getPlayerInput(player);
                return false;
            }
        }

        return true;
    }
}

