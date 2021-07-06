package bin.shape3d;

import bin.handlers.IFaceHandler;
import bin.shape3d.abstracts.Face3D;
import bin.shape3d.abstracts.Shape3D;

import java.awt.*;
import java.util.HashMap;

public class Structure3D extends Shape3D
{

    public Color default1=new Color(0xF6B62A),default2=new Color(0xE5D12D);

    public Structure3D(IFaceHandler callback)
    {
        super(callback);
        hashPoints = new HashMap<String,double[]>(){{
            put("A",new double[]{30,-45,90});
            put("B",new double[]{-30,-45,90});
            put("C",new double[]{30,45,90});
            put("D",new double[]{-30,45,90});
            put("E",new double[]{20,45,75});
            put("F",new double[]{30,45,60});
            put("G",new double[]{20,45,45});
            put("H",new double[]{30,45,30});
            put("I",new double[]{20,45,15});
            put("J",new double[]{30,45,0});
            put("K",new double[]{20,45,-15});
            put("L",new double[]{30,45,-30});
            put("M",new double[]{20,45,-45});
            put("N",new double[]{30,45,-60});
            put("Nn",new double[]{20,45,-75});
            put("O",new double[]{-20,45,75});
            put("P",new double[]{-30,45,60});
            put("Q",new double[]{-20,45,45});
            put("R",new double[]{-30,45,30});
            put("S",new double[]{-20,45,15});
            put("T",new double[]{-30,45,0});
            put("U",new double[]{-20,45,-15});
            put("V",new double[]{-30,45,-30});
            put("W",new double[]{-20,45,-45});
            put("X",new double[]{-30,45,-60});
            put("Y",new double[]{-20,45,-75});
            put("A'",new double[]{30,-45,-90});
            put("B'",new double[]{-30,-45,-90});
            put("C'",new double[]{30,45,-90});
            put("D'",new double[]{-30,45,-90});
            put("E'",new double[]{20,-45,75});
            put("F'",new double[]{30,-45,60});
            put("G'",new double[]{20,-45,45});
            put("H'",new double[]{30,-45,30});
            put("I'",new double[]{20,-45,15});
            put("J'",new double[]{30,-45,0});
            put("K'",new double[]{20,-45,-15});
            put("L'",new double[]{30,-45,-30});
            put("M'",new double[]{20,-45,-45});
            put("N'",new double[]{30,-45,-60});
            put("Nn'",new double[]{20,-45,-75});
            put("O'",new double[]{-20,-45,75});
            put("P'",new double[]{-30,-45,60});
            put("Q'",new double[]{-20,-45,45});
            put("R'",new double[]{-30,-45,30});
            put("S'",new double[]{-20,-45,15});
            put("T'",new double[]{-30,-45,0});
            put("U'",new double[]{-20,-45,-15});
            put("V'",new double[]{-30,-45,-30});
            put("W'",new double[]{-20,-45,-45});
            put("X'",new double[]{-30,-45,-60});
            put("Y'",new double[]{-20,-45,-75});
        }};
        initShape3D();
    }

