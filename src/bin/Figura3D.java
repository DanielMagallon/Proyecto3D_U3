package bin;

import static_props.AppProps;

import java.awt.*;
import java.util.Arrays;


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
//				Fig3D[i][0]= figuraOriginal[i][0]*Sx;
//				Fig3D[i][1]= figuraOriginal[i][1]*Sx;
//				Fig3D[i][2]= figuraOriginal[i][2]*Sx;
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

		}
		
		public void rotacionx(int gardos) {
			//[x,y*cos-sen*z,y*sen+z*cos]
			double gradosRad=Math.toRadians(gardos);
			double coseno=Math.cos(gradosRad);
			double seno=Math.sin(gradosRad);
			
			for (int i = 0; i < Fig3D.length; i++) {
//				double x= figuraOriginal[i][0];
//				double y= figuraOriginal[i][1];
//				double z= figuraOriginal[i][2];
//				Fig3D[i][0]=x;
//				Fig3D[i][1]=(y*coseno)-(seno*z);
//				Fig3D[i][2]= (y*seno)+(z*coseno);
				
			}
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
//				double x= figuraOriginal[i][0];
//				double y= figuraOriginal[i][1];
//				double z= figuraOriginal[i][2];
//				Fig3D[i][0]=x*(ca2*ca3)+y*((sa1*-sa2)*ca3+(ca1*-sa3))+z*((ca1*-sa2)*(ca3)+(-sa1*-sa3));
//				Fig3D[i][1]=x*(ca2*sa3)+y*((sa1*-sa2)*(sa3)+(ca1*ca3))+z*((ca1*-sa2)*(sa3)+(-sa1*ca3));
//				Fig3D[i][2]=x*sa2+y*(sa1*ca2)+z*(ca1*ca2);
				
			}
		}
}
