package bin.shape3d.abstracts;

import java.awt.*;
import java.util.HashMap;

public abstract class Shape3D implements AbstractShape3D
{
    protected HashMap<String,double[]> hashPoints;
    protected   Face3D[]  copyShapeFace3DS;
    protected int distance=1000,mz=-350, despx =400, despy =300;

    @Override
    public void draw(Graphics2D g2)
    {
        g2.setStroke(new BasicStroke(2f));
        for (Face3D copyShapeFace3D : copyShapeFace3DS) copyShapeFace3D.drawFace(g2);
    }

    @Override
    public void conv2D() {
        for (Face3D copyShapeFace3D : copyShapeFace3DS) {
            copyShapeFace3D.to2D(distance, mz, despx, despy);
        }
    }

    @Override
    public void scale(double factor) {
        for (Face3D copyShapeFace3D : copyShapeFace3DS) {
            copyShapeFace3D.scale(factor);
        }

    }

    @Override
    public void rotacionXYZH(int grx, int gry, int grz) {
        for (Face3D copyShapeFace3D : copyShapeFace3DS) {
            copyShapeFace3D.rotate(grx,gry,grz);
        }
    }

    @Override
    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public void setMz(int mz) {
        this.mz = mz;
    }

    @Override
    public boolean dentro(int cx, int cy) {
        double minx,miny,maxx=0,maxy=0;
        for (Face3D copyShapeFace3D : copyShapeFace3DS) {

             minx=copyShapeFace3D.xPts[0];
             miny=copyShapeFace3D.yPts[1];

            //encuentro menores
            for(int i=1; i<copyShapeFace3D.xPts.length;i++) {
                if(copyShapeFace3D.xPts[i]<minx)minx=copyShapeFace3D.xPts[i];
                if(copyShapeFace3D.yPts[i]<miny)miny=copyShapeFace3D.yPts[i];
            }

            //encuentro mayores
            for(int i=1; i<copyShapeFace3D.xPts.length;i++) {
                if (copyShapeFace3D.xPts[i] > maxx) maxx = copyShapeFace3D.xPts[i];
                if (copyShapeFace3D.yPts[i] > maxy) maxy = copyShapeFace3D.yPts[i];
            }

            if( (cx >= minx && cx <= maxx) && (cy >= miny && cy < maxy))
                return true;
        }

        return false;
    }

    public int incXSup=70,incYSup=100,incXLat=70,incYLat=230,incXFro=70,incYFro=370;
    public void VistaSup(Graphics2D g) {
        for (Face3D copyShapeFace3D : copyShapeFace3DS) {
            double[][] figtemp =rotacionxt(90,copyShapeFace3D);

            //eliminamos la profundidad
            for(int i=0;i<figtemp.length;i++) {
                figtemp[i][2]=0;
                figtemp[i][0]+=incXSup;
                figtemp[i][1]+=incYSup;
            }
            this.dibujarVista(g,figtemp, "Vista superior",25,60);
        }
    }

    public void VistaLat(Graphics2D g) {
        for (Face3D copyShapeFace3D : copyShapeFace3DS) {

            double figtemp[][]=rotaciony(90,copyShapeFace3D);
            //eliminamos la profundidad
            for(int i=0;i<figtemp.length;i++) {
                figtemp[i][2]=0;
                figtemp[i][1]*=-1;
                figtemp[i][0]+=incXLat;
                figtemp[i][1]+=incYLat;

            }
            this.dibujarVista(g,figtemp,"Vista Lateral",25,140);
        }

    }

    public void VistaFrontal(Graphics2D g) {

        for (Face3D copyShapeFace3D : copyShapeFace3DS) {
            double figtemp[][]= new double [copyShapeFace3D.points3D.length][2];

            //eliminamos la profundidad
            for(int i=0;i<figtemp.length;i++) {
                figtemp[i][0]=copyShapeFace3D.originalPoints3D[i][0];
                figtemp[i][1]=-copyShapeFace3D.originalPoints3D[i][1];

                figtemp[i][0]+=incXFro;
                figtemp[i][1]+=incYFro;

            }
            this.dibujarVista(g,figtemp,"Vista Frontal",25,240);
        }


    }

    public void dibujarVista(Graphics2D g, double[][] ft, String texto, int x, int y) {
        g.drawString(texto, x, y);
        for (int i = 0; i <= ft.length-2; i++) {

            g.drawLine((int)ft[i][0],(int) ft[i][1], (int)ft[i+1][0],(int)ft[i+1][1]);
        }

    }

    protected double[][] rotacionxt(int gardos,Face3D face3d) {
        //[x,y*cos-sen*z,y*sen+z*cos]
        double gradosRad=Math.toRadians(gardos);
        double coseno=Math.cos(gradosRad);
        double seno=Math.sin(gradosRad);
        double vt[][]=new double[face3d.originalPoints3D.length][3];
        for (int i = 0; i < face3d.originalPoints3D.length; i++) {
            double x= face3d.originalPoints3D[i][0];
            double y= face3d.originalPoints3D[i][1];
            double z= face3d.originalPoints3D[i][2];
            vt[i][0]=x;
            vt[i][1]=(y*coseno)-(seno*z);
            vt[i][2]= (y*seno)+(z*coseno);

        }
        return vt;

    }

    protected double[][] rotaciony(int gardos,Face3D face3d) {
        //x*cos-sen*z,y, x*sen+z*cos
        double gradosRad=Math.toRadians(gardos);
        double coseno=Math.cos(gradosRad);
        double seno=Math.sin(gradosRad);
        double vt[][]=new double [face3d.originalPoints3D.length][3];

        for (int i = 0; i < vt.length; i++) {
            double x= face3d.originalPoints3D[i][0];
            double y= face3d.originalPoints3D[i][1];
            double z= face3d.originalPoints3D[i][2];
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

    @Override
    public void mover(int cx, int cy) {
        despx=cx;
        despy=cy;
    }

    public int getDistance() {
        return distance;
    }

    public int getMz() {
        return mz;
    }
}
