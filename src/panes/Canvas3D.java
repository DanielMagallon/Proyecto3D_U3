package panes;

import bin.handlers.SelecctionListener;
import main.Run;
import static_props.AppProps;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.image.RasterFormatException;

import static main.Run.*;

public class Canvas3D extends JPanel
{
    public SelecctionListener selecctionListener;
    private boolean arrastrar=false;

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

        AppProps.setActionPanel("RX-",this, KeyEvent.VK_X, InputEvent.CTRL_MASK,
                ()->{
                        panelRotacion.s1.setValue(panelRotacion.s1.getValue()-10);
                        abstractShape3D.rotacionXYZH(panelRotacion.s1.getValue(),
                                panelRotacion.s2.getValue(),panelRotacion.s3.getValue());
                    System.out.println("Rotando en x");
                });

        AppProps.setActionPanel("RX+",this, KeyEvent.VK_X, InputEvent.ALT_MASK,
                ()->{
                    panelRotacion.s1.setValue(panelRotacion.s1.getValue()+10);
                    abstractShape3D.rotacionXYZH(panelRotacion.s1.getValue(),
                            panelRotacion.s2.getValue(),panelRotacion.s3.getValue());
                    System.out.println("Rotando en x");
                });

        addMouseListener(selecctionListener);
        addMouseMotionListener(selecctionListener);

        addMouseWheelListener(e->{
            int sentRot= e.getWheelRotation();
            if(sentRot>0) {
                abstractShape3D.scale(1.05);
            }else {
                if(sentRot<0)
                    abstractShape3D.scale(.95);
            }
            repaint();
        });

        addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent e) {
                    int cx=e.getX(), cy=e.getY();
                    arrastrar=abstractShape3D.dentro(cx,cy);
                }

            }
        );

        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                if(arrastrar) {
                    //sipuedes arrastrar la figura
                    int cx=e.getX(), cy=e.getY();
                    abstractShape3D.mover(cx,cy);
                    repaint();
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        if(!exportImage) {
            super.paintComponent(graphics);
            Graphics2D g2 = (Graphics2D) graphics;
            abstractShape3D.conv2D();
            abstractShape3D.draw(g2);
            abstractShape3D.VistaFrontal(g2);
            abstractShape3D.VistaLat(g2);
            abstractShape3D.VistaSup(g2);
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
