
package Form;


import Koneksi.koneksi;
import SubForm.HalamanDashboard;
import java.awt.Component;
import customdb.MenuEvent;
import SubForm.HalamanDashboard;
import SubForm.HalamanAccPinjamBarang;
import SubForm.HalamanKalender;
import SubForm.HalamanLaporan;
import SubForm.HalamanListProker;
import SubForm.HalamanPemasukan;
import SubForm.HalamanPeminjaman;
import SubForm.HalamanTambahBarang;
import SubForm.HalamanTambahProker;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;



public class Form1 extends javax.swing.JPanel {
public static String GUKM;
public static String nim;
public static int id;   
  
    public Form1() {
        initComponents();
        setOpaque(false);
        
        menu1.setEvent(new MenuEvent() {
            @Override
            public void selected(int index, int subIndex) {
                if (index == 0){
                    showForm(new HalamanDashboard());
                } else if (index == 1 && subIndex == 1) {
                    showForm(new HalamanTambahProker());
                }else if (index == 1 && subIndex == 2) {
                    showForm(new HalamanListProker());
                }else if (index == 2) {
                    showForm(new HalamanKalender());
                }else if (index == 3 && subIndex == 1) {
                    showForm(new HalamanPeminjaman(nim));
                }else if (index == 3 && subIndex == 2) {
                    showForm(new HalamanAccPinjamBarang());
                }else if (index == 3 && subIndex == 3) {
                    showForm(new HalamanLaporan());
                } else if (index == 4 && subIndex == 1) {
                    showForm(new HalamanPemasukan());
                }
 
            }  
        });
    }
  
    private void showForm(Component com) {
        Body.removeAll();
        Body.add(com);
        Body.repaint();
        Body.revalidate();
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelShadow1 = new swing.PanelShadow();
        scrollPaneWin111 = new Scrollmenu.ScrollPaneWin11();
        menu1 = new customdb.MenuPilihan();
        Body = new javax.swing.JPanel();
        imageAvatar1 = new swing.ImageAvatar();

        panelShadow1.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelShadow1Layout = new javax.swing.GroupLayout(panelShadow1);
        panelShadow1.setLayout(panelShadow1Layout);
        panelShadow1Layout.setHorizontalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 516, Short.MAX_VALUE)
        );
        panelShadow1Layout.setVerticalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 183, Short.MAX_VALUE)
        );

        scrollPaneWin111.setViewportView(menu1);

        Body.setLayout(new java.awt.BorderLayout());

        imageAvatar1.setForeground(new java.awt.Color(255, 255, 255));
        imageAvatar1.setBorderSize(-20);
        imageAvatar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Tema Wayang 2.png"))); // NOI18N
        Body.add(imageAvatar1, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(scrollPaneWin111, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Body, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(12, 12, 12))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(panelShadow1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(112, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelShadow1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(scrollPaneWin111, javax.swing.GroupLayout.DEFAULT_SIZE, 603, Short.MAX_VALUE)
                    .addComponent(Body, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Body;
    private swing.ImageAvatar imageAvatar1;
    private customdb.MenuPilihan menu1;
    private swing.PanelShadow panelShadow1;
    private Scrollmenu.ScrollPaneWin11 scrollPaneWin111;
    // End of variables declaration//GEN-END:variables
}
