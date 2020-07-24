package org.academiadecodigo.felinux.mvc.controller;

import org.academiadecodigo.felinux.mvc.model.Lobby;
import org.academiadecodigo.felinux.mvc.model.PlayerHandler;

public class CentralController implements Controller{


    private Lobby lobby;


    @Override
    public void init() {

    }
    public void registerPlayer(PlayerHandler player){

    }

    public void setLobby(Lobby lobby) {
        this.lobby = lobby;
    }
}
