package org.example;

public class Game {
    public static final int WIDTH = 600, HEIGHT = 600, GRIDSIZE = 10, MINECOUNT = 1;
    private Handler handler = new Handler();

    public Game() {
        new Window(WIDTH, HEIGHT, GRIDSIZE, "Minesweeper", this, handler);
    }

    public static void main(String[] args) {
        new Game();
    }
}
