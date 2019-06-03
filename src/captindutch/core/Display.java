package captindutch.core;

import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Canvas;

public class Display {

    private String title;
    private int width, height;
    private JFrame frame;
    private Canvas canvas;

    public Display (String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
        this.createDisplay();
    }

    private void createDisplay() {
        frame = new JFrame(title);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));

        frame.add(canvas);
        frame.pack();

        frame.setVisible(true);

    }

    public Canvas getCanvas() {
        return this.canvas;
    }

}
