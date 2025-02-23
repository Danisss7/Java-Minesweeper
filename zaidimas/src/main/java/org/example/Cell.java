package org.example;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

@Setter
@Getter
public class Cell extends JButton {
    //0 - tuscias, 1 - mine, 2 - skaicius
    private int type;
    private int position;
    private boolean discovered;
    private boolean flagged;
    private Handler handler;

    public Cell(int type, int position, boolean discovered, boolean flagged, Handler handler) {
        this.type = type;
        this.position = position;
        this.discovered = discovered;
        this.flagged = flagged;
        this.handler = handler;

        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    rightClickButton();
                } else {
                    leftClickButton();
                }
            }
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        });
    }

    public void leftClickButton() {
        handler.leftClick(this);
    }

    public void rightClickButton() {
        handler.rightClick(this);
    }
}
