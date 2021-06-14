package panes.items;

import main.Run;
import panes.PanelItem;
import static_props.AppProps;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import static main.Run.*;

public class Rotacion extends PanelItem implements ChangeListener
{
    public final JSlider s1,s2,s3;

    public Rotacion()
    {
        super();
        s1=AppProps.addSlider("Rotacion en eje X",this,this,
                            0,350,0,10,60);
        s2=AppProps.addSlider("Rotacion en eje Y",this,this,
                        0,350,0,10,60);
        s3=AppProps.addSlider("Rotacion en eje Z",this,this,
                        0,350,0,10,60);
    }

    public void action(String coord, boolean positive){
        
        if(coord.equalsIgnoreCase("X")){
            updateData(s1,positive);

        }else if(coord.equalsIgnoreCase("Y")){
            updateData(s2,positive);
        }
        else{
            updateData(s3,positive);
        }
    }

    private void updateData(JSlider master,boolean positive)
    {
        int val = master.getValue();
        if(positive){
            if(val==master.getMaximum())
                return;
        }else{
            if(val==0)
                return;
        }
        val += (positive ? 10 : -10);
        master.setValue(val);
    }

    public boolean updateItems=true;

    @Override
    public void stateChanged(ChangeEvent changeEvent)
    {
        if(updateItems) {
            abstractShape3D.setXAngulo(s1.getValue());
            abstractShape3D.setYAngulo(s2.getValue());
            abstractShape3D.setZAngulo(s3.getValue());
            abstractShape3D.rotacionXYZH(s1.getValue(), s2.getValue(), s3.getValue());
            canvas3D.repaint();
        }
    }

    public void updateShapeValues(){

        updateItems=false;
        s1.setValue(abstractShape3D.getXAngulo());
        s2.setValue(abstractShape3D.getYAngulo());
        s3.setValue(abstractShape3D.getZAngulo());
        updateItems=true;
    }
}
