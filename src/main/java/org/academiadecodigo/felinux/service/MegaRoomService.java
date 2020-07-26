package org.academiadecodigo.felinux.service;

import org.academiadecodigo.felinux.mvc.controller.MultiPlayerController;
import org.academiadecodigo.felinux.mvc.model.AbstractRoom;
import org.academiadecodigo.felinux.mvc.model.grid.Grid;

public class MegaRoomService extends AbstractRoomService {

    private Grid currentGrid;

    public MegaRoomService(AbstractRoom room) {

        super(room);
    }

    @Override
    protected boolean playARound(MultiPlayerController[] players) {
        return false;
    }

    @Override
    protected void applyMove(MultiPlayerController player, String lastMove) {}

    public void setCurrentGrid(Grid grid){
        this.currentGrid = grid;
    }
}
