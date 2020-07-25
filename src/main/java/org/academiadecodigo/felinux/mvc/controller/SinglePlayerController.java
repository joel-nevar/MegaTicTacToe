package org.academiadecodigo.felinux.mvc.controller;

public class SinglePlayerController implements Controller {

    private MainController mainController;

    @Override
    public void init() {
        System.out.println("bitch");
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
}
