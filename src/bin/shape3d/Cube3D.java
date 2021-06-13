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
            put("A",new double[]{-45,-45,45});
            put("B",new double[]{45,-45,45});
            put("C",new double[]{45,45,45});
            put("D",new double[]{-45,45,45});
            put("E",new double[]{-45,45,-45});
            put("F",new double[]{45,45,-45});
            put("G",new double[]{45,-45,-45});
            put("H",new double[]{-45,-45,-45});

            put("I",new double[]{-15,-45,45});
            put("J",new double[]{-15,45,45});
            put("K",new double[]{15,45,45});
            put("L",new double[]{15,-45,45});

            put("M",new double[]{-45,15,45});
            put("N",new double[]{45,15,45});
            put("O",new double[]{-45,-15,45});
            put("P",new double[]{45,-15,45});

            put("Q",new double[]{-15,15,45});
            put("R",new double[]{-15,-15,45});
            put("S",new double[]{15,15,45});
            put("T",new double[]{15,-15,45});

            put("U",new double[]{45,45,15});
            put("V",new double[]{45,45,-15});
            put("W",new double[]{45,15,15});
            put("X",new double[]{45,15,-15});
            put("Y",new double[]{45,-15,15});
            put("Z",new double[]{45,-15,-15});

            put("A2",new double[]{45,-45,15});
            put("B2",new double[]{45,-45,-15});
            put("C2",new double[]{45,15,-45});
            put("D2",new double[]{45,-15,-45});

            put("E2",new double[]{-15,45,-45});
            put("F2",new double[]{15,45,-45});
            put("G2",new double[]{-45,15,-45});
            put("H2",new double[]{-15,15,-45});
            put("I2",new double[]{15,15,-45});
            put("K2",new double[]{-45,-15,-45});
            put("L2",new double[]{-15,-15,-45});
            put("M2",new double[]{15,-15,-45});
            put("O2",new double[]{-15,-45,-45});
            put("P2",new double[]{15,-45,-45});

            put("Q2",new double[]{-45,45,15});
            put("R2",new double[]{-45,45,-15});
            put("T2",new double[]{-45,15,15});
            put("U2",new double[]{-45,15,-15});
            put("X2",new double[]{-45,-15,15});
            put("Y2",new double[]{-45,-15,-15});
            put("A3",new double[]{-45,-45,15});
            put("B3",new double[]{-45,-45,-15});

            put("C3",new double[]{-15,45,-15});
            put("D3",new double[]{15,45,-15});
            put("E3",new double[]{-15,45,15});
            put("F3",new double[]{15,45,15});
        }};
        initShape3D();
    }

    public void initShape3D(){
        copyShapeFace3DS = new Face3D[]{
                new Face3D("Front Face00",new Color(0xF8F8F8),
                        new double[][]{
                        hashPoints.get("D"), hashPoints.get("J"), hashPoints.get("Q"), hashPoints.get("M")
                }),
                new Face3D("Front Face01",new Color(0xF8F8F8),
                        new double[][]{
                                hashPoints.get("J"), hashPoints.get("K"), hashPoints.get("S"), hashPoints.get("Q")
                        }),
                new Face3D("Front Face02",new Color(0xF8F8F8),
                        new double[][]{
                                hashPoints.get("K"), hashPoints.get("C"), hashPoints.get("N"), hashPoints.get("S")
                        }),
                new Face3D("Front Face10",new Color(0xF8F8F8),
                        new double[][]{
                                hashPoints.get("M"), hashPoints.get("Q"), hashPoints.get("R"), hashPoints.get("O")
                        }),
                new Face3D("Front Face11",new Color(0xF8F8F8),
                        new double[][]{
                                hashPoints.get("Q"), hashPoints.get("S"), hashPoints.get("T"), hashPoints.get("R")
                        }),
                new Face3D("Front Face12",new Color(0xF8F8F8),
                        new double[][]{
                                hashPoints.get("S"), hashPoints.get("N"), hashPoints.get("P"), hashPoints.get("T")
                        }),
                new Face3D("Front Face20",new Color(0xF8F8F8),
                        new double[][]{
                                hashPoints.get("O"), hashPoints.get("R"), hashPoints.get("I"), hashPoints.get("A")
                        }),
                new Face3D("Front Face21",new Color(0xF8F8F8),
                        new double[][]{
                                hashPoints.get("R"), hashPoints.get("T"), hashPoints.get("L"), hashPoints.get("I")
                        }),
                new Face3D("Front Face22",new Color(0xF8F8F8),
                        new double[][]{
                                hashPoints.get("T"), hashPoints.get("P"), hashPoints.get("B"), hashPoints.get("L")
                        }),


                new Face3D("Rigth face00",new Color(0xF5A208),
                        new double[][]{
                        hashPoints.get("C"), hashPoints.get("U"), hashPoints.get("W"), hashPoints.get("N")
                }),
                new Face3D("Rigth face01",new Color(0xF5A208),
                        new double[][]{
                                hashPoints.get("U"), hashPoints.get("V"), hashPoints.get("X"), hashPoints.get("W")
                        }),
                new Face3D("Rigth face02",new Color(0xF5A208),
                        new double[][]{
                                hashPoints.get("V"), hashPoints.get("F"), hashPoints.get("C2"), hashPoints.get("X")
                        }),
                new Face3D("Rigth face10",new Color(0xF5A208),
                        new double[][]{
                                hashPoints.get("N"), hashPoints.get("W"), hashPoints.get("Y"), hashPoints.get("P")
                        }),
                new Face3D("Rigth face11",new Color(0xF5A208),
                        new double[][]{
                                hashPoints.get("W"), hashPoints.get("X"), hashPoints.get("Z"), hashPoints.get("Y")
                        }),
                new Face3D("Rigth face12",new Color(0xF5A208),
                        new double[][]{
                                hashPoints.get("X"), hashPoints.get("C2"), hashPoints.get("D2"), hashPoints.get("Z")
                        }),
                new Face3D("Rigth face20",new Color(0xF5A208),
                        new double[][]{
                                hashPoints.get("P"), hashPoints.get("Y"), hashPoints.get("A2"), hashPoints.get("B")
                        }),
                new Face3D("Rigth face21",new Color(0xF5A208),
                        new double[][]{
                                hashPoints.get("Y"), hashPoints.get("Z"), hashPoints.get("B2"), hashPoints.get("A2")
                        }),
                new Face3D("Rigth face22",new Color(0xF5A208),
                        new double[][]{
                                hashPoints.get("Z"), hashPoints.get("D2"), hashPoints.get("G"), hashPoints.get("B2")
                        }),


                new Face3D("Behind face00",new Color(0x9E45EC61, true),
                        new double[][]{
                        hashPoints.get("E"), hashPoints.get("E2"), hashPoints.get("H2"), hashPoints.get("G2")
                }),
                new Face3D("Behind face01",new Color(0x9E45EC61, true),
                        new double[][]{
                                hashPoints.get("E2"), hashPoints.get("F2"), hashPoints.get("I2"), hashPoints.get("H2")
                        }),
                new Face3D("Behind face02",new Color(0x9E45EC61, true),
                        new double[][]{
                                hashPoints.get("F2"), hashPoints.get("F"), hashPoints.get("C2"), hashPoints.get("I2")
                        }),

                new Face3D("Behind face10",new Color(0x9E45EC61, true),
                        new double[][]{
                                hashPoints.get("G2"), hashPoints.get("H2"), hashPoints.get("L2"), hashPoints.get("K2")
                        }),
                new Face3D("Behind face11",new Color(0x9E45EC61, true),
                        new double[][]{
                                hashPoints.get("H2"), hashPoints.get("I2"), hashPoints.get("M2"), hashPoints.get("L2")
                        }),
                new Face3D("Behind face12",new Color(0x9E45EC61, true),
                        new double[][]{
                                hashPoints.get("I2"), hashPoints.get("C2"), hashPoints.get("D2"), hashPoints.get("M2")
                        }),

                new Face3D("Behind face20",new Color(0x9E45EC61, true),
                        new double[][]{
                                hashPoints.get("K2"), hashPoints.get("L2"), hashPoints.get("O2"), hashPoints.get("H")
                        }),
                new Face3D("Behind face21",new Color(0x9E45EC61, true),
                        new double[][]{
                                hashPoints.get("L2"), hashPoints.get("M2"), hashPoints.get("P2"), hashPoints.get("O2")
                        }),
                new Face3D("Behind face22",new Color(0x9E45EC61, true),
                        new double[][]{
                                hashPoints.get("M2"), hashPoints.get("D2"), hashPoints.get("G"), hashPoints.get("P2")
                        }),

                new Face3D("Left face00",new Color(0xBB2648),
                        new double[][]{
                        hashPoints.get("D"), hashPoints.get("Q2"), hashPoints.get("T2"), hashPoints.get("M")
                }),
                new Face3D("Left face01",new Color(0xBB2648),
                        new double[][]{
                                hashPoints.get("Q2"), hashPoints.get("R2"), hashPoints.get("U2"), hashPoints.get("T2")
                        }),
                new Face3D("Left face02",new Color(0xBB2648),
                        new double[][]{
                                hashPoints.get("R2"), hashPoints.get("E"), hashPoints.get("G2"), hashPoints.get("U2")
                        }),

                new Face3D("Left face10",new Color(0xBB2648),
                        new double[][]{
                                hashPoints.get("M"), hashPoints.get("T2"), hashPoints.get("X2"), hashPoints.get("O")
                        }),
                new Face3D("Left face11",new Color(0xBB2648),
                        new double[][]{
                                hashPoints.get("T2"), hashPoints.get("U2"), hashPoints.get("Y2"), hashPoints.get("X2")
                        }),
                new Face3D("Left face12",new Color(0xBB2648),
                        new double[][]{
                                hashPoints.get("U2"), hashPoints.get("G2"), hashPoints.get("K2"), hashPoints.get("Y2")
                        }),

                new Face3D("Left face20",new Color(0xBB2648),
                        new double[][]{
                                hashPoints.get("O"), hashPoints.get("X2"), hashPoints.get("A3"), hashPoints.get("A")
                        }),
                new Face3D("Left face21",new Color(0xBB2648),
                        new double[][]{
                                hashPoints.get("X2"), hashPoints.get("Y2"), hashPoints.get("B3"), hashPoints.get("A3")
                        }),
                new Face3D("Left face22",new Color(0xBB2648),
                        new double[][]{
                                hashPoints.get("Y2"), hashPoints.get("K2"), hashPoints.get("H"), hashPoints.get("B3")
                        }),



                new Face3D("Top face00",new Color(0xE8DB12),
                        new double[][]{
                                hashPoints.get("E"), hashPoints.get("E2"), hashPoints.get("C3"), hashPoints.get("R2")
                        }),
                new Face3D("Top face01",new Color(0xE8DB12),
                        new double[][]{
                                hashPoints.get("E2"), hashPoints.get("F2"), hashPoints.get("D3"), hashPoints.get("C3")
                        }),
                new Face3D("Top face03",new Color(0xE8DB12),
                        new double[][]{
                                hashPoints.get("F2"), hashPoints.get("F"), hashPoints.get("V"), hashPoints.get("D3")
                        }),

                new Face3D("Bottom face",new Color(0xFFF6F6),
                        new double[][]{
                        hashPoints.get("A"),
                        hashPoints.get("B"),
                        hashPoints.get("G"),
                        hashPoints.get("H")
                }),
        };
    }
}
