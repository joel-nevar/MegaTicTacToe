package org.academiadecodigo.felinux.mvc.model;

import org.academiadecodigo.felinux.mvc.model.grid.Grid;
import org.academiadecodigo.felinux.mvc.model.grid.SuperGrid;
import org.academiadecodigo.felinux.service.RoomService;

public class Room {


    private PlayerHandler player1;
    private PlayerHandler player2;
    private RoomService roomService;

    private boolean roomIsFull = false;

    private Grid grid;
    private SuperGrid superGrid;

    public Room(PlayerHandler player1){

        this.roomService = new RoomService(this);
        this.player1 = player1;
        player1.setRoom(this);

        grid = new Grid();
        superGrid = new SuperGrid();
        //grid.drawGameBoard();
        //superGrid.drawGameBoard();

    }

    public void addPlayer(PlayerHandler player2) {

        this.player2 = player2;
        player2.setRoom(this);
        roomIsFull = true;
    }

    public boolean checkRoomIsFull(){
        return roomIsFull;
    }

    public void broadcast(String message){

        player1.getMultiPlayerController().receive(message);
        if(!(player2 == null)) {
            player2.getMultiPlayerController().receive(message);
        }
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

    public Grid getGrid(){
        return grid;
    }

    public SuperGrid getSuperGrid() {
        return superGrid;
    }
}
