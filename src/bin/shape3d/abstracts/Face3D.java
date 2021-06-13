package bin.shape3d.abstracts;

import static_props.AppProps;

import java.awt.*;
import java.util.ArrayList;

public class Face3D
{
    public String name;
    public double[][] originalPoints3D, points3D,reset3D;
    public Color bg_color;
    public boolean fillFace =true;

    public Face3D(String name,Color bg, double[][] points3D)
    {
        this.bg_color = bg;
        this.name = name;
        this.reset3D = points3D;
        this.originalPoints3D = new double[points3D.length][];
        this.points3D = new double[points3D.length][];
        for (int i = 0; i < this.points3D.length; i++) {
            this.points3D[i] = new double[points3D[i].length];
            this.originalPoints3D[i] = new double[points3D[i].length];
            System.arraycopy(points3D[i],0,this.points3D[i],0,points3D[i].length);
            System.arraycopy(points3D[i],0,this.originalPoints3D[i],0,points3D[i].length);
        }

    }

    public int[] xPts,yPts;

    public void to2D(int distance, int mz,int xInc, int yInc){
        ArrayList<Double> xPoints = new ArrayList<>();
        ArrayList<Double> yPoints = new ArrayList<>();
        double vX,vY;
        for (double[] doubles : points3D) {
            vX = (distance * doubles[0]) / (doubles[2] + mz) + xInc;
            vY = (distance * doubles[1]) / (doubles[2] + mz) + yInc;
            xPoints.add(vX);
            yPoints.add(vY);
        }

        xPts = new int[xPoints.size()];
        yPts = new int[xPoints.size()];

        for (int i = 0; i < xPts.length; i++) {
            xPts[i] =  (int)((double)xPoints.get(i));
            yPts[i] = (int) ((double)yPoints.get(i));
        }
    }

    public void scale(double Sx){
        for (int i = 0; i <points3D.length; i++) {
            points3D[i][0]=points3D[i][0]*=Sx;
            points3D[i][1]=points3D[i][1]*=Sx;
            points3D[i][2]=points3D[i][2]*=Sx;

        }
    }

    protected void reflectX(){
        for (int i = 0; i <points3D.length; i++) {
            originalPoints3D[i][1]=points3D[i][1]*=-1;
            originalPoints3D[i][2]=points3D[i][2]*=-1;

        }
    }

    protected void reflectY(){
        for (int i = 0; i <points3D.length; i++) {
            originalPoints3D[i][0]=points3D[i][0]*=-1;
            originalPoints3D[i][2]=points3D[i][2]*=-1;

        }
    }

    protected void reflectZ(){
        for (int i = 0; i <points3D.length; i++) {
            originalPoints3D[i][1]=points3D[i][1]*=-1;
            originalPoints3D[i][0]=points3D[i][0]*=-1;

        }
    }

    public static boolean filled=true;

    public void drawFace(Graphics2D g2){
        g2.setColor(AppProps.CANVAS_STROKE);
        g2.drawPolygon(xPts,yPts,xPts.length);
        if(filled && fillFace) {
            g2.setColor(this.bg_color);
            g2.fillPolygon(xPts, yPts, xPts.length);
        }
    }
    
    public void setcolor(Graphics2D g2){
       
        g2.setColor(this.bg_color);
 
    }

    public void rotate(int grx, int gry, int grz){
        double gradosRadx=Math.toRadians(grx);
        double gradosRady=Math.toRadians(gry);
        double gradosRadz=Math.toRadians(grz);
        double sa1=Math.sin(gradosRadx);
        double sa2=Math.sin(gradosRady);
        double sa3=Math.sin(gradosRadz);
        double ca1=Math.cos(gradosRadx);
        double ca2=Math.cos(gradosRady);
        double ca3=Math.cos(gradosRadz);

        for (int i = 0; i < this.points3D.length; i++) {
            double x= originalPoints3D[i][0];
            double y= originalPoints3D[i][1];
            double z= originalPoints3D[i][2];
            points3D[i][0]=x*(ca2*ca3)+y*((sa1*-sa2)*ca3+(ca1*-sa3))+z*((ca1*-sa2)*(ca3)+(-sa1*-sa3));
            points3D[i][1]=x*(ca2*sa3)+y*((sa1*-sa2)*(sa3)+(ca1*ca3))+z*((ca1*-sa2)*(sa3)+(-sa1*ca3));
            points3D[i][2]=x*sa2+y*(sa1*ca2)+z*(ca1*ca2);

        }
    }

    public void reset(){
        for (int i = 0; i < reset3D.length; i++) {
            System.arraycopy(reset3D[i],0,this.points3D[i],0,reset3D[i].length);
            System.arraycopy(reset3D[i],0,this.originalPoints3D[i],0,reset3D[i].length);
        }
    }

//    @Override
//    protected Face3D clone() {
//
//        double[][] ps = new double[points3D.length][];
//
//        for (int i = 0; i < points3D.length; i++) {
//            ps[i] =  new double[points3D[i].length];
//            System.arraycopy(points3D[i], 0, ps[i], 0, points3D[i].length);
//        }
//        return new Face3D(name,this.bg_color,ps);
//    }
}
