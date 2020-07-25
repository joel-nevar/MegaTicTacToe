package org.academiadecodigo.felinux.mvc.model.cell;

import org.academiadecodigo.felinux.mvc.model.Valuable;

import java.util.LinkedList;

public class Cell implements Valuable {

    private CellValueType cellValue;

    private Cell(CellBuilder cellBuilder){
        this.cellValue = cellBuilder.cellValue;
        //mais cenas se necessário
    }

    @Override
    public CellValueType getValue() {
        return this.cellValue;
    }

    @Override
    public void setValue(CellValueType playerValue) {
        this.cellValue = playerValue;
    }
    //=================BUILDER CLASS ====================\\

    public static class CellBuilder {

        private CellValueType cellValue;

        LinkedList<String> firstCell;
        LinkedList<String> everyOtherCell;

        public final String RESET = "\u001B[0m";
        public final String BLACK = "\u001B[30m";
        public final String RED = "\u001B[31m";
        public final String GREEN = "\u001B[32m";
        public final String YELLOW = "\u001B[33m";
        public final String BLUE = "\u001B[34m";
        public final String PURPLE = "\u001B[35m";
        public final String CYAN = "\u001B[36m";
        public final String WHITE = "\u001B[37m";

        public final String SELECTED_GREEN_BACKGROUND = "\u001B[42m";
        public final String UNSELECTED_BLACK_BACKGROUND = "\u001B[40m";


        private String topMiddlePart =      YELLOW + "1" + RESET + "  -  |  -  |  -  ";
        private String middleMiddlePart =   YELLOW + "2" + RESET + "  -  |  -  |  -  ";
        private String bottomMiddlePart =   YELLOW + "3" + RESET + "  -  |  -  |  -  ";

        private String headerNamePart = YELLOW +"   A     B     C    " + RESET;
        private String topTopPart =             "      |     |     ";
        private String topMiddleConcatPart =    "   -  |  -  |  -  ";
        private String topBottomPart =          " _____|_____|_____";
        private String middleTopPart =          "      |     |     ";
        private String middleMiddleConcatPart = "   -  |  -  |  -  ";
        private String middleBottomPart =       " _____|_____|_____";
        private String bottomTopPart =          "      |     |     ";
        private String bottomMiddleConcatPart = "   -  |  -  |  -  ";
        private String bottomBottomPart =       "      |     |     ";
        private String cellVerticalSeparator =  BLUE + "||" + RESET;
        private String cellHorizontalSeparator = BLUE + "==========================================================" + RESET;

        public CellBuilder(){
            this.cellValue = CellValueType.EMPTY;

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
            final String RED = "\u001B[31m";
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