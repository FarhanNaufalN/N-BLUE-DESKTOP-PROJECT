
package swing.win_button;

import Koneksi.koneksi;
import swing.PanelBuatBackground;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import Login.Login;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import main.Main;

public class WinButton extends javax.swing.JPanel {

   
    public WinButton() {
        initComponents();
        setOpaque(false);
    }
     public void initEvent(JFrame fram, PanelBuatBackground panel) {
        
        cmdClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
        
        
        cmdMi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                fram.setState(JFrame.ICONIFIED);
            }
        });
       
        cmdLog.addActionListener(new ActionListener() {
            @Override
            
            public void actionPerformed(ActionEvent ae) {
     
                int option = JOptionPane.showConfirmDialog(null, "Anda Yakin Logout?","Perhatian",JOptionPane.YES_NO_OPTION);
                 if (option == 0) {
                 Login a = new Login();  
                 a.setVisible(true);
                 fram.setVisible(false);
            } 
           }
        });
        
       /* cmdRe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (fram.getExtendedState()== JFrame.MAXIMIZED_BOTH){
                    panel.setRound(15);
                    fram.setExtendedState(JFrame.NORMAL);
                }else {
                    panel.setRound(0);
                    fram.setExtendedState(JFrame.MAXIMIZED_BOTH);
                
            }
        });*/    
    }    
        
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        button1 = new swing.win_button.Button();
        button2 = new swing.win_button.Button();
        cmdClose = new swing.win_button.Button();
        cmdMi = new swing.win_button.Button();
        cmdLog = new swing.win_button.Button();

        cmdClose.setBackground(new java.awt.Color(248, 18, 26));
        cmdClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCloseActionPerformed(evt);
            }
        });

        cmdMi.setBackground(new java.awt.Color(243, 243, 87));
        cmdMi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdMiActionPerformed(evt);
            }
        });

        cmdLog.setBackground(new java.awt.Color(51, 255, 51));
        cmdLog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdLogActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(cmdClose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmdMi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmdLog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmdLog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdClose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdMi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmdCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCloseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmdCloseActionPerformed

    private void cmdMiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdMiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmdMiActionPerformed

    private void cmdLogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdLogActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmdLogActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.win_button.Button button1;
    private swing.win_button.Button button2;
    private swing.win_button.Button cmdClose;
    private swing.win_button.Button cmdLog;
    private swing.win_button.Button cmdMi;
    // End of variables declaration//GEN-END:variables
}
