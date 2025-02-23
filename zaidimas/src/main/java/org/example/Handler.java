package org.example;

import java.util.ArrayList;

public class Handler {
    private ArrayList<Cell> current = new ArrayList<Cell>();
    private ArrayList<Cell> queue = new ArrayList<Cell>();

    public void leftClick(Cell cell) {
        int discoveredCells = 0;
        if (!cell.isFlagged()) {
            cell.setEnabled(false);
            cell.setDiscovered(true);


            int position = cell.getPosition();
            if (cell.getType() == 0) {
                if (position < Game.GRIDSIZE) {
                    if (position % Game.GRIDSIZE == 0) {
                        queue.add(Grid.cellGrid.get((position + Game.GRIDSIZE)));
                        queue.add(Grid.cellGrid.get((position + Game.GRIDSIZE + 1)));
                        queue.add(Grid.cellGrid.get((position + 1)));
                    } else if (position % Game.GRIDSIZE == Game.GRIDSIZE - 1) {
                        queue.add(Grid.cellGrid.get((position + Game.GRIDSIZE)));
                        queue.add(Grid.cellGrid.get((position + Game.GRIDSIZE - 1)));
                        queue.add(Grid.cellGrid.get((position - 1)));
                    } else {
                        queue.add(Grid.cellGrid.get((position + Game.GRIDSIZE)));
                        queue.add(Grid.cellGrid.get((position + Game.GRIDSIZE + 1)));
                        queue.add(Grid.cellGrid.get((position + Game.GRIDSIZE - 1)));
                        queue.add(Grid.cellGrid.get((position + 1)));
                        queue.add(Grid.cellGrid.get((position - 1)));
                    }
                } else if (position >= (Game.GRIDSIZE * (Game.GRIDSIZE - 1))) {
                    if (position % Game.GRIDSIZE == 0) {
                        queue.add(Grid.cellGrid.get((position - Game.GRIDSIZE)));
                        queue.add(Grid.cellGrid.get((position - Game.GRIDSIZE + 1)));
                        queue.add(Grid.cellGrid.get((position + 1)));
                    } else if (position % Game.GRIDSIZE == Game.GRIDSIZE - 1) {
                        queue.add(Grid.cellGrid.get((position - Game.GRIDSIZE)));
                        queue.add(Grid.cellGrid.get((position - Game.GRIDSIZE - 1)));
                        queue.add(Grid.cellGrid.get((position - 1)));
                    } else {
                        queue.add(Grid.cellGrid.get((position - Game.GRIDSIZE)));
                        queue.add(Grid.cellGrid.get((position - Game.GRIDSIZE + 1)));
                        queue.add(Grid.cellGrid.get((position - Game.GRIDSIZE - 1)));
                        queue.add(Grid.cellGrid.get((position + 1)));
                        queue.add(Grid.cellGrid.get((position - 1)));
                    }
                } else if (position % Game.GRIDSIZE == 0) {
                    queue.add(Grid.cellGrid.get((position - Game.GRIDSIZE)));
                    queue.add(Grid.cellGrid.get((position + Game.GRIDSIZE)));
                    queue.add(Grid.cellGrid.get((position - Game.GRIDSIZE + 1)));
                    queue.add(Grid.cellGrid.get((position + Game.GRIDSIZE + 1)));
                    queue.add(Grid.cellGrid.get((position + 1)));
                } else if (position % Game.GRIDSIZE == Game.GRIDSIZE - 1) {
                    queue.add(Grid.cellGrid.get((position + Game.GRIDSIZE)));
                    queue.add(Grid.cellGrid.get((position - Game.GRIDSIZE)));
                    queue.add(Grid.cellGrid.get((position + Game.GRIDSIZE - 1)));
                    queue.add(Grid.cellGrid.get((position - Game.GRIDSIZE - 1)));
                    queue.add(Grid.cellGrid.get((position - 1)));
                } else {
                    queue.add(Grid.cellGrid.get((position + Game.GRIDSIZE)));
                    queue.add(Grid.cellGrid.get((position - Game.GRIDSIZE)));
                    queue.add(Grid.cellGrid.get((position + Game.GRIDSIZE - 1)));
                    queue.add(Grid.cellGrid.get((position - Game.GRIDSIZE - 1)));
                    queue.add(Grid.cellGrid.get((position + Game.GRIDSIZE + 1)));
                    queue.add(Grid.cellGrid.get((position - Game.GRIDSIZE + 1)));
                    queue.add(Grid.cellGrid.get((position + 1)));
                    queue.add(Grid.cellGrid.get((position - 1)));
                }
            } else if (cell.getType() == 2) { //Number cell
                int mineCounter = 0;
                if (position < Game.GRIDSIZE) {
                    if (position % Game.GRIDSIZE == 0) {
                        if (Grid.cellGrid.get(position + Game.GRIDSIZE).getType() == 1) {
                            mineCounter++;
                        }
                        if (Grid.cellGrid.get(position + Game.GRIDSIZE + 1).getType() == 1) {
                            mineCounter++;
                        }
                        if (Grid.cellGrid.get(position + 1).getType() == 1) {
                            mineCounter++;
                        }
                    } else if (position % Game.GRIDSIZE == Game.GRIDSIZE - 1) {
                        if (Grid.cellGrid.get(position + Game.GRIDSIZE).getType() == 1) {
                            mineCounter++;
                        }
                        if (Grid.cellGrid.get(position + Game.GRIDSIZE - 1).getType() == 1) {
                            mineCounter++;
                        }
                        if (Grid.cellGrid.get(position - 1).getType() == 1) {
                            mineCounter++;
                        }
                    } else {
                        if (Grid.cellGrid.get(position + Game.GRIDSIZE).getType() == 1) {
                            mineCounter++;
                        }
                        if (Grid.cellGrid.get(position + Game.GRIDSIZE + 1).getType() == 1) {
                            mineCounter++;
                        }
                        if (Grid.cellGrid.get(position + Game.GRIDSIZE - 1).getType() == 1) {
                            mineCounter++;
                        }
                        if (Grid.cellGrid.get(position + 1).getType() == 1) {
                            mineCounter++;
                        }
                        if (Grid.cellGrid.get(position - 1).getType() == 1) {
                            mineCounter++;
                        }
                    }
                } else if (position >= (Game.GRIDSIZE * (Game.GRIDSIZE - 1))) {
                    if (position % Game.GRIDSIZE == 0) {
                        if (Grid.cellGrid.get(position - Game.GRIDSIZE).getType() == 1) {
                            mineCounter++;
                        }
                        if (Grid.cellGrid.get(position - Game.GRIDSIZE + 1).getType() == 1) {
                            mineCounter++;
                        }
                        if (Grid.cellGrid.get(position + 1).getType() == 1) {
                            mineCounter++;
                        }
                    } else if (position % Game.GRIDSIZE == Game.GRIDSIZE - 1) {
                        if (Grid.cellGrid.get(position - Game.GRIDSIZE).getType() == 1) {
                            mineCounter++;
                        }
                        if (Grid.cellGrid.get(position - Game.GRIDSIZE - 1).getType() == 1) {
                            mineCounter++;
                        }
                        if (Grid.cellGrid.get(position - 1).getType() == 1) {
                            mineCounter++;
                        }
                    } else {
                        if (Grid.cellGrid.get(position - Game.GRIDSIZE).getType() == 1) {
                            mineCounter++;
                        }
                        if (Grid.cellGrid.get(position - Game.GRIDSIZE + 1).getType() == 1) {
                            mineCounter++;
                        }
                        if (Grid.cellGrid.get(position - Game.GRIDSIZE - 1).getType() == 1) {
                            mineCounter++;
                        }
                        if (Grid.cellGrid.get(position + 1).getType() == 1) {
                            mineCounter++;
                        }
                        if (Grid.cellGrid.get(position - 1).getType() == 1) {
                            mineCounter++;
                        }
                    }
                } else if (position % Game.GRIDSIZE == 0) {
                    if (Grid.cellGrid.get(position - Game.GRIDSIZE).getType() == 1) {
                        mineCounter++;
                    }
                    if (Grid.cellGrid.get(position + Game.GRIDSIZE).getType() == 1) {
                        mineCounter++;
                    }
                    if (Grid.cellGrid.get(position - Game.GRIDSIZE + 1).getType() == 1) {
                        mineCounter++;
                    }
                    if (Grid.cellGrid.get(position + Game.GRIDSIZE + 1).getType() == 1) {
                        mineCounter++;
                    }
                    if (Grid.cellGrid.get(position + 1).getType() == 1) {
                        mineCounter++;
                    }
                } else if (position % Game.GRIDSIZE == Game.GRIDSIZE - 1) {
                    if (Grid.cellGrid.get((position - Game.GRIDSIZE)).getType() == 1) {
                        mineCounter++;
                    }
                    if (Grid.cellGrid.get((position + Game.GRIDSIZE)).getType() == 1) {
                        mineCounter++;
                    }
                    if (Grid.cellGrid.get((position - Game.GRIDSIZE - 1)).getType() == 1) {

                        mineCounter++;
                    }
                    if (Grid.cellGrid.get((position + Game.GRIDSIZE - 1)).getType() == 1) {
                        mineCounter++;
                    }
                    if (Grid.cellGrid.get((position - 1)).getType() == 1) {
                        mineCounter++;
                    }
                } else {
                    if (Grid.cellGrid.get((position - Game.GRIDSIZE)).getType() == 1) {
                        mineCounter++;
                    }
                    if (Grid.cellGrid.get((position + Game.GRIDSIZE)).getType() == 1) {
                        mineCounter++;
                    }
                    if (Grid.cellGrid.get((position - Game.GRIDSIZE - 1)).getType() == 1) {
                        mineCounter++;
                    }
                    if (Grid.cellGrid.get((position + Game.GRIDSIZE - 1)).getType() == 1) {
                        mineCounter++;
                    }
                    if (Grid.cellGrid.get((position - Game.GRIDSIZE + 1)).getType() == 1) {
                        mineCounter++;
                    }
                    if (Grid.cellGrid.get((position + Game.GRIDSIZE + 1)).getType() == 1) {
                        mineCounter++;
                    }
                    if (Grid.cellGrid.get((position - 1)).getType() == 1) {
                        mineCounter++;
                    }
                    if (Grid.cellGrid.get((position + 1)).getType() == 1) {
                        mineCounter++;
                    }
                }
                cell.setText(String.valueOf(mineCounter));
            } else if (cell.getType() == 1) { //Mine cell
                for (int x = 0; x < Grid.cellGrid.size(); x++) {
                    Grid.cellGrid.get(x).setEnabled(false);
                    Grid.cellGrid.get(x).setText("");
                    if (Grid.cellGrid.get(x).getType() == 1) {
                        Grid.cellGrid.get(x).setText("X");
                    }
                }
                cell.setText("*");
            }

            for (Cell value : queue) {
                if (!value.isDiscovered()) {
                    current.add(value);
                    value.setDiscovered(true);
                }
            }
            queue.clear();
            while (!current.isEmpty()) {
                Cell temp = current.getFirst();
                current.removeFirst();
                leftClick(temp);
            }

            for (int i = 0; i < Grid.cellGrid.size(); i++) {
                if (Grid.cellGrid.get(i).isDiscovered()) {
                    discoveredCells++;
                }
            }

            if (discoveredCells == Grid.cellGrid.size() - Game.MINECOUNT) {
                for (int i = 0; i < Grid.cellGrid.size(); i++) {
                    if (Grid.cellGrid.get(i).getType() == 1) {
                        Grid.cellGrid.get(i).setEnabled(false);
                        Grid.cellGrid.get(i).setText("X");
                    } else {
                        Grid.cellGrid.get(i).setEnabled(false);
                        Grid.cellGrid.get(i).setText(":P");
                    }
                }
            }
        }
    }

    public void rightClick(Cell cell) {
        if (!cell.isDiscovered()) {
            if (!cell.isFlagged()) {
                cell.setFlagged(true);
                cell.setText("F");
            } else {
                cell.setFlagged(false);
                cell.setText("0");
            }
        }
    }
}
