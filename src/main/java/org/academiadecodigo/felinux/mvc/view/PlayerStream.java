package org.academiadecodigo.felinux.mvc.view;

import org.academiadecodigo.bootcamp.Prompt;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;

public class PlayerStream {


    private Prompt prompt;
    private PrintWriter writer;

    public PlayerStream(Socket socket){

        try {

            prompt = new Prompt(socket.getInputStream(), new PrintStream(socket.getOutputStream()));
            writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Prompt getPrompt() {
        return prompt;
    }

    public PrintWriter getWriter(){

        return writer;
    }
}