package test;

import java.awt.Graphics;

public class FiguraED {

		double Fig3D[][],Fig3DO[][],Fig3D00[][];
		int sec[];
		double Fig2D[][];
		int distancia= 1000;
		int mz=-350;
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
            System.arraycopy(s, 0, sec, 0, s.length);
		}
		public void conv2D() {
			//cx=(d*x)/(z+mz)
			//cy=(d*y)/(z+mz)
            System.out.println("\n--------- Coordenas 2D ---------------\n");
			for (int i = 0; i < Fig3D.length; i++) {
				Fig2D[i][0]=(distancia*Fig3D[i][0])/(Fig3D[i][2]+mz);
				Fig2D[i][1]=(distancia*Fig3D[i][1])/(Fig3D[i][2]+mz);
				System.out.println("X="+ Fig2D[i][0] + " Y= "+ Fig2D[i][1]);
				Fig2D[i][0]+=tx;
				Fig2D[i][1]+=ty;
			}
            System.out.println("\n--------- END ---------------\n");
		}

//		int tx=400,ty=300;
		int tx=0,ty= 0;

		public void dibujar(Graphics g) {
            System.out.println("\n---------- Dibujando secuencia --------------\n");
			for (int i = 0; i <= sec.length-1; i+=2) {
				g.drawLine((int)Fig2D[sec[i]][0], (int)Fig2D[sec[i]][1],(int)Fig2D[sec[i+1]][0], (int)Fig2D[sec[i+1]][1]);
                System.out.printf("De (%d,%d) a (%d,%d)\n",(int)Fig2D[sec[i]][0],
                            (int)Fig2D[sec[i]][1],(int)Fig2D[sec[i+1]][0],(int)Fig2D[sec[i+1]][1]);
			}
            System.out.println("\n---------- END --------------\n");
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

			showArray("Rotacion X",Fig3D);
		}

		void showArray(String title,double[][] mat)
        {
            System.out.println("\n---------------Trans. "+title+"---------------------\n");
            for(double fig[] : mat)
            {
                System.out.printf("(%d,%d,%d)\n",(int)fig[0],(int)fig[1],(int) fig[2]);
            }
            System.out.println("\n---------------END TRANS---------------------\n");
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

            showArray("Rotacion Z",Fig3D);
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
            showArray("Rotacion XYZ",vr);
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

            showArray("Rotacion XYZ H",Fig3D);
		}
}
