
package SubForm;

import Koneksi.koneksi;
import com.mysql.cj.QueryResult;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import static main.Main.GUKM;

public class HalamanListProker extends javax.swing.JPanel {

  
   
    public HalamanListProker() {
        initComponents(); 
        cleardata();
        updateCombo();
        
    }

    private void updateCombo(){
    try {
            String query = "Select * FROM tb_department WHERE ukm = '"+GUKM+"'";
            java.sql.Connection vcon = (Connection)Koneksi.koneksi.configDB();
            java.sql.Statement statement = vcon.createStatement();
            java.sql.ResultSet result = statement.executeQuery(query);
            
            while (result.next()){
                cb_depart.addItem(result.getString("department"));
            
            }
        } catch (Exception e) {
        }
    }
    
    private void cleardata(){
        cb_depart.setSelectedItem("Pilih Department");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table2 = new TableAnggotaDashboard.Table();
        jLabel6 = new javax.swing.JLabel();
        cb_depart = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();

        jScrollPane1.setBorder(null);

        table2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Proker", "Waktu Pelaksanaan", "Departmen", "Jenis Pemasukan", "Nominal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table2);

        jLabel6.setFont(new java.awt.Font("Sitka Text", 0, 12)); // NOI18N
        jLabel6.setText("Pilih Department");

        cb_depart.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Department" }));
        cb_depart.setToolTipText("");
        cb_depart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_departActionPerformed(evt);
            }
        });

        jLabel7.setText("ID");

        txt_id.setEditable(false);
        txt_id.setText("auto_inc");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(55, 55, 55)
                        .addComponent(cb_depart, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                        .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cb_depart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cb_departActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_departActionPerformed
        // TODO add your handling code here:
    
         
        DefaultTableModel tb = new DefaultTableModel();
        tb.addColumn("Proker");
        tb.addColumn("Waktu Pelaksanaan");
        tb.addColumn("Departmen");
        tb.addColumn("Jenis Pemasukan");
        tb.addColumn("Nominal");

        try {
            String query = "SELECT * FROM tb_proker WHERE department = '"+cb_depart.getSelectedItem().toString()+"' AND ukm = '"+GUKM+"'";
            java.sql.Connection vcon = (Connection)Koneksi.koneksi.configDB();
            java.sql.Statement statement = vcon.createStatement();
            java.sql.ResultSet result = statement.executeQuery(query);

            while (result.next()) {
                tb.addRow(new Object[]{
                    result.getString(2),result.getString(3),result.getString(4),result.getString(5),result.getString(6)
                });
            }
            table2.setModel(tb);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cb_departActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cb_depart;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private TableAnggotaDashboard.Table table2;
    private javax.swing.JTextField txt_id;
    // End of variables declaration//GEN-END:variables
}
