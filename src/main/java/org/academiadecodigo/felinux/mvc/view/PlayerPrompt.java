package org.academiadecodigo.felinux.mvc.view;

import org.academiadecodigo.bootcamp.Prompt;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

public class PlayerPrompt {

    private Prompt playerPrompt;

    public PlayerPrompt(Socket socket){

        try {

            playerPrompt = new Prompt(socket.getInputStream(), (PrintStream) socket.getOutputStream());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Prompt getPrompt() {
        return playerPrompt;
    }
}
