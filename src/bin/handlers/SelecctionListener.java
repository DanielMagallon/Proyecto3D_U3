package bin.handlers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import static main.Run.bufferedImage;

public class SelecctionListener extends MouseAdapter implements KeyListener
{
    private int simageX,simageY,simageWidth,simageHeight;
    public boolean drawArea,exporSelection;
    private int currentX,currentY;
    private JPanel panelRef;
    private Runnable onCancel,onPrepare;
    private  final String SELECT = "Select";

    public SelecctionListener(JPanel canvas,Runnable onCancel,Runnable onPrepare)
    {
        this.onCancel = onCancel;
        this.onPrepare = onPrepare;
        panelRef = canvas;
        panelRef.addKeyListener(this);
        panelRef.setFocusable(true);
        panelRef.requestFocusInWindow();

        Action select = new AbstractAction(SELECT) {
            @Override
            public void actionPerformed(ActionEvent e) {
                prepare();
                System.out.println("Ejeuctando");
            }
        };
        panelRef.getInputMap().put(
                KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.CTRL_MASK), SELECT);
        panelRef.getActionMap().put(SELECT, select);
    }



    public void drawArea(Graphics g)
    {
        g.setColor(Color.orange);

        //dibuja horizontal
        g.drawLine(simageX,simageY,currentX,simageY);
        //dibuja vertcial
        g.drawLine(simageX,simageY,simageX,currentY);

        //dibuja horizontal opouesta
        g.drawLine(simageX,currentY,currentX,currentY);
        //dibuja vertical opouesta
        g.drawLine(currentX,simageY,currentX,currentY);

    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent)
    {
        if(exporSelection){
            currentX=mouseEvent.getX();
            currentY=mouseEvent.getY();
            panelRef.repaint();
        }
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        if(exporSelection){
            drawArea=true;
            simageX = mouseEvent.getX();
            simageY = mouseEvent.getY();
        }
    }

    private int auxSimageX,auxSimageY;

    private void toRectangle(int x, int y){

        if(simageX>x){
            simageWidth = simageX-x;
            auxSimageX=x;
        }else{
            simageWidth = x-simageX;
            auxSimageX = simageX;
        }

        if(simageY>y){
            simageHeight = simageY-y;
            auxSimageY=y;

        }else{
            simageHeight = y-simageY;
            auxSimageY = simageY;
        }
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        if(exporSelection){
            drawArea=false;
            toRectangle(mouseEvent.getX(),mouseEvent.getY());
            System.out.printf("Coords(%d,%d,%d,%d)\n",simageX,simageY,simageWidth,simageHeight);
            System.out.printf("Coords 2(%d,%d,%d,%d)\n",auxSimageX,auxSimageY,simageWidth,simageHeight);
            panelRef.setCursor(null);
            panelRef.repaint();
        }
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
           cancel();
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }

    public void prepare(){
        onPrepare.run();
    }

    public void cancel(){
        onCancel.run();
        exporSelection=false;
        drawArea=false;
        panelRef.setCursor(null);
        panelRef.repaint();
    }

    public BufferedImage getSelectedArea(BufferedImage bufferedImage){
        return bufferedImage.getSubimage(auxSimageX, auxSimageY, simageWidth, simageHeight);
    }
}
