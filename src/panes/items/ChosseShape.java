package panes.items;

import main.Run;
import panes.PanelItem;
import static_props.AppProps;

import javax.swing.*;

public class ChosseShape extends PanelItem
{
    private JLabel lblCubo,lblCorazon,lblStruct;

    public ChosseShape()
    {
        lblCubo = AppProps.createLabelFor("Cubo",()->{
            Run.abstractShape3D = Run.cube3D;
            if(!Run.showViews)
            Run.canvas3D.repaint();
            else Run.Canvasvistas.repaint();
        });

        lblCorazon = AppProps.createLabelFor("Corazon",()->{
            Run.abstractShape3D = Run.heart3D;
            if(!Run.showViews)
                Run.canvas3D.repaint();
            else Run.Canvasvistas.repaint();
        });

        lblStruct = AppProps.createLabelFor("Estructura",()->{
            Run.abstractShape3D = Run.structure3D;
            if(!Run.showViews)
                Run.canvas3D.repaint();
            else Run.Canvasvistas.repaint();
        });

        add(lblCubo);
        add(lblCorazon);
        add(lblStruct);
    }
}
