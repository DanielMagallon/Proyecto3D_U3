package panes.items;

import panes.PanelItem;
import static_props.AppProps;

import javax.swing.*;

import static main.Run.canvas3D;

public class Reflexion extends PanelItem
{
    private JLabel lblTX,lblTY,lblTZ;

    public Reflexion()
    {
        super();

        add(lblTX = AppProps.createLabelFor("Reflexion X",()->{
                canvas3D.repaint();
        }));
        add(lblTY = AppProps.createLabelFor("Reflexion Y",()->{
                canvas3D.repaint();
        }));
        add(lblTZ = AppProps.createLabelFor("Reflexion Z",()->{
            canvas3D.repaint();
        }));
    }

}
