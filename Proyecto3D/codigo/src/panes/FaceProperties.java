package panes;

import bin.shape3d.FaceFill;
import bin.shape3d.abstracts.Face3D;
import main.Run;
import static_props.AppProps;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class FaceProperties extends JPanel
{
    private TitledBorder  titleBorder;
    private Face3D face3D;
    public boolean closed=true;
    private JPanel panelCenter;
    private JLabel lblColorDemos,lblGradDe1,lblGradDe2,lblImagen;
    private String validExt[] = {"png", "jpg","jpeg","PNG","JPG","JPEG"};
    private FileNameExtensionFilter filter = new FileNameExtensionFilter("IMG FILES", validExt);
    private JFileChooser fileChooser = new JFileChooser();

    public FaceProperties()
    {
        setBackground(AppProps.BG_SELECTED);
        setLayout(new BorderLayout());
        titleBorder = new TitledBorder(BorderFactory.createLineBorder(Color.yellow));
        titleBorder.setTitleJustification(TitledBorder.CENTER);
        titleBorder.setTitleColor(AppProps.FG_NORMAL_TEXT);

        fileChooser.setFileFilter(filter);
        setBorder(titleBorder);
        northPanel();
        panelCenter();
    }

    private void panelCenter(){
        panelCenter = new JPanel();
        panelCenter.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        panelCenter.setOpaque(false);
        panelCenter.setPreferredSize(new Dimension(300,1200));
        panelCenter.setLayout(new GridLayout(3,1,0,10));
        add(panelCenter);
        addImageSelection();
        addColorSection();
        addGradientSelection();
    }


    private void addImageSelection(){
        JPanel panel = new JPanel();
        TitledBorder titleBorder = new TitledBorder(BorderFactory.createLineBorder(Color.yellow));
        titleBorder.setTitleJustification(TitledBorder.CENTER);
        titleBorder.setTitleColor(AppProps.FG_NORMAL_TEXT);
        titleBorder.setTitle("Asignar textura imagen");
        panel.setOpaque(false);
        panel.setBorder(titleBorder);

        lblImagen = getLabelDemos(100,100,()->{

            if(fileChooser.showDialog(Run.frame,"Imagen de textura")==JFileChooser.APPROVE_OPTION){
                try {
                    BufferedImage bf = ImageIO.read(fileChooser.getSelectedFile());
                    face3D.setTexturePaint(0,0,Run.canvas3D.getWidth(),Run.canvas3D.getHeight(),bf);
                    lblImagen.setIcon(face3D.image);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        });

        panel.add(lblImagen);
        panel.add(getButton("Aplicar",()->{

            if(face3D.image!=null) {
                this.face3D.fillFace = FaceFill.IMAGE;
                Run.canvas3D.repaint();
            }else JOptionPane.showMessageDialog(this,"No se ha seleccionado alguna imagen",
                    "Error 404",JOptionPane.ERROR_MESSAGE);
        }));

        JPanel center = new JPanel(new BorderLayout(1,1));
        center.add(panel);
        center.setBorder(BorderFactory.createEmptyBorder(25,0,0,0));
        center.setOpaque(false);
        panelCenter.add(center);
    }

    private void addGradientSelection(){
        JPanel panel = new JPanel();
        TitledBorder titleBorder = new TitledBorder(BorderFactory.createLineBorder(Color.yellow));
        titleBorder.setTitleJustification(TitledBorder.CENTER);
        titleBorder.setTitleColor(AppProps.FG_NORMAL_TEXT);
        titleBorder.setTitle("Asignar gradiente");
        panel.setOpaque(false);
        panel.setBorder(titleBorder);

        lblGradDe1 = getLabelDemos(50,100,()->{
            Color color = JColorChooser.showDialog(this,"Escoge el primer color",defaultFaceColor);
            if(color!=null)
            {
                this.face3D.updateColorsGradient(true,color);
                lblGradDe1.setBackground(color);
            }
        });
        lblGradDe2 = getLabelDemos(50,100,()->{
            Color color = JColorChooser.showDialog(this,"Escoge el segundo color",defaultFaceColor);
            if(color!=null)
            {
                this.face3D.updateColorsGradient(false,color);
                lblGradDe2.setBackground(color);
            }
        });

        panel.add(lblGradDe1);
        panel.add(lblGradDe2);
        panel.add(getButton("Aplicar",()->{
            this.face3D.fillFace = FaceFill.GRADIENT;
            this.face3D.updateGradient(10,10, Run.canvas3D.getWidth(),Run.canvas3D.getHeight());
            Run.canvas3D.repaint();
        }));

        JPanel center = new JPanel(new BorderLayout(1,1));
        center.add(panel);
        center.setBorder(BorderFactory.createEmptyBorder(25,0,0,0));
        center.setOpaque(false);
        panelCenter.add(center);
    }

    private JLabel getLabelDemos(int w, int h,Runnable handler){
        JLabel lbl = new JLabel();

        lbl.setPreferredSize(new Dimension(w,h));
        lbl.setOpaque(true);
        lbl.setCursor(AppProps.handCursor);
        lbl.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                handler.run();
            }
        });

        return lbl;
    }

    private void addColorSection(){
        JPanel panelColorS = new JPanel();
        TitledBorder titleBorder = new TitledBorder(BorderFactory.createLineBorder(Color.yellow));
        titleBorder.setTitleJustification(TitledBorder.CENTER);
        titleBorder.setTitleColor(AppProps.FG_NORMAL_TEXT);
        titleBorder.setTitle("Asignar color");
        panelColorS.setOpaque(false);
        panelColorS.setBorder(titleBorder);

        lblColorDemos = getLabelDemos(100,100,()-> {
            Color color = JColorChooser.showDialog(this, "Escoge un nuevo color", defaultFaceColor);
            if (color != null) {
                this.face3D.fillFace = FaceFill.NORMAL;
                defaultFaceColor = color;
                this.face3D.bg_color = color;
                Run.canvas3D.repaint();
            }
        });
        panelColorS.add(lblColorDemos);
        panelColorS.add(getButton("Sin color",()->{
            this.face3D.fillFace = FaceFill.NONE;
            lblColorDemos.setBackground(null);
            Run.canvas3D.repaint();
        }));

        JPanel center = new JPanel(new BorderLayout(1,1));
        center.add(panelColorS);
        center.setBorder(BorderFactory.createEmptyBorder(25,0,0,0));
        center.setOpaque(false);
        panelCenter.add(center);
    }

    private Color defaultFaceColor;

    public void showFaceProps(Face3D face3D){
        closed=false;
        defaultFaceColor = face3D.bg_color;
        lblColorDemos.setBackground(face3D.fillFace == FaceFill.NORMAL ? defaultFaceColor : null);
        lblGradDe1.setBackground(face3D.gradient1);
        lblGradDe2.setBackground(face3D.gradient2);

        lblImagen.setIcon(face3D.image);

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
