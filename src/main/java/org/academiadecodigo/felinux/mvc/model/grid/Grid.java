package org.academiadecodigo.felinux.mvc.model.grid;

import org.academiadecodigo.felinux.mvc.model.Gridable;
import org.academiadecodigo.felinux.mvc.model.Valuable;
import org.academiadecodigo.felinux.mvc.model.cell.Cell;
import org.academiadecodigo.felinux.mvc.model.cell.CellValueType;
import org.academiadecodigo.felinux.mvc.view.textIO.DrawBoardText;
import org.academiadecodigo.felinux.mvc.view.textIO.DrawColors;

import java.util.LinkedList;

public class Grid implements Gridable, Valuable {

    Cell[] cells;
    CellValueType cellValue;

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

        topTopPart =             "      |      |       ";
        topMiddlePart =    "  " + cells[0].getValue().getMoveType() + "   |  " + cells[1].getValue().getMoveType() + "   |  " + cells[2].getValue().getMoveType() + "    ";
        topBottomPart =          "______|______|______ ";
        middleTopPart =          "      |      |       ";
        middleMiddlePart = "  " + cells[3].getValue().getMoveType() + "   |  " + cells[4].getValue().getMoveType() + "   |  " + cells[5].getValue().getMoveType() + "    ";
        middleBottomPart =       "______|______|______ ";
        bottomTopPart =          "      |      |       ";
        bottomMiddlePart = "  " + cells[6].getValue().getMoveType() + "   |  " + cells[7].getValue().getMoveType() + "   |  " + cells[8].getValue().getMoveType() + "    ";
        bottomBottomPart =       "      |      |       ";

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
    public void drawGameBoard(){


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
