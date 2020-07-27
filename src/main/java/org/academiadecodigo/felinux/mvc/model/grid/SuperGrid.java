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


        for (int i = 0; i < grids.length; i++) {

            grids[i].initGrid();
            grids[i].playerPlayPrint();
        }

        String returnableString = "";

        returnableString += DrawBoardText.bigHeader + "\n";

        String drawBeforeHeader = DrawColors.BLUE_BACKGROUND + "     " + DrawColors.RESET;

        returnableString += drawBeforeHeader.concat(DrawBoardText.smallHeader).concat(DrawBoardText.smallHeader).concat(DrawBoardText.smallHeader) + "\n";

        for (int counter = 0; counter < 3; counter++) {
            for (int i = 0; i < grids[0].getCellList().size() - 2; i+=3) {

                //draws full game board
                returnableString += getGridNumber()
                                .concat(getCellNumber())
                                .concat(grids[0].getCellList().get(i)).concat(grids[3].getCellList().get(i+1)).concat(grids[6].getCellList().get(i+2))
                                .concat(DrawBoardText.cellVerticalSeparator)
                                .concat(getCellNumber()
                                        .concat(grids[1].getCellList().get(i)).concat(grids[4].getCellList().get(i+1)).concat(grids[7].getCellList().get(i+2))
                                        .concat(DrawBoardText.cellVerticalSeparator)
                                        .concat(getCellNumber()
                                                .concat(grids[2].getCellList().get(i)).concat(grids[5].getCellList().get(i+1)).concat(grids[8].getCellList().get(i+2))
                                        )) + "\n";
            }
            if (counter != 2) {
                returnableString += DrawBoardText.cellHorizontalSeparator + "\n";
            }
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

        for (int j = 0; j < grids.length; j++) {

            for (int i = 0; i < grids[j].getCellList().size(); i++) {

                if(!grids[j].cells[i].getValue().getMoveType().equals(CellValueType.EMPTY.getMoveType())){
                    switch (i){
                        case 0:
                            if(grids[j].cells[0].getValue().equals(CellValueType.PLAYER_1)) {
                                valueToPaint0 = DrawColors.GREEN_BACKGROUND + "      " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND + DrawColors.BLUE + "|" + DrawColors.RESET + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                                valueToPaint3 = DrawColors.GREEN_BACKGROUND + "  " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND + grids[j].cells[0].getValue().getMoveType() + DrawColors.RESET + DrawColors.GREEN_BACKGROUND + "   " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND + DrawColors.BLUE + "|" + DrawColors.RESET + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                                valueToPaint6 = DrawColors.GREEN_BACKGROUND + DrawColors.BLUE + "______" + DrawColors.RESET + DrawColors.WHITE_BACKGROUND + DrawColors.BLUE + "|" + DrawColors.RESET + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                                grids[j].getCellList().set(0, valueToPaint0);
                                grids[j].getCellList().set(3, valueToPaint3);
                                grids[j].getCellList().set(6, valueToPaint6);
                                continue;
                            }
                            valueToPaint0 = DrawColors.RED_BACKGROUND + "      " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND + DrawColors.BLUE + "|" + DrawColors.RESET + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                            valueToPaint3 = DrawColors.RED_BACKGROUND + "  " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND + grids[j].cells[0].getValue().getMoveType() + DrawColors.RESET + DrawColors.RED_BACKGROUND + "   " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND + DrawColors.BLUE + "|" + DrawColors.RESET + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                            valueToPaint6 =  DrawColors.RED_BACKGROUND + DrawColors.BLUE + "______" + DrawColors.RESET + DrawColors.WHITE_BACKGROUND + DrawColors.BLUE + "|" + DrawColors.RESET + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                            grids[j].getCellList().set(0,valueToPaint0);
                            grids[j].getCellList().set(3,valueToPaint3);
                            grids[j].getCellList().set(6,valueToPaint6);
                            continue;
                        case 1:
                            if(grids[j].cells[1].getValue().equals(CellValueType.PLAYER_1)){
                                valueToPaint1 = DrawColors.GREEN_BACKGROUND + "      " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND + DrawColors.BLUE + "|" + DrawColors.RESET + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                                valueToPaint4 = DrawColors.GREEN_BACKGROUND + "  " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND +grids[j].cells[1].getValue().getMoveType() + DrawColors.RESET + DrawColors.GREEN_BACKGROUND + "   " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND + DrawColors.BLUE + "|" + DrawColors.RESET + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                                valueToPaint7 = DrawColors.GREEN_BACKGROUND + DrawColors.BLUE + "______" + DrawColors.RESET + DrawColors.WHITE_BACKGROUND + DrawColors.BLUE + "|" + DrawColors.RESET + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                                grids[j].getCellList().set(1,valueToPaint1);
                                grids[j].getCellList().set(4,valueToPaint4);
                                grids[j].getCellList().set(7,valueToPaint7);
                                continue;
                            }
                            valueToPaint1 = DrawColors.RED_BACKGROUND + "      " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND + DrawColors.BLUE + "|" + DrawColors.RESET + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                            valueToPaint4 = DrawColors.RED_BACKGROUND + "  " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND +grids[j].cells[1].getValue().getMoveType() + DrawColors.RESET + DrawColors.RED_BACKGROUND + "   " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND + DrawColors.BLUE + "|" + DrawColors.RESET + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                            valueToPaint7 = DrawColors.RED_BACKGROUND + DrawColors.BLUE + "______" + DrawColors.RESET + DrawColors.WHITE_BACKGROUND + DrawColors.BLUE + "|" + DrawColors.RESET + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                            grids[j].getCellList().set(1,valueToPaint1);
                            grids[j].getCellList().set(4,valueToPaint4);
                            grids[j].getCellList().set(7,valueToPaint7);
                            continue;
                        case 2:
                            if(grids[j].cells[2].getValue().equals(CellValueType.PLAYER_1)){
                                valueToPaint2 = DrawColors.GREEN_BACKGROUND + "      " + DrawColors.RESET + " " + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                                valueToPaint5 = DrawColors.GREEN_BACKGROUND + "  " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND +grids[j].cells[2].getValue().getMoveType()+ DrawColors.RESET + DrawColors.GREEN_BACKGROUND + "   " + DrawColors.RESET + " " + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                                valueToPaint8 = DrawColors.GREEN_BACKGROUND+ DrawColors.BLUE + "______" + DrawColors.RESET + " " + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                                grids[j].getCellList().set(2,valueToPaint2);
                                grids[j].getCellList().set(5,valueToPaint5);
                                grids[j].getCellList().set(8,valueToPaint8);
                                continue;
                            }
                            valueToPaint2 = DrawColors.RED_BACKGROUND + "      " + DrawColors.RESET + " " + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                            valueToPaint5 = DrawColors.RED_BACKGROUND + "  " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND +grids[j].cells[2].getValue().getMoveType()+ DrawColors.RESET + DrawColors.RED_BACKGROUND + "   " + DrawColors.RESET + " " + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                            valueToPaint8 = DrawColors.RED_BACKGROUND + DrawColors.BLUE + "______" + DrawColors.RESET + " " + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                            grids[j].getCellList().set(2,valueToPaint2);
                            grids[j].getCellList().set(5,valueToPaint5);
                            grids[j].getCellList().set(8,valueToPaint8);
                            continue;
                        case 3:
                            if(grids[j].cells[3].getValue().equals(CellValueType.PLAYER_1)){
                                valueToPaint9 = DrawColors.GREEN_BACKGROUND + "      " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND + DrawColors.BLUE + "|" + DrawColors.RESET + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                                valueToPaint12 = DrawColors.GREEN_BACKGROUND + "  " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND +grids[j].cells[3].getValue().getMoveType()+ DrawColors.RESET + DrawColors.GREEN_BACKGROUND + "   " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND + DrawColors.BLUE + "|" + DrawColors.RESET + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                                valueToPaint15 = DrawColors.GREEN_BACKGROUND + DrawColors.BLUE + "______" + DrawColors.RESET + DrawColors.WHITE_BACKGROUND + DrawColors.BLUE + "|" + DrawColors.RESET + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                                grids[j].getCellList().set(9,valueToPaint9);
                                grids[j].getCellList().set(12,valueToPaint12);
                                grids[j].getCellList().set(15,valueToPaint15);
                                continue;
                            }
                            valueToPaint9 = DrawColors.RED_BACKGROUND + "      " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND + DrawColors.BLUE + "|" + DrawColors.RESET + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                            valueToPaint12 = DrawColors.RED_BACKGROUND + "  " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND +grids[j].cells[3].getValue().getMoveType()+ DrawColors.RESET + DrawColors.RED_BACKGROUND + "   " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND + DrawColors.BLUE +  "|" + DrawColors.RESET + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                            valueToPaint15 = DrawColors.RED_BACKGROUND + DrawColors.BLUE + "______" + DrawColors.RESET + DrawColors.WHITE_BACKGROUND + DrawColors.BLUE + "|" + DrawColors.RESET + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                            grids[j].getCellList().set(9,valueToPaint9);
                            grids[j].getCellList().set(12,valueToPaint12);
                            grids[j].getCellList().set(15,valueToPaint15);
                            continue;
                        case 4:
                            if(grids[j].cells[4].getValue().equals(CellValueType.PLAYER_1)){
                                valueToPaint10 = DrawColors.GREEN_BACKGROUND + "      " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND + DrawColors.BLUE + "|" + DrawColors.RESET + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                                valueToPaint13 = DrawColors.GREEN_BACKGROUND + "  " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND +grids[j].cells[4].getValue().getMoveType()+ DrawColors.RESET + DrawColors.GREEN_BACKGROUND + "   " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND + DrawColors.BLUE + "|" + DrawColors.RESET + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                                valueToPaint16 = DrawColors.GREEN_BACKGROUND + DrawColors.BLUE + "______" + DrawColors.RESET + DrawColors.WHITE_BACKGROUND + DrawColors.BLUE + "|" + DrawColors.RESET + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                                grids[j].getCellList().set(10,valueToPaint10);
                                grids[j].getCellList().set(13,valueToPaint13);
                                grids[j].getCellList().set(16,valueToPaint16);
                                continue;
                            }
                            valueToPaint10 = DrawColors.RED_BACKGROUND + "      " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND + DrawColors.BLUE + "|" + DrawColors.RESET + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                            valueToPaint13 = DrawColors.RED_BACKGROUND + "  " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND +grids[j].cells[4].getValue().getMoveType()+ DrawColors.RESET + DrawColors.RED_BACKGROUND + "   " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND + DrawColors.BLUE + "|" + DrawColors.RESET + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                            valueToPaint16 = DrawColors.RED_BACKGROUND + DrawColors.BLUE + "______" + DrawColors.RESET + DrawColors.WHITE_BACKGROUND + DrawColors.BLUE + "|" + DrawColors.RESET + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                            grids[j].getCellList().set(10,valueToPaint10);
                            grids[j].getCellList().set(13,valueToPaint13);
                            grids[j].getCellList().set(16,valueToPaint16);
                            continue;
                        case 5:
                            if(grids[j].cells[5].getValue().equals(CellValueType.PLAYER_1)){
                                valueToPaint11 = DrawColors.GREEN_BACKGROUND + "      " + DrawColors.RESET + " " + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                                valueToPaint14 = DrawColors.GREEN_BACKGROUND + "  " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND +grids[j].cells[5].getValue().getMoveType()+ DrawColors.RESET + DrawColors.GREEN_BACKGROUND + "   " + DrawColors.RESET + " " + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                                valueToPaint17 = DrawColors.GREEN_BACKGROUND + DrawColors.BLUE + "______" + DrawColors.RESET + " " + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                                grids[j].getCellList().set(11,valueToPaint11);
                                grids[j].getCellList().set(14,valueToPaint14);
                                grids[j].getCellList().set(17,valueToPaint17);
                                continue;
                            }
                            valueToPaint11 = DrawColors.RED_BACKGROUND + "      " + DrawColors.RESET + " " + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                            valueToPaint14 = DrawColors.RED_BACKGROUND + "  " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND +grids[j].cells[5].getValue().getMoveType()+ DrawColors.RESET + DrawColors.RED_BACKGROUND + "   " + DrawColors.RESET + " ";
                            valueToPaint17 = DrawColors.RED_BACKGROUND + DrawColors.BLUE + "______" + DrawColors.RESET + " " + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                            grids[j].getCellList().set(11,valueToPaint11);
                            grids[j].getCellList().set(14,valueToPaint14);
                            grids[j].getCellList().set(17,valueToPaint17);
                            continue;
                        case 6:
                            if(grids[j].cells[6].getValue().equals(CellValueType.PLAYER_1)){
                                valueToPaint18 = DrawColors.GREEN_BACKGROUND + "      " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND + DrawColors.BLUE + "|" + DrawColors.RESET + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                                valueToPaint21 = DrawColors.GREEN_BACKGROUND + "  " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND +grids[j].cells[6].getValue().getMoveType()+ DrawColors.RESET + DrawColors.GREEN_BACKGROUND + "   " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND + DrawColors.BLUE + "|" + DrawColors.RESET + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                                valueToPaint24 = DrawColors.GREEN_BACKGROUND + "      " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND + DrawColors.BLUE + "|" + DrawColors.RESET + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                                grids[j].getCellList().set(18,valueToPaint18);
                                grids[j].getCellList().set(21,valueToPaint21);
                                grids[j].getCellList().set(24,valueToPaint24);
                                continue;
                            }
                            valueToPaint18 = DrawColors.RED_BACKGROUND + "      " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND + DrawColors.BLUE + "|" + DrawColors.RESET + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                            valueToPaint21 = DrawColors.RED_BACKGROUND + "  " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND +grids[j].cells[6].getValue().getMoveType()+ DrawColors.RESET + DrawColors.RED_BACKGROUND + "   " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND + DrawColors.BLUE + "|" + DrawColors.RESET + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                            valueToPaint24 = DrawColors.RED_BACKGROUND + "      " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND + DrawColors.BLUE + "|" + DrawColors.RESET + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                            grids[j].getCellList().set(18,valueToPaint18);
                            grids[j].getCellList().set(21,valueToPaint21);
                            grids[j].getCellList().set(24,valueToPaint24);
                            continue;
                        case 7:
                            if(grids[j].cells[7].getValue().equals(CellValueType.PLAYER_1)){
                                valueToPaint19 = DrawColors.GREEN_BACKGROUND + "      " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND + DrawColors.BLUE + "|" + DrawColors.RESET + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                                valueToPaint22 = DrawColors.GREEN_BACKGROUND + "  " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND +grids[j].cells[7].getValue().getMoveType()+ DrawColors.RESET + DrawColors.GREEN_BACKGROUND + "   " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND + DrawColors.BLUE + "|" + DrawColors.RESET + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                                valueToPaint25 = DrawColors.GREEN_BACKGROUND + "      " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND + DrawColors.BLUE + "|" + DrawColors.RESET + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                                grids[j].getCellList().set(19,valueToPaint19);
                                grids[j].getCellList().set(22,valueToPaint22);
                                grids[j].getCellList().set(25,valueToPaint25);
                                continue;
                            }
                            valueToPaint19 = DrawColors.RED_BACKGROUND + "      " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND + DrawColors.BLUE + "|" + DrawColors.RESET + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                            valueToPaint22 = DrawColors.RED_BACKGROUND + "  " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND +grids[j].cells[7].getValue().getMoveType()+ DrawColors.RESET + DrawColors.RED_BACKGROUND + "   " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND + DrawColors.BLUE + "|" + DrawColors.RESET + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                            valueToPaint25 = DrawColors.RED_BACKGROUND + "      " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND + DrawColors.BLUE + "|" + DrawColors.RESET + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                            grids[j].getCellList().set(19,valueToPaint19);
                            grids[j].getCellList().set(22,valueToPaint22);
                            grids[j].getCellList().set(25,valueToPaint25);
                            continue;
                        case 8:
                            if(grids[j].cells[8].getValue().equals(CellValueType.PLAYER_1)){
                                valueToPaint20 = DrawColors.GREEN_BACKGROUND + "      " + DrawColors.RESET + " " + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                                valueToPaint23 = DrawColors.GREEN_BACKGROUND + "  " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND +grids[j].cells[8].getValue().getMoveType()+ DrawColors.RESET + DrawColors.GREEN_BACKGROUND + "   " + DrawColors.RESET + " " + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                                valueToPaint26 = DrawColors.GREEN_BACKGROUND + "      " + DrawColors.RESET + " " + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                                grids[j].getCellList().set(20,valueToPaint20);
                                grids[j].getCellList().set(23,valueToPaint23);
                                grids[j].getCellList().set(26,valueToPaint26);
                                continue;
                            }
                            valueToPaint20 = DrawColors.RED_BACKGROUND + "      " + DrawColors.RESET + " " + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                            valueToPaint23 = DrawColors.RED_BACKGROUND + "  " + DrawColors.RESET + DrawColors.WHITE_BACKGROUND +grids[j].cells[8].getValue().getMoveType()+ DrawColors.RESET + DrawColors.RED_BACKGROUND + "   " + DrawColors.RESET + " " + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                            valueToPaint26 = DrawColors.RED_BACKGROUND + "      " + DrawColors.RESET + " " + DrawColors.GREY_BACKGROUND + DrawColors.RESET;
                            grids[j].getCellList().set(20,valueToPaint20);
                            grids[j].getCellList().set(23,valueToPaint23);
                            grids[j].getCellList().set(26,valueToPaint26);
                            continue;
                    }
                }
            }
        }
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
