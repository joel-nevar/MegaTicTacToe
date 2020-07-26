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

    private String backGroundColor;

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

        String topTopLeftPart = DrawColors.WHITE_BACKGROUND + "      |" + DrawColors.RESET;
        String topTopMiddlePart = DrawColors.WHITE_BACKGROUND + "      |" + DrawColors.RESET;
        String topTopRightPart = DrawColors.WHITE_BACKGROUND + "      " + DrawColors.RESET + " ";

        String topMiddleLeftPart =      DrawColors.WHITE_BACKGROUND + "  " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND +cells[0].getValue().getMoveType()+ DrawColors.RESET + DrawColors.WHITE_BACKGROUND + "   |" + DrawColors.RESET;
        String topMiddleMiddlePart =  DrawColors.WHITE_BACKGROUND + "  " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND +cells[1].getValue().getMoveType()+ DrawColors.RESET + DrawColors.WHITE_BACKGROUND + "   |" + DrawColors.RESET;
        String topMiddleRightPart =   DrawColors.WHITE_BACKGROUND + "  " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND +cells[2].getValue().getMoveType()+ DrawColors.RESET + DrawColors.WHITE_BACKGROUND + "   " + DrawColors.RESET + " ";

        String topBottomLeftPart =      DrawColors.WHITE_BACKGROUND + "______|" + DrawColors.RESET;
        String topBottomMiddlePart = DrawColors.WHITE_BACKGROUND + "______|" + DrawColors.RESET;
        String topBottomRightPart = DrawColors.WHITE_BACKGROUND + "______" + DrawColors.RESET + " ";

        String middleTopLeftPart = DrawColors.WHITE_BACKGROUND + "      |" + DrawColors.RESET;
        String middleTopMiddlePart = DrawColors.WHITE_BACKGROUND + "      |" + DrawColors.RESET;
        String middleTopRightPart = DrawColors.WHITE_BACKGROUND + "      " + DrawColors.RESET + " ";

        String middleMiddleLeftPart =   DrawColors.WHITE_BACKGROUND + "  " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND +cells[3].getValue().getMoveType()+ DrawColors.RESET + DrawColors.WHITE_BACKGROUND + "   |" + DrawColors.RESET;
        String middleMiddleMiddlePart =  DrawColors.WHITE_BACKGROUND + "  " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND +cells[4].getValue().getMoveType()+ DrawColors.RESET + DrawColors.WHITE_BACKGROUND + "   |" + DrawColors.RESET;
        String middleMiddleRightPart =  DrawColors.WHITE_BACKGROUND + "  " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND +cells[5].getValue().getMoveType()+ DrawColors.RESET + DrawColors.WHITE_BACKGROUND + "   " + DrawColors.RESET + " ";

        String middleBottomLeftPart =   DrawColors.WHITE_BACKGROUND + "______|" + DrawColors.RESET;
        String middleBottomMiddlePart = DrawColors.WHITE_BACKGROUND + "______|" + DrawColors.RESET;
        String middleBottomRightPart = DrawColors.WHITE_BACKGROUND + "______" + DrawColors.RESET + " ";

        String bottomTopLeftPart =      DrawColors.WHITE_BACKGROUND + "      |" + DrawColors.RESET;
        String bottomTopMiddlePart = DrawColors.WHITE_BACKGROUND + "      |" + DrawColors.RESET;
        String bottomTopRightPart = DrawColors.WHITE_BACKGROUND + "      " + DrawColors.RESET + " ";

        String bottomMiddleLeftPart =   DrawColors.WHITE_BACKGROUND + "  " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND +cells[6].getValue().getMoveType()+ DrawColors.RESET + DrawColors.WHITE_BACKGROUND + "   |" + DrawColors.RESET;
        String bottomMiddleMiddlePart =  DrawColors.WHITE_BACKGROUND + "  " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND +cells[7].getValue().getMoveType()+ DrawColors.RESET + DrawColors.WHITE_BACKGROUND + "   |" + DrawColors.RESET;
        String bottomMiddleRightPart = DrawColors.WHITE_BACKGROUND + "  " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND +cells[8].getValue().getMoveType()+ DrawColors.RESET + DrawColors.WHITE_BACKGROUND + "   " + DrawColors.RESET + " ";


        String bottomBottomLeftPart =   DrawColors.WHITE_BACKGROUND + "      |" + DrawColors.RESET;
        String bottomBottomRightPart = DrawColors.WHITE_BACKGROUND + "      |" + DrawColors.RESET;
        String bottomBottomBottomPart = DrawColors.WHITE_BACKGROUND + "      " + DrawColors.RESET + " ";


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
        player1Play();

        String returnableString = "";

        System.out.println("  " + DrawBoardText.smallHeader);

        returnableString += "  " + DrawBoardText.smallHeader + "\n";

        for (int i = 0; i < cellsInTheGrid.size(); i+=3) {
            //draws full game board
            System.out.println(
                    getCellNumber()
                    .concat(getCellNumber())
                    .concat(getCellList().get(i)).concat(getCellList().get(i+1)).concat(getCellList().get(i+2))
            );
            returnableString += getCellNumber()
                    .concat(getCellNumber())
                    .concat(getCellList().get(i)).concat(getCellList().get(i+1)).concat(getCellList().get(i+2)) + "\n";
        }
        System.out.println(returnableString);
        return returnableString;
    }

    public void player1Play(){
        String valueToPaint1 = "";
        String valueToPaint2 = "";
        String valueToPaint3 = "";
        for (int i = 0; i < cells.length; i++) {

            if(!cells[i].getValue().getMoveType().equals(CellValueType.EMPTY.getMoveType())){
                switch (i){
                    case 0:
                        System.out.println("Passa aqui");
                        valueToPaint1 = DrawColors.WHITE_BACKGROUND + cellsInTheGrid.get(0) + DrawColors.RESET;
                        valueToPaint2 = DrawColors.GREEN_BACKGROUND + cellsInTheGrid.get(1) + DrawColors.RESET;
                        valueToPaint3 = DrawColors.GREEN_BACKGROUND + cellsInTheGrid.get(2) + DrawColors.RESET;
                        cellsInTheGrid.get(0).replaceAll("^((?!hede).)*$/s",valueToPaint1);
                        cellsInTheGrid.get(1).replaceAll("^((?!hede).)*$/s",valueToPaint2);
                        cellsInTheGrid.get(2).replaceAll("^((?!hede).)*$/s",valueToPaint3);
                        return;
                    case 1:
                        valueToPaint1 = DrawColors.GREEN_BACKGROUND + cellsInTheGrid.get(3) + DrawColors.RESET;
                        valueToPaint2 = DrawColors.GREEN_BACKGROUND + cellsInTheGrid.get(4) + DrawColors.RESET;
                        valueToPaint3 = DrawColors.GREEN_BACKGROUND + cellsInTheGrid.get(5) + DrawColors.RESET;
                        cellsInTheGrid.get(3).replaceAll("^((?!hede).)*$/s",valueToPaint1);
                        cellsInTheGrid.get(4).replaceAll("^((?!hede).)*$/s",valueToPaint2);
                        cellsInTheGrid.get(5).replaceAll("^((?!hede).)*$/s",valueToPaint3);
                        return;
                    case 2:
                        valueToPaint1 = DrawColors.GREEN_BACKGROUND + cellsInTheGrid.get(6) + DrawColors.RESET;
                        valueToPaint2 = DrawColors.GREEN_BACKGROUND + cellsInTheGrid.get(7) + DrawColors.RESET;
                        valueToPaint3 = DrawColors.GREEN_BACKGROUND + cellsInTheGrid.get(8) + DrawColors.RESET;
                        cellsInTheGrid.get(6).replaceAll("^((?!hede).)*$/s",valueToPaint1);
                        cellsInTheGrid.get(7).replaceAll("^((?!hede).)*$/s",valueToPaint2);
                        cellsInTheGrid.get(8).replaceAll("^((?!hede).)*$/s",valueToPaint3);
                        return;
                    case 3:
                        valueToPaint1 = DrawColors.GREEN_BACKGROUND + cellsInTheGrid.get(9) + DrawColors.RESET;
                        valueToPaint2 = DrawColors.GREEN_BACKGROUND + cellsInTheGrid.get(10) + DrawColors.RESET;
                        valueToPaint3 = DrawColors.GREEN_BACKGROUND + cellsInTheGrid.get(11) + DrawColors.RESET;
                        cellsInTheGrid.get(9).replaceAll("^((?!hede).)*$/s",valueToPaint1);
                        cellsInTheGrid.get(10).replaceAll("^((?!hede).)*$/s",valueToPaint2);
                        cellsInTheGrid.get(11).replaceAll("^((?!hede).)*$/s",valueToPaint3);
                        return;
                    case 4:
                        valueToPaint1 = DrawColors.GREEN_BACKGROUND + cellsInTheGrid.get(12) + DrawColors.RESET;
                        valueToPaint2 = DrawColors.GREEN_BACKGROUND + cellsInTheGrid.get(13) + DrawColors.RESET;
                        valueToPaint3 = DrawColors.GREEN_BACKGROUND + cellsInTheGrid.get(14) + DrawColors.RESET;
                        cellsInTheGrid.get(12).replaceAll("^((?!hede).)*$/s",valueToPaint1);
                        cellsInTheGrid.get(13).replaceAll("^((?!hede).)*$/s",valueToPaint2);
                        cellsInTheGrid.get(14).replaceAll("^((?!hede).)*$/s",valueToPaint3);
                        return;
                    case 5:
                        valueToPaint1 = DrawColors.GREEN_BACKGROUND + cellsInTheGrid.get(15) + DrawColors.RESET;
                        valueToPaint2 = DrawColors.GREEN_BACKGROUND + cellsInTheGrid.get(16) + DrawColors.RESET;
                        valueToPaint3 = DrawColors.GREEN_BACKGROUND + cellsInTheGrid.get(17) + DrawColors.RESET;
                        cellsInTheGrid.get(15).replaceAll("^((?!hede).)*$/s",valueToPaint1);
                        cellsInTheGrid.get(16).replaceAll("^((?!hede).)*$/s",valueToPaint2);
                        cellsInTheGrid.get(17).replaceAll("[A-z]",valueToPaint3);
                        return;
                    case 6:
                        valueToPaint1 = DrawColors.GREEN_BACKGROUND + cellsInTheGrid.get(18) + DrawColors.RESET;
                        valueToPaint2 = DrawColors.GREEN_BACKGROUND + cellsInTheGrid.get(19) + DrawColors.RESET;
                        valueToPaint3 = DrawColors.GREEN_BACKGROUND + cellsInTheGrid.get(20) + DrawColors.RESET;
                        cellsInTheGrid.get(18).replaceAll("[A-z]",valueToPaint1);
                        cellsInTheGrid.get(19).replaceAll("[A-z]",valueToPaint2);
                        cellsInTheGrid.get(20).replaceAll("[A-z]",valueToPaint3);
                        return;
                    case 7:
                        valueToPaint1 = DrawColors.GREEN_BACKGROUND + cellsInTheGrid.get(21) + DrawColors.RESET;
                        valueToPaint2 = DrawColors.GREEN_BACKGROUND + cellsInTheGrid.get(22) + DrawColors.RESET;
                        valueToPaint3 = DrawColors.GREEN_BACKGROUND + cellsInTheGrid.get(23) + DrawColors.RESET;
                        cellsInTheGrid.get(21).replaceAll("[A-z]",valueToPaint1);
                        cellsInTheGrid.get(22).replaceAll("[A-z]",valueToPaint2);
                        cellsInTheGrid.get(23).replaceAll("[A-z]",valueToPaint3);
                        return;
                    case 8:
                        valueToPaint1 = DrawColors.GREEN_BACKGROUND + cellsInTheGrid.get(24) + DrawColors.RESET;
                        valueToPaint2 = DrawColors.GREEN_BACKGROUND + cellsInTheGrid.get(25) + DrawColors.RESET;
                        valueToPaint3 = DrawColors.GREEN_BACKGROUND + cellsInTheGrid.get(26) + DrawColors.RESET;
                        cellsInTheGrid.get(24).replaceAll("[A-z]",valueToPaint1);
                        cellsInTheGrid.get(25).replaceAll("[A-z]",valueToPaint2);
                        cellsInTheGrid.get(26).replaceAll("[A-z]",valueToPaint3);
                        return;

                }
            }
        }

    }

    public LinkedList<String> getCellsInTheGridList() {
        return cellsInTheGrid;
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
