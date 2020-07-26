package org.academiadecodigo.felinux.service;

import org.academiadecodigo.felinux.mvc.controller.MultiAbstractController;
import org.academiadecodigo.felinux.mvc.controller.MultiPlayerController;
import org.academiadecodigo.felinux.mvc.model.AbstractRoom;
import org.academiadecodigo.felinux.mvc.model.PlayerHandler;
import org.academiadecodigo.felinux.mvc.model.Server;
import org.academiadecodigo.felinux.mvc.model.cell.CellValueType;

public abstract class AbstractRoomService {


    protected AbstractRoom room;
    protected MultiPlayerController multiPlayerController1;
    protected MultiPlayerController multiPlayerController2;

    public AbstractRoomService(AbstractRoom room){
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

        while(playARound(players)) { }

        try {

            Thread.sleep(5000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Server.THREAD_POOL.submit(player1);
        Server.THREAD_POOL.submit(player2);
    }

    protected abstract boolean playARound(MultiAbstractController[] players);

    protected void getPlayerInput(MultiAbstractController player) {

        player.listenToPlayer();
        applyMove(player,player.getLastMove());
    }

    protected abstract void applyMove(MultiAbstractController player, String lastMove);
}

