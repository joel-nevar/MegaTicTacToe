package org.academiadecodigo.felinux.mvc.controller;

import org.academiadecodigo.felinux.mvc.model.PlayerHandler;
import org.academiadecodigo.felinux.mvc.view.MenuView;
import org.academiadecodigo.felinux.mvc.view.textIO.MenuOptions;

public class MainController implements Controller {

    private MenuView menuView;

    private SinglePlayerController singlePlayerController;
    private ExitController exitController;
    private PlayerController playerController;
    private PlayerHandler player;
    private CentralController centralController;
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
        switch (userInput){
            case 1 :{
                centralController.registerPlayer(player);
                break;
            }
        }
    }

    public void setMenuView(MenuView menuView) {
        this.menuView = menuView;
    }

   /* public void setSinglePlayerController(SinglePlayerController singlePlayerController) {
        this.singlePlayerController = singlePlayerController;
        MenuOptions.SIMPLE_VS_COM.setController(singlePlayerController);
    }*/

    public void setExitController(ExitController exitController) {
        this.exitController = exitController;
        MenuOptions.EXIT.setController(exitController);
    }

    public void setPlayerController(PlayerController playerController) {

        this.playerController = playerController;
    }

    public void setCentralController(CentralController centralController) {
        this.centralController = centralController;
    }

    public void setPlayerHandler(PlayerHandler playerHandler) {
        this.player = playerHandler;
    }
}
