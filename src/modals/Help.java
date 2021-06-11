package modals;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class Help extends JDialog
{
	Image img;
	Font Fuente;
	JScrollPane scrollPane = new JScrollPane();
	JLabel lblContent;
    public Help(Frame frame, boolean b) {
        super(frame, b);
        setTitle("......:::::::AYUDA::::::......");
        setSize(900,636);
       add(new JLabel("Hello"));
       this.setLocationRelativeTo(null);
        setResizable(false);
       
    }

}
