package org.academiadecodigo.felinux.service;

import org.academiadecodigo.felinux.mvc.view.textIO.GameInput;

public class ComService {

    public String comInput() {

        return (String) GameInput.cellCoordinates.toArray()[randomNumberGenerator()];
    }

    private int randomNumberGenerator() {

        return (int) Math.floor(Math.random()*10);
    }
}
