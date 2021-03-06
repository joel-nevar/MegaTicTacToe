package org.academiadecodigo.felinux.mvc.model;

import org.academiadecodigo.felinux.mvc.model.cell.CellValueType;

public interface Valuable {

    CellValueType getValue();

    void setValue(CellValueType playerValue);
}
