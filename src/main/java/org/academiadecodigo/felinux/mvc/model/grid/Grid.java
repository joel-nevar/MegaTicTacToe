package org.academiadecodigo.felinux.mvc.model.grid;

import org.academiadecodigo.felinux.mvc.model.Gridable;
import org.academiadecodigo.felinux.mvc.model.Valuable;
import org.academiadecodigo.felinux.mvc.model.cell.Cell;
import org.academiadecodigo.felinux.mvc.model.cell.CellValueType;

public class Grid implements Gridable, Valuable {

    Cell[] cells;
    CellValueType cellValue;

    public Grid() {
        this.cells = new Cell[9];
        initCell();
        this.cellValue = CellValueType.EMPTY;
    }

    public void initCell() {
        for (int i = 0; i < 9; i++) {
            cells[i] = new Cell();
        }
    }

    @Override
    public CellValueType getValue() {
        return this.cellValue;
    }

    @Override
    public void setValue(CellValueType playerValue) {
        this.cellValue = playerValue;
    }

    @Override
    public CellValueType getCellValue(int index) {
        return this.cells[index].getValue();
    }

    @Override
    public void setCellValue(CellValueType playerValue, int index) {
        this.cells[index].setValue(playerValue);
    }

    public Valuable[] getCells() {
        return this.cells;
    }
}
