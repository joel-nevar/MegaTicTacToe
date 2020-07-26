package org.academiadecodigo.felinux.mvc.view.textIO;

import org.academiadecodigo.felinux.mvc.controller.Controller;
import org.academiadecodigo.felinux.mvc.controller.MainController;

public enum  MenuOptions {

       // SIMPLE_VS_COM("Single Player", null),
        //SIMPLE_VS_PLAYER("1 vs 1", null),
        MEGA_VS_COM("Single Player", null),
        MEGA_VS_PLAYER("Vs Mode", null),
        INSTRUCTIONS("Instructions", null),
        EXIT("Exit", null);

        private String menuMessage;
        private Controller controller;

        private MainController mainController;

        MenuOptions(String menuMessage, Controller controller) {
            this.menuMessage = menuMessage;
            this.controller = controller;
        }

        public void init() {
                this.controller.init();
        }

        protected String getMenuMessage() {
            return this.menuMessage;
        }

        public void setController(Controller controller) {
                this.controller = controller;
        }
}
