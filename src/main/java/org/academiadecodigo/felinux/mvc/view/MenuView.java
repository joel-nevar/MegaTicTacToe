package org.academiadecodigo.felinux.mvc.view;

import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.felinux.mvc.controller.MainController;
import org.academiadecodigo.felinux.mvc.view.textIO.Messages;

public class MenuView extends AbstractView {

    MainController mainController;

    @Override
    public void show() {
        showMenu();
    }

    private void showMenu() {
        System.out.println(mainController);
        super.writer.println(Messages.CLEAN_SCREEN);
        MenuInputScanner scanner = new MenuInputScanner(Messages.getMenuMessages());
        scanner.setError(Messages.CLEAN_SCREEN + Messages.VIEW_MAIN_ERROR);
        scanner.setMessage("\n" + Messages.MENU_MESSAGE);
        mainController.onMenuSelection(prompt.getUserInput(scanner));
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
}
