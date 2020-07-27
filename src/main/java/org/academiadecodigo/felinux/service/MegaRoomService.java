package org.academiadecodigo.felinux.service;

import org.academiadecodigo.felinux.mvc.controller.MultiAbstractController;
import org.academiadecodigo.felinux.mvc.model.AbstractRoom;
import org.academiadecodigo.felinux.mvc.model.MegaRoom;
import org.academiadecodigo.felinux.mvc.model.PlayerHandler;
import org.academiadecodigo.felinux.mvc.model.Server;
import org.academiadecodigo.felinux.mvc.model.cell.CellValueType;
import org.academiadecodigo.felinux.mvc.model.grid.Grid;

public class MegaRoomService extends AbstractRoomService {


    private Grid currentPlayableGrid;
    private boolean completedGrid;
    private boolean validGrid;
    private MegaRoom room;
    private Grid targetGrid;

    public MegaRoomService(AbstractRoom room) {

        super(room);
        this.room = (MegaRoom) room;

    }
    @Override
    public void gameLoop(){

        PlayerHandler player1 = room.getPlayer1();

        PlayerHandler player2 = room.getPlayer2();

        playerController1 = player1.getMegaModeController();
        playerController1.setPlayerNumber(CellValueType.PLAYER_1);

        playerController2 = player2.getMegaModeController();
        playerController2.setPlayerNumber(CellValueType.PLAYER_2);

        MultiAbstractController[] players = new MultiAbstractController[]{playerController1, playerController2};

        while(playARound(players)) { }

        try {

            Thread.sleep(5000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Server.THREAD_POOL.submit(player1);
        Server.THREAD_POOL.submit(player2);
    }

    @Override
    protected boolean playARound(MultiAbstractController[] players) {

        for(MultiAbstractController player: players){

            room.broadcast(room.getSuperGrid().drawGameBoard());
            getPlayerInput(player);
        }

        return true;
    }

    @Override
    protected void applyMove(MultiAbstractController player, String lastMove) {

        if(!validGrid){

            targetGrid = GameService.changeGrid(room.getSuperGrid(),lastMove);
            validGrid = checkValidGrid(targetGrid,player);
            getPlayerInput(player);
            return;
        }

        completedGrid = false;
        //gridcheck ends here

        //now its the cells of the grid

        if (!GameService.setValue(targetGrid, lastMove, player.getPlayerNumber())){

            player.receive("That position is full!\n");
            getPlayerInput(player);
            return;
        }

        if(playOnGrid(player, targetGrid)){

        }

        validGrid = false;
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

