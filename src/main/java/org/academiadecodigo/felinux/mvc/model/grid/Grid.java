package org.academiadecodigo.felinux.mvc.model.grid;

import org.academiadecodigo.felinux.mvc.model.Gridable;
import org.academiadecodigo.felinux.mvc.model.Valuable;
import org.academiadecodigo.felinux.mvc.model.cell.Cell;
import org.academiadecodigo.felinux.mvc.model.cell.CellValueType;
import org.academiadecodigo.felinux.mvc.view.textIO.DrawBoardText;
import org.academiadecodigo.felinux.mvc.view.textIO.DrawColors;

import java.util.LinkedList;

public class Grid implements Gridable, Valuable {

    private Cell[] cells;
    private CellValueType cellValue;

    private int counterForCellNumber = 0;

    private LinkedList<String> cellsInTheGrid;

    public Grid() {

        initCells();
        initGrid();
    }

    public void initCells() {

        this.cells = new Cell[9];

        for (int i = 0; i < cells.length ; i++) {
            cells[i] = new Cell();
        }

        this.cellValue = CellValueType.EMPTY;
    }

    public void initGrid() {

        String topTopPart =             "      |      |       ";
        String topMiddlePart =    "  " + cells[0].getValue().getMoveType() + "   |  " + cells[1].getValue().getMoveType() + "   |  " + cells[2].getValue().getMoveType() + "    ";
        String topBottomPart =          "______|______|______ ";
        String middleTopPart =          "      |      |       ";
        String middleMiddlePart = "  " + cells[3].getValue().getMoveType() + "   |  " + cells[4].getValue().getMoveType() + "   |  " + cells[5].getValue().getMoveType() + "    ";
        String middleBottomPart =       "______|______|______ ";
        String bottomTopPart =          "      |      |       ";
        String bottomMiddlePart = "  " + cells[6].getValue().getMoveType() + "   |  " + cells[7].getValue().getMoveType() + "   |  " + cells[8].getValue().getMoveType() + "    ";
        String bottomBottomPart =       "      |      |       ";

        this.cellsInTheGrid = new LinkedList<String>() {
            {
                add(topTopPart);
                add(topMiddlePart);
                add(topBottomPart);
                add(middleTopPart);
                add(middleMiddlePart);
                add(middleBottomPart);
                add(bottomTopPart);
                add(bottomMiddlePart);
                add(bottomBottomPart);
            }
        };
    }
    public void drawGameBoard(){

        initGrid();

        System.out.println(DrawBoardText.smallHeader);

        for (int i = 0; i < cells.length; i++) {
            //draws full game board
            System.out.println(
                    getCellNumber()
                            .concat(getCellNumber())
                            .concat(getCellList().get(i)));

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
        //Outputs to the console the "1,2,3" numbers on the left of each left-most grid
        counterForCellNumber++;

        switch (counterForCellNumber){
            case 4:
                return DrawColors.YELLOW + "1" + DrawColors.RESET;
            case 10:
                return DrawColors.YELLOW + "2" + DrawColors.RESET;
            case 16:
                return DrawColors.YELLOW + "3" + DrawColors.RESET;
            default:
                return " ";
        }
    }
}
