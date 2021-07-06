package main;

import bin.handlers.IFaceHandler;
import bin.shape3d.Cube3D;
import bin.shape3d.Heart3D;
import bin.shape3d.Structure3D;
import bin.shape3d.abstracts.AbstractShape3D;
import bin.shape3d.abstracts.Face3D;
import frame.DefaultFrame;
import modals.*;
import modals.NotifyImage;
import panes.Canvas3D;
import panes.Canvasvistas;
import panes.FaceProperties;
import panes.PanelItem;
import panes.items.*;
import panes.menu.PanelMenu;
import static_props.AppProps;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class Run
{
    public static DefaultFrame frame;
    private static JPanel panelMenus, panelMenuItem;
    private static Help modalHelp;
    private static Autores modalAutor;
    public static Canvas3D canvas3D;
    public  static Canvasvistas Canvasvistas;
//    public static Figura3D figura3D;

    public static NotifyImage notifyImage;

    public static boolean exportImage, showViews;
    public static BufferedImage bufferedImage;

    public static AbstractShape3D abstractShape3D;
    public static Cube3D cube3D;
    public static Heart3D heart3D;
    public static Structure3D structure3D;
    public static Rotacion panelRotacion = new Rotacion();
    public static Escalamiento escalamiento = new Escalamiento();
    public static Caras caras = new Caras();
    public static FaceProperties faceProperties = new FaceProperties();

    public static JLabel seleccionpane=new JLabel("Ver vistas");
    public static JLabel seleccionayuda=new JLabel("  AYUDA  ");
    public static JLabel seleccionautor=new JLabel("  AUTORES  ");

    static void initPanelItems(){
        JPanel panel = new JPanel(new BorderLayout()){{
            setOpaque(false);
        }};

        Reflexion reflexion = new Reflexion();
        Configuracion configuracion = new Configuracion();
        ChosseShape chosseShape = new ChosseShape();
       // Border border = LineBorder.createGrayLineBorder(Color.black);
        Border border = BorderFactory.createLineBorder(Color.black);
        panelMenuItem = new JPanel(new BorderLayout());
        panelMenuItem.add(panelRotacion);
        seleccionayuda.setCursor(AppProps.handCursor);
        seleccionayuda.setForeground(Color.black);
        seleccionayuda.setBorder(border);
        seleccionayuda.addMouseListener( new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
            	 modalHelp.setVisible(true);
            }
        });
        
        seleccionautor.setCursor(AppProps.handCursor);
        seleccionautor.setForeground(Color.black);
        seleccionautor.setBorder(border);
        seleccionautor.addMouseListener( new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
            	 modalAutor.setVisible(true);
            }
        });
        
        seleccionpane.setCursor(AppProps.handCursor);
        seleccionpane.setForeground(Color.black);
        seleccionpane.addMouseListener( new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {

                if(!showViews) {
                    seleccionpane.setText("Ver Dibujos");
                    seleccionpane.setForeground(AppProps.BG_CONTORNO);
                    frame.getContentPane().remove(canvas3D);
                    frame.getContentPane().add(Canvasvistas);
                }else {
                    seleccionpane.setText("Ver vistas");
                    seleccionpane.setForeground(Color.black);
                    frame.getContentPane().remove(Canvasvistas);
                    frame.getContentPane().add(canvas3D);

                }
                frame.getContentPane().validate();
                frame.getContentPane().repaint();
                showViews=!showViews;
            }
        });

        panelMenus = new JPanel(new FlowLayout(FlowLayout.LEFT,0,0))
        {{
            setOpaque(false);
            add(seleccionpane);
            add(new PanelMenu(panelRotacion,"Rotaciones",true));
            add(new PanelMenu(escalamiento,"Escalamiento"));
            add(new PanelMenu(reflexion,"Reflexion"));
            add(new PanelMenu(caras,"Caras"));
            add(new PanelMenu(chosseShape,"Figuras"));
            add(new PanelMenu(configuracion,"Configuracion"));
            add(seleccionayuda);
            add(seleccionautor);

        }};



        panel.add(panelMenus,"North");
        panel.add(panelMenuItem);
        panel.setPreferredSize(new Dimension(0,100));
        panel.setBorder(BorderFactory.createLineBorder(Color.black));


        frame.getContentPane().setBackground(AppProps.BG_GLOBAL);
        frame.getContentPane().add(panel,"North");
        canvas3D = new Canvas3D();
        Canvasvistas = new Canvasvistas();


        frame.getContentPane().add(canvas3D);

//        help = new Help(frame,true);

    }

//    public static Help help;

    public static void updatePanelItem(PanelItem panelItem){
        panelMenuItem.removeAll();
        panelMenuItem.add(panelItem);
        panelMenuItem.validate();
        panelItem.repaint();
    }


    public static void init(){
        frame = new DefaultFrame("Proyecto U3 -- Transformacions 3D").minSize(730,630);
        initPanelItems();
//        figura3D = new Figura3D();
        notifyImage = new NotifyImage(frame);
        modalHelp = new Help(frame,true);
        modalAutor = new Autores(frame,true);
        frame.setVisible(true);
        {
            cube3D = new Cube3D(Run::handler);
            heart3D = new Heart3D(Run::handler);
            structure3D = new Structure3D(Run::handler);
            abstractShape3D = cube3D;
        }
        caras.updateFaces();
        canvas3D.requestFocus();
        
   
    }

    static void handler(Face3D face3D)
    {
        if(faceProperties.closed) {
            frame.getContentPane().add(faceProperties, "East");
        }else{
            faceProperties.updateProps();
        }
        faceProperties.showFaceProps(face3D);
        frame.getContentPane().validate();
        frame.getContentPane().repaint();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(Run::init);
    }
}
