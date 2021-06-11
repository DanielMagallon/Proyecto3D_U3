package bin.shape3d.abstracts;

import java.awt.*;
import java.util.HashMap;

public abstract class Shape3D implements AbstractShape3D
{
    protected HashMap<String,double[]> hashPoints;
    protected   Face3D[]  copyShapeFace3DS;
    protected double[][] Fig2D;
    protected int distance=1000,mz=-350,xInc=400,yInc=300;

    @Override
    public void draw(Graphics2D g2)
    {
        g2.setStroke(new BasicStroke(1.8f));
        for (Face3D copyShapeFace3D : copyShapeFace3DS) copyShapeFace3D.drawFace(g2);
    }


    @Override
    public void conv2D() {
        for (Face3D copyShapeFace3D : copyShapeFace3DS) {
            copyShapeFace3D.to2D(distance, mz, xInc, yInc);
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

    public int getDistance() {
        return distance;
    }

    public int getMz() {
        return mz;
    }
}
