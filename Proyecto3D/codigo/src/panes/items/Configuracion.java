package panes.items;

import bin.shape3d.abstracts.Face3D;

import panes.PanelItem;
import static_props.AppProps;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static main.Run.*;
import static panes.items.ImageLoader.*;
public class Configuracion extends PanelItem 
{
    public Configuracion()
    {
        super(1,10);
        JLabel lblExportAll,lblExportSelect,lblFill,lblReset;

        lblExportAll = AppProps.createLabelFor("Exportar a imagen",()->{
            try {
                exportImage=true;
                canvas3D.selecctionListener.exporSelection=false;
                bufferedImage = new BufferedImage(canvas3D.getWidth(),
                        canvas3D.getHeight(), BufferedImage.TYPE_INT_RGB);
                canvas3D.repaint();

            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        lblExportAll.setIcon(ImageLoader.escposiDI);
       
        lblExportSelect = AppProps.createLabelFor("Exportar seleccion",()->canvas3D.selecctionListener.prepare());
        lblExportSelect.setIcon(ImageLoader.escseleciDI);
        lblFill = AppProps.createLabelFor("Relleno",()->{
            Face3D.filled=!Face3D.filled;
            canvas3D.repaint();
        });
        lblFill.setIcon(ImageLoader.paintDI);
        lblReset = AppProps.createLabelFor("Restaurar",()->{
            abstractShape3D.setXAngulo(0);
            abstractShape3D.setYAngulo(0);
            abstractShape3D.setZAngulo(0);
            panelRotacion.updateShapeValues();
            escalamiento.reset();
            abstractShape3D.reset();
            canvas3D.repaint();
        });
        lblReset.setIcon(ImageLoader.reset);
        //hovers de la simagenes
       
        lblReset.addMouseListener(new MouseAdapter() {
			public void mouseExited(MouseEvent e) {
				if(e.getComponent()==lblReset) {
				lblReset.setIcon(ImageLoader.reset);
				}
			}
			public void mouseEntered(MouseEvent e) {
				if(e.getComponent()==lblReset) {
					lblReset.setIcon(ImageLoader.resetR);
				}
			}
		});
 lblExportAll.addMouseListener(new MouseAdapter() {
			public void mouseExited(MouseEvent e) {
				if(e.getComponent()==lblExportAll) {
					lblExportAll.setIcon(ImageLoader.escposiDI);
				}
			}
			public void mouseEntered(MouseEvent e) {
				if(e.getComponent()==lblExportAll) {
					lblExportAll.setIcon(ImageLoader.escposiRI);
					System.out.println("exportall");
				}
			}
			
		});
 lblExportSelect.addMouseListener(new MouseAdapter() {
		public void mouseExited(MouseEvent e) {
			if(e.getComponent()==lblExportSelect) {
				lblExportSelect.setIcon(ImageLoader.escseleciDI);
			}
		}
		public void mouseEntered(MouseEvent e) {
			if(e.getComponent()==lblExportSelect) {
				lblExportSelect.setIcon(ImageLoader.escseleciRI);
			}
		}
		
	});
 lblFill.addMouseListener(new MouseAdapter() {
		public void mouseExited(MouseEvent e) {
			if(e.getComponent()== lblFill) {
				 lblFill.setIcon(ImageLoader.paintDI);
			}
		}
		public void mouseEntered(MouseEvent e) {
			if(e.getComponent()== lblFill) {
				 lblFill.setIcon(ImageLoader.paintRI);
			}
		}
		
	});
 
        add(lblExportAll);
        add(lblExportSelect);
        add(lblFill);
        add(lblReset);
    }

}
