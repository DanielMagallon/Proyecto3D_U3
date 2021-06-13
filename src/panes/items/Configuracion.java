package panes.items;

import bin.shape3d.abstracts.Face3D;
import panes.PanelItem;
import static_props.AppProps;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static main.Run.*;

public class Configuracion extends PanelItem
{
    private JLabel lblExportAll,lblExportSelect,lblFill;

    public Configuracion()
    {
        super();
        lblExportAll = AppProps.createLabelFor("Exportar a imagen",()->{
            try {
                exportImage=true;
                canvas3D.selecctionListener.exporSelection=false;
                bufferedImage = new BufferedImage(canvas3D.getWidth(),
                        canvas3D.getHeight(), BufferedImage.TYPE_INT_RGB);
                canvas3D.repaint();

            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        lblExportSelect = AppProps.createLabelFor("Exportar seleccion",()->canvas3D.selecctionListener.prepare());

        lblFill = AppProps.createLabelFor("Relleno",()->{
            Face3D.filled=!Face3D.filled;
            canvas3D.repaint();
        });

        add(lblExportAll);
        add(lblExportSelect);
        add(lblFill);
    }
}
