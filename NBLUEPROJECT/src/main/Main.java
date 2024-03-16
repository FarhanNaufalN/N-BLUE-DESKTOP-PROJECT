
package main;


import java.awt.Color;
import java.awt.Component;
import scrollbar.ScrollBarCustom;
import event.EventMenu;
import Form.Form1;
import SubForm.HalamanDepartment;
import SubForm.HalamanStaff;
import SubForm.HalamanStaff;
import SubForm.HalamanTambahBarang;



public class Main extends javax.swing.JFrame {

    public static String GUKM;
    public static String nim;
    
    public Main(String UKM,String NIM) {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        GUKM = UKM;
        nim = NIM;
         EventMenu eventMenu = new EventMenu() {
            @Override
            public void selected(int index) {
                if (index == 0){
                    ShowForm(new Form1());
                } else if (index == 1){
                    ShowForm(new HalamanStaff());
                } else if (index == 2){          
                    ShowForm(new HalamanDepartment());
                } else if (index == 3){          
                    ShowForm(new HalamanTambahBarang());
                }
            }
        };
        menu.initWinButton(Main.this, panelBuatBackground1);
        menu.initMenu(eventMenu);
        Scroll.setVerticalScrollBar(new ScrollBarCustom());
        Scroll.getViewport().setOpaque(false);
        Scroll.setViewportBorder(null);
        ShowForm(new Form1());
    }

    private void ShowForm (Component com){
        Body.removeAll();
        Body.add(com);
        Body.revalidate();
        Body.repaint();  
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBuatBackground1 = new swing.PanelBuatBackground();
        Scroll = new javax.swing.JScrollPane();
        Body = new javax.swing.JPanel();
        form11 = new Form.Form1();
        menu = new componen.Menu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        Scroll.setBorder(null);
        Scroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        Body.setOpaque(false);
        Body.setLayout(new java.awt.BorderLayout());
        Body.add(form11, java.awt.BorderLayout.CENTER);

        Scroll.setViewportView(Body);

        javax.swing.GroupLayout panelBuatBackground1Layout = new javax.swing.GroupLayout(panelBuatBackground1);
        panelBuatBackground1.setLayout(panelBuatBackground1Layout);
        panelBuatBackground1Layout.setHorizontalGroup(
            panelBuatBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBuatBackground1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 160, Short.MAX_VALUE)
                .addComponent(Scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 1063, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        panelBuatBackground1Layout.setVerticalGroup(
            panelBuatBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBuatBackground1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelBuatBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 793, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBuatBackground1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelBuatBackground1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

   
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
       /* java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }    
        });*/
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Body;
    private javax.swing.JScrollPane Scroll;
    private Form.Form1 form11;
    private componen.Menu menu;
    private swing.PanelBuatBackground panelBuatBackground1;
    // End of variables declaration//GEN-END:variables
}
