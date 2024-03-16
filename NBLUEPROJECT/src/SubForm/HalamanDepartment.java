
package SubForm;
import java.awt.event.KeyEvent;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import static main.Main.GUKM;

public class HalamanDepartment extends javax.swing.JPanel {

    
    public HalamanDepartment() {
        initComponents();
        setOpaque(false);
        txt_id.setVisible(false);
        clear_data();
        tampil_table();
        updateCombo();
        btn_tambah.setEnabled(false);
        btn_edit.setEnabled(false);
        btn_hapus.setEnabled(false);
        btn_cancel.setEnabled(false);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        depart = new javax.swing.JTextField();
        btn_tambah = new javax.swing.JButton();
        btn_edit = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        btn_cancel = new javax.swing.JButton();
        txt_id = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_depart = new javax.swing.JTable();
        cb_ormawa = new javax.swing.JComboBox<>();
        imageAvatar1 = new swing.ImageAvatar();

        jLabel1.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jLabel1.setText("ORMAWA");

        jLabel3.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jLabel3.setText("Departemen");

        depart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                departActionPerformed(evt);
            }
        });
        depart.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                departKeyTyped(evt);
            }
        });

        btn_tambah.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Green"));
        btn_tambah.setFont(new java.awt.Font("Sitka Text", 0, 12)); // NOI18N
        btn_tambah.setText("Tambah");
        btn_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahActionPerformed(evt);
            }
        });

        btn_edit.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Yellow"));
        btn_edit.setFont(new java.awt.Font("Sitka Text", 0, 12)); // NOI18N
        btn_edit.setText("Edit");
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });

        btn_hapus.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Red"));
        btn_hapus.setFont(new java.awt.Font("Sitka Text", 0, 12)); // NOI18N
        btn_hapus.setText("Hapus");
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });

        btn_cancel.setFont(new java.awt.Font("Sitka Text", 0, 12)); // NOI18N
        btn_cancel.setText("Cancel");
        btn_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelActionPerformed(evt);
            }
        });

        txt_id.setEditable(false);
        txt_id.setText("auto_inc");
        txt_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idActionPerformed(evt);
            }
        });

        tb_depart.setFont(new java.awt.Font("Sitka Text", 0, 12)); // NOI18N
        tb_depart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "ORMAWA", "Department"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_depart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_departMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_depart);

        cb_ormawa.setFont(new java.awt.Font("Sitka Text", 0, 12)); // NOI18N
        cb_ormawa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih ORMAWA" }));
        cb_ormawa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_ormawaActionPerformed(evt);
            }
        });

        imageAvatar1.setForeground(new java.awt.Color(255, 255, 255));
        imageAvatar1.setBorderSize(-20);
        imageAvatar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Tema Wayang 2.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3))
                                .addGap(57, 57, 57)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cb_ormawa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(depart, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(74, 74, 74)
                                .addComponent(imageAvatar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(304, 304, 304)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(cb_ormawa, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(depart, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_tambah)
                            .addComponent(btn_edit))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_hapus)
                            .addComponent(btn_cancel))
                        .addGap(27, 27, 27)
                        .addComponent(imageAvatar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    
     private void clear_data(){
         String id = txt_id.getText();
         depart.setText("");
        
    }
     private void updateCombo(){
        
    try {
            String query = "Select * FROM tb_ukm WHERE ukm = '"+GUKM+"'";
            java.sql.Connection vcon = (Connection)Koneksi.koneksi.configDB();
            java.sql.Statement statement = vcon.createStatement();
            java.sql.ResultSet result = statement.executeQuery(query);
            
            while (result.next()){
                cb_ormawa.addItem(result.getString("prodi"));
            
            }
        } catch (Exception e) {
        }
    }
     
    private void tampil_table(){
        btn_edit.setEnabled(false);
        btn_hapus.setEnabled(false);
        
        DefaultTableModel tb = new DefaultTableModel();
        tb.addColumn("ID");
        tb.addColumn("ORMAWA");
        tb.addColumn("Department");
        
        
        try {
            String query = "SELECT * FROM tb_department WHERE ukm = '"+GUKM+"'";
            java.sql.Connection vcon = (Connection)Koneksi.koneksi.configDB();
            java.sql.Statement statement = vcon.createStatement();
            java.sql.ResultSet result = statement.executeQuery(query);
            
            while (result.next()) {                
                tb.addRow(new Object[]{
                    result.getString(1),result.getString(2),result.getString(3)
                });
            }
            tb_depart.setModel(tb);
        } catch (Exception e) {
        }
    }
    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
        
        String ORMAWA = cb_ormawa.getSelectedItem().toString();
        String department = depart.getText();
        
        try {
            String query = "INSERT INTO tb_department (ukm, department) VALUES('"+ORMAWA+"','"+department+"')";
            java.sql.Connection vcon = (Connection)Koneksi.koneksi.configDB();
            java.sql.PreparedStatement preStatement = vcon.prepareStatement(query);
            preStatement.execute();
            JOptionPane.showMessageDialog(null, "Data Department Berhasil Ditambah");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data Department Gagal Ditambahkan");
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

        clear_data();
        tampil_table();
    }//GEN-LAST:event_btn_tambahActionPerformed

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed

        try {
            String query = "DELETE FROM tb_department WHERE department = '"+depart.getText()+"'";
            java.sql.Connection vcon = (Connection)Koneksi.koneksi.configDB();
            java.sql.PreparedStatement preStatement = vcon.prepareStatement(query);
            preStatement.execute();
            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data Gagal Dihapus");
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        clear_data();
        tampil_table();
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed

        clear_data();
    }//GEN-LAST:event_btn_cancelActionPerformed

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        //        // TODO add your handling code here:
        String id = txt_id.getText();
        String ORMAWA = cb_ormawa.getSelectedItem().toString();
        String department = depart.getText();;
        try {
            String query = "UPDATE tb_department SET ukm = '"+ORMAWA+"',department = '"+department+"' WHERE id = '"+id+"'";
            java.sql.Connection vcon = (Connection)Koneksi.koneksi.configDB();
            java.sql.PreparedStatement preStatement = vcon.prepareStatement(query);
            preStatement.execute();
            JOptionPane.showMessageDialog(null, "Data Berhasil Diubah");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data Gagal Diubah");
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        clear_data();
        tampil_table();
    }//GEN-LAST:event_btn_editActionPerformed

    private void tb_departMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_departMouseClicked
        // TODO add your handling code here:
        btn_tambah.setEnabled(false);
        btn_edit.setEnabled(true);
        btn_hapus.setEnabled(true);

        int baris = tb_depart.rowAtPoint(evt.getPoint());
         
        String id_proker = tb_depart.getValueAt(baris, 0).toString();
        txt_id.setText(id_proker);

        String ORMAWA = tb_depart.getValueAt(baris, 1).toString();
        cb_ormawa.setSelectedItem(GUKM);

        String department = tb_depart.getValueAt(baris, 2).toString();
        depart.setText(department);

       
    }//GEN-LAST:event_tb_departMouseClicked

    private void cb_ormawaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_ormawaActionPerformed

    }//GEN-LAST:event_cb_ormawaActionPerformed

    private void txt_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idActionPerformed
        setOpaque(false);
    }//GEN-LAST:event_txt_idActionPerformed

    private void departActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_departActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_departActionPerformed

    private void departKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_departKeyTyped
        btn_tambah.setEnabled(true);
        btn_edit.setEnabled(true);
        btn_hapus.setEnabled(false);
        btn_cancel.setEnabled(true);
        char c = evt.getKeyChar();
        if (!(Character.isAlphabetic(c) || (c == KeyEvent.VK_SPACE) || c == KeyEvent.VK_DELETE )){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_departKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_tambah;
    private javax.swing.JComboBox<String> cb_ormawa;
    private javax.swing.JTextField depart;
    private swing.ImageAvatar imageAvatar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tb_depart;
    private javax.swing.JTextField txt_id;
    // End of variables declaration//GEN-END:variables
}
