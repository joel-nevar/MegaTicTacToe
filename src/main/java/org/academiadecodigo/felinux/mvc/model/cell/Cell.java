package org.academiadecodigo.felinux.mvc.model.cell;

import org.academiadecodigo.felinux.mvc.model.Valuable;

public class Cell implements Valuable {

    private String row;
    private String column;
    private CellValueType cellValue;
    private String topPart = "---";
    private String middlePart = "| |";
    private String bottomPart = "---";
    private String cellSeparator = "|";
    private String concatTopCell = "";
    private String concatMidCell = "";
    private String concatBotCell = "";

    public Cell(CellBuilder cellBuilder){
        this.row = row;
        this.column = column;
    }

    @Override
    public CellValueType getValue() {
        return this.cellValue;
    }

    //=================BUILDER CLASS ====================\\

    public static class CellBuilder{

        private String row;
        private String column;
        private CellValueType cellValue;
        private String topPart = "---";
        private String middlePart = "| |";
        private String bottomPart = "---";
        private String cellSeparator = "|";
        private String concatTopCell = "";
        private String concatMidCell = "";
        private String concatBotCell = "";


        public CellBuilder(String row, String column, CellValueType cellValue){
            this.row = row;
            this.column = column;
            this.cellValue = cellValue;
        }
        public Cell build(){
            return new Cell(this);
        }

        public CellBuilder setDrawCellInNewLine(){
            System.out.println(concatTopCell.concat(topPart));
            System.out.println(concatMidCell.concat(middlePart));
            System.out.println(concatBotCell.concat(bottomPart));
            return this;
        }
        public CellBuilder setDrawCellInSameLine(Cell cell){
            System.out.println(cell.concatTopCell.concat(topPart));
            System.out.println(cell.concatMidCell.concat(middlePart));
            System.out.println(cell.concatBotCell.concat(bottomPart));
            return this;
        }
    }
}