package org.academiadecodigo.felinux.service;

import org.academiadecodigo.felinux.mvc.model.Valuable;
import org.academiadecodigo.felinux.mvc.model.grid.LineType;
import org.academiadecodigo.felinux.mvc.model.cell.CellValueType;
import org.academiadecodigo.felinux.mvc.model.grid.Grid;

public class GameService {


    public boolean hasWon(Grid grid, CellValueType playerValue) {

        boolean win = false;

        for (LineType winCombination : LineType.values()) {

            win = true;

            CellValueType[] lineValues = winCombination.getCells(grid);

            for (CellValueType cellValue : lineValues) {

                if (cellValue == playerValue) {
                    continue;
                }

                win = false;
            }

            if (win) {
                break;
            }
        }

        return win;
    }

    public boolean hasTied(Grid grid) {

        boolean tie = true;

        for (Valuable cell : grid.getCells()) {

            if (cell.getValue() == CellValueType.EMPTY) {
                tie = false;
            }
        }

        return tie;
    }

    public boolean hasNextGame(String playerInput) {

        return playerInput.toUpperCase().startsWith("Y");
    }

    public boolean setValue(Grid grid, String playerInput, CellValueType playerValue) {

        int index = 0;

        char col = playerInput.toUpperCase().charAt(0);
        int row = Integer.parseInt(String.valueOf(playerInput.charAt(1))) - 1;

        switch (col) {
            case 'B':
                index++;
                break;
            case 'C':
                index += 2;
                break;
            default:
                break;

        }

        index += (row * 3);

        if (grid.getCellValue(index) == CellValueType.EMPTY) {
            grid.setCellValue(playerValue, index);
            return true;
        }

        return false;
    }
}
