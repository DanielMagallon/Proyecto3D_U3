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

        double matriz[][]   = {
                {10,100,1000},
                {20,200,2000}
        };

        double[][] m2 = matriz.clone();
        m2[0] = new double[]{-11,-111};
        System.out.println(Arrays.toString(matriz[0]));
        System.out.println(Arrays.toString(m2[0]));

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
