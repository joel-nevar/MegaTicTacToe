package org.academiadecodigo.felinux.mvc.model;

import org.academiadecodigo.felinux.mvc.model.grid.Grid;

public enum WinCombinations {

    LINE_1(new int[] {0, 1, 2}),
    LINE_2(new int[] {3, 4, 5}),
    LINE_3(new int[] {6, 7, 8}),
    COL_1(new int[] {0, 3, 6}),
    COL_2(new int[] {1, 4, 2}),
    COL_3(new int[] {2, 5, 8}),
    DIAG_1(new int[] {0, 4, 8}),
    DIAG_2(new int[] {2, 4, 6});

    private int[] indexes;

    private WinCombinations(int[] indexes) {
        this.indexes = indexes;
    }

    public Combineable[] getCombineables(Grid grid) {

        return [grid.getCells()[indexes[0]], grid.getCells()[indexes[1]], grid.getCells()[indexes[2]]];
    }

