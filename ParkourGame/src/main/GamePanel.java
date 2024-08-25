package main;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class GamePanel extends JPanel {

    private MouseInputs mouseInputs;
    private KeyboardInputs keyboardInputs;
    private float xPos = 100, yPos = 100;
    private int panel_width = 1280, panel_height = 800;
    private int obj_width = 64, obj_height = 40;
    private float SCALE = 2.0f;
    private BufferedImage bufImg, subImg;

    public GamePanel() {
        mouseInputs = new MouseInputs(this);
        keyboardInputs = new KeyboardInputs(this);

        importImg();

        setPanelSize();
        addKeyListener(keyboardInputs);
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

    private void importImg() {
        InputStream is = getClass().getResourceAsStream("/player_sprites.png");

        try {
            bufImg = ImageIO.read(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void setPanelSize() {
        Dimension size = new Dimension(panel_width, panel_height);
        setMinimumSize(size);
        setMaximumSize(size);
        setPreferredSize(size);
    }

    public void changeXPos(int value) {
        this.xPos += value;
        repaint();
    }

    public void changeYPos(int value) {
        this.yPos += value;
        repaint();
    }

    public void setPos(int x, int y) {
        xPos = x;
        yPos = y;
        repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        subImg = bufImg.getSubimage(1 * obj_width, 8 * obj_height, obj_width, obj_height);

        g.drawImage(subImg, (int) xPos, (int) yPos, (int) (obj_width * SCALE),
                (int) (obj_height * SCALE), null);

    }

}
