package org.academiadecodigo.felinux.mvc.view;

import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;
import org.academiadecodigo.felinux.mvc.controller.PlayerController;

public class GameView implements View{


    private PlayerPrompt playerPrompt;
    private PlayerController controller;
    private StringInputScanner scanner;

    @Override
    public void show() {

        controller.transmit(playerPrompt.getPrompt().getUserInput(scanner));
    }

    public void setPrompt(PlayerPrompt playerPrompt) {

        this.playerPrompt = playerPrompt;
    }

    public void setController(PlayerController controller) {

        this.controller = controller;
    }

    public void setMessage(String message) {

        if(scanner == null){
            scanner = new StringInputScanner();
            scanner.setError("That's not valid");
        }

        scanner.setMessage(message);
    }
}
