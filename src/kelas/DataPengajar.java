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
 * @author giantluigi
 */
public class DataPengajar extends Koneksi {
    
    private String nama_ustadz, alamat, jenis_kelamin, no_hp;
    private int id_ustadz;
    private final Connection koneksi;
    private PreparedStatement ps;
    private Statement st;
    private ResultSet rs;
    private String query;
    
    public DataPengajar() {
       koneksi = super.ConfigDB ;
    }
    public int getId_ustadz () {
        return id_ustadz ;
    }

        public String getNama_ustadz() {
            return nama_ustadz;
        }

        public void setNama_ustadz(String nama_ustadz) {
            this.nama_ustadz = nama_ustadz;
        }

        public String getAlamat() {
            return alamat;
        }

        public void setAlamat(String alamat) {
            this.alamat = alamat;
        }

        public String getJenis_kelamin() {
            return jenis_kelamin;
        }

        public void setJenis_kelamin(String jenis_kelamin) {
            this.jenis_kelamin = jenis_kelamin;
        }

        public String getNo_hp() {
            return no_hp;
        }

        public void setNo_hp(String no_hp) {
            this.no_hp = no_hp;
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
    public ResultSet dataComboBox() {
        try {
            query = "SELECT nama_ustadz FROM ustadz";
            
            st = koneksi.createStatement();
            rs = st.executeQuery(query);
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Eror : " + sQLException.getMessage());
        }
        return rs;
    }
    public ResultSet konversi() {
        try {
            query = "SELECT id_ustadz FROM ustadz WHERE nama_ustadz = ?";
            
            ps = koneksi.prepareStatement(query);
            ps.setString(1, this.nama_ustadz);
            rs = ps.executeQuery();
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Eror : " + sQLException.getMessage());
        }
        return rs;  
    }  
}
