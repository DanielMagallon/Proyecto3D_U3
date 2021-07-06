package test;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class FiguraED {

		double Fig3D[][],Fig3DO[][],Fig3D00[][];
		int sec[];
		double Fig2D[][];
		int distancia= 1000;
		int mz=-350;
		int coordenadasfigx[];
		int coordenadasfigy[];
		//int carafrentex[]={384,384,354,354,263,263,233,233,203,203,233,233,263,263,293,293,324,324,354,354,384,384,415,415,445,445,475,475,506,506,536,536,566,566,596,596,566,566,536,536,445,445,415,415};
		//int carafrentey[]={178,148,148,118,118,148,148,178,178,300,300,330,330,360,360,390,390,421,421,451,451,481,481,451,451,421,421,390,390,360,360,330,330,300,300,178,178,148,148,118,118,148,148,178};
		//int caraatrasx[]={386,386,359,359,278,278,251,251,224,224,251,251,278,278,305,305,332,332,359,359,386,386,413,413,440,440,467,467,494,494,521,521,548,548,575,575,548,548,521,521,440,440,413,413};
		//int caraatrasy[]={191,164,164,137,137,164,164,191,191,300,300,327,327,354,354,381,381,408,408,435,435,462,462,435,435,408,408,381,381,354,354,327,327,300,300,191,191,164,164,137,137,164,164,191};
		public void actDistancia(int dist) {
			distancia=dist;
		}
		public void Escalar(double Sx) {
			for (int i = 0; i <Fig3D.length; i++) {
//				Fig3D[i][0]=Fig3DO[i][0]=Fig3DO[i][0]*Sx;
//				Fig3D[i][1]=Fig3DO[i][1]=Fig3DO[i][1]*Sx;
//				Fig3D[i][2]=Fig3DO[i][2]=Fig3DO[i][2]*Sx;
				Fig3DO[i][0]=Fig3D[i][0]*=Sx;
				Fig3DO[i][1]=Fig3D[i][1]*=Sx;
				Fig3DO[i][2]=Fig3D[i][2]*=Sx;
				
			}
		}
		//public void Escalar(double Sx) {
		//	for (int i = 0; i < Fig3D.length; i++) {
			//	Fig3D[i][0]=Fig3DO[i][0]*Sx;
			//	Fig3D[i][1]=Fig3DO[i][1]*Sx;
				//Fig3D[i][2]=Fig3DO[i][2]*Sx;
		//	}
		//}
		public FiguraED(double f[][], int s[]) {
			Fig3D = new double[f.length][3];
			Fig3DO = new double[f.length][3];
			Fig3D00= new double[f.length][3];
			
			Fig2D = new double[f.length][2];
			sec = new int[s.length];
			for (int i = 0; i < Fig3D.length; i++) {
				Fig3D00[i][0]=Fig3DO[i][0]=Fig3D[i][0]=f[i][0];
				Fig3D00[i][1]=Fig3DO[i][1]=Fig3D[i][1]=f[i][1];
				Fig3D00[i][2]=Fig3DO[i][2]=Fig3D[i][2]=f[i][2];
			}
			for (int i = 0; i < s.length; i++) {
				sec[i]=s[i];
			}
		}
		public void conv2D() {
			//cx=(d*x)/(z+mz)
			//cy=(d*y)/(z+mz)
			
			int conatras=0;
			for (int i = 0; i < Fig3D.length; i++) {
				Fig2D[i][0]=(distancia*Fig3D[i][0])/(Fig3D[i][2]+mz);
				Fig2D[i][1]=(distancia*Fig3D[i][1])/(Fig3D[i][2]+mz);
				
				Fig2D[i][0]+=400;
				Fig2D[i][1]+=300;
				//segunda cara
				
					if(i>43) {
					//caraatrasx[conatras]=(int)Fig2D[i][0];
					//caraatrasy[conatras]=(int)Fig2D[i][1];
					conatras++;
				
				}
				//primer cara
				if(i<44) {
					//carafrentex[i]=(int)Fig2D[i][0];
					//carafrentey[i]=(int)Fig2D[i][1];
				
				
				}
				
				
			}
			
		}
		public void dibujar(Graphics g) {
			 for(int i = 0; i <= sec.length-1; i+=2) {
				g.drawLine((int)Fig2D[sec[i]][0], (int)Fig2D[sec[i]][1],(int)Fig2D[sec[i+1]][0], (int)Fig2D[sec[i+1]][1]);
				
			}
			
			 this.caras(28, "uno", g);
			g.setColor(new Color(0x800441FF, true));
			//g.fillPolygon(caraatrasx, caraatrasy, 44);
			g.setColor(new Color(0x9AFF0000, true));
			//g.fillPolygon(carafrentex, carafrentey, 44);
			
			
		}
		
		public void rotacionx(int gardos) {
			//[x,y*cos-sen*z,y*sen+z*cos]
			double gradosRad=Math.toRadians(gardos);
			double coseno=Math.cos(gradosRad);
			double seno=Math.sin(gradosRad);
			
			for (int i = 0; i < Fig3D.length; i++) {
				double x= Fig3DO[i][0];
				double y= Fig3DO[i][1];
				double z= Fig3DO[i][2];
				Fig3D[i][0]=x;
				Fig3D[i][1]=(y*coseno)-(seno*z);
				Fig3D[i][2]= (y*seno)+(z*coseno);
				
			}
		}
		
		public double[][] rotacionxt(int gardos) {
			//[x,y*cos-sen*z,y*sen+z*cos]
			double gradosRad=Math.toRadians(gardos);
			double coseno=Math.cos(gradosRad);
			double seno=Math.sin(gradosRad);
			double vt[][]=new double[Fig3DO.length][3];
			for (int i = 0; i < Fig3D.length; i++) {
				double x= Fig3D00[i][0];
				double y= Fig3D00[i][1];
				double z= Fig3D00[i][2];
				vt[i][0]=x;
				vt[i][1]=(y*coseno)-(seno*z);
				vt[i][2]= (y*seno)+(z*coseno);
				
			}
			return vt; 
			
		}
		public void VistaSup(Graphics g) {
			double figtemp[][]=rotacionxt(90);
			//eliminamos la profundidad
			for(int i=0;i<figtemp.length;i++) {
				figtemp[i][2]=0;
				figtemp[i][0]+=50;
				figtemp[i][1]+=80;
			}
			dibujarVista(g,figtemp, "Vista superior",25,60);
		}
		
		public void VistaLat(Graphics g) {
			double figtemp[][]=rotaciony(90);
			//eliminamos la profundidad
			for(int i=0;i<figtemp.length;i++) {
				figtemp[i][2]=0;
				figtemp[i][1]*=-1;
				figtemp[i][0]+=50;
				figtemp[i][1]+=180;
				
			}
			dibujarVista(g,figtemp,"Vista Lateral",25,140);
		}
		
		public void VistaFrontal(Graphics g) {
			double figtemp[][]= new double [Fig3DO.length][2];
			//eliminamos la profundidad
			for(int i=0;i<figtemp.length;i++) {
				figtemp[i][0]=Fig3D00[i][0];
				figtemp[i][1]=-Fig3D00[i][1];
				
				figtemp[i][0]+=50;
				figtemp[i][1]+=280;
				
			}
			dibujarVista(g,figtemp,"Vista Frontal",25,240);
		}
		
		public void dibujarVista(Graphics g, double ft[][], String texto, int x, int y ) {
			g.drawString(texto, x, y);
			for (int i = 0; i <= sec.length-1; i+=2) {
	
				g.drawLine((int)ft[sec[i]][0], (int)ft[sec[i]][1],(int)ft[sec[i+1]][0], (int)ft[sec[i+1]][1]);
			}
			
		}
		
		public double[][] rotaciony(int gardos) {
			//x*cos-sen*z,y, x*sen+z*cos
			double gradosRad=Math.toRadians(gardos);
			double coseno=Math.cos(gradosRad);
			double seno=Math.sin(gradosRad);
			double vt[][]=new double [Fig3DO.length][3];
			
			for (int i = 0; i < vt.length; i++) {
				double x= Fig3D00[i][0];
				double y= Fig3D00[i][1];
				double z= Fig3D00[i][2];
				//al sentido
				/*vt[i][0]=(x*coseno)-(seno*z);;
				vt[i][1]=y;
				vt[i][2]= (x*seno)+(z*coseno);*/
				//al contrario
				vt[i][0]=(x*coseno)-(seno*z);
				vt[i][1]=y;
				vt[i][2]= +(x*seno)+(z*coseno);
				
			}
			return vt;
		}
		
		public double[][] rotaciony(int gardos,double vt[][]) {
			//x*cos-sen*z,y, x*sen+z*cos
			double gradosRad=Math.toRadians(gardos);
			double coseno=Math.cos(gradosRad);
			double seno=Math.sin(gradosRad);
			double vt2[][]=new double[Fig3DO.length][3];
			for (int i = 0; i < Fig3D.length; i++) {
				double x= vt[i][0];
				double y= vt[i][1];
				double z=vt[i][2];
				vt2[i][0]=(x*coseno)-(seno*z);
				vt2[i][1]=y;
				vt2[i][2]= (x*seno)+(z*coseno);
				
			}
			
			return vt2;
		}
		
		public void rotacionz(int gardos) {
			//x*seno-sen*y,x*seno+sen*y, z
			
			double gradosRad=Math.toRadians(gardos);
			double coseno=Math.cos(gradosRad);
			double seno=Math.sin(gradosRad);
			
			for (int i = 0; i < Fig3D.length; i++) {
				double x= Fig3DO[i][0];
				double y= Fig3DO[i][1];
				double z= Fig3DO[i][2];
				Fig3D[i][0]=(x*coseno)-(seno*y);
				Fig3D[i][1]=(x*seno)+(coseno*y);
				Fig3D[i][2]= z;
				
			}
		}
		
		public void rotacionz(int gardos, double v[][]) {
			//x*seno-sen*y,x*seno+sen*y, z
			
			double gradosRad=Math.toRadians(gardos);
			double coseno=Math.cos(gradosRad);
			double seno=Math.sin(gradosRad);
			
			for (int i = 0; i < Fig3D.length; i++) {
				double x= v[i][0];
				double y= v[i][1];
				double z= v[i][2];
				Fig3D[i][0]=(x*coseno)-(seno*y);
				Fig3D[i][1]=(x*seno)+(coseno*y);
				Fig3D[i][2]= z;
				
			}
		}
		
		public void rotacionxyz(int grx,int gry, int grz) {
			double vr[][]=rotacionxt(grx);
			vr=rotaciony(gry,vr);
			rotacionz(grz, vr);
		}
		
		public void rotacionXYZH(int grx,int gry, int grz) {
			
			double gradosRadx=Math.toRadians(grx);
			double gradosRady=Math.toRadians(gry);
			double gradosRadz=Math.toRadians(grz);
			double sa1=Math.sin(gradosRadx);
			double sa2=Math.sin(gradosRady);
			double sa3=Math.sin(gradosRadz);
			double ca1=Math.cos(gradosRadx);
			double ca2=Math.cos(gradosRady);
			double ca3=Math.cos(gradosRadz);
			
			for (int i = 0; i < Fig3D.length; i++) {
				double x= Fig3DO[i][0];
				double y= Fig3DO[i][1];
				double z= Fig3DO[i][2];
				Fig3D[i][0]=x*(ca2*ca3)+y*((sa1*-sa2)*ca3+(ca1*-sa3))+z*((ca1*-sa2)*(ca3)+(-sa1*-sa3));
				Fig3D[i][1]=x*(ca2*sa3)+y*((sa1*-sa2)*(sa3)+(ca1*ca3))+z*((ca1*-sa2)*(sa3)+(-sa1*ca3));
				Fig3D[i][2]=x*sa2+y*(sa1*ca2)+z*(ca1*ca2);
				
			}
		}
		
		public void caras(int ncaras, String fig, Graphics g) {
			
			int rangos[]= new int[ncaras];
			int conatras=0;
			int carazig1x[]=new int[4];
			int carazig2x[]=new int[4];
			int carazig3x[]=new int[26];
			int carazig4x[]=new int[26];
			int carazig5x[]=new int[4];
			int carazig6x[]=new int[4];
			int carazig7x[]=new int[4];
			int carazig8x[]=new int[4];
			int carazig9x[]=new int[4];
			int carazig10x[]=new int[4];
			int carazig11x[]=new int[4];
			int carazig12x[]=new int[4];
			int carazig13x[]=new int[4];
			int carazig14x[]=new int[4];
			int carazig15x[]=new int[4];
			int carazig16x[]=new int[4];
			int carazig17x[]=new int[4];
			int carazig18x[]=new int[4];
			int carazig19x[]=new int[4];
			int carazig20x[]=new int[4];
			int carazig21x[]=new int[4];
			int carazig22x[]=new int[4];
			int carazig23x[]=new int[4];
			int carazig24x[]=new int[4];
			int carazig25x[]=new int[4];
			int carazig26x[]=new int[4];
			int carazig27x[]=new int[4];
			int carazig28x[]=new int[4];
		
			// yes
			int carazig1y[]=new int[4];
			int carazig2y[]=new int[4];
			int carazig3y[]=new int[26];
			int carazig4y[]=new int[26];
			int carazig5y[]=new int[4];
			int carazig6y[]=new int[4];
			int carazig7y[]=new int[4];
			int carazig8y[]=new int[4];
			int carazig9y[]=new int[4];
			int carazig10y[]=new int[4];
			int carazig11y[]=new int[4];
			int carazig12y[]=new int[4];
			int carazig13y[]=new int[4];
			int carazig14y[]=new int[4];
			int carazig15y[]=new int[4];
			int carazig16y[]=new int[4];
			int carazig17y[]=new int[4];
			int carazig18y[]=new int[4];
			int carazig19y[]=new int[4];
			int carazig20y[]=new int[4];
			int carazig21y[]=new int[4];
			int carazig22y[]=new int[4];
			int carazig23y[]=new int[4];
			int carazig24y[]=new int[4];
			int carazig25y[]=new int[4];
			int carazig26y[]=new int[4];
			int carazig27y[]=new int[4];
			int carazig28y[]=new int[4];
	
			if(fig.equalsIgnoreCase("uno")) {
				//zigzacseao
				//caras= 28
				//coordenadas x=156
				//coordenadas y=156
				 
				int contador=0;
				int control=0;
			for(int i=0; i<sec.length; i++) {
				if (control!=2 && control!=3) {
					if(contador==4) {
					
						System.out.println("Control: "+control);
						contador=0;
						control++;
						
					}
				}else if(control== 2 || control==3){
					System.out.println("Es el momento");
					if(contador==26) {
						System.out.println(control);
						contador=0;
						control++;
						
					}
				}
				
				if(i<8) {
					System.out.print(contador);
					carazig1x[contador]=(int)Fig2D[sec[i]][0];
					carazig1y[contador]=(int)Fig2D[sec[i++]][1];
					contador++;
				}else
				if(i<16 ) {
					System.out.print(contador);
					carazig2x[contador]=(int)Fig2D[sec[i]][0];
					carazig2y[contador]=(int)Fig2D[sec[i++]][1];
					contador++;
				}else
				if(i<68) {
					System.out.print(contador);
					carazig3x[contador]=(int)Fig2D[sec[i]][0];
					carazig3y[contador]=(int)Fig2D[sec[i++]][1];
					contador++;
				}else
				if(i<120) {
					System.out.print(contador);
					carazig4x[contador]=(int)Fig2D[sec[i]][0];
					carazig4y[contador]=(int)Fig2D[sec[i++]][1];
					contador++;
				}else
				if(i<128) {
					System.out.print(contador);
					carazig5x[contador]=(int)Fig2D[sec[i]][0];
					carazig5y[contador]=(int)Fig2D[sec[i++]][1];
					contador++;
				}else
				if(i<136) {
					System.out.print(contador);
					carazig6x[contador]=(int)Fig2D[sec[i]][0];
					carazig6y[contador]=(int)Fig2D[sec[i++]][1];
					contador++;
				}else
				if(i<144) {
					carazig7x[contador]=(int)Fig2D[sec[i]][0];
					carazig7y[contador]=(int)Fig2D[sec[i++]][1];
					contador++;
				}else
				if(i<152) {
					carazig8x[contador]=(int)Fig2D[sec[i]][0];
					carazig8y[contador]=(int)Fig2D[sec[i++]][1];
					contador++;
				}else
				if(i<160) {
					carazig9x[contador]=(int)Fig2D[sec[i]][0];
					carazig9y[contador]=(int)Fig2D[sec[i++]][1];
					contador++;
				}else
				if(i<168) {
					carazig10x[contador]=(int)Fig2D[sec[i]][0];
					carazig10y[contador]=(int)Fig2D[sec[i++]][1];
					contador++;
				}else
				if(i<176) {
					carazig11x[contador]=(int)Fig2D[sec[i]][0];
					carazig11y[contador]=(int)Fig2D[sec[i++]][1];
					contador++;
				}else
				if(i<184) {
					carazig12x[contador]=(int)Fig2D[sec[i]][0];
					carazig12x[contador]=(int)Fig2D[sec[i++]][1];
					contador++;
				}else
				if(i<192) {
					carazig13x[contador]=(int)Fig2D[sec[i]][0];
					carazig13y[contador]=(int)Fig2D[sec[i++]][1];
					contador++;
				}else
				if(i<200) {
					carazig14x[contador]=(int)Fig2D[sec[i]][0];
					carazig14y[contador]=(int)Fig2D[sec[i++]][1];
					contador++;
				}else
				if(i<208) {
					carazig15x[contador]=(int)Fig2D[sec[i]][0];
					carazig15y[contador]=(int)Fig2D[sec[i++]][1];
					contador++;
				}else
				if(i<216) {
					carazig16x[contador]=(int)Fig2D[sec[i]][0];
					carazig16y[contador]=(int)Fig2D[sec[i++]][1];
					contador++;
				}else
				if(i<224) {
					carazig17x[contador]=(int)Fig2D[sec[i]][0];
					carazig17y[contador]=(int)Fig2D[sec[i++]][1];
					contador++;
				}else
				if(i<232) {
					carazig18x[contador]=(int)Fig2D[sec[i]][0];
					carazig18y[contador]=(int)Fig2D[sec[i++]][1];
					contador++;
				}else
				if(i<240) {
					carazig19x[contador]=(int)Fig2D[sec[i]][0];
					carazig19y[contador]=(int)Fig2D[sec[i++]][1];
					contador++;
				}else
				if(i<248) {
					carazig20x[contador]=(int)Fig2D[sec[i]][0];
					carazig20y[contador]=(int)Fig2D[sec[i++]][1];
					contador++;
				}else
				if(i<256) {
					carazig21x[contador]=(int)Fig2D[sec[i]][0];
					carazig21y[contador]=(int)Fig2D[sec[i++]][1];
					contador++;
				}else
				if(i<264) {
					carazig22x[contador]=(int)Fig2D[sec[i]][0];
					carazig22y[contador]=(int)Fig2D[sec[i++]][1];
					contador++;
				}else
				if(i<272) {
					carazig23x[contador]=(int)Fig2D[sec[i]][0];
					carazig23y[contador]=(int)Fig2D[sec[i++]][1];
					contador++;
				}else
				if(i<280) {
					carazig24x[contador]=(int)Fig2D[sec[i]][0];
					carazig24y[contador]=(int)Fig2D[sec[i++]][1];
					contador++;
				}else
				if(i<288) {
					carazig25x[contador]=(int)Fig2D[sec[i]][0];
					carazig25y[contador]=(int)Fig2D[sec[i++]][1];
					contador++;
				}else
				if(i<296) {
					carazig26x[contador]=(int)Fig2D[sec[i]][0];
					carazig26y[contador]=(int)Fig2D[sec[i++]][1];
					contador++;
				}else
				if(i<304) {
					carazig27x[contador]=(int)Fig2D[sec[i]][0];
					carazig27y[contador]=(int)Fig2D[sec[i++]][1];
					contador++;
				}else
				if(i<312) {
					carazig28x[contador]=(int)Fig2D[sec[i]][0];
					carazig28y[contador]=(int)Fig2D[sec[i++]][1];
					contador++;
				}
				
				
			}
			System.out.println(control);
			g.setColor(new Color(0x9AFF0000, true));
			g.fillPolygon(carazig1x, carazig1y, 4);
			g.fillPolygon(carazig2x, carazig2y, 4);
			g.fillPolygon(carazig3x, carazig3y, 26);
			g.fillPolygon(carazig4x, carazig4y, 26);
			g.fillPolygon(carazig5x, carazig5y, 4);
			g.fillPolygon(carazig6x, carazig6y, 4);
			g.fillPolygon(carazig7x, carazig7y, 4);
			g.fillPolygon(carazig8x, carazig8y, 4);
			g.fillPolygon(carazig9x, carazig9y, 4);
			g.fillPolygon(carazig10x, carazig10y, 4);
			g.fillPolygon(carazig11x, carazig11y, 4);
			
			g.fillPolygon(carazig12x, carazig12y, 4);
			g.fillPolygon(carazig13x, carazig13y, 4);
			g.fillPolygon(carazig14x, carazig14y, 4);
			g.fillPolygon(carazig15x, carazig15y, 4);
			g.fillPolygon(carazig16x, carazig16y, 4);
			g.fillPolygon(carazig17x, carazig17y, 4);
			g.fillPolygon(carazig18x, carazig18y, 4);
			g.fillPolygon(carazig19x, carazig19y, 4);
			g.fillPolygon(carazig20x, carazig20y, 4);
			g.fillPolygon(carazig21x, carazig21y, 4);
		    g.fillPolygon(carazig22x, carazig22y, 4);
			g.fillPolygon(carazig23x, carazig23y, 4);
			g.fillPolygon(carazig24x, carazig24y, 4);
			g.fillPolygon(carazig25x, carazig25y, 4);
			g.fillPolygon(carazig26x, carazig26y, 4);
			g.fillPolygon(carazig27x, carazig27y, 4);
			g.fillPolygon(carazig28x, carazig28y, 4);

			g.setColor(Color.black);
			g.drawPolygon(carazig1x, carazig1y, 4);
			g.drawPolygon(carazig2x, carazig2y, 4);
			g.drawPolygon(carazig3x, carazig3y, 26);
			g.drawPolygon(carazig4x, carazig4y, 26);
			g.drawPolygon(carazig5x, carazig5y, 4);
			g.drawPolygon(carazig6x, carazig6y, 4);
			g.drawPolygon(carazig7x, carazig7y, 4);
			g.drawPolygon(carazig8x, carazig8y, 4);
			g.drawPolygon(carazig9x, carazig9y, 4);
			g.drawPolygon(carazig10x, carazig10y, 4);
			g.drawPolygon(carazig11x, carazig11y, 4);
			g.drawPolygon(carazig12x, carazig12y, 4);
			g.drawPolygon(carazig13x, carazig13y, 4);
			g.drawPolygon(carazig14x, carazig14y, 4);
			g.drawPolygon(carazig15x, carazig15y, 4);
			g.drawPolygon(carazig16x, carazig16y, 4);
			g.drawPolygon(carazig17x, carazig17y, 4);
			g.drawPolygon(carazig18x, carazig18y, 4);
			g.drawPolygon(carazig19x, carazig19y, 4);
			g.drawPolygon(carazig20x, carazig20y, 4);
			g.drawPolygon(carazig21x, carazig21y, 4);
			g.drawPolygon(carazig22x, carazig22y, 4);
			g.drawPolygon(carazig23x, carazig23y, 4);
			g.drawPolygon(carazig24x, carazig24y, 4);
			g.drawPolygon(carazig25x, carazig25y, 4);
			g.drawPolygon(carazig26x, carazig26y, 4);
			g.drawPolygon(carazig27x, carazig27y, 4);
			g.drawPolygon(carazig28x, carazig28y, 4);

		}
		}
}
