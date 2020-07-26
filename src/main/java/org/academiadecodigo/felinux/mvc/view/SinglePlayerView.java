package org.academiadecodigo.felinux.mvc.view;

import org.academiadecodigo.bootcamp.scanners.string.StringSetInputScanner;
import org.academiadecodigo.felinux.mvc.controller.SinglePlayerController;
import org.academiadecodigo.felinux.mvc.model.grid.Grid;
import org.academiadecodigo.felinux.mvc.view.textIO.GameInput;
import org.academiadecodigo.felinux.mvc.view.textIO.Messages;

import java.util.Set;

public class SinglePlayerView extends AbstractView {

    private SinglePlayerController singlePlayerController;
    private Grid grid;

    public void setSinglePlayerController(SinglePlayerController singlePlayerController) {
        this.singlePlayerController = singlePlayerController;
    }

    @Override
    public void show() {
        grid.drawGameBoard();
        //TODO mexer aqui para desenhar
        singlePlayerController.getPlayerInput(chooseCell());
    }

    public String chooseCell() {

        Set<String> cellOptions = GameInput.cellCoordinates;

        StringSetInputScanner playerInput = new StringSetInputScanner(cellOptions);
        playerInput.setMessage(Messages.SELECT_CELL);
        playerInput.setError(Messages.WRONG_CELL_INPUT);

        return super.prompt.getUserInput(playerInput);
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }
}
