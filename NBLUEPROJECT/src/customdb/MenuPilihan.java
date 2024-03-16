package customdb;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import customdb.Item;
        
        
public class MenuPilihan extends JComponent {

  
    public MenuEvent getEvent() {
        return event;
    
    }
  
    public void setEvent(MenuEvent event) {
        this.event = event;
    }

    private MenuEvent event;
    private MigLayout layout;
    private String[][] menuItems = new String[][]{
        {"Daftar Pengurus"},
        {"Proker", "Tambah Proker", "List Proker"},
        {"Kalender"},
        {"Peminjaman", "Barang", "Acc Peminjaman Barang", "Status Peminjaman"},
        {"Keuangan", "Pemasukan",}
       
        
        
    };

    public MenuPilihan() {
        init();
    }

    private void init() {
        layout = new MigLayout("wrap 1, fillx, gapy 0, inset 2", "fill");
        setLayout(layout);
        setOpaque(true);
        
        //  Init MenuItem
        for (int i = 0; i < menuItems.length; i++) {
            addMenu(menuItems[i][0], i);
        }
        
    }
    
    private Icon getIcon(int index){
      URL url = getClass().getResource("/iconbuatdb/" + index + ".png");
      if (url != null) {
            return new ImageIcon(url);
        } else {
            return null;
        }
    }
    
    private void addMenu(String menuName, int index) {
        int length = menuItems[index].length;
        Item item = new Item(menuName, index, length > 1);
        Icon icon = getIcon(index);
        if(icon!=null){
            item.setIcon(icon);
        }
         item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (length > 1) {
                    if(!item.isSelected()){
                        item.setSelected(true);
                        addSubMenu(item, index, length, getComponentZOrder(item));
                    }else{
                        //Hide Menu
                        hideMenu(item, index);
                        item.setSelected(false);
                    }
                }else {
                    if (event != null) {
                        event.selected(index, 0);
                    }
                }
            }
                
                
        });
        add(item);
        revalidate();
        repaint();
    } 
    private void addSubMenu(Item item, int index, int length, int indexZorder) {
        JPanel panel = new JPanel(new MigLayout("wrap 1, fillx, inset 0, gapy 0", "fill"));
        panel.setName(index + "");
        panel.setOpaque(false);
        for (int i = 1; i < length; i++) {
            Item subItem = new Item(menuItems[index][i], i, false);
            subItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    if (event != null) {
                        event.selected(index, subItem.getIndex());
                    }
                }
            });
            subItem.initSubMenu(i, length);
            panel.add(subItem);
        }    
        add(panel,"h 0!",indexZorder+1);
        revalidate();
        repaint();
        MenuAnimation.showMenu(panel, item, layout, true);
    }
   
    private void hideMenu(Item item, int index) {
        for (Component com : getComponents()) {
            if (com instanceof JPanel && com.getName() != null && com.getName().equals(index + "")) {
                com.setName(null);
                MenuAnimation.showMenu(com, item, layout, false);
                break;
            }
        }
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setColor(new Color(53, 3, 152));
        g2.fill(new Rectangle2D.Double(0, 0, getWidth(), getHeight()));
        super.paintComponent(grphcs);
    }   
}
