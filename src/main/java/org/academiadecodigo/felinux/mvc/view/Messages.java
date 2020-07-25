package org.academiadecodigo.felinux.mvc.view;

import org.graalvm.compiler.lir.LIRInstruction;

public class Messages {

    protected static String MENU_MESSAGE = "Welcome to Mega TicTacToe! Please select:";
    protected static String VIEW_MAIN_ERROR = "Item does not exit";

    protected static String[] getMenuMessages() {

        String[] menuStrings = new String[MenuOptions.values().length];

        for (int i = 0; i < menuStrings.length; i++) {

            menuStrings[i] = MenuOptions.values()[i].getMenuMessage();
        }

        return menuStrings;
    }

    protected enum MenuOptions {
        SIMPLE_VS_COM("Single Player"),
        SIMPLE_VS_PLAYER("1 vs 1"),
        MEGA_VS_COM("Mega Single Player"),
        MEGA_VS_PLAYER("Mega 1 vs 1"),
        INSTRUCTIONS("Instructions"),
        EXIT("Exit");

        private String menuMessage;

        MenuOptions(String menuMessage) {
            this.menuMessage = menuMessage;
        }

        protected String getMenuMessage() {
            return this.menuMessage;
        }
    }
}
