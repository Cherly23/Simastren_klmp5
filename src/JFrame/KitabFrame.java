package JFrame;

import java.awt.CardLayout;
import kelas.DataKitab;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import kelas.Koneksi;



public class KitabFrame extends javax.swing.JFrame{
    
//    Connection conn;
//    
//    private javax.swing.JTextField txtIdKitab;
//    private javax.swing.JTextField txtNamaKitab;
//    private javax.swing.JComboBox<String> cmbKelas;
//    private javax.swing.JComboBox<String> cmbPengajar;
//    private javax.swing.JTable jTable1;

    public KitabFrame() {
        initComponents();
        loadKelas();
    }
    
    void loadKelas() {
        if (cmbKelas == null) return;
        cmbKelas.removeAllItems();
        cmbKelas.addItem("-- Pilih Kelas --");
        
        DataKitab ktb = new DataKitab();
        try (ResultSet rs = ktb.dataComboBoxKelas()) {
            while (rs.next()) {
                cmbKelas.addItem(rs.getString("nama_kelas"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal memuat data Kelas: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    void loadPengajar() {
        if (cmbPengajar == null) return;
        cmbPengajar.removeAllItems();
        cmbPengajar.addItem("-- Pilih Pengajar --");
        
        
        DataKitab ktb = new DataKitab();
        try (ResultSet rs = ktb.dataComboBoxUstadz()) {
            while (rs.next()) {
               
                cmbPengajar.addItem(rs.getString("nama_ustadz")); 
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal memuat data Pengajar: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

//    void autoID() {
//        if ( == null || txtIdKitab == null) return;
//        
//        DataKitab dataKitab = new DataKitab(conn);
//        ResultSet rsVar = dataKitab.autoID();
//        
//        try {
//            if (rsVar.next()) {
//                int id = rsVar.getInt("ID") + 1;
//                txtIdKitab.setText(String.valueOf(id));
//            } else {
//                txtIdKitab.setText("1");
//            }
//        } catch (SQLException sQLException) {
//            JOptionPane.showMessageDialog(this, "Error Auto ID: " + sQLException.getMessage());
//        }
//    }

    void resetForm() {
        if (txtIdKitab != null) txtIdKitab.setEditable(false);
        if (txtNamaKitab != null) txtNamaKitab.setText(null);
        if (cmbKelas != null) cmbKelas.setSelectedIndex(0);
        if (cmbPengajar != null) cmbPengajar.setSelectedIndex(0);
    }

    void load_table() {
    DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Kitab");
        model.addColumn("ID Kitab");
        model.addColumn("ID Kitab");
        model.addColumn("ID Kitab");

        try {
            DataKitab ktb = new DataKitab();
            ResultSet result = ktb.loadData();
            while (result.next()) {
                model.addRow(new Object[] {
                result.getInt("id_kitab"),
                result.getInt("nama_kitab"),
                result.getInt("ustadz_id"),
                result.getInt("kelas_id"),
                result.getInt("id_kitab")
            });    
            }
            tblKitab.setModel(model);
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Eror Tabel : " + sQLException);
        }

    

//    void loadTable()   
//        DefaultTableModel model = new DefaultTableModel();
//        model.addColumn("ID Kitsb");
//        
//        try {
//            ResultSet rsVar = dataKitab.loadData();
//            
//            while (rsVar.next()) {
//                int id = rsVar.getInt("id_kitab");
//                String namaKitab = rsVar.getString("nama_kitab");
//                String namaKelas = rsVar.getString("nama_kelas");
//                String namaUstadz = rsVar.getString("nama_ustadz"); // Kolom nama_ustadz dari JOIN
//                String kategoriKitab = rsVar.getString("kategori_kitab");
//                
//                Object data[] = {id, namaKitab, namaKelas, namaUstadz, kategoriKitab};
//                model.addRow(data);
//            }
//        } catch (SQLException sQLException) {
//            JOptionPane.showMessageDialog(this, "Error Load Table: " + sQLException.getMessage());
//        }
//    }
    
   
//    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {
////        if (cmbKelas.getSelectedIndex() == 0 || cmbPengajar.getSelectedIndex() == 0) {
////            JOptionPane.showMessageDialog(this, "Pilih Kelas dan Pengajar terlebih dahulu!", "Peringatan", JOptionPane.WARNING_MESSAGE);
////            return;
////        }
////        
////        String namaKitab = txtNamaKitab.getText();
////        String namaKelas = cmbKelas.getSelectedItem().toString();
////        String namaUstadz = cmbPengajar.getSelectedItem().toString();
////        String kategoriKitab = jTextField4.getText(); // Asumsi jTextField4 adalah input Kategori Kitab
////
////        if (namaKitab.isEmpty() || kategoriKitab.isEmpty()) {
////            JOptionPane.showMessageDialog(this, "Nama Kitab dan Kategori harus diisi.", "Peringatan", JOptionPane.WARNING_MESSAGE);
////            return;
////        }
////
////        DataKitab dataKitab = new DataKitab();
////        int idUstadz = -1;
////        int idKelas = -1;
////        
////        try {
////            ResultSet rsUstadz = dataKitab.konversiUstadzId(namaUstadz);
////            if (rsUstadz != null && rsUstadz.next()) {
////                idUstadz = rsUstadz.getInt("id_ustadz");
////            }
////
////           
////            ResultSet rsKelas = dataKitab.konversiKelasId(namaKelas);
////            if (rsKelas != null && rsKelas.next()) {
////                idKelas = rsKelas.getInt("id_kelas");
////            }
////            
////            if (idUstadz != -1 && idKelas != -1) {
////                dataKitab.setNama_kitab(namaKitab);
////                dataKitab.setUstadz_id(idUstadz);
////                dataKitab.setKelas_id(idKelas);
////                dataKitab.setKategori_kitab(kategoriKitab);
////                
////                dataKitab.saveData();
////                
////              
////                loadTable();
////                resetForm();
////            } else {
////                JOptionPane.showMessageDialog(this, "Gagal menemukan ID Ustadz atau Kelas.", "Error", JOptionPane.ERROR_MESSAGE);
////            }
////        } catch (SQLException e) {
////            JOptionPane.showMessageDialog(this, "Kesalahan SQL saat menyimpan data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
////        }
//    }
    
 
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainpanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txtNamaKitab = new javax.swing.JTextField();
        btnUbah = new javax.swing.JButton();
        jTextField4 = new javax.swing.JTextField();
        txtIdKitab = new javax.swing.JTextField();
        btnHapus = new javax.swing.JButton();
        btnTambah = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cmbKelas = new javax.swing.JComboBox<>();
        cmbPengajar = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKitab = new javax.swing.JTable();
        btnReset1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new java.awt.CardLayout());

        mainpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNamaKitab.setBorder(null);
        txtNamaKitab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaKitabActionPerformed(evt);
            }
        });
        jPanel2.add(txtNamaKitab, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, 360, 30));

        btnUbah.setBackground(new java.awt.Color(0, 0, 0));
        btnUbah.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnUbah.setForeground(new java.awt.Color(255, 255, 255));
        btnUbah.setText("Ubah");
        btnUbah.setContentAreaFilled(false);
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });
        jPanel2.add(btnUbah, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 470, 70, 40));

        jTextField4.setBorder(null);
        jPanel2.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 50, 300, 30));

        txtIdKitab.setBorder(null);
        txtIdKitab.setFocusable(false);
        txtIdKitab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdKitabActionPerformed(evt);
            }
        });
        jPanel2.add(txtIdKitab, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 370, 30));

        btnHapus.setBackground(new java.awt.Color(0, 0, 0));
        btnHapus.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnHapus.setForeground(new java.awt.Color(255, 255, 255));
        btnHapus.setText("Hapus");
        btnHapus.setContentAreaFilled(false);
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });
        jPanel2.add(btnHapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 470, 80, 40));

        btnTambah.setBackground(new java.awt.Color(0, 0, 0));
        btnTambah.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnTambah.setForeground(new java.awt.Color(255, 255, 255));
        btnTambah.setText("Tambah");
        btnTambah.setContentAreaFilled(false);
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });
        jPanel2.add(btnTambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 470, 90, 40));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setText("DATA KITAB");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 280, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("id_kitab");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, -1, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Nama Kitab");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, -1, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Kelas");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, 50, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Pengajar");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 380, -1, 30));

        cmbKelas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        cmbKelas.setBorder(null);
        jPanel2.add(cmbKelas, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, 370, 30));

        cmbPengajar.setBorder(null);
        jPanel2.add(cmbPengajar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 410, 360, 30));

        tblKitab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblKitab);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 130, -1, -1));

        btnReset1.setBackground(new java.awt.Color(0, 0, 0));
        btnReset1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnReset1.setForeground(new java.awt.Color(255, 255, 255));
        btnReset1.setText("Reset");
        btnReset1.setContentAreaFilled(false);
        btnReset1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReset1ActionPerformed(evt);
            }
        });
        jPanel2.add(btnReset1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 470, 80, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\ASUS\\Downloads\\Data_Kitab.png")); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        mainpanel.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        add(mainpanel, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_btnHapusActionPerformed

    private void txtIdKitabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdKitabActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtIdKitabActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        // 
         if (cmbKelas.getSelectedIndex() == 0 || cmbPengajar.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Pilih Kelas dan Pengajar terlebih dahulu!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String namaKitab = txtNamaKitab.getText();
        String namaKelas = cmbKelas.getSelectedItem().toString();
        String namaUstadz = cmbPengajar.getSelectedItem().toString();
        String kategoriKitab = jTextField4.getText(); // Asumsi jTextField4 adalah input Kategori Kitab

        if (namaKitab.isEmpty() || kategoriKitab.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nama Kitab dan Kategori harus diisi.", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        DataKitab dataKitab = new DataKitab();
        int idUstadz = -1;
        int idKelas = -1;
        
        try {
            ResultSet rsUstadz = dataKitab.konversiUstadzId(namaUstadz);
            if (rsUstadz != null && rsUstadz.next()) {
                idUstadz = rsUstadz.getInt("id_ustadz");
            }

           
            ResultSet rsKelas = dataKitab.konversiKelasId(namaKelas);
            if (rsKelas != null && rsKelas.next()) {
                idKelas = rsKelas.getInt("id_kelas");
            }
            
            if (idUstadz != -1 && idKelas != -1) {
                dataKitab.setNama_kitab(namaKitab);
                dataKitab.setUstadz_id(idUstadz);
                dataKitab.setKelas_id(idKelas);
                dataKitab.setKategori_kitab(kategoriKitab);
                
                dataKitab.saveData();
                
              
                load_table();
                resetForm();
            } else {
                JOptionPane.showMessageDialog(this, "Gagal menemukan ID Ustadz atau Kelas.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Kesalahan SQL saat menyimpan data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnTambahActionPerformed

    private void txtNamaKitabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaKitabActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaKitabActionPerformed

    private void btnReset1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReset1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnReset1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnReset1;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnUbah;
    private javax.swing.JComboBox<String> cmbKelas;
    private javax.swing.JComboBox<String> cmbPengajar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JPanel mainpanel;
    private javax.swing.JTable tblKitab;
    private javax.swing.JTextField txtIdKitab;
    private javax.swing.JTextField txtNamaKitab;
    // End of variables declaration//GEN-END:variables
}

