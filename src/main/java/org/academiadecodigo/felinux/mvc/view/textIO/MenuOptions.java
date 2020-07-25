package org.academiadecodigo.felinux.mvc.view.textIO;

public enum  MenuOptions {

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
