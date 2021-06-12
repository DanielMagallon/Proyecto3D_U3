package bin.shape3d.abstracts;

import java.awt.*;

public interface AbstractShape3D
{
    void draw(Graphics2D g2);
    void rotacionXYZH(int grx,int gry, int grz);
    void conv2D();
    void scale(double factor);
    void setDistance(int distance);
    void setMz(int mz);
    void initShape3D();
    boolean dentro(int cx,int cy);
    void mover(int cx,int cy);
}
