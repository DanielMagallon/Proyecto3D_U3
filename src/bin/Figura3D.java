package bin;

import static_props.AppProps;

import java.awt.*;
import java.util.Arrays;

import static static_props.AppProps.secf;
import static static_props.AppProps.figuraOriginal;

public class Figura3D {

		double Fig3D[][];
		double Fig2D[][];
		int distancia= 1000;
		int mz=-350;
		public void actDistancia(int dist) {
			distancia=dist;
		}
		public void Escalar(double Sx) {
			for (int i = 0; i < Fig3D.length; i++) {
				Fig3D[i][0]= figuraOriginal[i][0]*Sx;
				Fig3D[i][1]= figuraOriginal[i][1]*Sx;
				Fig3D[i][2]= figuraOriginal[i][2]*Sx;
			}
		}

    public void reflejarX(){
        for (int i = 0; i < Fig3D.length; i++) {
            Fig3D[i][1]= Fig3D[i][1]*-1;
            Fig3D[i][2]= Fig3D[i][2]*-1;
        }
    }

    public void reflejarY(){
        for (int i = 0; i < Fig3D.length; i++) {
            Fig3D[i][0]= Fig3D[i][0]*-1;
            Fig3D[i][2]= Fig3D[i][2]*-1;
        }
    }

    public void reflejarZ(){
        for (int i = 0; i < Fig3D.length; i++) {
            Fig3D[i][0]= Fig3D[i][0]*-1;
            Fig3D[i][1]= Fig3D[i][1]*-1;
        }
    }

		public Figura3D() {

			Fig3D = new double[figuraOriginal.length][3];
			Fig2D = new double[figuraOriginal.length][2];

			for (int i = 0; i < Fig3D.length; i++) {
				Fig3D[i][0]=figuraOriginal[i][0];
                Fig3D[i][1]=figuraOriginal[i][1];
                Fig3D[i][2]=figuraOriginal[i][2];
			}

		}
		public void conv2D() {
			//cx=(d*x)/(z+mz)
			//cy=(d*y)/(z+mz)
			for (int i = 0; i < Fig3D.length; i++) {
				Fig2D[i][0]=(distancia*Fig3D[i][0])/(Fig3D[i][2]+mz);
				Fig2D[i][1]=(distancia*Fig3D[i][1])/(Fig3D[i][2]+mz);
				Fig2D[i][0]+=400;
				Fig2D[i][1]+=300;
			}
		}
		public void dibujar(Graphics g) {
		    g.setColor(AppProps.CANVAS_STROKE);
			for (int i = 0; i <= secf.length-1; i+=2)
			{
				g.drawLine((int)Fig2D[secf[i]][0], (int)Fig2D[secf[i]][1],(int)Fig2D[secf[i+1]][0], (int)Fig2D[secf[i+1]][1]);
//                System.out.println("X: "+Fig2D[secf[i]][0]);
//                System.out.println("Y: "+Fig2D[secf[i]][1]);
//                System.out.println("X2: "+Fig2D[secf[i+1]][0]);
//                System.out.println("Y2: "+Fig2D[secf[i+1]][1]);
			}

//			g.setColor(Color.black);
//            int xPointsBase[] = {309,490,481,318};
////                    new int[]{ (int) Fig2D[secf[0]][0],(int) Fig2D[secf[2]][0],
////                    (int) Fig2D[secf[4]][0],(int) Fig2D[secf[6]][0]};
//            int yPointsBase[] = {406,406,394,394};
////                    new int[]{ (int) Fig2D[secf[1]][1],(int) Fig2D[secf[3]][1],
////                    (int) Fig2D[secf[5]][1],(int) Fig2D[secf[7]][1]};
//
//            System.out.println(Arrays.toString(xPointsBase));
//            System.out.println(Arrays.toString(yPointsBase));

            /**
             * Base
             *
             *  Linea1: (490,406) -> (309,406)
             *  Linea2: (490,406) -> (481,394)
             *  Linea3: (481,394) -> (318,394)
             *  Linea4: (318,394) -> (309,406)
             *
             * Cara frontal:
             *  Linea1: (309,406) -> (400,200)
             *  Linea2: (490,406) -> (400,200)
             */

//            int xFrontal[] = {309,400,490};
//            int yFrontal[] = {406,200,406};
//
//            g.fillPolygon(xPointsBase,yPointsBase,4);
//            g.setColor(new Color(0x487C7CB3, true));
//            g.fillPolygon(xFrontal,yFrontal,3);
//			g.fillPolygon(new int[]{100,100,400},new int[]{100,300,300},3);
		}
		
		public void rotacionx(int gardos) {
			//[x,y*cos-sen*z,y*sen+z*cos]
			double gradosRad=Math.toRadians(gardos);
			double coseno=Math.cos(gradosRad);
			double seno=Math.sin(gradosRad);
			
			for (int i = 0; i < Fig3D.length; i++) {
				double x= figuraOriginal[i][0];
				double y= figuraOriginal[i][1];
				double z= figuraOriginal[i][2];
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
			double vt[][]=new double[figuraOriginal.length][3];
			for (int i = 0; i < Fig3D.length; i++) {
				double x= figuraOriginal[i][0];
				double y= figuraOriginal[i][1];
				double z= figuraOriginal[i][2];
				vt[i][0]=x;
				vt[i][1]=(y*coseno)-(seno*z);
				vt[i][2]= (y*seno)+(z*coseno);
				
			}
			return vt; 
			
		}
		
		public void rotaciony(int gardos) {
			//x*cos-sen*z,y, x*sen+z*cos
			double gradosRad=Math.toRadians(gardos);
			double coseno=Math.cos(gradosRad);
			double seno=Math.sin(gradosRad);
			
			for (int i = 0; i < Fig3D.length; i++) {
				double x= figuraOriginal[i][0];
				double y= figuraOriginal[i][1];
				double z= figuraOriginal[i][2];
				Fig3D[i][0]=(x*coseno)-(seno*z);;
				Fig3D[i][1]=y;
				Fig3D[i][2]= (x*seno)+(z*coseno);
				
			}
		}
		
		public double[][] rotaciony(int gardos,double vt[][]) {
			//x*cos-sen*z,y, x*sen+z*cos
			double gradosRad=Math.toRadians(gardos);
			double coseno=Math.cos(gradosRad);
			double seno=Math.sin(gradosRad);
			double vt2[][]=new double[figuraOriginal.length][3];
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
				double x= figuraOriginal[i][0];
				double y= figuraOriginal[i][1];
				double z= figuraOriginal[i][2];
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
				double x= figuraOriginal[i][0];
				double y= figuraOriginal[i][1];
				double z= figuraOriginal[i][2];
				Fig3D[i][0]=x*(ca2*ca3)+y*((sa1*-sa2)*ca3+(ca1*-sa3))+z*((ca1*-sa2)*(ca3)+(-sa1*-sa3));
				Fig3D[i][1]=x*(ca2*sa3)+y*((sa1*-sa2)*(sa3)+(ca1*ca3))+z*((ca1*-sa2)*(sa3)+(-sa1*ca3));
				Fig3D[i][2]=x*sa2+y*(sa1*ca2)+z*(ca1*ca2);
				
			}
		}
}
