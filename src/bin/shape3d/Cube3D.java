package bin.shape3d;

import bin.shape3d.abstracts.Face3D;
import bin.shape3d.abstracts.Shape3D;

import java.awt.*;
import java.util.HashMap;

public class Cube3D extends Shape3D
{

    public Cube3D()
    {
        hashPoints = new HashMap<String,double[]>(){{
            put("A",new double[]{-40,-40,40});
            put("B",new double[]{40,-40,40});
            put("C",new double[]{40,40,40});
            put("D",new double[]{-40,40,40});
            put("E",new double[]{-40,40,-40});
            put("F",new double[]{40,40,-40});
            put("G",new double[]{40,-40,-40});
            put("H",new double[]{-40,-40,-40});
        }};
        initShape3D();
    }

    public void initShape3D(){
        copyShapeFace3DS = new Face3D[]{
                new Face3D("Front Face",new Color(0x4545EC),
                        new double[][]{
                        hashPoints.get("A"),
                        hashPoints.get("B"),
                        hashPoints.get("C"),
                        hashPoints.get("D")
                }),
                new Face3D("Rigth face",new Color(0xF5A208),
                        new double[][]{
                        hashPoints.get("B"),
                        hashPoints.get("C"),
                        hashPoints.get("F"),
                        hashPoints.get("G")
                }),
                new Face3D("Behind face",new Color(0x9E45EC61, true),
                        new double[][]{
                        hashPoints.get("G"),
                        hashPoints.get("F"),
                        hashPoints.get("E"),
                        hashPoints.get("H")
                }),
                new Face3D("Left face",new Color(0xBB2648),
                        new double[][]{
                        hashPoints.get("E"),
                        hashPoints.get("H"),
                        hashPoints.get("A"),
                        hashPoints.get("D")
                }),
                new Face3D("Bottom face",new Color(0xFFF6F6),
                        new double[][]{
                        hashPoints.get("A"),
                        hashPoints.get("B"),
                        hashPoints.get("G"),
                        hashPoints.get("H")
                }),
                new Face3D("Top face",new Color(0xE8DB12),
                        new double[][]{
                        hashPoints.get("C"),
                        hashPoints.get("D"),
                        hashPoints.get("E"),
                        hashPoints.get("F")
                })
        };
    }
}
