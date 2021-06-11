package panes;

import bin.handlers.SelecctionListener;
import main.Run;
import static_props.AppProps;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RasterFormatException;

import static main.Run.*;

public class Canvas3D extends JPanel
{
    public SelecctionListener selecctionListener;


    public Canvas3D() {
        setDoubleBuffered(true);
        setBorder(BorderFactory.createLineBorder(Color.black));
        setBackground(AppProps.CANVAS_BG);
        selecctionListener = new SelecctionListener(this,()->exportImage=false,()->{
            exportImage=true;

            canvas3D.selecctionListener.exporSelection=true;
            canvas3D.setCursor(AppProps.areaSelect);
            bufferedImage = new BufferedImage(canvas3D.getWidth(),
                    canvas3D.getHeight(), BufferedImage.TYPE_INT_RGB);
        });
        addMouseListener(selecctionListener);
        addMouseMotionListener(selecctionListener);
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        if(!exportImage) {
            super.paintComponent(graphics);
            abstractShape3D.conv2D();
            abstractShape3D.draw((Graphics2D) graphics);
        }else{

            if(selecctionListener.drawArea)
            {
                super.paintComponent(graphics);
                abstractShape3D.conv2D();
                abstractShape3D.draw((Graphics2D) graphics);
                selecctionListener.drawArea(graphics);
            }
            else {
                Graphics2D g2 = Run.bufferedImage.createGraphics();
                abstractShape3D.conv2D();
                g2.setColor(AppProps.CANVAS_BG);
                g2.fillRect(0, 0, this.getWidth(), this.getHeight());
                abstractShape3D.draw(g2);
                exportImage = false;

                if (selecctionListener.exporSelection) {
                    try{
                        selecctionListener.exporSelection = false;
                        bufferedImage = selecctionListener.getSelectedArea(bufferedImage);
                    }catch(RasterFormatException ignored){
                        return;
                    }

                }
                new Thread(()->notifyImage.setVisible(true)).start();
                repaint();

            }
        }
    }
}
