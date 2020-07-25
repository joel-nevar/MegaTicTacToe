package org.academiadecodigo.felinux.mvc.model.grid;

import org.academiadecodigo.felinux.mvc.model.Gridable;
import org.academiadecodigo.felinux.mvc.model.Valuable;
import org.academiadecodigo.felinux.mvc.model.cell.Cell;
import org.academiadecodigo.felinux.mvc.model.cell.CellValueType;

import java.util.LinkedList;

public class Grid implements Gridable, Valuable {

    Cell[] cells;
    CellValueType cellValue;

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
    public final String BLUE_BACKGROUND = "\u001B[44m";
    public final String BLACK_BACKGROUND = "\u001B[40m";
    public final String RED_BACKGROUND = "\u001B[41m";
    public final String YELLOW_BACKGROUND = "\u001B[43m";
    public final String PURPLE_BACKGROUND = "\u001B[45m";
    public final String CYAN_BACKGROUND = "\u001B[46m";
    public final String WHITE_BACKGROUND = "\u001B[47m";

    private String topTopPart;
    private String topMiddlePart;
    private String topBottomPart;
    private String middleTopPart;
    private String middleMiddlePart;
    private String middleBottomPart;
    private String bottomTopPart ;
    private String bottomMiddlePart;
    private String bottomBottomPart;

    private int counterForCellNumber = 0;

    private LinkedList<String> cellsInTheGrid;

    public Grid() {
        initCells();
        this.cellValue = CellValueType.EMPTY;

        topTopPart =             "      |      |      ";
        topMiddlePart =    "  " + cells[0].getValue().getMoveType() + "   |  " + cells[1].getValue().getMoveType() + "   |  " + cells[2].getValue().getMoveType() + "   ";
        topBottomPart =          "______|______|______";
        middleTopPart =          "      |      |      ";
        middleMiddlePart = "  " + cells[3].getValue().getMoveType() + "   |  " + cells[4].getValue().getMoveType() + "   |  " + cells[5].getValue().getMoveType() + "   ";
        middleBottomPart =       "______|______|______";
        bottomTopPart =          "      |      |      ";
        bottomMiddlePart = "  " + cells[6].getValue().getMoveType() + "   |  " + cells[7].getValue().getMoveType() + "   |  " + cells[8].getValue().getMoveType() + "   ";
        bottomBottomPart =       "      |      |      ";

        this.cellsInTheGrid = new LinkedList<>();
        this.cellsInTheGrid.add(topTopPart);
        this.cellsInTheGrid.add(topMiddlePart);
        this.cellsInTheGrid.add(topBottomPart);
        this.cellsInTheGrid.add(middleTopPart);
        this.cellsInTheGrid.add(middleMiddlePart);
        this.cellsInTheGrid.add(middleBottomPart);
        this.cellsInTheGrid.add(bottomTopPart);
        this.cellsInTheGrid.add(bottomMiddlePart);
        this.cellsInTheGrid.add(bottomBottomPart);
    }

    public void initCells(){
        this.cells = new Cell[9];
        for (int i = 0; i < cells.length ; i++) {
            cells[i] = new Cell();
        }
    }

    @Override
    public CellValueType getValue() {
        return this.cellValue;
    }

    @Override
    public void setValue(CellValueType playerValue) {
        this.cellValue = playerValue;
    }

    @Override
    public CellValueType getCellValue(int index) {
        return this.cells[index].getValue();
    }

    @Override
    public void setCellValue(CellValueType playerValue, int index) {
        this.cells[index].setValue(playerValue);
    }

    public Valuable[] getCells() {
        return this.cells;
    }

    public LinkedList<String> getCellList() {
        return cellsInTheGrid;
    }

    public String getCellNumber(){
        counterForCellNumber++;

        switch (counterForCellNumber){
            case 1:
                return "1 ";
            case 4:
                return "2 ";
            case 7:
                return "3 ";
            default:
                return "  ";
        }

    }
}
