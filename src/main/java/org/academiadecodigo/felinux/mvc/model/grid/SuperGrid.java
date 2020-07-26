package org.academiadecodigo.felinux.mvc.model.grid;

import org.academiadecodigo.felinux.mvc.model.Gridable;
import org.academiadecodigo.felinux.mvc.model.Valuable;
import org.academiadecodigo.felinux.mvc.model.cell.CellValueType;
import org.academiadecodigo.felinux.mvc.view.textIO.DrawBoardText;
import org.academiadecodigo.felinux.mvc.view.textIO.DrawColors;

public class SuperGrid implements Gridable {

    private Grid[] grids;

    private int counterForGridNumber = 0;
    private int counterForCellNumber = 0;

    public SuperGrid() {
        initGrids();
    }

    private void initGrids() {

        this.grids = new Grid[9];

        for (int i = 0; i < grids.length; i++) {
            grids[i] = new Grid();
        }
    }

    public String drawGameBoard(){

        String returnableString = "";

        returnableString += DrawBoardText.bigHeader + "\n";

        String drawBeforeHeader = DrawColors.BLUE_BACKGROUND + "     " + DrawColors.RESET;

        returnableString += drawBeforeHeader.concat(DrawBoardText.smallHeader).concat(DrawBoardText.smallHeader).concat(DrawBoardText.smallHeader) + "\n";

        for (int counter = 0; counter < 3; counter++) {
            for (int i = 0; i < grids[0].getCellList().size() - 2; i+=3) {

                //draws full game board
                returnableString += getGridNumber()
                                .concat(getCellNumber())
                                .concat(grids[0].getCellList().get(i)).concat(grids[1].getCellList().get(i+1)).concat(grids[2].getCellList().get(i+2))
                                .concat(DrawBoardText.cellVerticalSeparator)
                                .concat(getCellNumber()
                                        .concat(grids[3].getCellList().get(i)).concat(grids[4].getCellList().get(i+1)).concat(grids[5].getCellList().get(i+2))
                                        .concat(DrawBoardText.cellVerticalSeparator)
                                        .concat(getCellNumber()
                                                .concat(grids[6].getCellList().get(i)).concat(grids[7].getCellList().get(i+1)).concat(grids[8].getCellList().get(i+2))
                                        )) + "\n";
            }
            if (counter != 2) {
                returnableString += DrawBoardText.cellHorizontalSeparator + "\n";
            }
        }
        return returnableString;
    }

    //Draws the blue left-most part
    public String getGridNumber(){

        counterForGridNumber++;

        switch (counterForGridNumber){
            case 3:
                return DrawBoardText.leftHeader1;
            case 4:
                return DrawBoardText.leftHeader11;
            case 5:
                return DrawBoardText.leftHeader111;
            case 6:
                return DrawBoardText.leftHeader1111;
            case 12:
                return DrawBoardText.leftHeader2;
            case 13:
                return DrawBoardText.leftHeader22;
            case 14:
                return DrawBoardText.leftHeader222;
            case 15:
                return DrawBoardText.leftHeader2222;
            case 21:
                return DrawBoardText.leftHeader3;
            case 22:
                return DrawBoardText.leftHeader33;
            case 23:
                return DrawBoardText.leftHeader333;
            case 24:
                return DrawBoardText.leftHeader3333;
            default:
                return DrawColors.CYAN_BACKGROUND + "     " + DrawColors.RESET + " ";
        }
    }
    public String getCellNumber(){
        //Outputs to the console the "1,2,3" numbers on the left of each left-most grid
        counterForCellNumber++;

        switch (counterForCellNumber){
            case 4:
                return DrawColors.YELLOW + "1 " + DrawColors.RESET;
            case 13:
                return DrawColors.YELLOW + "2 " + DrawColors.RESET;
            case 22:
                return DrawColors.YELLOW + "3 " + DrawColors.RESET;
            case 27:
                counterForCellNumber = 0;
                return "  ";
            default:
                return "  ";
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
