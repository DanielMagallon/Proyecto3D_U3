package panes.items;

import panes.PanelItem;
import static_props.AppProps;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static main.Run.canvas3D;
import static main.Run.figura3D;

public class Reflexion extends PanelItem
{
    private JLabel lblTX,lblTY,lblTZ;

    public Reflexion()
    {
        super();

        add(lblTX = AppProps.createLabelFor("Reflexion X",()->{
                figura3D.reflejarX();
                canvas3D.repaint();
        }));
        add(lblTY = AppProps.createLabelFor("Reflexion Y",()->{
                figura3D.reflejarY();
                canvas3D.repaint();
        }));
        add(lblTZ = AppProps.createLabelFor("Reflexion Z",()->{
            figura3D.reflejarZ();
            canvas3D.repaint();
        }));
    }

}
