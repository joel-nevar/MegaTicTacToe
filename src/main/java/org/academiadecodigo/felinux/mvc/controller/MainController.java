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

        switch (menuOption){

            case VS_COM: {
                singlePlayerController.init();
                break;
            }
            case VS_PLAYER: {

                centralController.registerPlayer(player);
                playerController.init();
                break;
            }
            case INSTRUCTIONS: {

            }

            case EXIT: {

                exitController.init();
            }
        }
    }

    public void onMenuSelection(Integer userInput) {

        this.userInput = userInput;

    }

    public void setMenuView(MenuView menuView) {
        this.menuView = menuView;
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
