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

public class DataKitab extends Koneksi{
    private final Connection Koneksi; 
    private Statement stVar;
    private PreparedStatement psVar;
    private ResultSet rsVar;
    private String query;
    
    private int id_kitab;
    private String nama_kitab;
    private int ustadz_id; 
    private int kelas_id;
    private String kategori_kitab;
    
    public DataKitab(){
        Koneksi = super.configDB();
    }

    public int getId_kitab() {
        return id_kitab;
    }

    public void setId_kitab(int id_kitab) {
        this.id_kitab = id_kitab;
    }

    public String getNama_kitab() {
        return nama_kitab;
    }

    public void setNama_kitab(String nama_kitab) {
        this.nama_kitab = nama_kitab;
    }

    public int getUstadz_id() {
        return ustadz_id;
    }

    public void setUstadz_id(int ustadz_id) {
        this.ustadz_id = ustadz_id;
    }

    public int getKelas_id() {
        return kelas_id;
    }

    public void setKelas_id(int kelas_id) {
        this.kelas_id = kelas_id;
    }

    public String getKategori_kitab() {
        return kategori_kitab;
    }

    public void setKategori_kitab(String kategori_kitab) {
        this.kategori_kitab = kategori_kitab;
    }
    
    
    public ResultSet loadData() {
        try {
            query = "SELECT k.id_kitab, k.nama_kitab, u.nama_ustadz, l.nama_kelas, k.kategori_kitab " +
                    "FROM kitab k JOIN kelas l ON k.kelas_id = l.id_kelas " +
                    "JOIN ustadz u ON k.ustadz_id = u.id_ustadz";
            
            stVar = Koneksi.createStatement();
            rsVar = stVar.executeQuery(query);
            
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Error loadData Kitab: " + sQLException.getMessage());
        }
        return rsVar;
    }
    public void saveData() {
        try {
            query = "INSERT INTO kitab (nama_kitab, ustadz_id, kelas_id, kategori_kitab) VALUES (?,?,?,?)";
            
            psVar = Koneksi.prepareStatement(query);
            psVar.setString(1, nama_kitab);
            psVar.setInt(2, ustadz_id);
            psVar.setInt(3, kelas_id);
            psVar.setString(4, kategori_kitab);
            psVar.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Data Kitab berhasil ditambahkan");
            
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Error saveData Kitab: " + sQLException.getMessage());
        }
    }
    public void updateData() {
        try {
            query = "UPDATE kitab SET nama_kitab = ?, ustadz_id = ?, kelas_id = ?, kategori_kitab = ? WHERE id_kitab = ?";
            
            psVar = Koneksi.prepareStatement(query);
            psVar.setString(1, nama_kitab);
            psVar.setInt(2, ustadz_id); 
            psVar.setInt(3, kelas_id); // PERBAIKAN: kelas_id harusnya di indeks 3
            psVar.setString(4, kategori_kitab); // PERBAIKAN: kategori_kitab harusnya di indeks 4
            psVar.setInt(5, id_kitab); // ID Kitab untuk klausa WHERE
            
            psVar.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Data Kitab berhasil diubah");
            
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Error updateData Kitab: " + sQLException.getMessage());
        }
    }
    public void deleteData() {
        try {
            query = "DELETE FROM kitab WHERE id_kitab = ?";
            
            psVar = Koneksi.prepareStatement(query);
            psVar.setInt(1, id_kitab);
            
            psVar.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Data Kitab berhasil dihapus");
            
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Error deleteData Kitab: " + sQLException.getMessage());
        }
    }
    
    
    public ResultSet dataComboBoxKelas(){
        try {
            query = "SELECT nama_kelas FROM kelas ORDER BY nama_kelas ASC";
            stVar = Koneksi.createStatement();
            rsVar = stVar.executeQuery(query);
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Eror memuat ComboBOx kelas: "+ e.getMessage());
        }
        return rsVar;
    }
    
    public ResultSet dataComboBoxUstadz(){
        try {
            query = "SELECT nama_ustadz FROM ustadz ORDER BY nama_ustadz ASC";
            stVar = Koneksi.createStatement();
            rsVar = stVar.executeQuery(query);
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Error memuat ComboBox Ustadz: " + sQLException.getMessage());
        }
        return rsVar;
    }
    
    public ResultSet konversiKelasId(String namaKelas) {
        try {
            query = "SELECT id_kelas FROM kelas WHERE nama_kelas = ?";
            // PERBAIKAN: Menggunakan Koneksi (K besar)
            psVar = Koneksi.prepareStatement(query);
            psVar.setString(1, namaKelas);
            rsVar = psVar.executeQuery();
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Error konversi ID Kelas: " + sQLException.getMessage()); // Pesan error diperbaiki
        }
        return rsVar;
    }
    
    public ResultSet konversiUstadzId(String namaUstadz) {
        try {
            query = "SELECT id_ustadz FROM ustadz WHERE nama_ustadz = ?";
            psVar = Koneksi.prepareStatement(query);
            psVar.setString(1, namaUstadz);
            rsVar = psVar.executeQuery();
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Error konversi ID Ustadz: " + sQLException.getMessage());
        }
        return rsVar;
    }
    
    public ResultSet autoID() {
        try {
            query = "SELECT id_kitab AS ID FROM kitab ORDER BY id_kitab DESC LIMIT 1";
            stVar = Koneksi.createStatement();
            rsVar = stVar.executeQuery(query);
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Error Auto ID Kitab: " + sQLException.getMessage()); // Pesan error diperbaiki
        }
        return rsVar;
    }
    
}