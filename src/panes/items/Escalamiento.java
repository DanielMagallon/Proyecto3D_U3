package panes.items;

import panes.PanelItem;
import static_props.AppProps;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import static main.Run.abstractShape3D;
import static main.Run.canvas3D;

public class Escalamiento extends  PanelItem implements ChangeListener
{
    private JSlider jScale;

    public Escalamiento()
    {
        super(1,1);
        jScale = AppProps.addRotationItem("Escalar figura",this,this,
                        100,2300,1000,50,100 );
    }

    @Override
    public void stateChanged(ChangeEvent changeEvent) {
        if(update) {
            abstractShape3D.setDistance(jScale.getValue());
            canvas3D.repaint();
        }
    }

    private boolean update=true;
    public void updateScaleValue(){
        update=false;
        jScale.setValue(abstractShape3D.getDistance());
        update=true;
    }
}
