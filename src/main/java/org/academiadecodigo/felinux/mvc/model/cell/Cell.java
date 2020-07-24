package org.academiadecodigo.felinux.mvc.model.cell;

import org.academiadecodigo.felinux.mvc.model.Valuable;

import java.util.LinkedList;

public class Cell implements Valuable{

    private String row;
    private String column;
    private CellValueType cellValue;

    private Cell(CellBuilder cellBuilder){
        this.row = cellBuilder.row;
        this.column = cellBuilder.column;
        this.cellValue = cellBuilder.cellValue;
        //mais cenas se necessário
    }

    @Override
    public CellValueType getValue() {
        return this.cellValue;
    }
    //=================BUILDER CLASS ====================\\

    public static class CellBuilder {

        private String row;
        private String column;
        private CellValueType cellValue;

        LinkedList<String> firstCell;
        LinkedList<String> everyOtherCell;


        private String topMiddlePart =          "1  -  |  -  |  -  ";
        private String middleMiddlePart =       "2  -  |  -  |  -  ";
        private String bottomMiddlePart =       "3  -  |  -  |  -  ";

        private String headerNamePart =         "   A     B     C    ";
        private String topTopPart =             "      |     |     ";
        private String topMiddleConcatPart =    "   -  |  -  |  -  ";
        private String topBottomPart =          " _____|_____|_____";
        private String middleTopPart =          "      |     |     ";
        private String middleMiddleConcatPart = "   -  |  -  |  -  ";
        private String middleBottomPart =       " _____|_____|_____";
        private String bottomTopPart =          "      |     |     ";
        private String bottomMiddleConcatPart = "   -  |  -  |  -  ";
        private String bottomBottomPart =       "      |     |     ";
        private String cellVerticalSeparator =  "||";
        private String cellHorizontalSeparator ="==========================================================";

        public CellBuilder(String row, String column, CellValueType cellValue){
            this.row = row;
            this.column = column;
            this.cellValue = cellValue;

            this.firstCell = new LinkedList<>();
            this.firstCell.add(topTopPart);
            this.firstCell.add(topMiddlePart);
            this.firstCell.add(topBottomPart);
            this.firstCell.add(middleTopPart);
            this.firstCell.add(middleMiddlePart);
            this.firstCell.add(middleBottomPart);
            this.firstCell.add(bottomTopPart);
            this.firstCell.add(bottomMiddlePart);
            this.firstCell.add(bottomBottomPart);

            this.everyOtherCell = new LinkedList<>();
            this.everyOtherCell.add(topTopPart);
            this.everyOtherCell.add(topMiddleConcatPart);
            this.everyOtherCell.add(topBottomPart);
            this.everyOtherCell.add(middleTopPart);
            this.everyOtherCell.add(middleMiddleConcatPart);
            this.everyOtherCell.add(middleBottomPart);
            this.everyOtherCell.add(bottomTopPart);
            this.everyOtherCell.add(bottomMiddleConcatPart);
            this.everyOtherCell.add(bottomBottomPart);
        }

        public CellBuilder drawGameBoard(){

            System.out.println(headerNamePart.concat(headerNamePart).concat(headerNamePart));

            for (int counter = 0; counter < 3; counter++) {
                for (int i = 0; i < everyOtherCell.size(); i++) {
                    System.out.println(firstCell.get(i).concat(cellVerticalSeparator)
                            .concat(everyOtherCell.get(i)).concat(cellVerticalSeparator)
                            .concat(everyOtherCell.get(i)));
                }
                if (counter != 2) {
                    System.out.println(cellHorizontalSeparator);
                }
            }
            return this;
        }

        public CellBuilder setDrawCellInNewLine(){

            return this;
        }
        public CellBuilder setDrawCellInSameLine(){

            return this;
        }

        public Cell build(){
            return new Cell(this);
        }
    }
}