package panes.items;

import main.Run;
import panes.PanelItem;
import static_props.AppProps;

import javax.swing.*;
import static panes.items.ImageLoader.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
public class ChosseShape extends PanelItem
{
    private JLabel lblCubo,lblCorazon,lblStruct;

    public ChosseShape()
    {
        lblCubo = AppProps.createLabelFor("Cubo",()->{
            Run.abstractShape3D = Run.cube3D;
            updateShape();
        });
        lblCubo.setIcon(ImageLoader.cuboDI);
        lblCorazon = AppProps.createLabelFor("Corazon",()->{
            Run.abstractShape3D = Run.heart3D;
            updateShape();
        });
        lblCorazon.setIcon(ImageLoader.corazonDI);
        lblStruct = AppProps.createLabelFor("Estructura",()->{
            Run.abstractShape3D = Run.structure3D;
            updateShape();
        });
        lblStruct.setIcon(ImageLoader.estructuraDI);
        
        lblCubo.addMouseListener(new MouseAdapter() {
			public void mouseExited(MouseEvent e) {
				if(e.getComponent()==lblCubo) {
					 lblCubo.setIcon(ImageLoader.cuboDI);
				}
				
			}
			public void mouseEntered(MouseEvent e) {
				if(e.getComponent()==lblCubo) {
					 lblCubo.setIcon(ImageLoader.cuboDR);
				}
			}
		});
        lblCorazon.addMouseListener(new MouseAdapter() {
     			public void mouseExited(MouseEvent e) {
     				if(e.getComponent()==lblCorazon) {
     					 lblCorazon.setIcon(ImageLoader.corazonDI);
     				}
     				
     			}
     			public void mouseEntered(MouseEvent e) {
     				if(e.getComponent()==lblCorazon) {
     					 lblCorazon.setIcon(ImageLoader.corazonRI);
     				}
     			}
     		});
        lblStruct.addMouseListener(new MouseAdapter() {
 			public void mouseExited(MouseEvent e) {
 				if(e.getComponent()==lblStruct) {
 					lblStruct.setIcon(ImageLoader.estructuraDI);
 				}
 				
 			}
 			public void mouseEntered(MouseEvent e) {
 				if(e.getComponent()==lblStruct) {
 					lblStruct.setIcon(ImageLoader.estructuraRI);
 				}
 			}
 		});
        add(lblCubo);
        add(lblCorazon);
        add(lblStruct);
    }

    private void updateShape(){
        Run.panelRotacion.updateShapeValues();
        Run.escalamiento.updateScaleValue();
        Run.caras.updateFaces();
        if(!Run.showViews)
            Run.canvas3D.repaint();
        else Run.Canvasvistas.repaint();
        if(!Run.faceProperties.closed){
            Run.faceProperties.close();
        }
    }
}
