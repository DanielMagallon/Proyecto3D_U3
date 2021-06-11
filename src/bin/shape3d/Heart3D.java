package bin.shape3d;

import bin.shape3d.abstracts.Face3D;
import bin.shape3d.abstracts.Shape3D;

import java.awt.*;
import java.util.HashMap;

public class Heart3D extends Shape3D
{

    public Heart3D()
    {
        hashPoints = new HashMap<String,double[]>(){{
            put("A",new double[]{5,40,20});
            put("B",new double[]{5,50,20});
            put("C",new double[]{15,50,20});
            put("D",new double[]{15,60,20});
            put("E",new double[]{45,60,20});
            put("F",new double[]{45,50,20});
            put("G",new double[]{55,50,20});
            put("H",new double[]{55,40,20});
            put("I",new double[]{65,40,20});
            put("J",new double[]{65,0,20});
            put("K",new double[]{55,0,20});
            put("L",new double[]{55,-10,20});
            put("M",new double[]{45,-10,20});
            put("N",new double[]{45,-20,20});
            put("Nn",new double[]{35,-20,20});
            put("O",new double[]{35,-30,20});
            put("P",new double[]{25,-30,20});
            put("Q",new double[]{25,-40,20});
            put("R",new double[]{15,-40,20});
            put("S",new double[]{15,-50,20});
            put("T",new double[]{5,-50,20});
            put("U",new double[]{5,-60,20});
            put("V",new double[]{-5,-60,20});
            put("W",new double[]{-5,-50,20});
            put("X",new double[]{-15,-50,20});
            put("Y",new double[]{-15,-40,20});
            put("Z",new double[]{-25,-40,20});
            put("A1",new double[]{-25,-30,20});
            put("B1",new double[]{-35,-30,20});
            put("C1",new double[]{-35,-20,20});
            put("D1",new double[]{-45,-20,20});
            put("E1",new double[]{-45,-10,20});
            put("F1",new double[]{-55,-10,20});
            put("G1",new double[]{-55,0,20});
            put("H1",new double[]{-65,0,20});
            put("I1",new double[]{-65,40,20});
            put("J1",new double[]{-55,40,20});
            put("K1",new double[]{-55,50,20});
            put("L1",new double[]{-45,50,20});
            put("M1",new double[]{-45,60,20});
            put("N1",new double[]{-15,60,20});
            put("Nn1",new double[]{-15,50,20});
            put("O1",new double[]{-5,50,20});
            put("P1",new double[]{-5,40,20});


            //Cara atras
            put("2A",new double[]{5,40,-20});
            put("2B",new double[]{5,50,-20});
            put("2C",new double[]{15,50,-20});
            put("2D",new double[]{15,60,-20});
            put("2E",new double[]{45,60,-20});
            put("2F",new double[]{45,50,-20});
            put("2G",new double[]{55,50,-20});
            put("2H",new double[]{55,40,-20});
            put("2I",new double[]{65,40,-20});
            put("2J",new double[]{65,0,-20});
            put("2K",new double[]{55,0,-20});
            put("2L",new double[]{55,-10,-20});
            put("2M",new double[]{45,-10,-20});
            put("2N",new double[]{45,-20,-20});
            put("2Nn",new double[]{35,-20,-20});
            put("2O",new double[]{35,-30,-20});
            put("2P",new double[]{25,-30,-20});
            put("2Q",new double[]{25,-40,-20});
            put("2R",new double[]{15,-40,-20});
            put("2S",new double[]{15,-50,-20});
            put("2T",new double[]{5,-50,-20});
            put("2U",new double[]{5,-60,-20});
            put("2V",new double[]{-5,-60,-20});
            put("2W",new double[]{-5,-50,-20});
            put("2X",new double[]{-15,-50,-20});
            put("2Y",new double[]{-15,-40,-20});
            put("2Z",new double[]{-25,-40,-20});
            put("2A1",new double[]{-25,-30,-20});
            put("2B1",new double[]{-35,-30,-20});
            put("2C1",new double[]{-35,-20,-20});
            put("2D1",new double[]{-45,-20,-20});
            put("2E1",new double[]{-45,-10,-20});
            put("2F1",new double[]{-55,-10,-20});
            put("2G1",new double[]{-55,0,-20});
            put("2H1",new double[]{-65,0,-20});
            put("2I1",new double[]{-65,40,-20});
            put("2J1",new double[]{-55,40,-20});
            put("2K1",new double[]{-55,50,-20});
            put("2L1",new double[]{-45,50,-20});
            put("2M1",new double[]{-45,60,-20});
            put("2N1",new double[]{-15,60,-20});
            put("2Nn1",new double[]{-15,50,-20});
            put("2O1",new double[]{-5,50,-20});
            put("2P1",new double[]{-5,40,-20});
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
                                hashPoints.get("D"),
                                hashPoints.get("E"),
                                hashPoints.get("F"),
                                hashPoints.get("G"),
                                hashPoints.get("H"),
                                hashPoints.get("I"),
                                hashPoints.get("J"),
                                hashPoints.get("K"),
                                hashPoints.get("L"),
                                hashPoints.get("M"),
                                hashPoints.get("N"),
                                hashPoints.get("Nn"),
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
                                hashPoints.get("Z"),
                                hashPoints.get("A1"),
                                hashPoints.get("B1"),
                                hashPoints.get("C1"),
                                hashPoints.get("D1"),
                                hashPoints.get("E1"),
                                hashPoints.get("F1"),
                                hashPoints.get("G1"),
                                hashPoints.get("H1"),
                                hashPoints.get("I1"),
                                hashPoints.get("J1"),
                                hashPoints.get("K1"),
                                hashPoints.get("L1"),
                                hashPoints.get("M1"),
                                hashPoints.get("N1"),
                                hashPoints.get("Nn1"),
                                hashPoints.get("O1"),
                                hashPoints.get("P1")
                        }),
                new Face3D("Behind face",new Color(0xBB2648),
                        new double[][]{
                                hashPoints.get("2A"),
                                hashPoints.get("2B"),
                                hashPoints.get("2C"),
                                hashPoints.get("2D"),
                                hashPoints.get("2E"),
                                hashPoints.get("2F"),
                                hashPoints.get("2G"),
                                hashPoints.get("2H"),
                                hashPoints.get("2I"),
                                hashPoints.get("2J"),
                                hashPoints.get("2K"),
                                hashPoints.get("2L"),
                                hashPoints.get("2M"),
                                hashPoints.get("2N"),
                                hashPoints.get("2Nn"),
                                hashPoints.get("2O"),
                                hashPoints.get("2P"),
                                hashPoints.get("2Q"),
                                hashPoints.get("2R"),
                                hashPoints.get("2S"),
                                hashPoints.get("2T"),
                                hashPoints.get("2U"),
                                hashPoints.get("2V"),
                                hashPoints.get("2W"),
                                hashPoints.get("2X"),
                                hashPoints.get("2Y"),
                                hashPoints.get("2Z"),
                                hashPoints.get("2A1"),
                                hashPoints.get("2B1"),
                                hashPoints.get("2C1"),
                                hashPoints.get("2D1"),
                                hashPoints.get("2E1"),
                                hashPoints.get("2F1"),
                                hashPoints.get("2G1"),
                                hashPoints.get("2H1"),
                                hashPoints.get("2I1"),
                                hashPoints.get("2J1"),
                                hashPoints.get("2K1"),
                                hashPoints.get("2L1"),
                                hashPoints.get("2M1"),
                                hashPoints.get("2N1"),
                                hashPoints.get("2Nn1"),
                                hashPoints.get("2O1"),
                                hashPoints.get("2P1"),
                        }),
        };
    }
}
