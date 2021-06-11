package modals;

import bin.SaveImage;
import bin.handlers.IName;
import frame.DefaultFrame;
import static_props.AppProps;

import javax.swing.*;
import java.awt.*;

import static main.Run.bufferedImage;

public class NotifyImage extends JDialog
{

    public NotifyImage(JFrame frame)
    {
        super(frame,"Guardando imagen",true);
        getContentPane().setLayout(new BorderLayout());
        getContentPane().setBackground(AppProps.BG_GLOBAL);

        JLabel lbl = new JLabel("Nombre de la imagen:");
        lbl.setForeground(AppProps.FG_NORMAL_TEXT);
        JTextField txtName = new JTextField(15);

        JPanel panelData = new JPanel(new FlowLayout(FlowLayout.CENTER)){{
            setOpaque(false);
            add(lbl);
            add(txtName);
        }};
        getContentPane().add(panelData,"Center");
        JButton btnAcep = new JButton("Aceptar"){{
            setBackground(AppProps.BG_BTN_NOTIFY);
            setForeground(AppProps.FG_NORMAL_TEXT);
            addActionListener(a->{
                if(SaveImage.existImage(txtName.getText())){
                    JOptionPane.showMessageDialog(null,
                            "Ingrese otro nombre","La imagen ya existe",
                            JOptionPane.ERROR_MESSAGE);
                }
                else {
                    SaveImage.saveImage(bufferedImage, txtName.getText());
                    NotifyImage.this.dispose();
                }
            });
        }};
        JButton btnCancel = new JButton("Cancelar"){{
            setBackground(AppProps.BG_BTN_NOTIFY);
            setForeground(AppProps.FG_NORMAL_TEXT);
            addActionListener(a->{
                NotifyImage.this.dispose();
            });
        }};

        JPanel btns = new JPanel(new FlowLayout(FlowLayout.CENTER)){{
            setOpaque(false);
            add(btnAcep);
            add(btnCancel);
        }};


        getContentPane().add(btns,"South");
        pack();

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width-this.getWidth()-10,dim.height-this.getHeight()-50);
    }
    //    public static void main(String[] args) {
//        new NotifyImage(new JFrame()).setVisible(true);
//    }
}