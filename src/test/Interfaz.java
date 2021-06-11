package test;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.GeneralPath;
public class Interfaz extends JPanel {
	FiguraED F;
	JFrame Vent;
	JSlider S1,S2,S3,S4;
	GeneralPath pat;
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
				//F.rotaciony(S2.getValue());
				F.rotacionXYZH(S1.getValue(), S2.getValue(), S3.getValue());

				repaint();
			}
		});
		S3.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				//F.rotacionz(S3.getValue());
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
		
		//-----------------------general path-----------------------------
		pat = new GeneralPath();
		
		
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
		double cfigcorazon[][]= {
				{5,40,20},//A 0
				{5,50,20},//B 1
				{15,50,20},//C
				{15,60,20},//D
				{45,60,20},//E
				{45,50,20},//F
				{55,50,20},//G
				{55,40,20},//H
				{65,40,20},//I
				{65,0,20},//J
				{55,0,20},//K
				{55,-10,20},//L
				{45,-10,20},//M
				{45,-20,20},//N
				{35,-20,20},
				{35,-30,20},
				{25,-30,20},
				{25,-40,20},
				{15,-40,20},
				{15,-50,20},
				{5,-50,20},
				{5,-60,20},
				{-5,-60,20},
				{-5,-50,20},
				{-15,-50,20},
				{-15,-40,20},
				{-25,-40,20},
				{-25,-30,20},
				{-35,-30,20},
				{-35,-20,20},
				{-45,-20,20},
				{-45,-10,20},
				{-55,-10,20},
				{-55,0,20},
				{-65,0,20},
				{-65,40,20},
				{-55,40,20},
				{-55,50,20},
				{-45,50,20},
				{-45,60,20},
				{-15,60,20},
				{-15,50,20},
				{-5,50,20},
				{-5,40,20},
				//CARA ATRAS
				{5,40,-20},//A 0
				{5,50,-20},//B 1
				{15,50,-20},//C
				{15,60,-20},//D
				{45,60,-20},//E
				{45,50,-20},//F
				{55,50,-20},//G
				{55,40,-20},//H
				{65,40,-20},//I
				{65,0,-20},//J
				{55,0,-20},//K
				{55,-10,-20},//L
				{45,-10,-20},//M
				{45,-20,-20},//N
				{35,-20,-20},
				{35,-30,-20},
				{25,-30,-20},
				{25,-40,-20},
				{15,-40,-20},
				{15,-50,-20},
				{5,-50,-20},
				{5,-60,-20},
				{-5,-60,-20},
				{-5,-50,-20},
				{-15,-50,-20},
				{-15,-40,-20},
				{-25,-40,-20},
				{-25,-30,-20},
				{-35,-30,-20},
				{-35,-20,-20},
				{-45,-20,-20},
				{-45,-10,-20},
				{-55,-10,-20},
				{-55,0,-20},
				{-65,0,-20},
				{-65,40,-20},
				{-55,40,-20},
				{-55,50,-20},
				{-45,50,-20},
				{-45,60,-20},
				{-15,60,-20},
				{-15,50,-20},
				{-5,50,-20},
				{-5,40,-20}


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
				{-20,30,6}, //A 0
				{20,30,6},//B 1
				{20,18,6},//c 2
				{-10,18,6},//D 3
				{-10,6,6},//E 4
				{15,6,6},//F 5
				{-10,-6,6},//G 6
				{15,-6,6},//H 7
				{-20,-30,6},//I 8
				{-10,-18,6},//J 9
				{20,-18,6},//K 10
				{20,-30,6},//L 11
				{-20,30,-6},//A' 12
				{20,30,-6},//B' 13
				{20,18,-6},//C' 14
				{-10,18,-6},//D' 15
				{-10,6,-6},//E' 16
				{15,6,-6},//F' 17
				{-10,-6,-6},//G' 18
				{15,-6,-6},//H' 19
				{-20,-30,-6},//I' 20
				{-10,-18,-6},//J' 21
				{20,-18,-6},//K' 22
				{20,-30,-6}//L' 23

		};
		int secefra[]= {0,1,1,2,2,3,3,4,4,5,5,7,7,6,6,9,9,10,10,11,11,8,8,0,
				12,13,13,14,14,15,15,16,16,17,17,19,19,18,18,21,21,22,22,23,23,20,20,12,
				0,12,1,13,2,14,3,15,4,16,5,17,7,19,8,20,9,21,10,22,11,23};
		int secf[]= {2,1,2,3,3,4,4,1,1,0,2,0,3,0,4,0};
		int secf2[]= {1,0,0,2,2,3,3,1,3,15,15,16,16,17,17,18,18,19,19,20,20,21,21,22,22,23,23,24,24,25,25,29,29,28,28,14,14,13,13,12,12,11,11,10,10,9,9,8,8,7,7,6,6,5,5,4,4,2,2,3,
				1,41,41,42,42,43,43,44,44,45,45,46,46,47,47,48,48,49,49,50,50,51,51,27,27,26,26,40,40,39,39,38,38,37,37,36,36,35,35,34,34,33,33,32,32,31,31,30,30,0,0,1,
				26,27,27,29,29,28,28,26,4,30,5,31,6,32,7,33,8,34,9,35,10,36,11,37,12,38,13,39,14,40,15,41,16,42,17,43,18,44,19,45,20,46,21,47,22,48,23,49,24,50,25,51};
		int secfe[]= {0,1, 1,2, 2,3, 3,0, 1,4, 4,5,
				5,2,4,10, 5,11, 2,8, 3,9, 0,6,
				9,8, 8,11, 11,10, 10,7, 6,7,
				9,6, 1,7, 7,8};
		double hexagono[][]= {
				{30,50,0},//A 0
				{15,50,-30},//B 1
				{-15,50,-30},//C2
				{-30,50,0},//D 3
				{-15,50,30},//E 4
				{15,50,30},//F 5
				{30,-50,0},//A' 6
				{15,-50,-30},//B' 7
				{-15,-50,-30},//C'8
				{-30,-50,0},//D' 9
				{-15,-50,30},//E' 10
				{15,-50,30}//F' 11
		};
		
		int seccorazon[]= {0,1,1,2,2,3,3,4,4,5,5,6,6,7,7,8,8,9,9,10,10,11,11,12,12,13,13,14,14,15,15,16,16,17,17,18,18,19,19,20,20,21,21,22,22,23,23,24,24,25,25,26,26,27,27,28,28,29,29,30,30,31,31,32,32,33,33,34,34,35,35,36,36,37,37,38,38,39,39,40,40,41,41,42,42,43,43,0,
				44,45,45,46,46,47,47,48,48,49,49,50,50,51,51,52,52,53,53,54,54,55,55,56,56,57,57,58,58,59,59,60,60,61,61,62,62,63,63,64,64,65,65,66,66,67,67,68,68,69,69,70,70,71,71,72,72,73,73,74,74,75,75,76,76,77,77,78,78,79,79,80,80,81,81,82,82,83,83,84,84,85,85,86,86,87,87,44,
				0,44,1,45,2,46,3,47,4,48,5,49,6,50,7,51,8,52,9,53,10,54,11,55,12,56,13,57,14,58,15,59,16,60,17,61,18,62,19,63,20,64,21,65,22,66,23,67,24,68,25,69,26,70,27,71,28,72,29,73,30,74,31,75,32,76,33,77,34,78,35,79,36,80,37,81,38,82,39,83,40,84,41,85,42,86,43,87};
		int sechexa[]= {0,1,1,2,2,3,3,4,4,5,5,0,6,7,7,8,8,9,9,10,10,11,11,6,0,6,1,7,2,8,3,9,4,10,5,11};
		new Interfaz(cfigcorazon,seccorazon);
	}

}
