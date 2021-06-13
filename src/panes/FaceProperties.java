package panes;

import bin.shape3d.abstracts.Face3D;
import main.Run;
import static_props.AppProps;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class FaceProperties extends JPanel
{
    private TitledBorder  titleBorder;
    private Face3D face3D;
    public boolean closed=true;
    private JPanel panelCenter;
    private JLabel lblColorDemos;

    public FaceProperties()
    {
        setBackground(AppProps.BG_SELECTED);
        setLayout(new BorderLayout());
        titleBorder = new TitledBorder(BorderFactory.createLineBorder(Color.yellow));
        titleBorder.setTitleJustification(TitledBorder.CENTER);
        titleBorder.setTitleColor(AppProps.FG_NORMAL_TEXT);

        setBorder(titleBorder);
        northPanel();
//        southPanel();
        panelCenter();
    }

    private void panelCenter(){
        panelCenter = new JPanel();
        panelCenter.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        panelCenter.setOpaque(false);
        panelCenter.setPreferredSize(new Dimension(300,1200));
        panelCenter.setLayout(new GridLayout(3,1,0,5));
        add(panelCenter);
        addColorSection();
    }

    private void addColorSection(){
        JPanel panelColorS = new JPanel();
        TitledBorder titleBorder = new TitledBorder(BorderFactory.createLineBorder(Color.yellow));
        titleBorder.setTitleJustification(TitledBorder.CENTER);
        titleBorder.setTitleColor(AppProps.FG_NORMAL_TEXT);
        titleBorder.setTitle("Asignar color");
        panelColorS.setOpaque(false);
        panelColorS.setBorder(titleBorder);

        lblColorDemos = new JLabel();
        lblColorDemos.setPreferredSize(new Dimension(20,20));
        lblColorDemos.setOpaque(true);

        panelColorS.add(lblColorDemos);
        panelColorS.add(getButton("Escoger color",()->{
            Color color = JColorChooser.showDialog(this,"Escoge un nuevo color",defaultFaceColor);
            if(color!=null)
            {
                this.face3D.fillFace=true;
                defaultFaceColor = color;
                this.face3D.bg_color = color;
                Run.canvas3D.repaint();
            }
        }));
        panelColorS.add(getButton("Sin color",()->{
            this.face3D.fillFace = false;
            lblColorDemos.setBackground(null);
            Run.canvas3D.repaint();
        }));

        panelCenter.add(panelColorS);
    }

    private Color defaultFaceColor;

    public void showFaceProps(Face3D face3D){
        closed=false;
        defaultFaceColor = face3D.bg_color;
        lblColorDemos.setBackground(face3D.fillFace ? defaultFaceColor : null);
        face3D.bg_color = Color.green;
        titleBorder.setTitle("Propiedades "+face3D.name);
        this.face3D = face3D;
        Run.canvas3D.repaint();
    }

    private void northPanel(){
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panel.setOpaque(false);
        panel.add(AppProps.createLabelFor("X", this::close));

        add(panel,"North");
    }

    private void southPanel(){
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel.setOpaque(false);

        panel.add(getButton("Aplicar",()->{
            close();
        }));
        panel.add(getButton("Cancelar", this::close));

        add(panel,"South");
    }

    private JButton getButton(String text, Runnable handler){
        JButton btn = new JButton(text);
        btn.setBackground(AppProps.BG_GLOBAL);
        btn.addActionListener(a->handler.run());
        return btn;
    }

    public void updateProps(){
        this.face3D.bg_color = defaultFaceColor;
        Run.canvas3D.repaint();
    }

    public void close(){
        closed=true;
        updateProps();
        Run.frame.getContentPane().remove(this);
        Run.frame.getContentPane().validate();
        Run.frame.getContentPane().repaint();
    }
}