    @Override
    public void initShape3D()
    {
        copyShapeFace3DS = new Face3D[]{
                new Face3D("Front face",default1,
                new double[][]{
                        hashPoints.get("A"),
                        hashPoints.get("B"),
                        hashPoints.get("D"),
                        hashPoints.get("C"),
                }),
                new Face3D("Behind face",default2,
                        new double[][]{
                                hashPoints.get("A'"),
                                hashPoints.get("B'"),
                                hashPoints.get("D'"),
                                hashPoints.get("C'"),
                        }),
                new Face3D("Top face",default2,
                        new double[][]{
                                hashPoints.get("C"),
                                hashPoints.get("D"),
                                hashPoints.get("O"),
                                hashPoints.get("P"),
                                hashPoints.get("Q"),
                                hashPoints.get("R"),
                                hashPoints.get("S"),
                                hashPoints.get("T"),
                                hashPoints.get("U"),
                                hashPoints.get("V"),
                                hashPoints.get("W"),
                                hashPoints.get("X"),
                                hashPoints.get("Y"),
                                hashPoints.get("D'"),
                                hashPoints.get("C'"),
                                hashPoints.get("Nn"),
                                hashPoints.get("N"),
                                hashPoints.get("M"),
                                hashPoints.get("L"),
                                hashPoints.get("K"),
                                hashPoints.get("J"),
                                hashPoints.get("I"),
                                hashPoints.get("H"),
                                hashPoints.get("G"),
                                hashPoints.get("F"),
                                hashPoints.get("E"),
                        }),
                new Face3D("Bottom face",default1,
                        new double[][]{
                                hashPoints.get("A"),
                                hashPoints.get("B"),
                                hashPoints.get("O'"),
                                hashPoints.get("P'"),
                                hashPoints.get("Q'"),
                                hashPoints.get("R'"),
                                hashPoints.get("S'"),
                                hashPoints.get("T'"),
                                hashPoints.get("U'"),
                                hashPoints.get("V'"),
                                hashPoints.get("W'"),
                                hashPoints.get("X'"),
                                hashPoints.get("Y'"),
                                hashPoints.get("B'"),
                                hashPoints.get("A'"),
                                hashPoints.get("Nn'"),
                                hashPoints.get("N'"),
                                hashPoints.get("M'"),
                                hashPoints.get("L'"),
                                hashPoints.get("K'"),
                                hashPoints.get("J'"),
                                hashPoints.get("I'"),
                                hashPoints.get("H'"),
                                hashPoints.get("G'"),
                                hashPoints.get("F'"),
                                hashPoints.get("E'"),
                        }),
                         new Face3D("D1",default2,
                            new double[][]{
                                    hashPoints.get("C"),
                                    hashPoints.get("E"),
                                    hashPoints.get("E'"),
                                    hashPoints.get("A"),
                            }),
                new Face3D("L1",default2,
                        new double[][]{
                                hashPoints.get("O"),
                                hashPoints.get("O'"),
                                hashPoints.get("B"),
                                hashPoints.get("D"),
                        }),
                new Face3D("L2",default1,
                        new double[][]{
                                hashPoints.get("O"),
                                hashPoints.get("P"),
                                hashPoints.get("P'"),
                                hashPoints.get("O'"),
                        }),
                new Face3D("L3",default2,
                        new double[][]{
                                hashPoints.get("Q"),
                                hashPoints.get("Q'"),
                                hashPoints.get("P'"),
                                hashPoints.get("P"),
                        }),
                new Face3D("L4",default1,
                        new double[][]{
                                hashPoints.get("Q"),
                                hashPoints.get("R"),
                                hashPoints.get("R'"),
                                hashPoints.get("Q'"),
                        }),
                new Face3D("L5",default2,
                        new double[][]{
                                hashPoints.get("S"),
                                hashPoints.get("S'"),
                                hashPoints.get("R'"),
                                hashPoints.get("R"),
                        }),
                new Face3D("L6",default1,
                        new double[][]{
                                hashPoints.get("S"),
                                hashPoints.get("T"),
                                hashPoints.get("T'"),
                                hashPoints.get("S'"),
                        }),
                new Face3D("L7",default2,
                        new double[][]{
                                hashPoints.get("U"),
                                hashPoints.get("U'"),
                                hashPoints.get("T'"),
                                hashPoints.get("T"),
                        }),
                new Face3D("L8",default1,
                        new double[][]{
                                hashPoints.get("U"),
                                hashPoints.get("V"),
                                hashPoints.get("V'"),
                                hashPoints.get("U'"),
                        }),
                new Face3D("L9",default2,
                        new double[][]{
                                hashPoints.get("W"),
                                hashPoints.get("W'"),
                                hashPoints.get("V'"),
                                hashPoints.get("V"),
                        }),
                new Face3D("L10",default1,
                        new double[][]{
                                hashPoints.get("W"),
                                hashPoints.get("X"),
                                hashPoints.get("X'"),
                                hashPoints.get("W'"),
                        }),
                new Face3D("L11",default2,
                        new double[][]{
                                hashPoints.get("Y"),
                                hashPoints.get("Y'"),
                                hashPoints.get("X'"),
                                hashPoints.get("X"),
                        }),
                new Face3D("L12",default1,
                        new double[][]{
                                hashPoints.get("Y"),
                                hashPoints.get("D'"),
                                hashPoints.get("B'"),
                                hashPoints.get("Y'"),
                        }),
                new Face3D("R1",default1,
                        new double[][]{
                                hashPoints.get("E"),
                                hashPoints.get("E'"),
                                hashPoints.get("A"),
                                hashPoints.get("C"),
                        }),
                new Face3D("R2",default2,
                        new double[][]{
                                hashPoints.get("E"),
                                hashPoints.get("F"),
                                hashPoints.get("F'"),
                                hashPoints.get("E'"),
                        }),
                new Face3D("R3",default1,
                        new double[][]{
                                hashPoints.get("G"),
                                hashPoints.get("G'"),
                                hashPoints.get("F'"),
                                hashPoints.get("F"),
                        }),
                new Face3D("R4",default2,
                        new double[][]{
                                hashPoints.get("G"),
                                hashPoints.get("H"),
                                hashPoints.get("H'"),
                                hashPoints.get("G'"),
                        }),
                new Face3D("R5",default1,
                        new double[][]{
                                hashPoints.get("I"),
                                hashPoints.get("I'"),
                                hashPoints.get("H'"),
                                hashPoints.get("H"),
                        }),
                new Face3D("R6",default2,
                        new double[][]{
                                hashPoints.get("I"),
                                hashPoints.get("J"),
                                hashPoints.get("J'"),
                                hashPoints.get("I'"),
                        }),
                new Face3D("R7",default1,
                        new double[][]{
                                hashPoints.get("K"),
                                hashPoints.get("K'"),
                                hashPoints.get("J'"),
                                hashPoints.get("J"),
                        }),
                new Face3D("R8",default2,
                        new double[][]{
                                hashPoints.get("K"),
                                hashPoints.get("L"),
                                hashPoints.get("L'"),
                                hashPoints.get("K'"),
                        }),
                new Face3D("R9",default1,
                        new double[][]{
                                hashPoints.get("M"),
                                hashPoints.get("M'"),
                                hashPoints.get("L'"),
                                hashPoints.get("L"),
                        }),
                new Face3D("R10",default2,
                        new double[][]{
                                hashPoints.get("M"),
                                hashPoints.get("N"),
                                hashPoints.get("N'"),
                                hashPoints.get("M'"),
                        }),
                new Face3D("R11",default1,
                        new double[][]{
                                hashPoints.get("Nn"),
                                hashPoints.get("Nn'"),
                                hashPoints.get("N'"),
                                hashPoints.get("N"),
                        }),
                new Face3D("R12",default2,
                        new double[][]{
                                hashPoints.get("Nn"),
                                hashPoints.get("C'"),
                                hashPoints.get("A'"),
                                hashPoints.get("Nn'"),
                        }),
        };
        initPanelFaces();
    }
}
