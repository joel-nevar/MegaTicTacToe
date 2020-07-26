package org.academiadecodigo.felinux.mvc.controller;

import org.academiadecodigo.felinux.mvc.model.cell.CellValueType;
import org.academiadecodigo.felinux.mvc.model.grid.Grid;
import org.academiadecodigo.felinux.mvc.view.SinglePlayerView;
import org.academiadecodigo.felinux.service.GameService;

public class SinglePlayerController implements Controller {

    private GameOverController gameOverController;
    private SinglePlayerView singlePlayerView;
    private Grid grid;

    private boolean acceptedPlay = false;

    @Override
    public void init() {
        newGame();
    }

    private void newGame() {

        grid = new Grid();
        singlePlayerView.setGrid(grid);

        boolean win = false;
        boolean lose = false;
        boolean tie = false;

        while (grid.getValue() == CellValueType.EMPTY && !tie) {

            while (!acceptedPlay) {
                singlePlayerView.show(); //player move
            }

            acceptedPlay = false;

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

        acceptedPlay = GameService.setValue(grid, playerChoice, CellValueType.PLAYER_1);
    }

    public void getComInput(String comChoice) {
        boolean validChoice = false;

        while (!validChoice) {
            validChoice = GameService.setValue(grid, comChoice, CellValueType.PLAYER_2);
        }
    }

    public void setSinglePlayerView(SinglePlayerView singlePlayerView) {
        this.singlePlayerView = singlePlayerView;
    }

    public void setGameOverController(GameOverController gameOverController) {
        this.gameOverController = gameOverController;
    }
}