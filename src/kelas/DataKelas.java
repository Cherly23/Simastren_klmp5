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
            JOptionPane.showMessageDialog(null, "Data Berhasil DiTambah");
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Gagal Tambah : " + sQLException.getMessage());
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
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Gagal Ubah: " + sQLException.getMessage());
        }
    }

    public void hapusDataKelas() {
        query = "DELETE FROM kelas WHERE id_kelas=?";
        try {
            ps = koneksi.prepareStatement(query);
            ps.setInt(1, id_kelas);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Gagal Hapus: " + sQLException.getMessage());
        }
    }

    public ResultSet tampilKelas() {
        // Menggabungkan tabel kelas dan ustadz untuk mendapatkan nama wali
        query = "SELECT k.id_kelas, k.nama_kelas, u.nama_ustadz " +
                "FROM kelas k JOIN ustadz u ON k.wali_ustadz_id = u.id_ustadz";
        try {
            st = koneksi.createStatement();
            rs = st.executeQuery(query);
        } catch (SQLException sQLException) {
            System.err.println("Gagal Tampil: " + sQLException.getMessage());
        }
        return rs;
    }

    public ResultSet cariKelas(String cari) {
    query = "SELECT k.*, u.nama_ustadz "
            + "FROM kelas k "
            + "LEFT JOIN ustadz u ON k.wali_ustadz_id = u.id_ustadz "
            + "WHERE k.nama_kelas LIKE ? "
            + "OR u.nama_ustadz LIKE ?";

        try {
            ps = koneksi.prepareStatement(query);
            ps.setString(1, "%" + cari + "%");
            ps.setString(2, "%" + cari + "%");
//            ps.setString(3, "%" + cari + "%");
            rs = ps.executeQuery();
        } catch (SQLException e) {
            System.err.println("Gagal Cari: " + e.getMessage());
        }
        return rs;
    }

    public ResultSet autoId() {
        query = "SELECT id_kelas AS ID FROM kelas ORDER BY id_kelas DESC LIMIT 1";
        try {
            st = koneksi.createStatement();
            rs = st.executeQuery(query);
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Auto ID Error: " + sQLException.getMessage());
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