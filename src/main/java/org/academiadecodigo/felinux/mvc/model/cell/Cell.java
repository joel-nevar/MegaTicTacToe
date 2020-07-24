package org.academiadecodigo.felinux.mvc.model.cell;

public class Cell {
    private String row;
    private String column;
    private CellValueType cellValue;

    public Cell(String row, String column){
        this.row = row;
        this.column = column;
    }

    public void drawCell(){
        System.out.print("aqui");
        System.out.print("tambem aqui");
    }

}
