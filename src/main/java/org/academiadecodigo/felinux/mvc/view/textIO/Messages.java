package org.academiadecodigo.felinux.mvc.view.textIO;

public class Messages {

    public static String CLEAN_SCREEN = "\033[H\033[2J";

    public static String MENU_MESSAGE = "Welcome to Mega TicTacToe! Please select:";
    public static String VIEW_MAIN_ERROR = "Item does not exit";

    public static String SELECT_CELL = "Please select a cell: ";
    public static String WRONG_CELL_INPUT = "No such cell exists, try again.";

    public static String UNAVAILABLE_CELL = "This cell is unavailable, choose another";

    public static String[] getMenuMessages() {

        String[] menuStrings = new String[MenuOptions.values().length];

        for (int i = 0; i < menuStrings.length; i++) {

            menuStrings[i] = MenuOptions.values()[i].getMenuMessage();
        }

        return menuStrings;
    }
}
