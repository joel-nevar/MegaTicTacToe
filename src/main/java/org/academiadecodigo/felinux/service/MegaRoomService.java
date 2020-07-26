package org.academiadecodigo.felinux.service;

import org.academiadecodigo.felinux.mvc.controller.MultiPlayerController;
import org.academiadecodigo.felinux.mvc.model.AbstractRoom;

public class MegaRoomService extends AbstractRoomService {


    public MegaRoomService(AbstractRoom room) {

        super(room);
    }

    @Override
    protected boolean playARound(MultiPlayerController[] players) {
        return false;
    }

    @Override
    protected void applyMove(MultiPlayerController player, String lastMove) {

    }
}
