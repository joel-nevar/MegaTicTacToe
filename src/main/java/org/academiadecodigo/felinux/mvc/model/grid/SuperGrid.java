package org.academiadecodigo.felinux.mvc.model.grid;

import org.academiadecodigo.felinux.mvc.model.Gridable;
import org.academiadecodigo.felinux.mvc.model.Valuable;
import org.academiadecodigo.felinux.mvc.model.cell.CellValueType;

public class SuperGrid implements Gridable {

    Grid[] grids;

    public SuperGrid() {
        this.grids = new Grid[9];
        initGrids();
    }

    private void initGrids() {

        for (int i = 0; i < 9; i++) {
            grids[i] = new Grid();
        }
    }

    @Override
    public CellValueType getCellValue(int index) {
        return this.grids[index].getValue();
    }

    @Override
    public void setCellValue(CellValueType playerValue, int index) {
        this.grids[index].setValue(playerValue);
    }

    public Valuable[] getGrids() {
        return this.grids;
    }
}
