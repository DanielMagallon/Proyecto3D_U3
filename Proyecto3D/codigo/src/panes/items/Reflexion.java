package panes.items;

import panes.PanelItem;
import static_props.AppProps;

import javax.swing.*;

import static main.Run.abstractShape3D;
import static main.Run.canvas3D;
import static panes.items.ImageLoader.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Reflexion extends PanelItem
{
    private JLabel lblTX,lblTY,lblTZ;

    public Reflexion()
    {
        super();
        lblTX = AppProps.createLabelFor("Reflexion X",()->{
            abstractShape3D.reflectX();
            canvas3D.repaint();
    });
          lblTX.setIcon(ImageLoader.refX);
        add(lblTX);
        lblTY = AppProps.createLabelFor("Reflexion Y",()->{
            abstractShape3D.reflectY();
            canvas3D.repaint();
    });
        lblTY.setIcon(ImageLoader.refY);
        add(lblTY);
        lblTZ = AppProps.createLabelFor("Reflexion Z",()->{
            abstractShape3D.reflectZ();
            canvas3D.repaint();
        });
        lblTZ.setIcon(ImageLoader.refz);
        add(lblTZ);
        
        lblTX.addMouseListener(new MouseAdapter() {
			public void mouseExited(MouseEvent e) {
				if(e.getComponent()==lblTX) {
					lblTX.setIcon(ImageLoader.refX);
				}
				
			}
			public void mouseEntered(MouseEvent e) {
				if(e.getComponent()==lblTX) {
					lblTX.setIcon(ImageLoader.refXR);
				}
				
			}
        
        });
    lblTY.addMouseListener(new MouseAdapter() {
		public void mouseExited(MouseEvent e) {
			if(e.getComponent()==lblTY) {
				lblTY.setIcon(ImageLoader.refY);
			}
			
		}
		public void mouseEntered(MouseEvent e) {
			if(e.getComponent()==lblTY) {
				lblTY.setIcon(ImageLoader.refYR);
			}
			
		}
    
    });
    lblTZ.addMouseListener(new MouseAdapter() {
		public void mouseExited(MouseEvent e) {
			if(e.getComponent()==lblTZ) {
				lblTZ.setIcon(ImageLoader.refz);
			}
			
		}
		public void mouseEntered(MouseEvent e) {
			if(e.getComponent()==lblTZ) {
				lblTZ.setIcon(ImageLoader.refzR);
			}
			
		}
    
    });
    
    }
      
    
}
