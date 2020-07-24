package org.academiadecodigo.felinux.mvc.model.cell;

public class Cell {

    private String row;
    private String column;
    private CellValueType cellValue;
    private String topPart = "---";
    private String middlePart = "| |";
    private String bottomPart = "---";
    private String cellSeparator = "|";

    public Cell(String row, String column){
        this.row = row;
        this.column = column;
    }

    public void drawCellInNewLine(){
        System.out.println(topPart);
        System.out.println(middlePart);
        System.out.println(bottomPart);
    }
    public void drawCellInSameLine(Cell cell){
        System.out.println(cell.topPart.concat(cellSeparator).concat(topPart));
        System.out.println(cell.middlePart.concat(cellSeparator).concat(middlePart));
        System.out.println(cell.bottomPart.concat(cellSeparator).concat(bottomPart));

    }

}