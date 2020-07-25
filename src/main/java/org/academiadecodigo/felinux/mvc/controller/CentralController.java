package org.academiadecodigo.felinux.mvc.controller;

import org.academiadecodigo.felinux.mvc.model.Lobby;
import org.academiadecodigo.felinux.mvc.model.PlayerHandler;
import org.academiadecodigo.felinux.service.PlayerService;

public class CentralController implements Controller{


    private Lobby lobby;
    private PlayerService playerService;


    @Override
    public void init() {

    }
    public void registerPlayer(PlayerHandler player){
        playerService.registerPlayer(player);
    }

    public void setLobby(Lobby lobby) {
        this.lobby = lobby;
    }

    public void setPlayerService(PlayerService playerService) {
        this.playerService = playerService;
    }
}
