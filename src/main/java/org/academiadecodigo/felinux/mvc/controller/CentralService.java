package org.academiadecodigo.felinux.mvc.controller;

import org.academiadecodigo.felinux.mvc.model.Lobby;
import org.academiadecodigo.felinux.mvc.model.PlayerHandler;
import org.academiadecodigo.felinux.service.PlayerService;

public class CentralService {


    private Lobby lobby;
    private PlayerService playerService;

    public CentralService(){

        this.lobby = new Lobby();
    }

    public void registerPlayer(PlayerHandler player){
        playerService.registerPlayer(player);
    }

    public void registerMegaPlayer(PlayerHandler player){
        playerService.registerMegaPlayer(player);
    }

    public void setLobby(Lobby lobby) {
        this.lobby = lobby;
    }

    public void setPlayerService(PlayerService playerService) {
        this.playerService = playerService;
    }
}
