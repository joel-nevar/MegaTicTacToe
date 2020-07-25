package org.academiadecodigo.felinux.mvc.model.grid;

import org.academiadecodigo.felinux.mvc.model.Gridable;
import org.academiadecodigo.felinux.mvc.model.Valuable;
import org.academiadecodigo.felinux.mvc.model.cell.CellValueType;
import org.academiadecodigo.felinux.mvc.view.textIO.DrawBoardText;
import org.academiadecodigo.felinux.mvc.view.textIO.DrawColors;

public class SuperGrid implements Gridable {

    Grid[] grids;

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

        System.out.println(DrawBoardText.bigHeader);
        String drawBeforeHeader = DrawColors.BLUE_BACKGROUND + "     " + DrawColors.RESET;
        System.out.println(drawBeforeHeader.concat(DrawBoardText.smallHeader).concat(DrawBoardText.smallHeader).concat(DrawBoardText.smallHeader));

        for (int counter = 0; counter < 3; counter++) {
            for (int i = 0; i < grids.length; i++) {
                //draws full game board
                System.out.println(
                        getGridNumber()
                        .concat(grids[0].getCellNumber())
                        .concat(grids[i].getCellList().get(i))
                        .concat(DrawBoardText.cellVerticalSeparator)
                        .concat(grids[0].getCellNumber()
                        .concat(grids[i].getCellList().get(i)))
                        .concat(DrawBoardText.cellVerticalSeparator)
                        .concat(grids[0].getCellNumber()
                        .concat(grids[i].getCellList().get(i))));
            }
            if (counter != 2) {
                System.out.println(DrawBoardText.cellHorizontalSeparator);
            }
        }
    }

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
