
package SubForm;

import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;
import static main.Main.GUKM;
import javax.swing.JOptionPane;
import java.text.NumberFormat;
import java.util.Locale;


public class HalamanPemasukan extends javax.swing.JPanel {
    

    public HalamanPemasukan() {
        initComponents();
        clear_data();
        updateCombo();
        txt_id.setVisible(false);
        tampil_table();
        btn_tambah.setEnabled(false);
        btn_edit.setEnabled(false);
        btn_hapus.setEnabled(false);
        btn_cancel.setEnabled(false);
        
    }
    
      private void clear_data(){
        txt_id.setText("");
        txt_proker.setText("");
        tgl_pelaksanaan.setDate(null);
        cb_department.setSelectedItem("Pilih Depeartment");
        txt_jpemasukan.setText("");
        txt_nominal.setText("");
    }
    
    private void updateCombo(){
        
    try {
            String query = "Select * FROM tb_department WHERE ukm = '"+GUKM+"'";
            java.sql.Connection vcon = (Connection)Koneksi.koneksi.configDB();
            java.sql.Statement statement = vcon.createStatement();
            java.sql.ResultSet result = statement.executeQuery(query);
            
            while (result.next()){
                cb_department.addItem(result.getString("department"));
            
            }
        } catch (Exception e) {
        }
    }
    
   private void tampil_table(){
     DefaultTableModel tb = new DefaultTableModel();
        tb.addColumn("ID");
        tb.addColumn("Nama Pemasukan");
        tb.addColumn("Tanggal Pemasukan");
        tb.addColumn("Departmen");
        tb.addColumn("Jenis Pemasukan");
        tb.addColumn("Nominal");

        try {
            String query = "SELECT * FROM tb_keuangan WHERE ukm = '"+GUKM+"'";
            java.sql.Connection vcon = (Connection)Koneksi.koneksi.configDB();
            java.sql.Statement statement = vcon.createStatement();
            java.sql.ResultSet result = statement.executeQuery(query);

            while (result.next()) {
                tb.addRow(new Object[]{
                    result.getString(1),result.getString(2),result.getString(5),result.getString(3),result.getString(6),result.getString(7)
                });
            }
            tb_proker.setModel(tb);
        } catch (Exception e) {
        }
        clear_data();
   }
   
   private void autosum(){
       int total = 0;
       for (int i = 0; i < tb_proker.getRowCount(); i++){
           int amount = Integer.parseInt((String) tb_proker.getValueAt(i, 6));
           total += amount;
       }
       labelsaldo.setText(""+total);
   }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_proker = new javax.swing.JTextField();
        cb_department = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        txt_nominal = new javax.swing.JTextField();
        txt_jpemasukan = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btn_edit = new javax.swing.JButton();
        btn_tambah = new javax.swing.JButton();
        txt_id = new javax.swing.JTextField();
        btn_hapus = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_proker = new javax.swing.JTable();
        btn_cancel = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        labelsaldo = new javax.swing.JLabel();
        tgl_pelaksanaan = new com.toedter.calendar.JDateChooser();

