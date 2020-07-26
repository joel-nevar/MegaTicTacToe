package org.academiadecodigo.felinux.mvc.controller;

import org.academiadecodigo.felinux.mvc.model.cell.CellValueType;
import org.academiadecodigo.felinux.mvc.model.grid.Grid;
import org.academiadecodigo.felinux.mvc.view.GameOverView;
import org.academiadecodigo.felinux.service.GameService;

public class GameOverController implements Controller {

    private MainController mainController;
    private SinglePlayerController singlePlayerController;
    private GameOverView gameOverView;
    private GameService gameService;

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

        boolean hasNextGame = gameService.hasNextGame(playerAnswer);

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

    public void setGameService(GameService gameService) {
        this.gameService = gameService;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }
}
