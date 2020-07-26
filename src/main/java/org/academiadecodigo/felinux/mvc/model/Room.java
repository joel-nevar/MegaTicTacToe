package org.academiadecodigo.felinux.mvc.model;

import org.academiadecodigo.felinux.mvc.model.grid.Grid;
import org.academiadecodigo.felinux.service.AbstractRoomService;
import org.academiadecodigo.felinux.service.RoomService;

public class Room extends AbstractRoom {


    private AbstractRoomService roomService;

    private Grid grid;

    public Room(PlayerHandler player1){

        super(player1);

        this.roomService = new RoomService(this);
        grid = new Grid();
    }

    public AbstractRoomService getRoomService() {
        return roomService;
    }

    public Grid getGrid(){
        return grid;
    }
}
