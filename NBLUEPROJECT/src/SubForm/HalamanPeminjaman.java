
package SubForm;


import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import javax.swing.JOptionPane;
import static main.Main.nim;

public class HalamanPeminjaman extends javax.swing.JPanel {

    public static int row;
    public static String id_peminjaman;
    public HalamanPeminjaman(String NIM) {
        initComponents();
        try {
            String id_peminjaman = "";
            String query = "SELECT COUNT(id) FROM tb_peminjaman";
            java.sql.Connection vcon = (Connection)Koneksi.koneksi.configDB();
            java.sql.Statement statement = vcon.createStatement();
            java.sql.ResultSet result = statement.executeQuery(query);
            
            while (result.next()) {                
                id_peminjaman = result.getString(1);
            }
            int id = Integer.parseInt(id_peminjaman);
            id++;
            txt_peminjaman1.setText(Integer.toString(id));
        } catch (Exception e) {
        }
    }
     private void insert_detail(){
        String id_barang = "";
        String jml_barang = "";
        for (int i = 0; i <= tb_cart.getModel().getRowCount(); i++) {
            id_barang = tb_cart.getModel().getValueAt(i, 0).toString();
            jml_barang = tb_cart.getModel().getValueAt(i, 2).toString();
            try {
            
            int stok_brg = 0;
            
            String query_stok = "SELECT jml_barang FROM tb_barang where id = '"+id_barang+"'";
            java.sql.Connection vcon = (Connection)Koneksi.koneksi.configDB();
            java.sql.Statement statement = vcon.createStatement();
            java.sql.ResultSet result2 = statement.executeQuery(query_stok);
            
            while (result2.next()) {                
                stok_brg = result2.getInt(1);
            }
                try {
                    int jml_brg = Integer.parseInt(jml_barang);
                    if (stok_brg - jml_brg >=1){
                        String query = "INSERT INTO tb_detail_peminjaman(id_peminjaman,id_barang,jml_barang) VALUES('"+txt_peminjaman1.getText()+"','"+id_barang+"','"+jml_barang+"')";     
                        java.sql.PreparedStatement preStatement = vcon.prepareStatement(query);
                        preStatement.execute();
                    }else{
                        JOptionPane.showMessageDialog(null, "Beberapa Data Barang Gagal Ditambahkan. Stok Barang Yang dipilih tidak mencukupi");
                        
                    }
                } catch (Exception e) {
                
                }
            
            
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Data Barang Gagal Ditambahkan");
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_kurang = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_barang = new javax.swing.JTable();
        txt_peminjaman = new javax.swing.JLabel();
        txt_peminjaman1 = new javax.swing.JLabel();
        btn_pinjam = new javax.swing.JButton();
        cb_ukm = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        btn_tambah = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_cart = new javax.swing.JTable();

        btn_kurang.setText("Kurangi");
        btn_kurang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_kurangActionPerformed(evt);
            }
        });

