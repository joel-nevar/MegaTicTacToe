package org.academiadecodigo.felinux.service;

import org.academiadecodigo.felinux.mvc.controller.MultiAbstractController;
import org.academiadecodigo.felinux.mvc.model.AbstractRoom;
import org.academiadecodigo.felinux.mvc.model.MegaRoom;
import org.academiadecodigo.felinux.mvc.model.cell.CellValueType;
import org.academiadecodigo.felinux.mvc.model.grid.Grid;

public class MegaRoomService extends AbstractRoomService {


    private Grid currentPlayableGrid;
    private boolean completedGrid;
    private boolean validGrid;
    private MegaRoom room;
    private Grid currentTarget;

    public MegaRoomService(AbstractRoom room) {

        super(room);
        this.room = (MegaRoom) room;

    }

    @Override
    protected boolean playARound(MultiAbstractController[] players) {

        for(MultiAbstractController player: players){

            room.broadcast(room.getSuperGrid().drawGameBoard());
            getPlayerInput(player);
            System.out.println("MMS");
        }

        return true;
    }

    @Override
    protected void applyMove(MultiAbstractController player, String lastMove) {


        if(!validGrid){

            currentTarget = GameService.changeGrid(room.getSuperGrid(),lastMove);
            validGrid = checkValidGrid(currentTarget,player);
            getPlayerInput(player);
            return;
        }

        completedGrid = false;
        //gridcheck ends here

        //now its the cells of the grid

        if (!GameService.setValue(currentTarget, lastMove, player.getPlayerNumber())){

            player.receive("That position is full!\n");
            getPlayerInput(player);
            return;
        }

        if(playOnGrid(player,currentTarget)){

        }
    }

    public void setCurrentGrid(Grid grid){

        this.currentPlayableGrid = grid;
    }

    protected boolean playOnGrid(MultiAbstractController player, Grid currentTarget){

        if(GameService.hasWon(room.getSuperGrid(),player.getPlayerNumber())){

            room.broadcast(room.getSuperGrid().drawGameBoard());
            return true;
        }

        if(GameService.hasTied(currentTarget)){
            room.broadcast(room.getSuperGrid().drawGameBoard());
            return true;
        }

        return true;
    }

    protected boolean checkValidGrid(Grid currentTarget, MultiAbstractController player){

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

