package panes.items;

import panes.PanelItem;
import static_props.AppProps;

import javax.swing.*;
import java.awt.*;

public class Caras extends PanelItem
{
    private JPanel contentScroll;

    public Caras(int w, int h)
    {
        super(1,1);
        contentScroll = new JPanel();
        contentScroll.setBackground(AppProps.BG_SELECTED);
        contentScroll.setPreferredSize(new Dimension(w,h));
        JScrollPane sc = new JScrollPane(contentScroll);
        sc.setBorder(BorderFactory.createEmptyBorder());
        sc.setOpaque(false);
        this.add(sc);
    }

}
