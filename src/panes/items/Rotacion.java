package panes.items;

import panes.PanelItem;
import static_props.AppProps;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import static main.Run.*;

public class Rotacion extends PanelItem implements ChangeListener
{
    private final JSlider s1,s2,s3;

    public Rotacion()
    {
        super();
        s1=AppProps.addRotationItem("Rotacion en eje X",this,this,
                            0,350,0,10,60);
        s2=AppProps.addRotationItem("Rotacion en eje Y",this,this,
                        0,350,0,10,60);
        s3=AppProps.addRotationItem("Rotacion en eje Z",this,this,
                        0,350,0,10,60);
    }

    @Override
    public void stateChanged(ChangeEvent changeEvent)
    {
        abstractShape3D.rotacionXYZH(s1.getValue(),s2.getValue(),s3.getValue());
        canvas3D.repaint();
    }
}
