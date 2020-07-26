package org.academiadecodigo.felinux.mvc.model.grid;

import org.academiadecodigo.felinux.mvc.model.Gridable;
import org.academiadecodigo.felinux.mvc.model.Valuable;
import org.academiadecodigo.felinux.mvc.model.cell.Cell;
import org.academiadecodigo.felinux.mvc.model.cell.CellValueType;
import org.academiadecodigo.felinux.mvc.view.textIO.DrawBoardText;
import org.academiadecodigo.felinux.mvc.view.textIO.DrawColors;
import org.academiadecodigo.felinux.mvc.view.textIO.MenuOptions;

import java.awt.*;
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

        String topTopLeftPart = DrawColors.WHITE_BACKGROUND + DrawColors.BLUE + "      |" + DrawColors.RESET + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
        String topTopMiddlePart = DrawColors.WHITE_BACKGROUND + DrawColors.BLUE + "      |" + DrawColors.RESET + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
        String topTopRightPart = DrawColors.WHITE_BACKGROUND + DrawColors.BLUE + "      " + DrawColors.RESET + " " + DrawColors.RESET + DrawColors.GREY_BACKGROUND + DrawColors.RESET;

        String topMiddleLeftPart =      DrawColors.WHITE_BACKGROUND + "  " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND +cells[0].getValue().getMoveType()+ DrawColors.RESET + DrawColors.WHITE_BACKGROUND + DrawColors.BLUE + "   |" + DrawColors.RESET + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
        String topMiddleMiddlePart =  DrawColors.WHITE_BACKGROUND + "  " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND +cells[1].getValue().getMoveType()+ DrawColors.RESET + DrawColors.WHITE_BACKGROUND + DrawColors.BLUE + "   |" + DrawColors.RESET + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
        String topMiddleRightPart =   DrawColors.WHITE_BACKGROUND + "  " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND +cells[2].getValue().getMoveType()+ DrawColors.RESET + DrawColors.WHITE_BACKGROUND + "   " + DrawColors.RESET + " " + DrawColors.RESET + DrawColors.GREY_BACKGROUND + DrawColors.RESET;

        String topBottomLeftPart =      DrawColors.WHITE_BACKGROUND + DrawColors.BLUE + "______|" + DrawColors.RESET + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
        String topBottomMiddlePart = DrawColors.WHITE_BACKGROUND + DrawColors.BLUE + "______|" + DrawColors.RESET + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
        String topBottomRightPart = DrawColors.WHITE_BACKGROUND + DrawColors.BLUE + "______" + DrawColors.RESET + " " + DrawColors.RESET + DrawColors.GREY_BACKGROUND + DrawColors.RESET;

        String middleTopLeftPart = DrawColors.WHITE_BACKGROUND + DrawColors.BLUE + "      |" + DrawColors.RESET + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
        String middleTopMiddlePart = DrawColors.WHITE_BACKGROUND + DrawColors.BLUE + "      |" + DrawColors.RESET + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
        String middleTopRightPart = DrawColors.WHITE_BACKGROUND + DrawColors.BLUE + "      " + DrawColors.RESET + " " + DrawColors.RESET + DrawColors.GREY_BACKGROUND + DrawColors.RESET;

        String middleMiddleLeftPart =   DrawColors.WHITE_BACKGROUND + "  " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND +cells[3].getValue().getMoveType()+ DrawColors.RESET + DrawColors.WHITE_BACKGROUND + DrawColors.BLUE + "   |" + DrawColors.RESET + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
        String middleMiddleMiddlePart =  DrawColors.WHITE_BACKGROUND + "  " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND +cells[4].getValue().getMoveType()+ DrawColors.RESET + DrawColors.WHITE_BACKGROUND + DrawColors.BLUE + "   |" + DrawColors.RESET + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
        String middleMiddleRightPart =  DrawColors.WHITE_BACKGROUND + "  " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND +cells[5].getValue().getMoveType()+ DrawColors.RESET + DrawColors.WHITE_BACKGROUND + "   " + DrawColors.RESET + " " + DrawColors.RESET + DrawColors.GREY_BACKGROUND + DrawColors.RESET;

        String middleBottomLeftPart =   DrawColors.WHITE_BACKGROUND + DrawColors.BLUE + "______|" + DrawColors.RESET + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
        String middleBottomMiddlePart = DrawColors.WHITE_BACKGROUND + DrawColors.BLUE + "______|" + DrawColors.RESET + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
        String middleBottomRightPart = DrawColors.WHITE_BACKGROUND + DrawColors.BLUE + "______" + DrawColors.RESET + " " + DrawColors.RESET + DrawColors.GREY_BACKGROUND + DrawColors.RESET;

        String bottomTopLeftPart =      DrawColors.WHITE_BACKGROUND + DrawColors.BLUE + "      |" + DrawColors.RESET + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
        String bottomTopMiddlePart = DrawColors.WHITE_BACKGROUND + DrawColors.BLUE + "      |" + DrawColors.RESET + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
        String bottomTopRightPart = DrawColors.WHITE_BACKGROUND + DrawColors.BLUE + "      " + DrawColors.RESET + " " + DrawColors.RESET + DrawColors.GREY_BACKGROUND + DrawColors.RESET;

        String bottomMiddleLeftPart =   DrawColors.WHITE_BACKGROUND + "  " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND +cells[6].getValue().getMoveType()+ DrawColors.RESET + DrawColors.WHITE_BACKGROUND + DrawColors.BLUE + "   |" + DrawColors.RESET + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
        String bottomMiddleMiddlePart =  DrawColors.WHITE_BACKGROUND + "  " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND +cells[7].getValue().getMoveType()+ DrawColors.RESET + DrawColors.WHITE_BACKGROUND + DrawColors.BLUE + "   |" + DrawColors.RESET + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
        String bottomMiddleRightPart = DrawColors.WHITE_BACKGROUND + "  " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND +cells[8].getValue().getMoveType()+ DrawColors.RESET + DrawColors.WHITE_BACKGROUND + "   " + DrawColors.RESET + " " + DrawColors.RESET + DrawColors.GREY_BACKGROUND + DrawColors.RESET;


        String bottomBottomLeftPart =   DrawColors.WHITE_BACKGROUND + DrawColors.BLUE + "      |" + DrawColors.RESET + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
        String bottomBottomRightPart = DrawColors.WHITE_BACKGROUND + DrawColors.BLUE + "      |" + DrawColors.RESET + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
        String bottomBottomBottomPart = DrawColors.WHITE_BACKGROUND + DrawColors.BLUE + "      " + DrawColors.RESET + " " + DrawColors.RESET + DrawColors.GREY_BACKGROUND + DrawColors.RESET;


        this.cellsInTheGrid = new LinkedList<String>() {
            {
                 /*      A      B      C
                             |      |
                     1   -   |  -   |  -
                       ______|______|______
                             |      |
                     2   -   |  -   |  -
                       ______|______|______
                             |      |
                     3   -   |  -   |  -
                             |      |
                */

                add(topTopLeftPart);
                add(topTopMiddlePart);
                add(topTopRightPart);

                add(topMiddleLeftPart);
                add(topMiddleMiddlePart);
                add(topMiddleRightPart);

                add(topBottomLeftPart);
                add(topBottomMiddlePart);
                add(topBottomRightPart);


                add(middleTopLeftPart);
                add(middleTopMiddlePart);
                add(middleTopRightPart);

                add(middleMiddleLeftPart);
                add(middleMiddleMiddlePart);
                add(middleMiddleRightPart);

                add(middleBottomLeftPart);
                add(middleBottomMiddlePart);
                add(middleBottomRightPart);


                add(bottomTopLeftPart);
                add(bottomTopMiddlePart);
                add(bottomTopRightPart);

                add(bottomMiddleLeftPart);
                add(bottomMiddleMiddlePart);
                add(bottomMiddleRightPart);

                add(bottomBottomLeftPart);
                add(bottomBottomRightPart);
                add(bottomBottomBottomPart);
            }
        };
    }
    public String drawGameBoard(){

        initGrid();
        playerPlayPrint();

        String returnableString = "\n";

        returnableString += "  " + DrawBoardText.smallHeader + "\n";

        for (int i = 0; i < cellsInTheGrid.size(); i+=3) {
            returnableString += getCellNumber()
                    .concat(getCellNumber())
                    .concat(getCellList().get(i)).concat(getCellList().get(i+1)).concat(getCellList().get(i+2)) + "\n";
        }
        return returnableString;
    }

    public void playerPlayPrint(){

        String valueToPaint0 = "";
        String valueToPaint1 = "";
        String valueToPaint2 = "";
        String valueToPaint3 = "";
        String valueToPaint4 = "";
        String valueToPaint5 = "";
        String valueToPaint6 = "";
        String valueToPaint7 = "";
        String valueToPaint8 = "";
        String valueToPaint9 = "";
        String valueToPaint10 = "";
        String valueToPaint11 = "";
        String valueToPaint12 = "";
        String valueToPaint13 = "";
        String valueToPaint14 = "";
        String valueToPaint15 = "";
        String valueToPaint16 = "";
        String valueToPaint17 = "";
        String valueToPaint18 = "";
        String valueToPaint19 = "";
        String valueToPaint20 = "";
        String valueToPaint21 = "";
        String valueToPaint22 = "";
        String valueToPaint23 = "";
        String valueToPaint24 = "";
        String valueToPaint25 = "";
        String valueToPaint26 = "";

        for (int i = 0; i < cells.length; i++) {

            if(!cells[i].getValue().getMoveType().equals(CellValueType.EMPTY.getMoveType())){
                switch (i){
                    case 0:
                        if(cells[0].getValue().equals(CellValueType.PLAYER_1)) {
                            valueToPaint0 = DrawColors.GREEN_BACKGROUND + "      " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND + DrawColors.BLUE + "|" + DrawColors.RESET + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                            valueToPaint3 = DrawColors.GREEN_BACKGROUND + "  " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND + cells[0].getValue().getMoveType() + DrawColors.RESET + DrawColors.GREEN_BACKGROUND + "   " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND + DrawColors.BLUE + "|" + DrawColors.RESET + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                            valueToPaint6 = DrawColors.GREEN_BACKGROUND + DrawColors.BLUE + "______" + DrawColors.RESET + DrawColors.WHITE_BACKGROUND + DrawColors.BLUE + "|" + DrawColors.RESET + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                            cellsInTheGrid.set(0, valueToPaint0);
                            cellsInTheGrid.set(3, valueToPaint3);
                            cellsInTheGrid.set(6, valueToPaint6);
                            continue;
                        }
                        valueToPaint0 = DrawColors.RED_BACKGROUND + "      " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND + DrawColors.BLUE + "|" + DrawColors.RESET + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                        valueToPaint3 = DrawColors.RED_BACKGROUND + "  " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND + cells[0].getValue().getMoveType() + DrawColors.RESET + DrawColors.RED_BACKGROUND + "   " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND + DrawColors.BLUE + "|" + DrawColors.RESET + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                        valueToPaint6 =  DrawColors.RED_BACKGROUND + DrawColors.BLUE + "______" + DrawColors.RESET + DrawColors.WHITE_BACKGROUND + DrawColors.BLUE + "|" + DrawColors.RESET + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                        cellsInTheGrid.set(0,valueToPaint0);
                        cellsInTheGrid.set(3,valueToPaint3);
                        cellsInTheGrid.set(6,valueToPaint6);
                        continue;
                    case 1:
                        if(cells[1].getValue().equals(CellValueType.PLAYER_1)){
                            valueToPaint1 = DrawColors.GREEN_BACKGROUND + "      " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND + DrawColors.BLUE + "|" + DrawColors.RESET + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                            valueToPaint4 = DrawColors.GREEN_BACKGROUND + "  " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND +cells[1].getValue().getMoveType() + DrawColors.RESET + DrawColors.GREEN_BACKGROUND + "   " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND + DrawColors.BLUE + "|" + DrawColors.RESET + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                            valueToPaint7 = DrawColors.GREEN_BACKGROUND + DrawColors.BLUE + "______" + DrawColors.RESET + DrawColors.WHITE_BACKGROUND + DrawColors.BLUE + "|" + DrawColors.RESET + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                            cellsInTheGrid.set(1,valueToPaint1);
                            cellsInTheGrid.set(4,valueToPaint4);
                            cellsInTheGrid.set(7,valueToPaint7);
                            continue;
                        }
                        valueToPaint1 = DrawColors.RED_BACKGROUND + "      " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND + DrawColors.BLUE + "|" + DrawColors.RESET + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                        valueToPaint4 = DrawColors.RED_BACKGROUND + "  " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND +cells[1].getValue().getMoveType() + DrawColors.RESET + DrawColors.RED_BACKGROUND + "   " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND + DrawColors.BLUE + "|" + DrawColors.RESET + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                        valueToPaint7 = DrawColors.RED_BACKGROUND + DrawColors.BLUE + "______" + DrawColors.RESET + DrawColors.WHITE_BACKGROUND + DrawColors.BLUE + "|" + DrawColors.RESET + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                        cellsInTheGrid.set(1,valueToPaint1);
                        cellsInTheGrid.set(4,valueToPaint4);
                        cellsInTheGrid.set(7,valueToPaint7);
                        continue;
                    case 2:
                        if(cells[2].getValue().equals(CellValueType.PLAYER_1)){
                            valueToPaint2 = DrawColors.GREEN_BACKGROUND + "      " + DrawColors.RESET + " " + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                            valueToPaint5 = DrawColors.GREEN_BACKGROUND + "  " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND +cells[2].getValue().getMoveType()+ DrawColors.RESET + DrawColors.GREEN_BACKGROUND + "   " + DrawColors.RESET + " " + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                            valueToPaint8 = DrawColors.GREEN_BACKGROUND+ DrawColors.BLUE + "______" + DrawColors.RESET + " " + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                            cellsInTheGrid.set(2,valueToPaint2);
                            cellsInTheGrid.set(5,valueToPaint5);
                            cellsInTheGrid.set(8,valueToPaint8);
                            continue;
                        }
                        valueToPaint2 = DrawColors.RED_BACKGROUND + "      " + DrawColors.RESET + " " + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                        valueToPaint5 = DrawColors.RED_BACKGROUND + "  " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND +cells[2].getValue().getMoveType()+ DrawColors.RESET + DrawColors.RED_BACKGROUND + "   " + DrawColors.RESET + " " + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                        valueToPaint8 = DrawColors.RED_BACKGROUND + DrawColors.BLUE + "______" + DrawColors.RESET + " " + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                        cellsInTheGrid.set(2,valueToPaint2);
                        cellsInTheGrid.set(5,valueToPaint5);
                        cellsInTheGrid.set(8,valueToPaint8);
                        continue;
                    case 3:
                        if(cells[3].getValue().equals(CellValueType.PLAYER_1)){
                            valueToPaint9 = DrawColors.GREEN_BACKGROUND + "      " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND + DrawColors.BLUE + "|" + DrawColors.RESET + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                            valueToPaint12 = DrawColors.GREEN_BACKGROUND + "  " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND +cells[3].getValue().getMoveType()+ DrawColors.RESET + DrawColors.GREEN_BACKGROUND + "   " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND + DrawColors.BLUE + "|" + DrawColors.RESET + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                            valueToPaint15 = DrawColors.GREEN_BACKGROUND + DrawColors.BLUE + "______" + DrawColors.RESET + DrawColors.WHITE_BACKGROUND + DrawColors.BLUE + "|" + DrawColors.RESET + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                            cellsInTheGrid.set(9,valueToPaint9);
                            cellsInTheGrid.set(12,valueToPaint12);
                            cellsInTheGrid.set(15,valueToPaint15);
                            continue;
                        }
                        valueToPaint9 = DrawColors.RED_BACKGROUND + "      " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND + DrawColors.BLUE + "|" + DrawColors.RESET + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                        valueToPaint12 = DrawColors.RED_BACKGROUND + "  " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND +cells[3].getValue().getMoveType()+ DrawColors.RESET + DrawColors.RED_BACKGROUND + "   " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND + DrawColors.BLUE +  "|" + DrawColors.RESET + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                        valueToPaint15 = DrawColors.RED_BACKGROUND + DrawColors.BLUE + "______" + DrawColors.RESET + DrawColors.WHITE_BACKGROUND + DrawColors.BLUE + "|" + DrawColors.RESET + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                        cellsInTheGrid.set(9,valueToPaint9);
                        cellsInTheGrid.set(12,valueToPaint12);
                        cellsInTheGrid.set(15,valueToPaint15);
                        continue;
                    case 4:
                        if(cells[4].getValue().equals(CellValueType.PLAYER_1)){
                            valueToPaint10 = DrawColors.GREEN_BACKGROUND + "      " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND + DrawColors.BLUE + "|" + DrawColors.RESET + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                            valueToPaint13 = DrawColors.GREEN_BACKGROUND + "  " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND +cells[4].getValue().getMoveType()+ DrawColors.RESET + DrawColors.GREEN_BACKGROUND + "   " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND + DrawColors.BLUE + "|" + DrawColors.RESET + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                            valueToPaint16 = DrawColors.GREEN_BACKGROUND + DrawColors.BLUE + "______" + DrawColors.RESET + DrawColors.WHITE_BACKGROUND + DrawColors.BLUE + "|" + DrawColors.RESET + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                            cellsInTheGrid.set(10,valueToPaint10);
                            cellsInTheGrid.set(13,valueToPaint13);
                            cellsInTheGrid.set(16,valueToPaint16);
                            continue;
                        }
                        valueToPaint10 = DrawColors.RED_BACKGROUND + "      " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND + DrawColors.BLUE + "|" + DrawColors.RESET + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                        valueToPaint13 = DrawColors.RED_BACKGROUND + "  " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND +cells[4].getValue().getMoveType()+ DrawColors.RESET + DrawColors.RED_BACKGROUND + "   " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND + DrawColors.BLUE + "|" + DrawColors.RESET + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                        valueToPaint16 = DrawColors.RED_BACKGROUND + DrawColors.BLUE + "______" + DrawColors.RESET + DrawColors.WHITE_BACKGROUND + DrawColors.BLUE + "|" + DrawColors.RESET + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                        cellsInTheGrid.set(10,valueToPaint10);
                        cellsInTheGrid.set(13,valueToPaint13);
                        cellsInTheGrid.set(16,valueToPaint16);
                        continue;
                    case 5:
                        if(cells[5].getValue().equals(CellValueType.PLAYER_1)){
                            valueToPaint11 = DrawColors.GREEN_BACKGROUND + "      " + DrawColors.RESET + " " + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                            valueToPaint14 = DrawColors.GREEN_BACKGROUND + "  " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND +cells[5].getValue().getMoveType()+ DrawColors.RESET + DrawColors.GREEN_BACKGROUND + "   " + DrawColors.RESET + " " + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                            valueToPaint17 = DrawColors.GREEN_BACKGROUND + DrawColors.BLUE + "______" + DrawColors.RESET + " " + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                            cellsInTheGrid.set(11,valueToPaint11);
                            cellsInTheGrid.set(14,valueToPaint14);
                            cellsInTheGrid.set(17,valueToPaint17);
                            continue;
                        }
                        valueToPaint11 = DrawColors.RED_BACKGROUND + "      " + DrawColors.RESET + " " + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                        valueToPaint14 = DrawColors.RED_BACKGROUND + "  " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND +cells[5].getValue().getMoveType()+ DrawColors.RESET + DrawColors.RED_BACKGROUND + "   " + DrawColors.RESET + " ";
                        valueToPaint17 = DrawColors.RED_BACKGROUND + DrawColors.BLUE + "______" + DrawColors.RESET + " " + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                        cellsInTheGrid.set(11,valueToPaint11);
                        cellsInTheGrid.set(14,valueToPaint14);
                        cellsInTheGrid.set(17,valueToPaint17);
                        continue;
                    case 6:
                        if(cells[6].getValue().equals(CellValueType.PLAYER_1)){
                            valueToPaint18 = DrawColors.GREEN_BACKGROUND + "      " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND + DrawColors.BLUE + "|" + DrawColors.RESET + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                            valueToPaint21 = DrawColors.GREEN_BACKGROUND + "  " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND +cells[6].getValue().getMoveType()+ DrawColors.RESET + DrawColors.GREEN_BACKGROUND + "   " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND + DrawColors.BLUE + "|" + DrawColors.RESET + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                            valueToPaint24 = DrawColors.GREEN_BACKGROUND + "      " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND + DrawColors.BLUE + "|" + DrawColors.RESET + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                            cellsInTheGrid.set(18,valueToPaint18);
                            cellsInTheGrid.set(21,valueToPaint21);
                            cellsInTheGrid.set(24,valueToPaint24);
                            continue;
                        }
                        valueToPaint18 = DrawColors.RED_BACKGROUND + "      " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND + DrawColors.BLUE + "|" + DrawColors.RESET + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                        valueToPaint21 = DrawColors.RED_BACKGROUND + "  " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND +cells[6].getValue().getMoveType()+ DrawColors.RESET + DrawColors.RED_BACKGROUND + "   " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND + DrawColors.BLUE + "|" + DrawColors.RESET + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                        valueToPaint24 = DrawColors.RED_BACKGROUND + "      " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND + DrawColors.BLUE + "|" + DrawColors.RESET + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                        cellsInTheGrid.set(18,valueToPaint18);
                        cellsInTheGrid.set(21,valueToPaint21);
                        cellsInTheGrid.set(24,valueToPaint24);
                        continue;
                    case 7:
                        if(cells[7].getValue().equals(CellValueType.PLAYER_1)){
                            valueToPaint19 = DrawColors.GREEN_BACKGROUND + "      " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND + DrawColors.BLUE + "|" + DrawColors.RESET + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                            valueToPaint22 = DrawColors.GREEN_BACKGROUND + "  " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND +cells[7].getValue().getMoveType()+ DrawColors.RESET + DrawColors.GREEN_BACKGROUND + "   " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND + DrawColors.BLUE + "|" + DrawColors.RESET + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                            valueToPaint25 = DrawColors.GREEN_BACKGROUND + "      " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND + DrawColors.BLUE + "|" + DrawColors.RESET + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                            cellsInTheGrid.set(19,valueToPaint19);
                            cellsInTheGrid.set(22,valueToPaint22);
                            cellsInTheGrid.set(25,valueToPaint25);
                            continue;
                        }
                        valueToPaint19 = DrawColors.RED_BACKGROUND + "      " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND + DrawColors.BLUE + "|" + DrawColors.RESET + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                        valueToPaint22 = DrawColors.RED_BACKGROUND + "  " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND +cells[7].getValue().getMoveType()+ DrawColors.RESET + DrawColors.RED_BACKGROUND + "   " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND + DrawColors.BLUE + "|" + DrawColors.RESET + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                        valueToPaint25 = DrawColors.RED_BACKGROUND + "      " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND + DrawColors.BLUE + "|" + DrawColors.RESET + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                        cellsInTheGrid.set(19,valueToPaint19);
                        cellsInTheGrid.set(22,valueToPaint22);
                        cellsInTheGrid.set(25,valueToPaint25);
                        continue;
                    case 8:
                        if(cells[8].getValue().equals(CellValueType.PLAYER_1)){
                            valueToPaint20 = DrawColors.GREEN_BACKGROUND + "      " + DrawColors.RESET + " " + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                            valueToPaint23 = DrawColors.GREEN_BACKGROUND + "  " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND +cells[8].getValue().getMoveType()+ DrawColors.RESET + DrawColors.GREEN_BACKGROUND + "   " + DrawColors.RESET + " " + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                            valueToPaint26 = DrawColors.GREEN_BACKGROUND + "      " + DrawColors.RESET + " " + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                            cellsInTheGrid.set(20,valueToPaint20);
                            cellsInTheGrid.set(23,valueToPaint23);
                            cellsInTheGrid.set(26,valueToPaint26);
                            continue;
                        }
                        valueToPaint20 = DrawColors.RED_BACKGROUND + "      " + DrawColors.RESET + " " + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                        valueToPaint23 = DrawColors.RED_BACKGROUND + "  " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND +cells[8].getValue().getMoveType()+ DrawColors.RESET + DrawColors.RED_BACKGROUND + "   " + DrawColors.RESET + " " + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                        valueToPaint26 = DrawColors.RED_BACKGROUND + "      " + DrawColors.RESET + " " + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                        cellsInTheGrid.set(20,valueToPaint20);
                        cellsInTheGrid.set(23,valueToPaint23);
                        cellsInTheGrid.set(26,valueToPaint26);
                        continue;
                }
            }
        }
    }

    public String getCellNumber(){
        //Outputs to the console the "1,2,3" numbers on the left of each left-most grid
        counterForCellNumber++;

        switch (counterForCellNumber){
            case 4:
                return DrawColors.YELLOW + "1 " + DrawColors.RESET;
            case 10:
                return DrawColors.YELLOW + "2 " + DrawColors.RESET;
            case 16:
                return DrawColors.YELLOW + "3 " + DrawColors.RESET;
            case 18:
                counterForCellNumber = 0;
                return "  ";
            default:
                return "  ";
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

}
