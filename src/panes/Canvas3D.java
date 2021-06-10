package panes;

import static_props.AppProps;

import javax.swing.*;
import java.awt.*;

import static main.Run.figura3D;

public class Canvas3D extends JPanel
{
    public Canvas3D() {
        setDoubleBuffered(true);
        setBorder(BorderFactory.createLineBorder(Color.black));
        setBackground(AppProps.CANVAS_BG);
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        figura3D.conv2D();
        figura3D.dibujar(graphics);
    }
}
