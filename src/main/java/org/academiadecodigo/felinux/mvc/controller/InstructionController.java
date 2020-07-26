package org.academiadecodigo.felinux.mvc.controller;

import org.academiadecodigo.felinux.mvc.view.InstructionView;
import org.academiadecodigo.felinux.mvc.view.MenuView;

public class InstructionController implements Controller{


    private InstructionView view;
    private MenuView menuView;

    @Override
    public void init() {

        view.show();
        menuView.showMenu();
    }

    public void setView(InstructionView instructionView) {

        this.view=instructionView;
    }

    public void setMenuView(MenuView menuView) {

        this.menuView = menuView;
    }
}
