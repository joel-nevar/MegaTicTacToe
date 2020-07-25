package org.academiadecodigo.felinux.mvc.model.cell;

import org.academiadecodigo.felinux.mvc.model.Valuable;

public class Cell implements Valuable {

    private CellValueType cellValue;

    public Cell(){
        this.cellValue = CellValueType.EMPTY;
    }

    @Override
    public CellValueType getValue() {
        return this.cellValue;
    }

    @Override
    public void setValue(CellValueType playerValue) {
        this.cellValue = playerValue;
    }
}