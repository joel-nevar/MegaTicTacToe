package org.academiadecodigo.felinux.mvc.view;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringSetInputScanner;
import org.academiadecodigo.felinux.mvc.controller.PlayerController;

import java.io.PrintWriter;
import java.util.HashSet;

public class GameView extends AbstractView {


    private PlayerController controller;
    private StringInputScanner scanner;

    @Override
    public void show() {

        showGame();
    }

    private void showGame(){

        if (controller.getLastMove()==null){

            String userInput = super.prompt.getUserInput(scanner);
            controller.saveMove(userInput);
        }
    }

    public void setPrompt(Prompt prompt) {

        super.setPrompt(prompt);
    }

    public void setController(PlayerController controller) {

        this.controller = controller;
    }

    public void setScanner(String message) {

        if(scanner == null){
            scanner = new StringInputScanner();
            scanner.setError("That's not valid");
        }
        scanner.setMessage(message + "\n");
    }

    public void sendMessage(String message) {

        super.getWriter().println(message);
    }

    @Override
    public PrintWriter getWriter() {

        return super.getWriter();
    }

    @Override
    public Prompt getPrompt() {

        return super.getPrompt();
    }
}
