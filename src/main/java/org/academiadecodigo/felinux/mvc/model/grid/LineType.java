package org.academiadecodigo.felinux.mvc.model.grid;

import org.academiadecodigo.felinux.mvc.model.Gridable;
import org.academiadecodigo.felinux.mvc.model.cell.CellValueType;

public enum LineType {

    LINE_1(0, 1, 2),
    LINE_2(3, 4, 5),
    LINE_3(6, 7, 8),
    COL_1(0, 3, 6),
    COL_2(1, 4, 7),
    COL_3(2, 5, 8),
    DIAG_1(0, 4, 8),
    DIAG_2(2, 4, 6);

    private int i;
    private int j;
    private int k;

    LineType(int i, int j, int k) {
        this.i = i;
        this.j = j;
        this.k = k;
    }

    public CellValueType[] getCells(Gridable grid) {
        return new CellValueType[] {grid.getCellValue(i), grid.getCellValue(j), grid.getCellValue(k)};
    }
}