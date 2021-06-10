package panes;

import static_props.AppProps;

import javax.swing.*;
import java.awt.*;

public abstract class PanelItem extends JPanel
{
    public PanelItem()
    {
        setBackground(AppProps.BG_SELECTED);
        setLayout(new FlowLayout(FlowLayout.CENTER));
//        add(new JLabel(title));
    }

    public PanelItem(int r, int c)
    {
        setBackground(AppProps.BG_SELECTED);
        setLayout(new GridLayout(r,c));
//        add(new JLabel(title));
    }
}
