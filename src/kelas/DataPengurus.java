/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kelas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException ;
/**
 *
 * @author giantluigi
 */
public class DataPengurus extends Koneksi {
    public boolean simpanPengurus(int pengurusId, String jabatan) {
        String sql = "INSERT INTO pengurus (pengurus_id, jabatan) VALUES (?, ?)";
        Connection conn = Koneksi.getConection();
        PreparedStatement pstmt = null ;
        
        try {
            pstmt = conn.prepareStatement(sql) ;
            pstmt.setInt(1, pengurusId);
            pstmt.setString(2, jabatan);
            
            int rowsAffected = pstmt.executeUpdate() ;
            
            if (rowsAffected > 0) {
                System.out.println("Data Pengurus ID" + pengurusId + "berhasil ditambahkan!");
                return true ;
            }
        }catch (SQLException e) {
            if (e.getErrorCode() == 1452) {
                System.err.println("Gagal INSERT: ID Ustadz (" + pengurusId + ") tidak ditemukan! (Foreign Key Error)");
            } else {
                System.err.println("Error saat menyimpan data Pengurus: " + e.getMessage());
            }
        } finally {
            try {
                if (pstmt != null) pstmt.close(); ;
            }catch (SQLException e) {
                
            }
        }
        return false;
    }
    public static void main(String[] args) {
        DataPengurus dau = new DataPengurus();
        dau.simpanPengurus(1, "Kepala Madin") ;
        dau.simpanPengurus(2, "Kepala Pondok") ;
        dau.simpanPengurus(99, "Kepala Yayasan") ;
    }
    
}
