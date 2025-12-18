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
public class DataSantri extends Koneksi{
    private String nama_santri, tempat_lahir, alamat, jenis_kelamin, wali_santri, no_hp, tanggal_lahir, tanggal_masuk;
    private int id_santri, Status, kelas_id;
    private final Connection koneksi;
    private PreparedStatement ps;
    private Statement st;
    private ResultSet rs;
    private String query;
    
    public DataSantri() {
        koneksi = super.configDB();
    
    }

    public String getNama_santri() {
        return nama_santri;
    }

    public void setNama_santri(String nama_santri) {
        this.nama_santri = nama_santri;
    }

    public String getTempat_lahir() {
        return tempat_lahir;
    }

    public void setTempat_lahir(String tempat_lahir) {
        this.tempat_lahir = tempat_lahir;
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

    public String getWali_santri() {
        return wali_santri;
    }

    public void setWali_santri(String wali_santri) {
        this.wali_santri = wali_santri;
    }

    public String getNo_hp() {
        return no_hp;
    }

    public void setNo_hp(String no_hp) {
        this.no_hp = no_hp;
    }

    public String getTanggal_lahir() {
        return tanggal_lahir;
    }

    public void setTanggal_lahir(String tanggal_lahir) {
        this.tanggal_lahir = tanggal_lahir;
    }

    public String getTanggal_masuk() {
        return tanggal_masuk;
    }

    public void setTanggal_masuk(String tanggal_masuk) {
        this.tanggal_masuk = tanggal_masuk;
    }

    public int getId_santri() {
        return id_santri;
    }

    public void setId_santri(int id_santri) {
        this.id_santri = id_santri;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }

    public int getKelas_id() {
        return kelas_id;
    }

    public void setKelas_id(int kelas_id) {
        this.kelas_id = kelas_id;
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

    
    
    public ResultSet JumlahPutra () {
    query = "SELECT COUNT(*) AS jumlahPutra FROM santri WHERE jenis_kelamin = 'Laki-Laki';";
    try {
        st = koneksi.createStatement();
        rs = st.executeQuery(query);
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Gagal menampilkan Putra: " + e.getMessage());
    }
    return rs;
}
    public ResultSet JumlahPutri () {
    query = "SELECT COUNT(*) AS jumlahPutri FROM santri WHERE jenis_kelamin = 'Perempuan';";
    try {
        st = koneksi.createStatement();
        rs = st.executeQuery(query);
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Gagal menampilkan Putri: " + e.getMessage());
    }
    return rs;
}
    public void TambahSantri() {
        query = "INSERT INTO santri (nama_santri, tempat_lahir, tanggal_lahir, alamat, "
                 + "jenis_kelamin, wali_santri, no_hp, tanggal_masuk, status) VALUES (?,?,?,?,?,?,?,?,?)";

    try {
            ps = koneksi.prepareStatement(query);
            ps.setString(1, nama_santri);
            ps.setString(2, tempat_lahir);
            ps.setString(3, tanggal_lahir);
            ps.setString(4, alamat);
            ps.setString(5, jenis_kelamin);
            ps.setString(6, wali_santri);
            ps.setString(7, no_hp);
            ps.setString(8, tanggal_masuk);
            ps.setInt(9, Status);
            ps.executeUpdate();
            ps.close();
            
            JOptionPane.showMessageDialog(null, "Data Berhasil Ditambahkan");
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data Gagal Ditambahkan, Eror : " + sQLException.getMessage());
    }
   
}
    public void UbahSantri() {
        query = "UPDATE santri SET nama_santri=?, tempat_lahir=?, tanggal_lahir=?, alamat=?, jenis_kelamin=?, "
                + "wali_santri=?, no_hp=?, tanggal_masuk=?, kelas_id = ?, Status=? WHERE id_santri=?";

    try {
            ps = koneksi.prepareStatement(query);
            ps.setString(1, nama_santri);
            ps.setString(2, tempat_lahir);
            ps.setString(3, tanggal_lahir);
            ps.setString(4, alamat);
            ps.setString(5, jenis_kelamin);
            ps.setString(6, wali_santri);
            ps.setString(7, no_hp);
            ps.setString(8, tanggal_masuk);
            ps.setInt(9, kelas_id);
            ps.setInt(10, Status);
            ps.setInt(11, id_santri);
            ps.executeUpdate();
            ps.close();
            
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Perubahan Gagal DiSimpan, Eror : " + sQLException.getMessage());
    }
    }
    //    public void SimpanSantri() {
//      query = "INSERT INTO santri (nama_santri, tempat_lahir, tanggal_lahir, alamat, "
//                 + "jenis_kelamin, wali_santri, no_hp, tanggal_masuk, status) VALUES (?,?,?,?,?,?,?,?,?)";
//    try {
//            ps = koneksi.prepareStatement(query);
//            ps.setString(1, nama_santri);
//            ps.setString(2, tempat_lahir);
//            ps.setString(3, tanggal_lahir);
//            ps.setString(4, alamat);
//            ps.setString(5, jenis_kelamin);
//            ps.setString(6, wali_santri);
//            ps.setString(7, no_hp);
//            ps.setString(8, tanggal_masuk);
//            ps.setInt(9, Status);
//            ps.executeUpdate();
//            ps.close();
//            
//            JOptionPane.showMessageDialog(null, "Data Berhasil DiSimpan");
//        } catch (SQLException sQLException) {
//            JOptionPane.showMessageDialog(null, "Data Gagal DiSimpan " + sQLException.getMessage());
//    }
//    }
    public void HapusSantri(){
        query = "DELETE FROM santri WHERE id_santri = ? ";
        
        try {
            ps = koneksi.prepareStatement(query);
            ps.setInt(1, id_santri);
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Data Berhasil DiHapus");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Gagal DiHapus");
        }
    }
        public void SimpanSantri() {
        // Jika id_santri = 0 artinya data baru
    if (id_santri == 0) {
        UbahSantri();
    } else {
        UbahSantri();
    }
    }
    public ResultSet TampilSantri(){
        query = "SELECT * FROM santri";
        
        try {
            st = koneksi.createStatement();
            rs = st.executeQuery(query);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Gagal Ditampilkan");
        }
        return rs;
    }
    
    public ResultSet DetailSantri(int id) {
        query = "SELECT * FROM santri WHERE id_santri= ?";
        try {
            ps = koneksi.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
        return rs;
    }

    public ResultSet cariSantri(String key) {
    query = "SELECT * FROM santri WHERE "
            + "nama_santri LIKE ? OR "
            + "tempat_lahir LIKE ? OR "
            + "tanggal_lahir LIKE ? OR "
            + "alamat LIKE ? OR "
            + "jenis_kelamin LIKE ? OR "
            + "wali_santri LIKE ? OR "
            + "no_hp LIKE ? OR "
            + "tanggal_masuk LIKE ? OR "
            + "status LIKE ?";

    try {
        ps = koneksi.prepareStatement(query);
        key = "%" + key + "%";

        ps.setString(1, key);  // nama
        ps.setString(2, key);  // tempat lahir
        ps.setString(3, key);  // tanggal lahir
        ps.setString(4, key);  // alamat
        ps.setString(5, key);  // jenis kelamin
        ps.setString(6, key);  // wali santri
        ps.setString(7, key);  // no hp
        ps.setString(8, key);  // tanggal masuk
        ps.setString(9, key);  // status

        rs = ps.executeQuery();

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null,
                "Gagal mencari data santri: " + e.getMessage());
    }

    return rs;
}
    
}
