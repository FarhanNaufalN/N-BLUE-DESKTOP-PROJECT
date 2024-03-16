
package SubForm;


import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import static main.Main.GUKM;
import static main.Main.nim;

public class HalamanAccPinjamBarang extends javax.swing.JPanel {
    String id;
    
    public HalamanAccPinjamBarang() {
        initComponents();
        tampil_table();
        tampil_detail();
    }
    private void tampil_table(){
        btn_acc.setEnabled(true);
        btn_declice.setEnabled(true);
        
        DefaultTableModel tb = new DefaultTableModel();
        tb.addColumn("Id");
        tb.addColumn("Nama");
        tb.addColumn("UKM");
        tb.addColumn("Status");
        
        try {
            String query = "SELECT tb_peminjaman.id,tb_anggota.nama,tb_anggota.ukm,tb_peminjaman.status FROM tb_peminjaman join tb_anggota on tb_anggota.nim = tb_peminjaman.id_peminjam WHERE tb_peminjaman.ukm = '"+GUKM+"'";
            java.sql.Connection vcon = (Connection)Koneksi.koneksi.configDB();
            java.sql.Statement statement = vcon.createStatement();
            java.sql.ResultSet result = statement.executeQuery(query);
            
            while (result.next()) {                
                tb.addRow(new Object[]{
                    result.getString(1),result.getString(2),result.getString(3),result.getString(4)
                });
            }
            tb_peminjaman.setModel(tb);
        } catch (Exception e) {
        }
    }
    private void tampil_detail(){
        
        DefaultTableModel tb = new DefaultTableModel();
        tb.addColumn("IDP");
        tb.addColumn("Id");
        tb.addColumn("Barang");
        tb.addColumn("Jumlah");
        
        try {
            String query = "SELECT d.id,b.id,b.nama,d.jml_barang FROM tb_detail_peminjaman d join tb_barang b on b.id = d.id_barang  WHERE d.id_peminjaman = '"+id+"'";
            java.sql.Connection vcon = (Connection)Koneksi.koneksi.configDB();
            java.sql.Statement statement = vcon.createStatement();
            java.sql.ResultSet result = statement.executeQuery(query);
            
            while (result.next()) {                
                tb.addRow(new Object[]{
                    result.getString(1),result.getString(2),result.getString(3),result.getString(4)
                });
            }
            tb_detail.setModel(tb);
        } catch (Exception e) {
        }
    }
    
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tb_detail = new javax.swing.JTable();
        btn_declice = new javax.swing.JButton();
        btn_acc = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_peminjaman = new javax.swing.JTable();

