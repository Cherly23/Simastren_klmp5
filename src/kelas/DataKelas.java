/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kelas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author cherly
 */
public class DataKelas extends Koneksi {
    private String nama_kelas;
    private int id_kelas, wali_ustadz_id;
    
    private Connection koneksi; 
    private PreparedStatement ps;
    private Statement st;
    private ResultSet rs;
    private String query;

    public DataKelas() {
        this.koneksi = super.configDB(); 
    }
        
    public String getNama_kelas() { 
        return nama_kelas; 
    }
    public void setNama_kelas(String nama_kelas) { 
        this.nama_kelas = nama_kelas; 
    }

    public int getId_kelas() { 
        return id_kelas; 
    }
    public void setId_kelas(int id_kelas) { 
        this.id_kelas = id_kelas; 
    }

    public int getWali_ustadz_id() { 
        return wali_ustadz_id; 
    }
    public void setWali_ustadz_id(int wali_ustadz_id) { 
        this.wali_ustadz_id = wali_ustadz_id;
    }

    

    public void tambahDataKelas() {
        
        query = "INSERT INTO kelas (nama_kelas, wali_ustadz_id) VALUES (?,?)";
        try {
            ps = koneksi.prepareStatement(query);
            ps.setString(1, nama_kelas);
            ps.setInt(2, wali_ustadz_id);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal Simpan: " + e.getMessage());
        }
    }

    public void ubahDataKelas() {
        query = "UPDATE kelas SET nama_kelas=?, wali_ustadz_id=? WHERE id_kelas=?";
        try {
            ps = koneksi.prepareStatement(query);
            ps.setString(1, nama_kelas);
            ps.setInt(2, wali_ustadz_id);
            ps.setInt(3, id_kelas);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil Diperbarui");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal Ubah: " + e.getMessage());
        }
    }

    public void hapusDataKelas() {
        query = "DELETE FROM kelas WHERE id_kelas=?";
        try {
            ps = koneksi.prepareStatement(query);
            ps.setInt(1, id_kelas);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal Hapus: " + e.getMessage());
        }
    }

    public ResultSet tampilKelas() {
        // Menggabungkan tabel kelas dan ustadz untuk mendapatkan nama wali
        query = "SELECT k.id_kelas, k.nama_kelas, u.nama_ustadz " +
                "FROM kelas k JOIN ustadz u ON k.wali_ustadz_id = u.id_ustadz";
        try {
            st = koneksi.createStatement();
            rs = st.executeQuery(query);
        } catch (SQLException e) {
            System.err.println("Gagal Tampil: " + e.getMessage());
        }
        return rs;
    }

    public ResultSet cariKelas(String cari) {
        query = "SELECT * FROM kelas WHERE nama_kelas LIKE ?";
        try {
            ps = koneksi.prepareStatement(query);
            ps.setString(1, "%" + cari + "%");
            ps.setString(2, "%" + cari + "%");
            rs = ps.executeQuery();
        } catch (SQLException e) {
            System.err.println("Gagal Cari: " + e.getMessage());
        }
        return rs;
    }

    public int autoId() {
        int idBaru = 1;
        query = "SELECT MAX(id_kelas) AS max_id FROM kelas";
        try {
            st = koneksi.createStatement();
            rs = st.executeQuery(query);
            if (rs.next()) {
                idBaru = rs.getInt("max_id") + 1;
            }
        } catch (SQLException e) {
            System.err.println("Auto ID Error: " + e.getMessage());
        }
        return idBaru;
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