package org.academiadecodigo.felinux.mvc.model.cell;

public enum CellValueType {

    PLAYER_1("X"),
    PLAYER_2("O"),
    EMPTY("-");

    private String moveType;

    CellValueType(String moveType){
        this.moveType = moveType;
    }

    public String getMoveType() {
        return moveType;
    }
}
