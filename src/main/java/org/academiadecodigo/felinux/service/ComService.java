package org.academiadecodigo.felinux.service;

import org.academiadecodigo.felinux.mvc.view.textIO.GameInput;

public class ComService {

    public static String comInput() {

        System.out.println(GameInput.cellCoordinates.toArray()[randomNumberGenerator()]);
        return (String) GameInput.cellCoordinates.toArray()[randomNumberGenerator()];
    }

    private static int randomNumberGenerator() {

        return (int) Math.floor(Math.random()*9);
    }
}
