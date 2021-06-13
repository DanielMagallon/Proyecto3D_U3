package main;

import bin.shape3d.Cube3D;
import bin.shape3d.Heart3D;
import bin.shape3d.Structure3D;
import bin.shape3d.abstracts.AbstractShape3D;
import frame.DefaultFrame;
import modals.NotifyImage;
import panes.Canvas3D;
import panes.Canvasvistas;
import panes.PanelItem;
import panes.items.*;
import panes.menu.PanelMenu;
import static_props.AppProps;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;

public class Run
{
    private static DefaultFrame frame;
    private static JPanel panelMenus, panelMenuItem;

    public static Canvas3D canvas3D;
    public  static Canvasvistas Canvasvistas;
//    public static Figura3D figura3D;

    public static NotifyImage notifyImage;

    public static boolean exportImage;
    public static BufferedImage bufferedImage;

    public static AbstractShape3D abstractShape3D;
    public static Cube3D cube3D;
    public static Heart3D heart3D;
    public static Structure3D structure3D;
    public static Rotacion panelRotacion = new Rotacion();
    static JToggleButton seleccionpane=new JToggleButton("Ver vistas");

    static void initPanelItems(){
        JPanel panel = new JPanel(new BorderLayout()){{
            setOpaque(false);
        }};

        Caras caras = new Caras(1500,0);
        Escalamiento escalamiento = new Escalamiento();
        Reflexion reflexion = new Reflexion();
        Configuracion configuracion = new Configuracion();
        ChosseShape chosseShape = new ChosseShape();

        panelMenuItem = new JPanel(new BorderLayout());
        panelMenuItem.add(panelRotacion);

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

        }};



        panel.add(panelMenus,"North");
        panel.add(panelMenuItem);
        panel.setBorder(BorderFactory.createLineBorder(Color.black));


        frame.getContentPane().setBackground(AppProps.BG_GLOBAL);
        frame.getContentPane().add(panel,"North");
        canvas3D = new Canvas3D();
        Canvasvistas = new Canvasvistas();
        if(seleccionpane.isSelected()) {
        	seleccionpane.setText("Ver Dibujos"); 
        	frame.getContentPane().add(Canvasvistas);
        }else {
        	seleccionpane.setText("Ver Vistas");
        	seleccionpane.setBackground(Color.RED);
				seleccionpane.setForeground(Color.white);
        	frame.getContentPane().add(canvas3D);
        }
        //frame.getContentPane().add(canvas3D);
        
        
        seleccionpane.addItemListener( new ItemListener() {
			
   			public void itemStateChanged(ItemEvent e) {
   				// TODO Auto-generated method stub
   				if(seleccionpane.isSelected()) {
   					seleccionpane.setText("Ver Dibujos"); 
   					seleccionpane.setBackground(Color.RED);
   					seleccionpane.setForeground(Color.white);
   					frame.getContentPane().remove(canvas3D);
   					frame.getContentPane().add(Canvasvistas);
   					frame.getContentPane().repaint();
   					System.out.println("entra para ver vistas");
   				}else {
   					seleccionpane.setText("Ver vistas"); 
   					frame.getContentPane().remove(Canvasvistas);
   					frame.getContentPane().add(canvas3D);
   					System.out.println("entra para ver dibujos");
   					frame.getContentPane().repaint();
   					
   				}
   			}
   		});
        

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
