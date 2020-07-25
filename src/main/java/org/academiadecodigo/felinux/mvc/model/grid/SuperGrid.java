package org.academiadecodigo.felinux.mvc.model.grid;

import org.academiadecodigo.felinux.mvc.model.Gridable;
import org.academiadecodigo.felinux.mvc.model.Valuable;
import org.academiadecodigo.felinux.mvc.model.cell.CellValueType;

import java.util.LinkedList;

public class SuperGrid implements Gridable {

    Grid[] grids;

    private String cellVerticalSeparator =  DrawColors.BLUE + "||" + DrawColors.RESET;
    private String cellHorizontalSeparator =  DrawColors.BLUE_BACKGROUND + "     " + DrawColors.RESET + DrawColors.BLUE + "  =====================================================================" + DrawColors.RESET;

    private String topHeader =  DrawColors.BLUE_BACKGROUND + "           _                      ___                     ___               " + DrawColors.RESET + "\n" +
                                DrawColors.BLUE_BACKGROUND + "          /_\\                    | _ )                  / __|               " + DrawColors.RESET + "\n" +
                                DrawColors.BLUE_BACKGROUND + "         / _ \\                   | _ \\                  | (__               " + DrawColors.RESET + "\n" +
                                DrawColors.BLUE_BACKGROUND + "        /_/ \\_\\                  |___/                  \\___|               " + DrawColors.RESET;

    private String headerNamePart = DrawColors.YELLOW + "    A      B      C      " + DrawColors.RESET;

    private int counterForGridNumber = 0;

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
        String drawBeforeHeader = DrawColors.BLUE_BACKGROUND + "     " + DrawColors.RESET;
        System.out.println(drawBeforeHeader.concat(headerNamePart).concat(headerNamePart).concat(headerNamePart));

        for (int counter = 0; counter < 3; counter++) {
            for (int i = 0; i < grids.length; i++) {
                //draws full game board
                System.out.println(
                        getGridNumber()
                        .concat(grids[0].getCellNumber())
                        .concat(grids[i].getCellList().get(i))
                        .concat(cellVerticalSeparator)
                        .concat(grids[0].getCellNumber()
                        .concat(grids[i].getCellList().get(i)))
                        .concat(cellVerticalSeparator)
                        .concat(grids[0].getCellNumber()
                        .concat(grids[i].getCellList().get(i))));
            }
            if (counter != 2) {
                System.out.println(cellHorizontalSeparator);
            }
        }
    }

    public String getGridNumber(){
        counterForGridNumber++;

        String leftHeader1 =    DrawColors.BLUE_BACKGROUND + "  _  " + DrawColors.RESET + " ";
        String leftHeader11 =   DrawColors.BLUE_BACKGROUND + " / | " + DrawColors.RESET + " ";
        String leftHeader111 =  DrawColors.BLUE_BACKGROUND + " | | " + DrawColors.RESET + " ";
        String leftHeader1111 = DrawColors.BLUE_BACKGROUND + " |_| " + DrawColors.RESET + " ";

        String leftHeader2 =    DrawColors.BLUE_BACKGROUND + " ___ " + DrawColors.RESET + " ";
        String leftHeader22 =   DrawColors.BLUE_BACKGROUND + "|_  )" + DrawColors.RESET + " ";
        String leftHeader222 =  DrawColors.BLUE_BACKGROUND + " / / " + DrawColors.RESET + " ";
        String leftHeader2222 = DrawColors.BLUE_BACKGROUND + "/___|" + DrawColors.RESET + " ";

        String leftHeader3 =    DrawColors.BLUE_BACKGROUND + " ___ " + DrawColors.RESET + " ";
        String leftHeader33 =   DrawColors.BLUE_BACKGROUND + "|__ /" + DrawColors.RESET + " ";
        String leftHeader333 =  DrawColors.BLUE_BACKGROUND +  " |_ \\" + DrawColors.RESET + " ";
        String leftHeader3333 = DrawColors.BLUE_BACKGROUND + "|___/" + DrawColors.RESET + " ";

        switch (counterForGridNumber){
            case 3:
                return leftHeader1;
            case 4:
                return leftHeader11;
            case 5:
                return leftHeader111;
            case 6:
                return leftHeader1111;
            case 12:
                return leftHeader2;
            case 13:
                return leftHeader22;
            case 14:
                return leftHeader222;
            case 15:
                return leftHeader2222;
            case 21:
                return leftHeader3;
            case 22:
                return leftHeader33;
            case 23:
                return leftHeader333;
            case 24:
                return leftHeader3333;
            default:
                return DrawColors.BLUE_BACKGROUND + "     " + DrawColors.RESET + " ";
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
