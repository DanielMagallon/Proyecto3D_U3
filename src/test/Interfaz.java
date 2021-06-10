package test;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.*;
public class Interfaz extends JPanel {
	FiguraED F;
	JFrame Vent;
	JSlider S1,S2,S3,S4;
	public Interfaz(double fig[][], int sec[]) {
		Vent = new JFrame("Transformaciones en 3D");
		Vent.setSize(800,600);
		Vent.add(this);
		F = new FiguraED(fig,sec);
		JPanel ps1=new JPanel(new GridLayout(1,1));
		TitledBorder tb1=new TitledBorder("Rotacion eje x");
		tb1.setTitleJustification(TitledBorder.CENTER);
		ps1.setBorder(tb1);
		S1=new JSlider(JSlider.HORIZONTAL,0,350,0);
		S1.setMinorTickSpacing(10);
		S1.setMajorTickSpacing(60);
		S1.setPaintLabels(true);
		S1.setPaintTicks(true);
		ps1.add(S1);
		//kaskvckasvcskn
		JPanel ps2=new JPanel(new GridLayout(1,1));
		TitledBorder tb2=new TitledBorder("Rotacion eje y");
		tb2.setTitleJustification(TitledBorder.CENTER);
		ps2.setBorder(tb2);
		S2=new JSlider(JSlider.HORIZONTAL,0,350,0);
		S2.setMinorTickSpacing(10);
		S2.setMajorTickSpacing(60);
		S2.setPaintLabels(true);
		S2.setPaintTicks(true);
		ps2.add(S2);
		///askhvkvashvhksahxvhk
		JPanel ps3=new JPanel(new GridLayout(1,1));
		TitledBorder tb3=new TitledBorder("Rotacion eje z");
		tb3.setTitleJustification(TitledBorder.CENTER);
		ps3.setBorder(tb3);
		S3=new JSlider(JSlider.HORIZONTAL,0,350,0);
		S3.setMinorTickSpacing(10);
		S3.setMajorTickSpacing(60);
		S3.setPaintLabels(true);
		S3.setPaintTicks(true);
		ps3.add(S3);
		JPanel sur=new JPanel(new GridLayout(1,3));
		sur.add(ps1);sur.add(ps2);sur.add(ps3);
		Vent.add(sur,BorderLayout.SOUTH);
		S4=new JSlider(JSlider.VERTICAL,100,2300,1000);
		S4.setMinorTickSpacing(50);
		S4.setMajorTickSpacing(100);
		S4.setPaintLabels(true);
		S4.setPaintTicks(true);
		Vent.add(S4,BorderLayout.EAST);
		
		
		//Evento Slider rotar
		S1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				//F.rotacionx(S1.getValue());
				F.rotacionXYZH(S1.getValue(), S2.getValue(), S3.getValue());
				repaint();
			}
		});
		
		S2.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
//				F.rotaciony(S2.getValue());
				F.rotacionXYZH(S1.getValue(), S2.getValue(), S3.getValue());

				repaint();
			}
		});
		S3.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
//				F.rotacionz(S3.getValue());
				F.rotacionXYZH(S1.getValue(), S2.getValue(), S3.getValue());

				repaint();
			}
		});
		
		S4.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				//F.rotacionx(S1.getValue());
				int dist= S4.getValue();
				F.actDistancia(dist);
				repaint();
			}
		});
		
		addMouseWheelListener(new MouseWheelListener() {
			
			@Override
			public void mouseWheelMoved(MouseWheelEvent e) {
				int sentRot= e.getWheelRotation();
				if(sentRot>0) { 
					F.Escalar(1.05);
				System.out.println("agranda");
				}else {
					if(sentRot<0)
					  F.Escalar(.95);
					System.out.println("Achica");
				}
				repaint();
			}
		});
		
		Vent.setVisible(true);
		Vent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		F.conv2D();
		F.dibujar(g);
		F.VistaSup(g);
		F.VistaLat(g);
		F.VistaFrontal(g);
	}
	public static void main(String[] args) {
		
		double cfig[][]={{0,35,0},
						 {30,-35,20},
						 {-30,-35,20},
						 {-30,-35,-20},
						 {30,-35,-20}};
		double cfige[][]= {
				{ -6, -6, 6 }, // a - 0
				{ 6, -6, 6 }, // b - 1
				{ 6, 6, 6 }, // c - 2
				{ -6, 6, 6 }, // d - 3
				{ 16, -1, 1 }, // e - 4
				{ 16, 1, 1 }, // f - 5

				{ -6, -6, -6 }, // a' - 6
				{ 6, -6, -6 }, // b' - 7
				{ 6, 6, -6 }, // c' - 8
				{ -6, 6, -6 }, // d' - 9
				{ 16, -1, -1 }, // e' - 10
				{ 16, 1, -1 }, // f' - 11

				};
		
		double cfig2[][]= {{30,-45,90}, //A 0
						   {-30,-45,90}, //B 1
						   {30,45,90}, //C 2
						   {-30,45,90},// D 3
						   {20,45,75},//E 4
						   {30,45,60},//F 5
						   {20,45,45},//G 6
						   {30,45,30},// H 7
						   {20,45,15},//I 8
						   {30,45,0},//J 9
						   {20,45,-15},//K 10
						   {30,45,-30},//L 11
						   {20,45,-45},//M 12
						   {30,45,-60},//N 13
						   {20,45,-75},//� 14
						   {-20,45,75},//O 15
						   {-30,45,60},//P 16
						   {-20,45,45},//Q 17
						   {-30,45,30},//R 18
						   {-20,45,15},//S 19
						   {-30,45,0},//T 20
						   {-20,45,-15},//U 21
						   {-30,45,-30},//V 22
						   {-20,45,-45},//W 23
						   {-30,45,-60},//X 24
						   {-20,45,-75}, //Y 25
						   {30,-45,-90},//A' 26
						   {-30,-45,-90},//B' 27
						   {30,45,-90},//C' 28
						   {-30,45,-90},//D' 29
						   {20,-45,75},//E' 30
						   {30,-45,60},//F' 31
						   {20,-45,45},//G' 32
						   {30,-45,30},//H' 33
						   {20,-45,15},//I� 34
						   {30,-45,0},//J' 35
						   {20,-45,-15},//K�36
						   {30,-45,-30},//L' 37
						   {20,-45,-45},//M�38
						   {30,-45,-60},//N' 39
						   {20,-45,-75},//�' 40
						   {-20,-45,75},//O' 41
						   {-30,-45,60},//P' 42
						   {-20,-45,45},//Q' 43
						   {-30,-45,30},// R' 44	
						   {-20,-45,15},//S' 45
						   {-30,-45,0},//T' 46
						   {-20,-45,-15},//U' 47
						   {-30,-45,-30},//V' 48
						   {-20,-45,-45},//W' 49
						   {-30,-45,-60},//X' 50
						   {-20,-45,-75},//Y' 51
		};
		double figurae[][]= {
				{15,-25,20}, //A 0
		};
		int secefra[]= {};
		new Interfaz(figurae,secefra);
	}

}
