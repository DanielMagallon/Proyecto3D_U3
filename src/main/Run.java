package main;

import bin.Figura3D;
import frame.DefaultFrame;
import panes.Canvas3D;
import panes.PanelItem;
import panes.items.Escalamiento;
import panes.items.Reflexion;
import panes.items.Rotacion;
import panes.items.Vistas;
import panes.menu.PanelMenu;
import static_props.AppProps;

import javax.swing.*;
import java.awt.*;

public class Run
{
    private static DefaultFrame frame;
    private static JPanel panelMenus, panelMenuItem;

    public static Canvas3D canvas3D;
    public static Figura3D figura3D;

    static void initPanelItems(){
        JPanel panel = new JPanel(new BorderLayout()){{
            setOpaque(false);
        }};
        Rotacion panelRotacion = new Rotacion();
        Vistas vistas = new Vistas();
        Escalamiento escalamiento = new Escalamiento();
        Reflexion reflexion = new Reflexion();

        panelMenus = new JPanel(new FlowLayout(FlowLayout.LEFT,0,0))
        {{
            setOpaque(false);
            add(new PanelMenu(panelRotacion,"Rotaciones",true));
            add(new PanelMenu(escalamiento,"Escalamiento"));
            add(new PanelMenu(reflexion,"Reflexion"));
            add(new PanelMenu(vistas,"Vistas"));
        }};

        panelMenuItem = new JPanel(new BorderLayout());
        panelMenuItem.add(panelRotacion);

        panel.add(panelMenus,"North");
        panel.add(panelMenuItem);
        panel.setBorder(BorderFactory.createLineBorder(Color.black));

        canvas3D = new Canvas3D();

        frame.getContentPane().setBackground(AppProps.BG_GLOBAL);
        frame.getContentPane().add(panel,"North");
        frame.getContentPane().add(canvas3D);
    }

    public static void updatePanelItem(PanelItem panelItem){
        panelMenuItem.removeAll();
        panelMenuItem.add(panelItem);
        panelMenuItem.validate();
        panelItem.repaint();
    }


    public static void init(){
        frame = new DefaultFrame("Proyecto U3 -- Transformacions 3D");
        initPanelItems();
        figura3D = new Figura3D();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Run::init);
    }
}
