package org.academiadecodigo.felinux.mvc.controller;

public class ExitController implements Controller {

    @Override
    public void init() {
        System.exit(0);
        //This may as well be the place to end all streams and sockets necessary
    }
}