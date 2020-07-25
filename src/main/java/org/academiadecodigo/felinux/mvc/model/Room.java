package org.academiadecodigo.felinux.mvc.model;

import org.academiadecodigo.felinux.mvc.model.grid.Grid;
import org.academiadecodigo.felinux.service.RoomService;

public class Room {


    private PlayerHandler player1;
    private PlayerHandler player2;
    private RoomService roomService;

    private boolean roomIsFull = false;

    private Grid grid;

    public Room(PlayerHandler player1){
        this.roomService = new RoomService(this);
        this.player1 = player1;
        grid = new Grid();
        player1.changeTurns();
        player1.setRoom(this);
    }

    public void addPlayer(PlayerHandler player2) {

        this.player2 = player2;
        player2.setRoom(this);
        roomIsFull = true;
    }
    public void changeTurns(){
        player1.changeTurns();
        player2.changeTurns();
    }
    public boolean checkRoomIsFull(){
        return roomIsFull;
    }

    public void broadcast(String message){

        player1.getController().receive(message);
        player2.getController().receive(message);
    }

    public RoomService getRoomService() {
        return roomService;
    }
    public PlayerHandler getPlayer1(){
        return player1;
    }
    public PlayerHandler getPlayer2(){
        return player2;
    }
}
