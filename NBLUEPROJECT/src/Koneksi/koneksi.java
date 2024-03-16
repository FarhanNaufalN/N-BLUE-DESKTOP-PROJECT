
package Koneksi;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class koneksi {
    public static Connection koneksiDb;
    public static Connection configDB()throws SQLException{
        try {
            String url = "jdbc:mysql://localhost/db_uas_pbo";
            String user = "root";
            String pass = "";
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            koneksiDb = DriverManager.getConnection(url,user,pass);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Koneksi Gagal");
            System.err.println("Koneksi Gagal "+e.getMessage());
        }
        return koneksiDb;
    }
}