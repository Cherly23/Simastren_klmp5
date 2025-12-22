/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kelas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException ;
import javax.swing.JOptionPane;

/**
 *
 * @author giantluigi
 */
public class DataPengurus extends Koneksi {
   private String jabatan;
   private int id_pengurus,id_ustadz;
   private final Connection Koneksi ;
   private PreparedStatement ps ;
   private Statement st ;
   private ResultSet rs ;
   private String query ;
   
    public DataPengurus() {
        Koneksi = super.configDB() ;
    }
    public String getJabatan() {
        return jabatan ;
    }
    
    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public int getId_pengurus() {
        return id_pengurus;
    }

    public void setId_pengurus(int id_pengurus) {
        this.id_pengurus = id_pengurus;
    }

    public int getId_ustadz() {
        return id_ustadz;
    }

    public void setId_ustadz(int id_ustadz) {
        this.id_ustadz = id_ustadz;
    }

    public PreparedStatement getPs() {
        return ps;
    }

    public void setPs(PreparedStatement ps) {
        this.ps = ps;
    }

    public Statement getSt() {
        return st;
    }

    public void setSt(Statement st) {
        this.st = st;
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
    public void TambahPengurus() {
        query = "INSERT INTO pengurus (id_pengurus, id_ustadz, jabatan ) VALUES (?,?,?)";

    try {
            ps = Koneksi.prepareStatement(query);
            ps.setInt(1, id_pengurus);
            ps.setInt(2, id_ustadz);
            ps.setString(3, jabatan);
            ps.executeUpdate();
            ps.close();
            
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data Gagal Ditambahkan, Eror : " + sQLException.getMessage());
    }
   
   }
    public void UbahPengurus() {
       query = "UPDATE pengurus SET id_ustadz = ?, jabatan = ? WHERE id_pengurus = ?";

    try {
            ps = Koneksi.prepareStatement(query);
            ps.setInt(1, id_ustadz);
            ps.setString(2, jabatan);
            ps.setInt(3, id_pengurus);
            ps.executeUpdate();
            ps.close();
            
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Perubahan Gagal DiSimpan, Eror : " + sQLException.getMessage());
    }
    }
    public void HapusPengurus() {
        query = "DELETE FROM pengurus WHERE id_pengurus = ?";

        try {
            ps = Koneksi.prepareStatement(query);
            ps.setInt(1, id_pengurus);
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Data Pengurus Berhasil DiHapus");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Pengurus Gagal DiHapus");
        }
}
    public ResultSet TampilPengurus() {
       query = "SELECT "
               + "p.id_pengurus, "
               + "u.nama_ustadz, "
               + "u.jenis_kelamin, "
               + "p.jabatan "
               + "FROM pengurus p "
               + "JOIN ustadz u ON p.id_ustadz = u.id_ustadz";
        
        try {
            st = Koneksi.createStatement();
            rs = st.executeQuery(query);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Gagal Ditampilkan");
        }
        return rs;
    }
    public ResultSet DetailPengurus(int id) {
        query = "SELECT p.*, u.nama_ustadz, u.jenis_kelamin, u.alamat, u.no_hp " +
                "FROM pengurus p " +
                "LEFT JOIN ustadz u ON p.id_ustadz = u.id_ustadz " +
                "WHERE p.id_pengurus = ?";
        try {
            ps = Koneksi.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error DetailPengurus: " + e.getMessage());
        }
        return rs;
    }
    public ResultSet cariPengurus(String key) {
        query = "SELECT p.*, u.nama_ustadz, u.jenis_kelamin, u.alamat, u.no_hp " +
                "FROM pengurus p " +
                "LEFT JOIN ustadz u ON p.id_ustadz = u.id_ustadz " +
                "WHERE u.nama_ustadz LIKE ? " +
                "OR u.jenis_kelamin LIKE ? " +
                "OR u.alamat LIKE ? " +
                "OR u.no_hp LIKE ? " +
                "OR p.jabatan LIKE ?";

        try {
            ps = Koneksi.prepareStatement(query);
            key = "%" + key + "%";

            ps.setString(1, key); // nama ustadz
            ps.setString(2, key); // jenis kelamin
            ps.setString(3, key); // alamat
            ps.setString(4, key); // no hp
            ps.setString(5, key); // jabatan pengurus

            rs = ps.executeQuery();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "Gagal mencari data pengurus: " + e.getMessage());
        }

        return rs;
}

    public ResultSet NamaUstadz(String nama) {
    query = "SELECT id_ustadz, jenis_kelamin FROM ustadz WHERE nama_ustadz = ?";
    try {
        ps = Koneksi.prepareStatement(query);
        ps.setString(1, nama);
        rs = ps.executeQuery();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null,
                "Gagal mengambil data ustadz: " + e.getMessage());
    }
    return rs;
}
    
    public  ResultSet autoId() {
            query = "SELECT id_pengurus AS ID FROM pengurus ORDER BY id_pengurus DESC LIMIT 1";
            
        try {    
            st = Koneksi.createStatement();
            rs = st.executeQuery(query);
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Eror : " + sQLException.getMessage());
        }
        return rs;
    }

}
