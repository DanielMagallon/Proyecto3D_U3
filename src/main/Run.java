package main;

import bin.shape3d.Cube3D;
import bin.shape3d.Heart3D;
import bin.shape3d.Structure3D;
import bin.shape3d.abstracts.AbstractShape3D;
import frame.DefaultFrame;
import modals.NotifyImage;
import panes.Canvas3D;
import panes.PanelItem;
import panes.items.*;
import panes.menu.PanelMenu;
import static_props.AppProps;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Run
{
    private static DefaultFrame frame;
    private static JPanel panelMenus, panelMenuItem;

    public static Canvas3D canvas3D;
//    public static Figura3D figura3D;

    public static NotifyImage notifyImage;

    public static boolean exportImage;
    public static BufferedImage bufferedImage;

    public static AbstractShape3D abstractShape3D;
    public static Cube3D cube3D;
    public static Heart3D heart3D;
    public static Structure3D structure3D;
    public static Rotacion panelRotacion = new Rotacion();


    static void initPanelItems(){
        JPanel panel = new JPanel(new BorderLayout()){{
            setOpaque(false);
        }};

        Vistas vistas = new Vistas();
        Escalamiento escalamiento = new Escalamiento();
        Reflexion reflexion = new Reflexion();
        Configuracion configuracion = new Configuracion();
        ChosseShape chosseShape = new ChosseShape();

        panelMenus = new JPanel(new FlowLayout(FlowLayout.LEFT,0,0))
        {{
            setOpaque(false);
            add(new PanelMenu(panelRotacion,"Rotaciones",true));
            add(new PanelMenu(escalamiento,"Escalamiento"));
            add(new PanelMenu(reflexion,"Reflexion"));
            add(new PanelMenu(vistas,"Vistas"));
            add(new PanelMenu(chosseShape,"Figuras"));
            add(new PanelMenu(configuracion,"Configuracion"));

        }};

        panelMenuItem = new JPanel(new BorderLayout());
        panelMenuItem.add(panelRotacion);

        panel.add(panelMenus,"North");
        panel.add(panelMenuItem);
        panel.setBorder(BorderFactory.createLineBorder(Color.black));


        frame.getContentPane().setBackground(AppProps.BG_GLOBAL);
        frame.getContentPane().add(panel,"North");
        canvas3D = new Canvas3D();
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
        frame = new DefaultFrame("Proyecto U3 -- Transformacions 3D").minSize(600,600);
        initPanelItems();
//        figura3D = new Figura3D();
        notifyImage = new NotifyImage(frame);
        frame.setVisible(true);
        {
            cube3D = new Cube3D();
            heart3D = new Heart3D();
            structure3D = new Structure3D();
            abstractShape3D = structure3D;
        }
        canvas3D.requestFocus();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(Run::init);
    }
}
