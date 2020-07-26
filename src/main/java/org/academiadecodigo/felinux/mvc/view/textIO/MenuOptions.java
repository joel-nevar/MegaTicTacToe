package org.academiadecodigo.felinux.mvc.view.textIO;

public enum  MenuOptions {

        VS_COM("Single Player"),
        VS_PLAYER("Vs Mode"),
        MEGA_VS_PLAYER("Vs Mega Mode"),
        INSTRUCTIONS("Instructions"),
        EXIT("Exit");

        private String menuMessage;

        MenuOptions(String menuMessage) {
            this.menuMessage = menuMessage;
        }

        public String getMenuMessage() {
            return this.menuMessage;
        }

}
