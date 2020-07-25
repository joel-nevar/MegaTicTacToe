package org.academiadecodigo.felinux.mvc.model;

import org.academiadecodigo.felinux.mvc.model.cell.CellValueType;

public interface Gridable {

    CellValueType getCellValue(int index);

    void setCellValue(CellValueType playerValue, int index);
}
