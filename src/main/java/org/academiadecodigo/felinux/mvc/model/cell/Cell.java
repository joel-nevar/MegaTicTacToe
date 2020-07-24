package org.academiadecodigo.felinux.mvc.model.cell;

public class Cell {

    private String row;
    private String column;
    private CellValueType cellValue;
    private String cellVisualRepresentation = "¬¬¬¬¬¬\n" +
                                              "|    |\n" +
                                              "|    |\n" +
                                              "¬¬¬¬¬¬";

    public Cell(String row, String column){
        this.row = row;
        this.column = column;
    }

    public void drawCell(){
        System.out.println(cellVisualRepresentation);
    }
    public void drawCellBellow(){
        System.out.println("aqui");
    }

}