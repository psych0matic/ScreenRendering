package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferStrategy;

public class App implements Runnable
{
    JFrame frame;
    Canvas canvas;
    public void setup() {
        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(300,300));
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(canvas);
        frame.pack();
        frame.setLocationRelativeTo(null);
    }

    public void render() {
        canvas.createBufferStrategy(2);
        BufferStrategy bs = canvas.getBufferStrategy();
        Graphics2D g2d = (Graphics2D) bs.getDrawGraphics();
        g2d.setBackground(Color.black);
        g2d.clearRect(0,0,canvas.getWidth(),canvas.getHeight());

        // ACTUAL DRAWING PART
        Rectangle2D r = new Rectangle2D.Double(150,-50,100,100);
        g2d.rotate(Math.toRadians(45));
        g2d.setColor(Color.white);
        g2d.draw(r);

        //TODO: Make rectangle rotate using AffineTransform

        // *******************
        g2d.dispose();
        bs.show();
        bs.dispose();
    }

    public static void main(String[] args) {
        App s = new App();
        s.run();
    }

    @Override
    public void run() {
        boolean running = true;
        setup();
        while (running) {
            render();
        }
    }
}
