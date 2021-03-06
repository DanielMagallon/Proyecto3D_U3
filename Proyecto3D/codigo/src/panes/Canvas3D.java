package panes;

import bin.handlers.SelecctionListener;
import main.Run;
import static_props.AppProps;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.image.RasterFormatException;

import static main.Run.*;

public class Canvas3D extends JPanel
{
    public SelecctionListener selecctionListener;
    private boolean arrastrar=false,firstTime=true;

    public Canvas3D() {
        setDoubleBuffered(true);
        TitledBorder titledBorder = new TitledBorder("Lienzo de dibujo");
        titledBorder.setTitleColor(AppProps.FG_NORMAL_TEXT);
        titledBorder.setTitleJustification(TitledBorder.CENTER);
        titledBorder.setBorder(BorderFactory.createLineBorder(AppProps.BG_CONTORNO));
        setBorder(titledBorder);
        setBackground(AppProps.CANVAS_BG);
        selecctionListener = new SelecctionListener(this,()->exportImage=false,()->{

            if(!showViews) {
                if(firstTime){
                    JOptionPane.showMessageDialog(this,"Para seleccionar el area debe " +
                            "mantener presionado el boton del mouse/touchpad\ny arrastrar hasta donde" +
                            " se desee obtener la imagen. Las imagenes son guardadas\nautomaticamente en la carpeta" +
                            " myimages.La cual esta en la raiz del proyecto.");
                    firstTime=false;
                }
                exportImage = true;
                canvas3D.selecctionListener.exporSelection = true;
                canvas3D.setCursor(AppProps.areaSelect);
                bufferedImage = new BufferedImage(canvas3D.getWidth(),
                        canvas3D.getHeight(), BufferedImage.TYPE_INT_RGB);
            }
        });

        AppProps.setActionPanel("RST",this, KeyEvent.VK_R, InputEvent.ALT_MASK,
                ()->   {
                    abstractShape3D.setXAngulo(0);
                    abstractShape3D.setYAngulo(0);
                    abstractShape3D.setZAngulo(0);
                    panelRotacion.updateShapeValues();
                    abstractShape3D.reset();
                    escalamiento.reset();
                    canvas3D.repaint();
                });

        AppProps.setActionPanel("RX-",this, KeyEvent.VK_X, InputEvent.CTRL_MASK,
                ()->    panelRotacion.action("X",false));

        AppProps.setActionPanel("RX+",this, KeyEvent.VK_X, InputEvent.ALT_MASK,
                ()->panelRotacion.action("X",true));

        AppProps.setActionPanel("RY-",this, KeyEvent.VK_Y, InputEvent.CTRL_MASK,
                ()->    panelRotacion.action("Y",false));

        AppProps.setActionPanel("RY+",this, KeyEvent.VK_Y, InputEvent.ALT_MASK,
                ()->panelRotacion.action("Y",true));

        AppProps.setActionPanel("RZ-",this, KeyEvent.VK_Z, InputEvent.CTRL_MASK,
                ()->    panelRotacion.action("Z",false));

        AppProps.setActionPanel("RZ+",this, KeyEvent.VK_Z, InputEvent.ALT_MASK,
                ()->panelRotacion.action("Z",true));

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
                                if(!exportImage) {
                                    int cx = e.getX(), cy = e.getY();
                                    arrastrar = abstractShape3D.dentro(cx, cy);
                                }
                            }

                             @Override
                             public void mouseEntered(MouseEvent mouseEvent) {
                                 canvas3D.requestFocus();
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
