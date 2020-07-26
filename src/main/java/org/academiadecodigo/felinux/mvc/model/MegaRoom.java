package org.academiadecodigo.felinux.mvc.model;

import org.academiadecodigo.felinux.mvc.model.grid.SuperGrid;
import org.academiadecodigo.felinux.service.AbstractRoomService;
import org.academiadecodigo.felinux.service.MegaRoomService;

public class MegaRoom extends AbstractRoom {


    private AbstractRoomService roomService;
    private SuperGrid superGrid;

    public MegaRoom(PlayerHandler player1) {

        super(player1);

        this.roomService = new MegaRoomService(this);
        superGrid = new SuperGrid();
    }

    @Override
    public AbstractRoomService getRoomService() {

        return roomService;
    }

    public SuperGrid getSuperGrid() {
        return superGrid;
    }
}

