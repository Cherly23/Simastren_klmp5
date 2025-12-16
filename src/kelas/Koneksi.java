package kelas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author cherly
 */

import javax.swing.JOptionPane;
public class Koneksi {
    private Connection mysqlconfig;
    public Connection configDB () {
            try {
                String url = "jdbc:mysql://localhost:3306/mangement_pesantren"; 
                String user = "root";
                String pass = "";
                
                mysqlconfig = DriverManager.getConnection(url, user, pass);
            } catch (SQLException sQLException) {
                JOptionPane.showMessageDialog(null, "Driver tidak ditemukan: " + sQLException.getMessage());
            }
        return mysqlconfig;
    }
    }

