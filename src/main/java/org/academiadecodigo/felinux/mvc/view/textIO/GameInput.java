package org.academiadecodigo.felinux.mvc.view.textIO;

import java.util.HashSet;
import java.util.Set;

public class GameInput {

    public static final Set<String> cellCoordinates = new HashSet<String>() {
        {
            add("A1");
            add("A2");
            add("A3");
            add("B1");
            add("B2");
            add("B3");
            add("C1");
            add("C2");
            add("C3");
        }
    };
}