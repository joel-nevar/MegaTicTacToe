package org.academiadecodigo.felinux.service;

import org.academiadecodigo.felinux.mvc.model.WinCombinations;
import org.academiadecodigo.felinux.mvc.model.cell.CellValueType;
import org.academiadecodigo.felinux.mvc.model.grid.Grid;

public class GameService {

    WinCombinations winCombinations;

    public boolean hasWon(Grid grid, CellValueType playerValue) {

        boolean win = false;

        for (WinCombinations winCombination : winCombinations.values()) {

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
}
