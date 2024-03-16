
package SubForm;

import java.sql.Connection;
import javax.swing.table.DefaultTableModel;
import static main.Main.GUKM;

public class HalamanPengembalian extends javax.swing.JPanel {

   
    public HalamanPengembalian() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tb_peminjaman = new javax.swing.JTable();

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(292, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                .addGap(66, 66, 66))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    String id;
    
     private void tampil_table(){
         
        DefaultTableModel tb = new DefaultTableModel();
        tb.addColumn("Id");
        tb.addColumn("Nama");
        tb.addColumn("UKM");
        tb.addColumn("Barang");
        tb.addColumn("Jumlah");
        tb.addColumn("Status");
        
        try {
            String query = "SELECT tb_peminjaman.id, tb_anggota.nama, tb_anggota.ukm, tb_pengembalian.barang, tb_pengembalian.jumlah, tb_pengembalian.status " +
               "FROM tb_pengembalian " +
               "JOIN tb_anggota ON tb_anggota.nim = tb_peminjaman.id_peminjam " +
               "JOIN tb_peminjaman ON tb_peminjaman.id = tb_pengembalian.id_peminjaman " +
               "WHERE tb_pengembalian.ukm = '"+GUKM+"'";

            java.sql.Connection vcon = (Connection)Koneksi.koneksi.configDB();
            java.sql.Statement statement = vcon.createStatement();
            java.sql.ResultSet result = statement.executeQuery(query);
            
            while (result.next()) {                
                tb.addRow(new Object[]{
                    result.getString(1),result.getString(2),result.getString(3),result.getString(4),result.getString(5),result.getString(5)
                });
            }
            tb_peminjaman.setModel(tb);
        } catch (Exception e) {
        }
    }
    private void tb_peminjamanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_peminjamanMouseClicked
      
     
    }//GEN-LAST:event_tb_peminjamanMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tb_peminjaman;
    // End of variables declaration//GEN-END:variables
}
