package bin.shape3d;

import bin.shape3d.abstracts.Face3D;
import bin.shape3d.abstracts.Shape3D;
import static_props.AppProps;

import java.awt.*;
import java.util.HashMap;

public class Heart3D extends Shape3D
{



    private String[] sequence =
            {
                    "A", "2A", "B", "2B", "C", "2C", "D", "2D", "E", "2E", "F", "2F", "G", "2G", "H", "2H", "I",
                    "2I", "J", "2J", "K", "2K", "L", "2L", "M", "2M", "N", "2N", "Nn", "2Nn", "O", "2O", "P", "2P",
                    "Q", "2Q", "R", "2R", "S", "2S", "T", "2T", "U", "2U", "V", "2V", "W", "2W", "X", "2X", "Y",
                    "2Y", "Z", "2Z", "A1", "2A1", "B1", "2B1", "C1", "2C1", "D1", "2D1", "E1", "2E1", "F1", "2F1",
                    "G1", "2G1", "H1", "2H1", "I1", "2I1", "J1", "2J1", "K1", "2K1", "L1", "2L1", "M1", "2M1", "N1",
                    "2N1", "Nn1", "2Nn1", "O1", "2O1", "P1", "2P1"
            };

    private double[][] unions3D, originalPoints3D, unions2D;

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
        initUnion3D();
    }

    private void initUnion3D(){
        unions3D = new double[sequence.length][3];
        originalPoints3D = new double[sequence.length][3];
        unions2D = new double[sequence.length][2];

        int i=0;
        for (String s : sequence) {
            unions3D[i] = hashPoints.get(s).clone();
            originalPoints3D[i++] = hashPoints.get(s).clone();
        }
    }

    private void to2D(){
        int i=0;
        for (double [] union : unions3D)
        {
            unions2D[i][0] = (distance * union[0]) / (union[2] + mz) + despx;
            unions2D[i++][1] = (distance * union[1]) / (union[2] + mz) + despy;
        }
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
                                hashPoints.get("P1"),
                                hashPoints.get("A"),
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
                                hashPoints.get("2A"),
                        }),
        };
    }

    @Override
    public void draw(Graphics2D g2)
    {
        super.draw(g2);
        g2.setColor(AppProps.CANVAS_STROKE);
        to2D();
        for(int i = 0; i <= sequence.length-1; i+=2) {
            g2.drawLine((int)unions2D[i][0],
                    (int)unions2D[i][1],(int)unions2D[i+1][0],
                    (int)unions2D[i+1][1]);

        }
    }

    @Override
    public void scale(double factor) {
        super.scale(factor);
        for (int i = 0; i <unions3D.length; i++) {
            unions3D[i][0]=unions3D[i][0]*=factor;
            unions3D[i][1]=unions3D[i][1]*=factor;
            unions3D[i][2]=unions3D[i][2]*=factor;
        }
    }

    @Override
    public void rotacionXYZH(int grx, int gry, int grz) {
        super.rotacionXYZH(grx, gry, grz);
        rotate(grx,gry,grz);
    }

    private void rotate(int grx, int gry, int grz){
        double gradosRadx=Math.toRadians(grx);
        double gradosRady=Math.toRadians(gry);
        double gradosRadz=Math.toRadians(grz);
        double sa1=Math.sin(gradosRadx);
        double sa2=Math.sin(gradosRady);
        double sa3=Math.sin(gradosRadz);
        double ca1=Math.cos(gradosRadx);
        double ca2=Math.cos(gradosRady);
        double ca3=Math.cos(gradosRadz);

        for (int i = 0; i < this.unions3D.length; i++) {
            double x= originalPoints3D[i][0];
            double y= originalPoints3D[i][1];
            double z= originalPoints3D[i][2];
            unions3D[i][0]=x*(ca2*ca3)+y*((sa1*-sa2)*ca3+(ca1*-sa3))+z*((ca1*-sa2)*(ca3)+(-sa1*-sa3));
            unions3D[i][1]=x*(ca2*sa3)+y*((sa1*-sa2)*(sa3)+(ca1*ca3))+z*((ca1*-sa2)*(sa3)+(-sa1*ca3));
            unions3D[i][2]=x*sa2+y*(sa1*ca2)+z*(ca1*ca2);
        }
    }



    public void VistaSup(Graphics2D g) {
        super.VistaSup(g);
        double[][] figtemp =rotacionxt(90);
        //eliminamos la profundidad
        for(int i=0;i<figtemp.length;i++) {
            figtemp[i][2]=0;
            figtemp[i][0]+=incXSup;
            figtemp[i][1]+=incYSup;
        }
        view(g,figtemp);
    }

    public void VistaLat(Graphics2D g) {
       super.VistaLat(g);
        double figtemp[][]=rotaciony(90);
        //eliminamos la profundidad
        for(int i=0;i<figtemp.length;i++) {
            figtemp[i][2]=0;
            figtemp[i][1]*=-1;
            figtemp[i][0]+=incXLat;
            figtemp[i][1]+=incYLat;

        }
        view(g,figtemp);
    }

    private void view(Graphics2D g, double[][] ft) {
        for (int i = 0; i <= ft.length-1; i+=2) {
            g.drawLine((int)ft[i][0],(int) ft[i][1], (int)ft[i+1][0],(int)ft[i+1][1]);
        }
    }

    private double[][] rotacionxt(int gardos) {
        //[x,y*cos-sen*z,y*sen+z*cos]
        double gradosRad=Math.toRadians(gardos);
        double coseno=Math.cos(gradosRad);
        double seno=Math.sin(gradosRad);
        double vt[][]=new double[originalPoints3D.length][3];
        for (int i = 0; i < originalPoints3D.length; i++) {
            double x= originalPoints3D[i][0];
            double y= originalPoints3D[i][1];
            double z= originalPoints3D[i][2];
            vt[i][0]=x;
            vt[i][1]=(y*coseno)-(seno*z);
            vt[i][2]= (y*seno)+(z*coseno);

        }
        return vt;

    }

    private double[][] rotaciony(int gardos) {
        //x*cos-sen*z,y, x*sen+z*cos
        double gradosRad=Math.toRadians(gardos);
        double coseno=Math.cos(gradosRad);
        double seno=Math.sin(gradosRad);
        double vt[][]=new double [originalPoints3D.length][3];

        for (int i = 0; i < vt.length; i++) {
            double x= originalPoints3D[i][0];
            double y= originalPoints3D[i][1];
            double z= originalPoints3D[i][2];
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
}
