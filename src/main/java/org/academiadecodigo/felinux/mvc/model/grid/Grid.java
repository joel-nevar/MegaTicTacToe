package org.academiadecodigo.felinux.mvc.model.grid;

import org.academiadecodigo.felinux.mvc.model.Gridable;
import org.academiadecodigo.felinux.mvc.model.Valuable;
import org.academiadecodigo.felinux.mvc.model.cell.Cell;
import org.academiadecodigo.felinux.mvc.model.cell.CellValueType;

public class Grid implements Gridable, Valuable {

    Cell[] cells;
    CellValueType cellValue;

    @Override
    public CellValueType getValue() {
        return this.cellValue;
    }

    @Override
    public CellValueType getCellValue(int index) {
        return this.cells[index].getValue();
    }

    public Valuable[] getCells() {
        return this.cells;
    }
}