        txt_proker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_prokerActionPerformed(evt);
            }
        });
        txt_proker.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_prokerKeyTyped(evt);
            }
        });

        cb_department.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Department" }));
        cb_department.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_departmentActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Sitka Text", 0, 12)); // NOI18N
        jLabel1.setText("Nama Pemasukan");

        txt_nominal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_nominalKeyTyped(evt);
            }
        });

        txt_jpemasukan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_jpemasukanKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Sitka Text", 0, 12)); // NOI18N
        jLabel2.setText("Tanggal Pemasukan");

        btn_edit.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Yellow"));
        btn_edit.setText("Edit");
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });

        btn_tambah.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Green"));
        btn_tambah.setText("Tambah");
        btn_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahActionPerformed(evt);
            }
        });

        txt_id.setEditable(false);
        txt_id.setText("auto_inc");
        txt_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idActionPerformed(evt);
            }
        });

        btn_hapus.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Red"));
        btn_hapus.setText("Hapus");
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Sitka Text", 0, 12)); // NOI18N
        jLabel3.setText("Department");

        tb_proker.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nama Pemasukan", " Tanggal Pemasukan", "Department", "Jenis Pemasukan", "Nominal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_proker.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_prokerMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_proker);

        btn_cancel.setText("Cancel");
        btn_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Sitka Text", 0, 12)); // NOI18N
        jLabel4.setText("Jenis Pemasukan");

        jLabel5.setFont(new java.awt.Font("Sitka Text", 0, 12)); // NOI18N
        jLabel5.setText("Nominal");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(71, 71, 71)
                                        .addComponent(labelsaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(btn_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel1))
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_proker, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                                    .addComponent(cb_department, 0, 174, Short.MAX_VALUE)
                                    .addComponent(txt_jpemasukan, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                                    .addComponent(txt_nominal, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                                    .addComponent(tgl_pelaksanaan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(txt_proker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2))
                            .addComponent(tgl_pelaksanaan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cb_department, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txt_jpemasukan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txt_nominal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_tambah)
                            .addComponent(btn_edit))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_cancel)
                            .addComponent(btn_hapus))))
                .addGap(42, 42, 42)
                .addComponent(labelsaldo)
                .addContainerGap(236, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txt_prokerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_prokerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_prokerActionPerformed

    private void cb_departmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_departmentActionPerformed

    }//GEN-LAST:event_cb_departmentActionPerformed

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
       
        String tampilan = "yyyy-MM-dd";
        SimpleDateFormat fm  = new SimpleDateFormat(tampilan);
        String Pelaksanaan = String.valueOf(fm.format(tgl_pelaksanaan.getDate()));
        String id = txt_id.getText();
        String nama_proker = txt_proker.getText();
        //String pelaksanaan = tgl_pelaksanaan.getDateFormatString();
        String department = cb_department.getSelectedItem().toString();
        String jenis_pemasukan = txt_jpemasukan.getText();
        String nominal = txt_nominal.getText();
        try {
            String query = "UPDATE tb_keuangan SET Pemasukan = '"+nama_proker+"',TanggalPemasukan = '"+Pelaksanaan+"',Departement = '"+department+"',Jenis_Pemasukan = '"+jenis_pemasukan+"',nominal = '"+nominal+"' WHERE id = '"+id+"'";
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

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed

        String tampilan = "yyyy-MM-dd";
        SimpleDateFormat fm  = new SimpleDateFormat(tampilan);
        String Pelaksanaan = String.valueOf(fm.format(tgl_pelaksanaan.getDate()));
        String Proker = txt_proker.getText();
        //java.util.Date Pelaksanaan = tgl_pelaksanaan.getDate();
        String Department = cb_department.getSelectedItem().toString();
        String Pemasukan = txt_jpemasukan.getText();
        String Nominal = txt_nominal.getText();

        try {
            String query = "INSERT INTO tb_keuangan(Pemasukan,TanggalPemasukan,Departement,Jenis_Pemasukan,nominal, ukm) VALUES('"+Proker+"','"+Pelaksanaan+"','"+Department+"','"+Pemasukan+"','"+Nominal+"', '"+GUKM+"')";
            java.sql.Connection vcon = (Connection)Koneksi.koneksi.configDB();
            java.sql.PreparedStatement preStatement = vcon.prepareStatement(query);
            preStatement.execute();
            JOptionPane.showMessageDialog(null, "Data Program Kerja Berhasil Ditambah");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data Program Kerja Gagal Ditambahkan");
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

        clear_data();
        tampil_table();
        
    }//GEN-LAST:event_btn_tambahActionPerformed

    private void txt_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idActionPerformed

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed

        try {
            String query = "DELETE FROM tb_keuangan WHERE id = '"+txt_id.getText()+"'";
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

    private void tb_prokerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_prokerMouseClicked
        // TODO add your handling code here:
        btn_tambah.setEnabled(false);
        btn_edit.setEnabled(true);
        btn_hapus.setEnabled(true);

        int baris = tb_proker.rowAtPoint(evt.getPoint());

        String id_proker = tb_proker.getValueAt(baris, 0).toString();
        txt_id.setText(id_proker);

        String Proker = tb_proker.getValueAt(baris, 1).toString();
        txt_proker.setText(Proker);

        String Pelaksanaan = tb_proker.getValueAt(baris, 2).toString();
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date tanggalPelaksanaan = dateFormat.parse(Pelaksanaan);
            tgl_pelaksanaan.setDate(tanggalPelaksanaan);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String Department = tb_proker.getValueAt(baris, 3).toString();
        cb_department.setSelectedItem(Department);

        String Pemasukan = tb_proker.getValueAt(baris, 4).toString();
        txt_jpemasukan.setText(Pemasukan);

        String Nominal = tb_proker.getValueAt(baris, 5).toString();
        txt_nominal.setText(Nominal);

    }//GEN-LAST:event_tb_prokerMouseClicked

    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed

        clear_data();
    }//GEN-LAST:event_btn_cancelActionPerformed

    private void txt_prokerKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_prokerKeyTyped
        btn_tambah.setEnabled(true);
        btn_edit.setEnabled(true);
        btn_hapus.setEnabled(false);
        btn_cancel.setEnabled(true);
        char c = evt.getKeyChar();
        if (!(Character.isAlphabetic(c) || (c == KeyEvent.VK_SPACE) || c == KeyEvent.VK_DELETE )){
            getToolkit().beep();
            evt.consume();
        }
        
    }//GEN-LAST:event_txt_prokerKeyTyped

    private void txt_jpemasukanKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_jpemasukanKeyTyped
         char c = evt.getKeyChar();
        if (!(Character.isAlphabetic(c) || (c == KeyEvent.VK_SPACE) || c == KeyEvent.VK_DELETE )){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txt_jpemasukanKeyTyped

    private void txt_nominalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nominalKeyTyped
                char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txt_nominalKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_tambah;
    private javax.swing.JComboBox<String> cb_department;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelsaldo;
    private javax.swing.JTable tb_proker;
    private com.toedter.calendar.JDateChooser tgl_pelaksanaan;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_jpemasukan;
    private javax.swing.JTextField txt_nominal;
    private javax.swing.JTextField txt_proker;
    // End of variables declaration//GEN-END:variables
}
