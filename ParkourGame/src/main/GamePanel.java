package main;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    private MouseInputs mouseInputs;
    private KeyboardInputs keyboardInputs;
    private int xPos = 100;
    private int yPos = 100;
    private int width = 200;
    private int height = 50;

    public GamePanel() {
        mouseInputs = new MouseInputs(this);
        keyboardInputs = new KeyboardInputs(this);
        addKeyListener(keyboardInputs);
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }


    public void changeXPos(int value) {
        this.xPos += value;
        repaint();
    }

    public void changeYPos(int value) {
        this.yPos += value;
        repaint();
    }

    public void setRectPos(int x, int y) {
        xPos = x;
        yPos = y;
        repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.fillRect(xPos, yPos, width, height);
    }
}