        tb_barang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id", "Barang", "Stok"
            }
        ));
        tb_barang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_barangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_barang);

        txt_peminjaman.setText("Id Peminjaman : ");

        txt_peminjaman1.setText("1");

        btn_pinjam.setText("Pinjam");
        btn_pinjam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pinjamActionPerformed(evt);
            }
        });

        cb_ukm.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih UKM", "BEM", "DPM", "HIMA RPL", "HIMA TEKKOM", "HIMA PEDIA", "HIMA PGSD", "HIMA PGPAUD" }));
        cb_ukm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_ukmActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Sitka Text", 0, 12)); // NOI18N
        jLabel1.setText("Pilih UKM");

        btn_tambah.setText("Tambah");
        btn_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahActionPerformed(evt);
            }
        });

        btn_hapus.setText("Hapus");
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });

        tb_cart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Barang", "Jumlah Barang"
            }
        ));
        tb_cart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_cartMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tb_cart);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_pinjam)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(cb_ukm, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(53, 53, 53)
                                .addComponent(txt_peminjaman)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_peminjaman1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btn_tambah, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btn_kurang)
                                    .addComponent(btn_hapus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(330, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_ukm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(txt_peminjaman)
                    .addComponent(txt_peminjaman1))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(btn_tambah)
                        .addGap(18, 18, 18)
                        .addComponent(btn_kurang)
                        .addGap(18, 18, 18)
                        .addComponent(btn_hapus))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(btn_pinjam)
                .addContainerGap(91, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_kurangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_kurangActionPerformed
        // TODO add your handling code here:
        String jml_barang = tb_cart.getModel().getValueAt(row, 2).toString();
        int jml = Integer.parseInt(jml_barang);
        jml--;
        tb_cart.getModel().setValueAt(Integer.toString(jml), row, 2);
    }//GEN-LAST:event_btn_kurangActionPerformed

    private void tb_barangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_barangMouseClicked
        // TODO add your handling code here:
        btn_tambah.setEnabled(true);
        btn_kurang.setEnabled(false);
        btn_hapus.setEnabled(false);
        row = tb_barang.getSelectedRow();
    }//GEN-LAST:event_tb_barangMouseClicked

    private void btn_pinjamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pinjamActionPerformed
        // TODO add your handling code here:

        try {
            String ukm_res = "";

            String query_ukm = "SELECT ukm FROM tb_anggota where nim = '"+nim+"'";
            java.sql.Connection vcon = (Connection)Koneksi.koneksi.configDB();
            java.sql.Statement statement = vcon.createStatement();
            java.sql.ResultSet result = statement.executeQuery(query_ukm);

            while (result.next()) {
                ukm_res = result.getString(1);
            }

            String query = "INSERT INTO tb_peminjaman(id,id_peminjam,ukm,status) VALUES('"+txt_peminjaman1.getText()+"','"+nim+"','"+cb_ukm.getSelectedItem().toString()+"','Pending')";

            java.sql.PreparedStatement preStatement = vcon.prepareStatement(query);
            preStatement.execute();
            JOptionPane.showMessageDialog(null, "Peminjaman berhasil diajukan");
            this.setVisible(false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data Barang Gagal Ditambahkan");
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

        insert_detail();

    }//GEN-LAST:event_btn_pinjamActionPerformed

    private void cb_ukmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_ukmActionPerformed
        // TODO add your handling code here:
        btn_kurang.setEnabled(false);
        btn_tambah.setEnabled(false);
        btn_hapus.setEnabled(false);

        DefaultTableModel tb = new DefaultTableModel();
        tb.addColumn("Id");
        tb.addColumn("Nama");
        tb.addColumn("Stok");

        try {
            String query = "SELECT * FROM tb_barang WHERE ukm = '"+cb_ukm.getSelectedItem().toString()+"'";
            java.sql.Connection vcon = (Connection)Koneksi.koneksi.configDB();
            java.sql.Statement statement = vcon.createStatement();
            java.sql.ResultSet result = statement.executeQuery(query);

            while (result.next()) {
                tb.addRow(new Object[]{
                    result.getString(1),result.getString(3),result.getString(4)
                });
            }
            tb_barang.setModel(tb);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cb_ukmActionPerformed

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel)tb_cart.getModel();
        String id_barang = tb_barang.getModel().getValueAt(row, 0).toString();
        String nama_barang = tb_barang.getModel().getValueAt(row, 1).toString();
        if (tb_cart.getRowCount() == 0) {
            model.addRow(new Object[]{id_barang,nama_barang,"1"});
        } else {
            boolean newrow = true;
            int idrow = 0;
            for (int i = 0; i < tb_cart.getRowCount(); i++) {
                if (id_barang == tb_cart.getModel().getValueAt(i, 0)) {
                    newrow = false;
                    idrow = i;
                }
            }
            if (newrow) {
                model.addRow(new Object[]{id_barang,nama_barang,"1"});
            }else{
                String jml_barang = tb_cart.getModel().getValueAt(idrow, 2).toString();
                int jml = Integer.parseInt(jml_barang);
                jml++;
                tb_cart.getModel().setValueAt(Integer.toString(jml), idrow, 2);
            }
        }
    }//GEN-LAST:event_btn_tambahActionPerformed

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel)tb_cart.getModel();
        model.removeRow( row );
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void tb_cartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_cartMouseClicked
        // TODO add your handling code here:
        btn_kurang.setEnabled(true);
        btn_hapus.setEnabled(true);
        btn_tambah.setEnabled(false);

        row = tb_cart.getSelectedRow();

    }//GEN-LAST:event_tb_cartMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_kurang;
    private javax.swing.JButton btn_pinjam;
    private javax.swing.JButton btn_tambah;
    private javax.swing.JComboBox<String> cb_ukm;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tb_barang;
    private javax.swing.JTable tb_cart;
    private javax.swing.JLabel txt_peminjaman;
    private javax.swing.JLabel txt_peminjaman1;
    // End of variables declaration//GEN-END:variables
}
