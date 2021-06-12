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
