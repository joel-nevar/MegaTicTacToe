package org.academiadecodigo.felinux.mvc.view;

import org.academiadecodigo.bootcamp.scanners.string.StringSetInputScanner;
import org.academiadecodigo.felinux.mvc.controller.GameOverController;
import org.academiadecodigo.felinux.mvc.model.cell.CellValueType;
import org.academiadecodigo.felinux.mvc.model.grid.Grid;
import org.academiadecodigo.felinux.mvc.view.textIO.GameInput;
import org.academiadecodigo.felinux.mvc.view.textIO.Messages;

public class GameOverView extends AbstractView {

    private GameOverController gameOverController;
    private CellValueType winner;
    private Grid grid;
    private String resultMessage;

    @Override
    public void show() {

        grid.drawGameBoard();

        switch (winner) {
            case PLAYER_1:
                resultMessage = Messages.WIN_GAME;
                break;
            case PLAYER_2:
                resultMessage = Messages.LOST_GAME;
                break;
            default:
                resultMessage = Messages.TIED_GAME;
        }

        gameOverController.restartGame(nextGame());
    }

    public String nextGame() {

        System.out.println(resultMessage); //change to an output

        StringSetInputScanner answer = new StringSetInputScanner(GameInput.yesOrNo);
        answer.setMessage(Messages.NEXT_GAME);
        answer.setError(Messages.WRONG_INPUT);

        return super.getPrompt().getUserInput(answer);
    }

    public void setGameOverController(GameOverController gameOverController) {
        this.gameOverController = gameOverController;
    }

    public void setWinner(CellValueType winner) {
        this.winner = winner;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }
}