        tb_detail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "IDP", "Id", "Barang", "Jumlah"
            }
        ));
        jScrollPane2.setViewportView(tb_detail);

        btn_declice.setText("Declice");
        btn_declice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_decliceActionPerformed(evt);
            }
        });

        btn_acc.setText("Accept");
        btn_acc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_accActionPerformed(evt);
            }
        });

        tb_peminjaman.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "Nama", "UKM", "Status"
            }
        ));
        tb_peminjaman.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_peminjamanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_peminjaman);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_acc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_declice)))
                .addContainerGap(312, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(83, 83, 83)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_declice)
                    .addComponent(btn_acc))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_decliceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_decliceActionPerformed

        String jum;
        int jumlah = 0;
        Object value = tb_detail.getValueAt(0, 1);
        String barang = tb_detail.getValueAt(0, 3).toString();
        int brg = Integer.parseInt(barang);
        
         try {
            String query = "SELECT * FROM tb_detail_peminjaman WHERE id = '"+value+"'";
             java.sql.Connection vcon = (Connection)Koneksi.koneksi.configDB();
            java.sql.Statement statement = vcon.createStatement();
            java.sql.ResultSet result = statement.executeQuery(query);
            
            while (result.next()) {                
           jum = result.getString(4);
           jumlah = Integer.parseInt(jum);
           jumlah = jumlah + brg ;
            };
      }
            
        catch (Exception e) {
       
        }
         
        try {
            String query = "SELECT * FROM tb_barang WHERE id = '"+value+"'";
            java.sql.Connection vcon = (Connection)Koneksi.koneksi.configDB();
            java.sql.Statement statement = vcon.createStatement();
            java.sql.ResultSet result = statement.executeQuery(query);
            
            while (result.next()) {                
           jum = result.getString(4);
           jumlah = Integer.parseInt(jum);
           jumlah = jumlah + brg ;
            };
      }
            
        catch (Exception e) {
        }
        
        
        try {
            String query = "UPDATE tb_peminjaman SET status = 'Declice' WHERE id = '"+id+"'";
            java.sql.Connection vcon = (Connection)Koneksi.koneksi.configDB();
            java.sql.PreparedStatement preStatement = vcon.prepareStatement(query);
            preStatement.execute();
        } catch (Exception e) {
          
        }
        
        try {
            String query = "UPDATE tb_barang SET jml_barang = '"+jumlah+"' WHERE id = '"+value+"'";
            java.sql.Connection vcon = (Connection)Koneksi.koneksi.configDB();
            java.sql.PreparedStatement preStatement = vcon.prepareStatement(query);
            preStatement.execute();
            JOptionPane.showMessageDialog(null, "Staus Peminjaman Berhasil Diubah");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Staus Peminjaman Gagal Diubah");
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        tampil_table();
        
        
    }//GEN-LAST:event_btn_decliceActionPerformed

    private void btn_accActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_accActionPerformed
        
//        String barang = tb_detail.getValueAt(0, 2).toString();
//        String jumlahbarang = tb_detail.getValueAt(0, 3).toString();
//        String UKM = tb_peminjaman.getValueAt(0, 2).toString();
//        int brg = Integer.parseInt(barang);
//        int jmlbrg = Integer.parseInt(jumlahbarang);
//        String ukm_res = "";
//          
//        try {
//            String query = "INSERT INTO tb_pengembalian(id_peminjam, ukm, barang, jumlah, status) VALUES('"+nim+"','"+UKM+",'"+brg+"','"+jmlbrg+"','Pending')";
//            java.sql.Connection vcon = (Connection)Koneksi.koneksi.configDB();
//            java.sql.Statement statement = vcon.createStatement();
//            java.sql.ResultSet result = statement.executeQuery(query);
//            
//        } catch (Exception e) {
//             JOptionPane.showMessageDialog(null, "Staus Peminjaman Gagal Diubah");
//            JOptionPane.showMessageDialog(this, e.getMessage());
//        }
          
        try {
            String query = "UPDATE tb_peminjaman SET status = 'Accept', ukm = '"+GUKM+"' WHERE id = '"+id+"'";
            java.sql.Connection vcon = (Connection)Koneksi.koneksi.configDB();
            java.sql.PreparedStatement preStatement = vcon.prepareStatement(query);
            preStatement.execute();
            JOptionPane.showMessageDialog(null, "Staus Peminjaman Berhasil Diubah");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Staus Peminjaman Gagal Diubah");
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        
        tampil_table();
    }//GEN-LAST:event_btn_accActionPerformed

    private void tb_peminjamanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_peminjamanMouseClicked
        // TODO add your handling code here:
        int baris = tb_peminjaman.rowAtPoint(evt.getPoint());

        id = tb_peminjaman.getValueAt(baris, 0).toString();
       // idb= tb_detail.getValueAt(baris, 2).toString();
        String status = tb_peminjaman.getValueAt(baris, 3).toString();

        if ("Declice".equals(status)) {
            btn_acc.setEnabled(true);
            btn_declice.setEnabled(false);
        } else {
            btn_acc.setEnabled(true);
            btn_declice.setEnabled(true);
        }

        tampil_detail();
    }//GEN-LAST:event_tb_peminjamanMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_acc;
    private javax.swing.JButton btn_declice;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tb_detail;
    private javax.swing.JTable tb_peminjaman;
    // End of variables declaration//GEN-END:variables
}
