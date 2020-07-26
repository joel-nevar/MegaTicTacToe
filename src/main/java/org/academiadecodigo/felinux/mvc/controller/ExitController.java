package org.academiadecodigo.felinux.mvc.controller;

import org.academiadecodigo.felinux.mvc.model.PlayerHandler;
import org.academiadecodigo.felinux.mvc.model.Server;

import java.io.IOException;

public class ExitController implements Controller {

    private Server server;

    @Override
    public void init() {
        System.exit(0);
        //This may as well be the place to end all streams and sockets necessary
    }
    public void init(PlayerHandler player){
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
}