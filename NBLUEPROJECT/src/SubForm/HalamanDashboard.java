
package SubForm;

import java.sql.Connection;
import javax.swing.table.DefaultTableModel;
import static main.Main.GUKM;
public class HalamanDashboard extends javax.swing.JPanel {

    
    public HalamanDashboard() {
        initComponents();
        DefaultTableModel tb = new DefaultTableModel();
        tb.addColumn("NIM");
        tb.addColumn("Nama");
        tb.addColumn("Jurusan");
        tb.addColumn("Angkatan");
        tb.addColumn("Jabatan");
        
      
        try {
            String query = "SELECT * FROM tb_anggota WHERE ukm = '"+GUKM+"'";
            java.sql.Connection vcon = (Connection)Koneksi.koneksi.configDB();
            java.sql.Statement statement = vcon.createStatement();
            java.sql.ResultSet result = statement.executeQuery(query);
            
            while (result.next()) {                
                tb.addRow(new Object[]{
                    result.getString(1),result.getString(2),result.getString(3),result.getString(4),result.getString(10),result.getString(7),result.getString(8),result.getString(10)
                });
            }
            table1.setModel(tb);
        } catch (Exception e) {
        }
 
    } 

    

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new com.raven.swing.PanelBorder();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new TableAnggotaDashboard.Table();

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBorder(null);

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NIM", "Nama", "Jabatan", "Status", "null", "null", "null", "null"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table1);

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 741, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(100, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private com.raven.swing.PanelBorder panelBorder1;
    private TableAnggotaDashboard.Table table1;
    // End of variables declaration//GEN-END:variables
}
