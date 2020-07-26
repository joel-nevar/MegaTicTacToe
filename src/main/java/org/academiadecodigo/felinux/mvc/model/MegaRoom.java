package org.academiadecodigo.felinux.mvc.model;

import org.academiadecodigo.felinux.mvc.model.grid.SuperGrid;
import org.academiadecodigo.felinux.service.AbstractRoomService;

public class MegaRoom extends AbstractRoom {


    private SuperGrid superGrid;

    public MegaRoom(PlayerHandler player1) {

        super(player1);
        superGrid = new SuperGrid();
    }

    @Override
    public AbstractRoomService getRoomService() {

        return null;
    }

    public SuperGrid getSuperGrid() {
        return superGrid;
    }
}

