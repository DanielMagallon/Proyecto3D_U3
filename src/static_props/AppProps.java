package static_props;

import panes.PanelItem;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class AppProps
{
    public static Cursor handCursor = new Cursor(Cursor.HAND_CURSOR);
    public static Color BG_GLOBAL = new Color(0x383838);
    public static Color BG_SELECTED = new Color(0x555454);
    public static Color FG_SELECTED = new Color(0xFFFFFF);
    public static Color BG_CONTORNO = new Color(0xF8D500);
    public static Color BG_NOT_SELECTED = null;

    public static Color CANVAS_BG = new Color(0x555454);
    public static Color CANVAS_STROKE = new Color(0xFFFFFF);


    public static Color FG_NORMAL_TEXT = new Color(0xFFFFFF);

    public static double figuraOriginal[][]=
            {{0,35,0},
            {30,-35,20},
            {-30,-35,20},
            {-30,-35,-20},
            {30,-35,-20}};


    public static int secf[]= {2,1,2,3,3,4,4,1,1,0,2,0,3,0,4,0};
//public static int secf[]= {2,1,2,3,3,4,4,1};//,1,1,0,2,0,3,0,4,0};
//    public static int secf[]= {1,0,2,0};


    public static JLabel createLabelFor(String text, Runnable handler)
    {
        JLabel lbl = new JLabel(text);
        lbl.setCursor(handCursor);
        lbl.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                handler.run();
                System.out.println(text);
            }
        });
        lbl.setForeground(FG_NORMAL_TEXT);
        return lbl;
    }

    public static JSlider addRotationItem(String title, ChangeListener handler, PanelItem p,int min, int max, int val,
                                          int minorTickS,int majorTickS)
    {
        JPanel ps1=new JPanel(new GridLayout(1,1));
        ps1.setOpaque(false);
//        ps1.setBackground(new Color(0xF3F3F3));
        TitledBorder tb1=new TitledBorder(title);
        tb1.setBorder(BorderFactory.createLineBorder(AppProps.BG_CONTORNO));
        tb1.setTitleColor(AppProps.FG_SELECTED);
        tb1.setTitleJustification(TitledBorder.CENTER);
        ps1.setBorder(tb1);
        JSlider S1=new JSlider(JSlider.HORIZONTAL,min,max,val);
        S1.setForeground(AppProps.FG_SELECTED);
        S1.setOpaque(false);
        S1.setMinorTickSpacing(minorTickS);
        S1.setMajorTickSpacing(majorTickS);
        S1.setPaintLabels(true);
        S1.setPaintTicks(true);
        S1.addChangeListener(handler);
        ps1.add(S1);

        p.add(ps1);

        return S1;
    }
}
