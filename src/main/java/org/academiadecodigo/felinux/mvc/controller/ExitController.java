package org.academiadecodigo.felinux.mvc.controller;

import org.academiadecodigo.felinux.mvc.model.PlayerHandler;
import org.academiadecodigo.felinux.mvc.model.Server;

import java.io.IOException;

public class ExitController implements Controller {

    private PlayerHandler player;
    private Server server;

    @Override

    public void init(){
        try {
            player.getSocket().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        server.subtractPlayerCount();
    }

    public void setServer(Server server) {
        this.server = server;
    }

    public void setPlayer(PlayerHandler player) {
        this.player = player;
    }
}