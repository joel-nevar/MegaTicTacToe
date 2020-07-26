package org.academiadecodigo.felinux.mvc.view;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.string.StringSetInputScanner;
import org.academiadecodigo.felinux.mvc.controller.MultiPlayerController;
import org.academiadecodigo.felinux.mvc.view.textIO.GameInput;
import org.academiadecodigo.felinux.mvc.view.textIO.Messages;

import java.io.PrintWriter;
import java.util.Set;

public class GameView extends AbstractView {


    private MultiPlayerController controller;
    private StringSetInputScanner scanner;

    @Override
    public void show() {

        showGame();
    }

    private void showGame(){

        String userInput = super.prompt.getUserInput(scanner);
        controller.saveMove(userInput);
    }

    public void setPrompt(Prompt prompt) {

        super.setPrompt(prompt);
    }

    public void setController(MultiPlayerController controller) {

        this.controller = controller;
    }

    public void setScanner() {

        if(scanner == null){

            Set<String> cellOptions = GameInput.cellCoordinates;

            scanner = new StringSetInputScanner(cellOptions);
            scanner.setMessage(Messages.SELECT_CELL);
            scanner.setError(Messages.WRONG_CELL_INPUT);
        }
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
