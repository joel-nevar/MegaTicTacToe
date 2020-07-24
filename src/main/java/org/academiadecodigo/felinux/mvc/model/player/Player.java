package org.academiadecodigo.felinux.mvc.model.player;

import java.net.Socket;

public class Player {
    Socket socket;

    public Player(){
        this.socket = new Socket();
    }
}
