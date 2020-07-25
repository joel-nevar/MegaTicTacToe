package org.academiadecodigo.felinux.mvc.controller;

import org.academiadecodigo.felinux.mvc.model.cell.CellValueType;
import org.academiadecodigo.felinux.mvc.model.grid.Grid;
import org.academiadecodigo.felinux.mvc.view.SinglePlayerView;
import org.academiadecodigo.felinux.service.GameService;

public class SinglePlayerController implements Controller {

    private MainController mainController;
    private SinglePlayerView singlePlayerView;
    private GameService gameService;

    private Grid grid;

    @Override
    public void init() {
        newGame();
    }

    private void newGame() {
        grid = new Grid();
        singlePlayerView.setGrid(grid);

        while (grid.getValue() == CellValueType.EMPTY) {
            singlePlayerView.show();
        }
    }

    public void getPlayerInput(String playerChoice) {
        boolean validChoice = false;

        while (!validChoice) {
            validChoice = gameService.setValue(grid, playerChoice, CellValueType.PLAYER_1);
        }
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    public void setSinglePlayerView(SinglePlayerView singlePlayerView) {
        this.singlePlayerView = singlePlayerView;
    }

    public void setGameService(GameService gameService) {
        this.gameService = gameService;
    }
}