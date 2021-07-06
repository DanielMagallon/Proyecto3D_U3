package panes.items;

import main.Run;
import panes.PanelItem;
import static_props.AppProps;

import javax.swing.*;
import java.awt.*;

public class Caras extends PanelItem
{
    public Caras()
    {
        super(1,1);
    }

    public void updateFaces(){
        this.removeAll();
        this.add(Run.abstractShape3D.getPanelFaces());
        this.validate();
        this.repaint();
    }
}
