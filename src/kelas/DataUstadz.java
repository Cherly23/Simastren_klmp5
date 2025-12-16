/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kelas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author LUIGI
 */
public class DataUstadz {
    public boolean simpanUstadz(String nama, String alamat, String jenisKelamin, String noHp) {
        String sql = "INSERT INTO ustadz (nama_ustadz, alamat, jenis_kelamin, no_hp) VALUES (?, ?, ?, ?)" ;
        Connection conn = Koneksi.getConnection() ;
        PreparedStatement pstmt = null;
        
        try {
            pstmt = conn.prepareStatement(sql) ;
            pstmt.setString(1, nama);
            pstmt.setString(2, alamat);
            pstmt.setString(3, jenisKelamin);
            pstmt.setString(4, noHp);
            
            int rowsAffected = pstmt.executeUpdate();
            
            if (rowsAffected > 0) {
                System.out.println("Data Ustadz '" + nama +"'berhasil ditambahkan'");
                return true;
            }
        }catch (SQLException e) {
            System.err.println("Error saat menyimpan data Ustadz: " + e.getMessage());
        }finally{
            try {
                if (pstmt != null) pstmt.close();
            }catch (SQLException e) {
                
            }
        }
        return false ;
    }
    public static void main(String[] args) {
        DataUstadz dau = new DataUstadz();
        dau.simpanUstadz("Alfiyan", "Jl. Kemayoran No. 5", "Laki-laki", "08123456789") ;
        dau.simpanUstadz("Irtifa'", "Bonggah Ploso Nganjuk", "Perempuan", "08135542789") ;
    }
}
