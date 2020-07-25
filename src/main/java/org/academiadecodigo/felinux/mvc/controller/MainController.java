package org.academiadecodigo.felinux.mvc.controller;

import org.academiadecodigo.felinux.mvc.view.MenuView;

public class MainController implements Controller {

    private MenuView menuView;

    private SinglePlayerController singlePlayerController;
    //...all other controllers - setters for everyone

    private int userInput = 0;

    @Override
    public void init() {

        if (userInput == 0) {
            menuView.show();
        }

        chooseItem();
    }

    private void chooseItem() {

        Me
        switch (userInput) {
            case 1:
                singlePlayerController.init();
                break;
                case
        }
    }

    public void onMenuSelection(Integer userInput) {
        this.userInput = userInput;
    }

    public void setMenuView(MenuView menuView) {
        this.menuView = menuView;
    }

    public void setSinglePlayerController(SinglePlayerController singlePlayerController) {
        this.singlePlayerController = singlePlayerController;
    }
}
