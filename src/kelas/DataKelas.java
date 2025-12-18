/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kelas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author cherly
 */
public class DataKelas extends Koneksi{
    private String nama_kelas, wali_ustadz;
    private int id_kelas;
    private final Connection koneksi;
    private PreparedStatement ps;
    private Statement st;
    private ResultSet rs;
    private String query;
    
    public DataKelas() {
        koneksi = super.configDB();
    }

    public String getNama_kelas() {
        return nama_kelas;
    }

    public void setNama_kelas(String nama_kelas) {
        this.nama_kelas = nama_kelas;
    }

    public String getWali_ustadz() {
        return wali_ustadz;
    }

    public void setWali_ustadz(String wali_ustadz) {
        this.wali_ustadz = wali_ustadz;
    }

    public int getId_kelas() {
        return id_kelas;
    }

    public void setId_kelas(int id_kelas) {
        this.id_kelas = id_kelas;
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
    public void UbahKelas() {
        query = "UPDATE kelas SET nama_kelas=?, wali_ustadz_id=? WHERE id_kelas=?" ;

    try {
            ps = koneksi.prepareStatement(query);
            ps.setString(1, nama_kelas);
            ps.setString(2, wali_ustadz);
            ps.setInt(3, id_kelas);
            ps.executeUpdate();
            ps.close();
            
            JOptionPane.showMessageDialog(null, "Data Berhasil Ditambahkan");
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data Gagal Ditambahkan, Eror : " + sQLException.getMessage());
    }
}
    
        public ResultSet cariKelas(String key) {
    query = "SELECT * FROM kelas WHERE "
            + "nama_kelas LIKE ? OR "
            + "wali_ustadz_id LIKE ? ";

    try {
        ps = koneksi.prepareStatement(query);
        key = "%" + key + "%";

        ps.setString(1, key);  // nama
        ps.setString(2, key);  // wali

        rs = ps.executeQuery();

    } catch (SQLException sQLException) {
        JOptionPane.showMessageDialog(null, "Gagal mencari data santri: " + sQLException.getMessage());
    }

    return rs;
}
    
    public void HapusKelas(){
        query = "DELETE FROM kelas WHERE id_kelas = ? ";
        
        try {
            ps = koneksi.prepareStatement(query);
            ps.setInt(1, id_kelas);
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Data Berhasil DiHapus");
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data Gagal DiHapus, Eror : " + sQLException.getMessage());
        }
    }
    
    public ResultSet TampilSantri(){
        query = "SELECT * FROM kelas";
        
        try {
            st = koneksi.createStatement();
            rs = st.executeQuery(query);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Gagal Ditampilkan");
        }
        return rs;
    }
        
      public ResultSet dataComboBox() {
        try {
            query = "SELECT nama_kelas FROM kelas";
            
            st = koneksi.createStatement();
            rs = st.executeQuery(query);
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Eror : " + sQLException.getMessage());
        }
        return rs;
    }
    
    public ResultSet konversi() {
        try {
            query = "SELECT id_kelas FROM kelas WHERE nama_kelas = ?";
            
            ps = koneksi.prepareStatement(query);
            ps.setString(1, this.nama_kelas);
            rs = ps.executeQuery();
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Eror : " + sQLException.getMessage());
        }
        return rs;  
    }  
    
}
