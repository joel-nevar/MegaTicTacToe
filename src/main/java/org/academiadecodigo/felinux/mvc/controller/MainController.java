package org.academiadecodigo.felinux.mvc.controller;

import org.academiadecodigo.felinux.mvc.view.MenuView;
import org.academiadecodigo.felinux.mvc.view.textIO.MenuOptions;

public class MainController implements Controller {

    private MenuView menuView;

    private SinglePlayerController singlePlayerController;
    //all controllers

    private int userInput = 0;

    @Override
    public void init() {

        if (userInput == 0) {
            menuView.show();
        }

        chooseItem();
    }

    private void chooseItem() {

        MenuOptions menuOption = MenuOptions.values()[userInput - 1];
        userInput = 0;

        menuOption.init();
    }

    public void onMenuSelection(Integer userInput) {
        this.userInput = userInput;
    }

    public void setMenuView(MenuView menuView) {
        this.menuView = menuView;
    }

    public void setSinglePlayerController(SinglePlayerController singlePlayerController) {
        this.singlePlayerController = singlePlayerController;
        MenuOptions.SIMPLE_VS_COM.setController(singlePlayerController);
    }
}
