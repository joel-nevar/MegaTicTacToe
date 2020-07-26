package org.academiadecodigo.felinux.mvc.controller;

import org.academiadecodigo.felinux.mvc.model.cell.CellValueType;

public abstract class MultiAbstractController implements Controller{


    @Override
    public void init() {

    }

    public abstract void listenToPlayer();

    public abstract String getLastMove();

    public abstract void receive(String message);

    public abstract CellValueType getPlayerNumber();

    public abstract void setPlayerNumber(CellValueType player1);
}
