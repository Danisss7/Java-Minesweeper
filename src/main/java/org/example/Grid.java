package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Grid extends JPanel {
    private boolean picked = false;
    public static ArrayList<Cell> cellGrid = new ArrayList<Cell>();
    private final ArrayList<Integer> mines = new ArrayList<Integer>();

    public Grid(GridLayout gridLayout, Handler handler) {
        super(gridLayout);
        createCells(handler);
        addCells();
    }

    private void addCells() {
        for (Cell cell : cellGrid) {
            cell.setText("0");
            add(cell);
        }
    }

    public void createCells(Handler handler) {
        int bound = Game.GRIDSIZE * Game.GRIDSIZE;
        for(int i = 1; i <= Game.MINECOUNT; i++) {
            while(!picked) {
                int minePosition = (int) (Math.random() * bound);
                if (!mines.contains(minePosition)) {
                    mines.add(minePosition);
                    picked = true;
                }
            }
            picked = false;
        }

        for(int i = 0; i < bound; i++) {
            if(mines.contains(i)) {
                cellGrid.add(new Cell(1, i, false, false, handler));
            } else if(i % Game.GRIDSIZE == 0){
                if(mines.contains(i - Game.GRIDSIZE) ||
                        mines.contains(i - Game.GRIDSIZE + 1) ||
                        mines.contains(i + 1) ||
                        mines.contains(i + Game.GRIDSIZE) ||
                        mines.contains(i + Game.GRIDSIZE + 1)) {
                    cellGrid.add(new Cell(2, i, false, false, handler));
                } else {
                    cellGrid.add(new Cell(0, i, false, false, handler));
                }
            } else if(i % Game.GRIDSIZE == Game.GRIDSIZE - 1){
                if(mines.contains(i - Game.GRIDSIZE - 1) ||
                        mines.contains(i - Game.GRIDSIZE) ||
                        mines.contains(i - 1) ||
                        mines.contains(i + Game.GRIDSIZE - 1) ||
                        mines.contains(i + Game.GRIDSIZE)) {
                    cellGrid.add(new Cell(2, i, false, false, handler));
                } else {
                    cellGrid.add(new Cell(0, i, false, false, handler));
                }
            }else {
                if(mines.contains(i - Game.GRIDSIZE - 1) ||
                        mines.contains(i - Game.GRIDSIZE) ||
                        mines.contains(i - Game.GRIDSIZE + 1) ||
                        mines.contains(i - 1) ||
                        mines.contains(i + 1) ||
                        mines.contains(i + Game.GRIDSIZE - 1) ||
                        mines.contains(i + Game.GRIDSIZE) ||
                        mines.contains(i + Game.GRIDSIZE + 1)) {
                    cellGrid.add(new Cell(2, i, false, false, handler));
                } else {
                    cellGrid.add(new Cell(0, i, false, false, handler));
                }
            }
        }
    }
}
