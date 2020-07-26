package org.academiadecodigo.felinux.mvc.controller;

import org.academiadecodigo.felinux.mvc.model.cell.CellValueType;
import org.academiadecodigo.felinux.mvc.model.grid.Grid;
import org.academiadecodigo.felinux.mvc.view.SinglePlayerView;
import org.academiadecodigo.felinux.service.ComService;
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

        boolean winner = false;

        while (!winner) {

            singlePlayerView.show(); //player move

            while (!acceptedPlay) {

                singlePlayerView.showRepeat(); //must re-move if cell is chosen
            }

            acceptedPlay = false;

            winner = GameService.hasWon(grid, CellValueType.PLAYER_1);

            if (winner) {
                break;
            }

            winner = GameService.hasTied(grid);

            if (winner) {
                break;
            }

            while (!GameService.setValue(grid, ComService.randomNumberGenerator(), CellValueType.PLAYER_2)) {

                System.out.println("COM playing...");
            }

            winner = GameService.hasWon(grid, CellValueType.PLAYER_2);

        }

        gameOverController.setGrid(grid);
        gameOverController.init();
    }

    public void getPlayerInput(String playerChoice) {

        acceptedPlay = GameService.setValue(grid, playerChoice, CellValueType.PLAYER_1);
    }

    public void getComInput(int comChoice) {

        acceptedPlay = GameService.setValue(grid, comChoice, CellValueType.PLAYER_2);
    }

    public boolean isAcceptedPlay() {
        return acceptedPlay;
    }

    public void setSinglePlayerView(SinglePlayerView singlePlayerView) {
        this.singlePlayerView = singlePlayerView;
    }

    public void setGameOverController(GameOverController gameOverController) {
        this.gameOverController = gameOverController;
    }
}