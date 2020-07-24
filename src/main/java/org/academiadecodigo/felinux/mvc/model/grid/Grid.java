package org.academiadecodigo.felinux.mvc.model.grid;

import org.academiadecodigo.felinux.mvc.model.Cellable;
import org.academiadecodigo.felinux.mvc.model.cell.Cell;
import org.academiadecodigo.felinux.mvc.model.cell.CellValueType;

public class Grid implements Cellable {
    Cell[] cells;
    CellValueType cellValue;

    @Override
    public CellValueType getValue() {
        return this.cellValue;
    }

    public Cell getCells(int ind) {
        return this.cells[ind];
    }
}
