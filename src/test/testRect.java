package test;

import frame.DefaultFrame;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.HashMap;

public class testRect
{


    static int x=30,y=30,w=400,h=100;

    static int getNumber(JTextField txt){
        return Integer.parseInt(txt.getText());
    }

    public static void main(String[] args) {

        HashMap<String,double[]> d = new HashMap<String,double[]>(){{
            put("A",new double[]{10,20,30});
        }};

        double [][]  de = new double[1][3];
        de[0] = d.get("A").clone();

        System.out.println(Arrays.toString(d.get("A")));
        System.out.println(Arrays.toString(de[0]));

        de[0][1] = 450;

        System.out.println(Arrays.toString(d.get("A")));
        System.out.println(Arrays.toString(de[0]));

//        SwingUtilities.invokeLater(()->{
//            JPanel panel = new JPanel();
//            JPanel canvas = new JPanel(){
//                @Override
//                protected void paintComponent(Graphics graphics) {
//                    super.paintComponent(graphics);
//                    graphics.drawRect(x,y,w,h);
//                }
//            };
//            JTextField[] txts = new JTextField[4];
//            JButton btn = new JButton("Aplicar");
//            btn.addActionListener(a->{
//                x = getNumber(txts[0]);
//                y = getNumber(txts[1]);
//                w = getNumber(txts[2]);
//                h = getNumber(txts[3]);
//                canvas.repaint();
//            });
//            for (int i = 0; i < txts.length; i++) {
//                txts[i] = new JTextField(10);
//                panel.add(txts[i]);
//            }
//            panel.add(btn);
//
//            DefaultFrame frame = new DefaultFrame();
//            frame.getContentPane().add(canvas);
//            frame.getContentPane().add(panel,"North");
//        });
    }

}
