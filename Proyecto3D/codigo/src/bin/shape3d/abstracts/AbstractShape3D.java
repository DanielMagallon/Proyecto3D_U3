package bin.shape3d.abstracts;

import javax.swing.*;
import java.awt.*;

public interface AbstractShape3D
{
    void draw(Graphics2D g2);
    void setcolor(Graphics2D g2);
    void rotacionXYZH(int grx,int gry, int grz);
    void conv2D();
    void scale(double factor);
    void setDistance(int distance);
    int getDistance();
    void setMz(int mz);
    void initShape3D();
    void reflectX();
    void reflectY();
    void reflectZ();
    void setXAngulo(int xAngulo);
    void setYAngulo(int yAngulo);
    void setZAngulo(int zAngulo);
    int getXAngulo();
    int getYAngulo();
    int getZAngulo();
    boolean dentro(int cx,int cy);
    void mover(int cx,int cy);
    void reset();
    void VistaSup(Graphics2D g);
    void VistaLat(Graphics2D g);
    void VistaFrontal(Graphics2D g);
    JScrollPane getPanelFaces();
    void dibujarVista(Graphics2D g, double ft[][], String texto, int x, int y );
}
