package org.academiadecodigo.felinux.mvc.controller;

import org.academiadecodigo.felinux.mvc.model.AbstractRoom;
import org.academiadecodigo.felinux.mvc.model.PlayerHandler;
import org.academiadecodigo.felinux.mvc.model.cell.CellValueType;
import org.academiadecodigo.felinux.mvc.view.MegaModeView;
import org.academiadecodigo.felinux.mvc.view.MultiPlayerView;

public class MegaModeController extends MultiAbstractController {

    private AbstractRoom room;
    private MegaModeView view;
    private PlayerHandler player;
    private String lastMove;
    private CellValueType playerNumber;

    @Override
    public void init() {

        gameInit();
    }

    private void gameInit() {

        this.room = player.getRoom();

        view.setScanner();

        if(room.checkRoomIsFull()){
            room.getRoomService().gameLoop();
        }
    }

    public void listenToPlayer() {

        view.show();
    }

    public void receive(String message){

        view.sendMessage(message);
    }

    public void transmit(String message){

        player.getRoom().broadcast(message);
    }

    public synchronized void saveMove(String message){

        this.lastMove = message;
    }

    public synchronized String getLastMove() {

        return lastMove;
    }

    public void setMegaView(MegaModeView playerScreen) {

        this.view = playerScreen;
    }

    public void setPlayer(PlayerHandler playerHandler) {

        this.player = playerHandler;
    }

    public void setPlayerNumber(CellValueType playerNumber) {
        this.playerNumber = playerNumber;
    }

    public CellValueType getPlayerNumber() {
        return playerNumber;
    }
}
