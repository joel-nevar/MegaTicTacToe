package org.academiadecodigo.felinux.mvc.controller;

import org.academiadecodigo.felinux.mvc.model.cell.CellValueType;
import org.academiadecodigo.felinux.mvc.model.grid.Grid;
import org.academiadecodigo.felinux.mvc.view.SinglePlayerView;
import org.academiadecodigo.felinux.service.GameService;

public class SinglePlayerController implements Controller {

    private GameOverController gameOverController;
    private SinglePlayerView singlePlayerView;
    private Grid grid;

    @Override
    public void init() {
        newGame();
    }

    private void newGame() {

        grid = new Grid();
        singlePlayerView.setGrid(grid);
        grid.isSinglePlayer(true);

        boolean win = false;
        boolean lose = false;
        boolean tie = false;

        while (grid.getValue() == CellValueType.EMPTY && !tie) {

            singlePlayerView.show();

            win = GameService.hasWon(grid, CellValueType.PLAYER_1);
            lose = GameService.hasWon(grid, CellValueType.PLAYER_2);
            tie = GameService.hasTied(grid);

            if (win) {
                grid.setValue(CellValueType.PLAYER_1);
            }

            if (lose) {
                grid.setValue(CellValueType.PLAYER_2);
            }
        }

        gameOverController.setGrid(grid);
        gameOverController.init();
    }

    public void getPlayerInput(String playerChoice) {
        boolean validChoice = false;

        //TODO re-chamar metodo selectCell
        while (!validChoice) {
            validChoice = GameService.setValue(grid, playerChoice, CellValueType.PLAYER_1);

        }
    }

    public void setSinglePlayerView(SinglePlayerView singlePlayerView) {
        this.singlePlayerView = singlePlayerView;
    }

    public void setGameOverController(GameOverController gameOverController) {
        this.gameOverController = gameOverController;
    }
}