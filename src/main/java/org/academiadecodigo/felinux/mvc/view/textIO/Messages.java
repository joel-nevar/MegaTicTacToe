package org.academiadecodigo.felinux.mvc.view.textIO;

public class Messages {

    public static String INSTRUCTIONS = "The game is played on a 3 by 3 square grid.\n\n" +
                                        "You are X, your friend (and also the computer in Single Player) is O. Players take turns putting their marks in empty squares.\n\n" +
                                        "The first player to make a line of 3 marks (vertically, horizontally or diagonally) is the winner.\n\n" +
                                        "If all 9 squares are full with no line of 3, the game is tied.\n\n" +
                                        "You place a mark by typing the coordinates, as shown in the grid.\n\n";

    public static String CLEAN_SCREEN = "\033[H\033[2J";

    public static String MENU_MESSAGE = DrawColors.RED + "Yb        dP 888888 88      dP\"\"b8  dP\"Yb  8b    d8 888888     888888  dP\"Yb      8b    d8 888888  dP\"\"b8    db    888888 88  dP\"\"b8 888888    db     dP\"\"b8 888888  dP\"Yb  888888 d8b \n" + DrawColors.RESET +
                                        DrawColors.YELLOW + " Yb  db  dP  88__   88     dP   `\" dP   Yb 88b  d88 88__         88   dP   Yb     88b  d88 88__   dP   `\"   dPYb     88   88 dP   `\"   88     dPYb   dP   `\"   88   dP   Yb 88__   Y8P \n" + DrawColors.RESET +
                                        DrawColors.BLUE + "  YbdPYbdP   88\"\"   88  .o Yb      Yb   dP 88YbdP88 88\"\"         88   Yb   dP     88YbdP88 88\"\"   Yb  \"88  dP__Yb    88   88 Yb        88    dP__Yb  Yb        88   Yb   dP 88\"\"   `\"' \n" + DrawColors.RESET +
                                        DrawColors.CYAN + "   YP  YP    888888 88ood8  YboodP  YbodP  88 YY 88 888888       88    YbodP      88 YY 88 888888  YboodP dP\"\"\"\"Yb   88   88  YboodP   88   dP\"\"\"\"Yb  YboodP   88    YbodP  888888 (8) " + DrawColors.RESET;

    public static String VIEW_MAIN_ERROR = "Item does not exit";

    public static String SELECT_CELL = "Please select a cell: ";
    public static String WRONG_CELL_INPUT = "No such cell exists, try again.";

    public static String UNAVAILABLE_CELL = "This cell is unavailable, choose another";

    public static String WIN_GAME = "Congratulations, you won!";
    public static String LOST_GAME = "Sorry, you have lost!";
    public static String TIED_GAME = "It's a tie!";
    public static String NEXT_GAME = "New game? (Y/N)\n";

    public static String WRONG_INPUT = "Wrong input.";

    public static String[] getMenuMessages() {

        String[] menuStrings = new String[MenuOptions.values().length];

        for (int i = 0; i < menuStrings.length; i++) {

            menuStrings[i] = MenuOptions.values()[i].getMenuMessage();
        }

        return menuStrings;
    }
}
