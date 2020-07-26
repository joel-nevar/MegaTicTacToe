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
            add("a1");
            add("a2");
            add("a3");
            add("b1");
            add("b2");
            add("b3");
            add("c1");
            add("c2");
            add("c3");
        }
    };

    public static final Set<String> yesOrNo = new HashSet<String>() {
        {
            add("y");
            add("n");
            add("yes");
            add("no");
            add("Yes");
            add("No");
            add("YES");
            add("NO");
        }
    };
}