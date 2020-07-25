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

    private String leftHeader1 = "  _   ";
    private String leftHeader11 = " / |  ";
    private String leftHeader111 = " | |  ";
    private String leftHeader1111 = " |_|_ ";
    private String leftHeader2 = "  ___ ";
    private String leftHeader22 = " |_  )";
    private String leftHeader222 = "  / / ";
    private String leftHeader2222 = " /___|";
    private String leftHeader3 = "  ___ ";
    private String leftHeader33 = " |__ /";
    private String leftHeader333 = "  |_ \\";
    private String leftHeader3333 = " |___/";

    private String topMiddlePart =      YELLOW + "1" + RESET + "  A   |  A   |  A   ";
    private String middleMiddlePart =   YELLOW + "2" + RESET + "  B   |  B   |  B   ";
    private String bottomMiddlePart =   YELLOW + "3" + RESET + "  C   |  C   |  C   ";

    private String topTopPart =             "       |      |      ";
    private String topMiddleConcatPart =    "   " + cells[0].getValue().getMoveType() + "   |  " + cells[1].getValue().getMoveType() + "   |  " + cells[2].getValue().getMoveType() + "   ";
    private String topBottomPart =          " ______|______|______";
    private String middleTopPart =          "       |      |      ";
    private String middleMiddleConcatPart = "   " + cells[3].getValue().getMoveType() + "   |  " + cells[4].getValue().getMoveType() + "   |  " + cells[5].getValue().getMoveType() + "   ";
    private String middleBottomPart =       " ______|______|______";
    private String bottomTopPart =          "       |      |      ";
    private String bottomMiddleConcatPart = "   " + cells[6].getValue().getMoveType() + "   |  " + cells[7].getValue().getMoveType() + "   |  " + cells[8].getValue().getMoveType() + "   ";
    private String bottomBottomPart =       "       |      |      ";


    private LinkedList<String> firstCell;
    private LinkedList<String> everyOtherCell;

    public Grid() {
        this.cells = new Cell[9];
<<<<<<< HEAD
        initCell();
=======
        initCells();
>>>>>>> 8b07aec27513876f4cce63af17512c5a1e146284
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

    public void initCells(){
        for (int i = 0; i < cells.length ; i++) {
            cells[i] = new Cell();
        }
    }

    public void initCell() {
        for (int i = 0; i < 9; i++) {
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

    public LinkedList<String> getEveryOtherCellList() {
        return everyOtherCell;
    }

    public LinkedList<String> getFirstCellList() {
        return firstCell;
    }
}
