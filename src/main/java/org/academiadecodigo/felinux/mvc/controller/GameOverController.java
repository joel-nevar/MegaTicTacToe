package org.academiadecodigo.felinux.mvc.controller;

import org.academiadecodigo.felinux.mvc.model.cell.CellValueType;
import org.academiadecodigo.felinux.mvc.model.grid.Grid;
import org.academiadecodigo.felinux.mvc.view.GameOverView;
import org.academiadecodigo.felinux.service.GameService;

public class GameOverController implements Controller {

    private MainController mainController;
    private SinglePlayerController singlePlayerController;
    private GameOverView gameOverView;

    private Grid grid;

    @Override
    public void init() {

        gameOverView.setWinner(getWinner());
        gameOverView.setGrid(grid);
        gameOverView.show();
    }

    public CellValueType getWinner() {
        return grid.getValue();
    }

    public void restartGame(String playerAnswer) {

        boolean hasNextGame = GameService.hasNextGame(playerAnswer);

        if (hasNextGame) {
            singlePlayerController.init();
            return;
        }

        mainController.init();
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    public void setSinglePlayerController(SinglePlayerController singlePlayerController) {
        this.singlePlayerController = singlePlayerController;
    }

    public void setGameOverView(GameOverView gameOverView) {
        this.gameOverView = gameOverView;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }
}
