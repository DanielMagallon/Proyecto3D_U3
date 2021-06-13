package panes;
import bin.handlers.SelecctionListener;
import main.Run;
import static_props.AppProps;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import static main.Run.abstractShape3D;
import static main.Run.bufferedImage;
import static main.Run.canvas3D;
import static main.Run.exportImage;
import static main.Run.notifyImage;
import static main.Run.panelRotacion;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.image.RasterFormatException;
public class Canvasvistas  extends JPanel {

	 public Canvasvistas() {
	        setDoubleBuffered(true);
	        TitledBorder titledBorder = new TitledBorder("Lienzo de Vistas");
	        titledBorder.setTitleColor(AppProps.FG_NORMAL_TEXT);
	        titledBorder.setTitleJustification(TitledBorder.CENTER);
	        titledBorder.setBorder(BorderFactory.createLineBorder(AppProps.BG_CONTORNO));
	        setBorder(titledBorder);
	        setBackground(AppProps.CANVAS_BG);
	      
	      
	    }
	 
	 
	    protected void paintComponent(Graphics graphics) {
	            super.paintComponent(graphics);
	            Graphics2D g2 = (Graphics2D) graphics;
	            abstractShape3D.conv2D();
	            abstractShape3D.setcolor(g2);
	            abstractShape3D.VistaFrontal(g2);
	            abstractShape3D.VistaLat(g2);
	            abstractShape3D.VistaSup(g2);
}
}