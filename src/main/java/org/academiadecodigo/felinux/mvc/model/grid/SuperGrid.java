package org.academiadecodigo.felinux.mvc.model.grid;

import org.academiadecodigo.felinux.mvc.model.Gridable;
import org.academiadecodigo.felinux.mvc.model.Valuable;
import org.academiadecodigo.felinux.mvc.model.cell.CellValueType;

import java.util.LinkedList;

public class SuperGrid implements Gridable {

    Grid[] grids;

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

    private String cellVerticalSeparator =  BLUE + "||" + RESET;
    private String cellHorizontalSeparator = BLUE + "===================================================================" + RESET;

    private String topHeader =  BLUE_BACKGROUND + "          _                      ___                    ___        "+ RESET + "\n" +
                                BLUE_BACKGROUND + "         /_\\                    | _ )                 / __|        "+ RESET + "\n" +
                                BLUE_BACKGROUND + "        / _ \\                   | _ \\                 | (__        "+ RESET + "\n" +
                                BLUE_BACKGROUND + "       /_/ \\_\\                  |___/                 \\___|        " + RESET;
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

    private String headerNamePart = YELLOW + "   A      B      C     " + RESET;

    public SuperGrid() {
        initGrids();
    }

    private void initGrids() {

        this.grids = new Grid[9];

        for (int i = 0; i < grids.length; i++) {
            grids[i] = new Grid();
        }
    }
    public void drawGameBoard(){

        System.out.println(topHeader);
        System.out.println(headerNamePart.concat(headerNamePart).concat(headerNamePart));

        for (int counter = 0; counter < 3; counter++) {
            for (int i = 0; i < grids.length; i++) {
                //draws full game board
                System.out.println(grids[i].getFirstCellList().get(i).concat(cellVerticalSeparator)
                        .concat(grids[i].getEveryOtherCellList().get(i)).concat(cellVerticalSeparator)
                        .concat(grids[i].getEveryOtherCellList().get(i)));
            }
            if (counter != 2) {
                System.out.println(cellHorizontalSeparator);
            }
        }
    }

    @Override
    public CellValueType getCellValue(int index) {
        return this.grids[index].getValue();
    }

    @Override
    public void setCellValue(CellValueType playerValue, int index) {
        this.grids[index].setValue(playerValue);
    }

    public Valuable[] getGrids() {
        return this.grids;
    }
}
