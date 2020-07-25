package org.academiadecodigo.felinux.mvc.view;

import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;
import org.academiadecodigo.felinux.mvc.controller.PlayerController;

public class GameView extends AbstractView {

    private PlayerStream stream;
    private PlayerController controller;
    private StringInputScanner scanner;

    @Override
    public void show() {

        controller.transmit(stream.getPrompt().getUserInput(scanner));
    }

    public void setPrompt(PlayerStream playerPrompt) {

        this.stream = playerPrompt;
    }

    public void setController(PlayerController controller) {

        this.controller = controller;
    }

    public void setMessage(String message) {

        if(scanner == null){
            scanner = new StringInputScanner();
            scanner.setError("That's not valid");
        }

        scanner.setMessage(message + "\n");
    }

    public void sendMessage(String message) {

        stream.getWriter().println(message);
    }
}
