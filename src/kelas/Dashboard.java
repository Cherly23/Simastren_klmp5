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
public class Dashboard extends Koneksi{
    private int Jsantri, Jpengajar, Jkelas,Jkitab;
    private final Connection Koneksi;
    private PreparedStatement ps;
    private Statement st;
    private ResultSet rs;
    private String query;
    
    public Dashboard(){
        Koneksi = super.configDB();
    }
    
    public int getJsantri() {
        return Jsantri;
    }

    public void setJsantri(int Jsantri) {
        this.Jsantri = Jsantri;
    }

    public int getJpengajar() {
        return Jpengajar;
    }

    public void setJpengajar(int Jpengajar) {
        this.Jpengajar = Jpengajar;
    }

    public int getJkelas() {
        return Jkelas;
    }

    public void setJkelas(int Jkelas) {
        this.Jkelas = Jkelas;
    }

    public int getJkitab() {
        return Jkitab;
    }

    public void setJkitab(int Jkitab) {
        this.Jkitab = Jkitab;
    }
    
    public ResultSet JumlahSantri () {
        query = "SELECT COUNT(*) AS jumlahS FROM santri; ";
        
        try {
            st = Koneksi.createStatement();
            rs = st.executeQuery(query);
            
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Jumlah Santri Gagal Ditampilkan " + sQLException.getMessage());
        }
        return rs;
    }
    
    public ResultSet JumlahPengajar () {
        query = "SELECT COUNT(*) AS jumlahP FROM ustadz; ";
        
        try {
            st = Koneksi.createStatement();
            rs = st.executeQuery(query);
            
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Jumlah Santri Gagal Ditampilkan " + sQLException.getMessage());
        }
        return rs;
    }
    
    public ResultSet JumlahKelas () {
        query = "SELECT COUNT(*) AS jumlahKL FROM kelas; ";
        
        try {
            st = Koneksi.createStatement();
            rs = st.executeQuery(query);
            
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Jumlah Santri Gagal Ditampilkan " + sQLException.getMessage());
        }
        return rs;
    }
    
    public ResultSet JumlahKitab () {
        query = "SELECT COUNT(*) AS jumlahKT FROM kitab; ";
        
        try {
            st = Koneksi.createStatement();
            rs = st.executeQuery(query);
            
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Jumlah Santri Gagal Ditampilkan " + sQLException.getMessage());
        }
        return rs;
    }
}
