package org.academiadecodigo.felinux.mvc.model;

import org.academiadecodigo.felinux.mvc.model.grid.Grid;

public class Room {

    private PlayerHandler player1;
    private PlayerHandler player2;

    private boolean roomIsFull = false;

    private Grid grid;

    public Room(PlayerHandler player1){
        this.player1 = player1;
        grid = new Grid();
    }

    public void addPlayer(PlayerHandler player2) {
        this.player2 = player2;
        roomIsFull = true;
    }

    public boolean checkRoomIsFull(){
        return roomIsFull;
    }


}
