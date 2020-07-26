package org.academiadecodigo.felinux.mvc.model.cell;

import org.academiadecodigo.felinux.mvc.view.textIO.DrawColors;

public enum CellValueType {

    PLAYER_1(DrawColors.YELLOW + DrawColors.GREEN_BACKGROUND + "X" + DrawColors.RESET),
    PLAYER_2(DrawColors.YELLOW + DrawColors.RED_BACKGROUND + "O" + DrawColors.RESET),
    EMPTY(DrawColors.BLUE + "-" + DrawColors.RESET);

    private String moveType;

    CellValueType(String moveType){
        this.moveType = moveType;
    }

    public String getMoveType() {
        return moveType;
    }
}
