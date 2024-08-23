package main;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GamePanel extends JPanel {

    private Random random;
    private MouseInputs mouseInputs;
    private KeyboardInputs keyboardInputs;
    private int frames = 0;
    private long lastCheck = 0, now = 0;
    private float xDir = 1f, yDir = 1f;
    private float xPos = 100, yPos = 100;
    private int width = 200, height = 50;

    private Color color = new Color(150,  20, 90);

    public GamePanel() {
        random = new Random();
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

        updateRectangle();
        g.setColor(color);
        g.fillRect((int) xPos,(int) yPos, width, height);


    }

    private void updateRectangle() {
        xPos += xDir;
        if (xPos + width > 400 || xPos < 0) {
            xDir *= -1;
            color = getRandomColor();
        }
        yPos += yDir;
        if (yPos + height > 400 || yPos < 0) {
            yDir *= -1;
            color = getRandomColor();
        }
    }

    private Color getRandomColor() {
        int r = random.nextInt(255);
        int g = random.nextInt(255);
        int b = random.nextInt(255);
        return new Color(r,g,b);
    }
}
