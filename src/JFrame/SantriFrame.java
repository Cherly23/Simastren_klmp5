/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package JFrame;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import kelas.DataKelas;
import kelas.DataSantri;
/**
 *
 * @author cherly
 */
public class SantriFrame extends javax.swing.JPanel {

    /**
     * Creates new form SiswaFrame
     */
    public SantriFrame() {
        initComponents();
        JmlhSantri();
        load_table();
        ComboBox();
        reset();
//        autoID();
    }
    void reset() {
        txtIdsantri.setText(null);
        txtNamleng.setText(null);
        txtTempatLhir.setText(null);
        jTanggalLhir.setCalendar(null);
        txtAlamat.setText(null);
        buttonGroup1.clearSelection();
        txtWali1.setText(null);
        txtNoHp.setText(null);
        jTanggalMasuk.setCalendar(null);
        cbxKelas.setSelectedItem(null);
        cbxStatus.setSelectedItem(null);   

    }
    
//    void autoID() {
//        try {
//            DataSantri str = new DataSantri();
//            ResultSet rs = str.autoID();
//            
//            if (rs.next()) {
//                int id = rs.getInt("ID") + 1;
//                txtIdsantri.setText(String.valueOf(id));
//            }else {
//                txtIdsantri.setText("1");
//            }
//        } catch (SQLException sQLException) {
//            JOptionPane.showMessageDialog(null, "AutoId Eror : " + sQLException.getMessage());
//        }
//    }
    
    void ComboBox() {
        try {
            DataKelas value = new DataKelas();
            ResultSet rs = value.dataComboBox();
            
            while (rs.next()) {
                String data = rs.getString("nama_kelas");
                cbxKelas.addItem(data);
                
            }
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, " EROR ComboBox : " + sQLException.getMessage());
        }
    }
    
    private void JmlhSantri() {
    try {
        DataSantri snt = new DataSantri();

        // Ambil Putra
        ResultSet rsPutra = snt.JumlahPutra();
        int putra = 0;
        if (rsPutra.next()) {
            putra = rsPutra.getInt("jumlahPutra");
        }

        // Ambil Putri
        ResultSet rsPutri = snt.JumlahPutri();
        int putri = 0;
        if (rsPutri.next()) {
            putri = rsPutri.getInt("jumlahPutri");
        }

        // Set ke label
        jmlhSantriPutri.setText(String.valueOf(putri));
        jmlhSantriPutra.setText(String.valueOf(putra));

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "EROR : " + e.getMessage());
    }
    
}
    
    private void pencarian(String key) {
    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("ID Santri");
    model.addColumn("Nama");
    model.addColumn("Tempat Lahir");
    model.addColumn("Tanggal Lahir");
    model.addColumn("Alamat");
    model.addColumn("Gender");
    model.addColumn("Wali Santri");
    model.addColumn("No HP");
    model.addColumn("Tanggal Masuk");
    model.addColumn("Kelas");
    model.addColumn("Status");

    try {
        DataSantri snr = new DataSantri();
        ResultSet result = snr.cariSantri (key);

        while (result.next()) {
            String status = (result.getInt("status") == 1) ? "Mukim" : "Tidak Mukim";
            model.addRow(new Object[]{
                result.getInt("id_santri"),
                result.getString("nama_santri"),
                result.getString("tempat_lahir"),
                result.getString("tanggal_lahir"),
                result.getString("alamat"),
                result.getString("jenis_kelamin"),
                result.getString("wali_santri"),
                result.getString("no_hp"),
                result.getString("tanggal_masuk"),
                result.getString("nama_kelas"),
                status
            });
        }

        tblSantri.setModel(model);
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error saat mencari: " + e.getMessage());
    }
}
    void load_table() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Santri");
        model.addColumn("Nama");
        model.addColumn("Tempat Lahir");
        model.addColumn("Tanggal Lahir");
        model.addColumn("Alamat");
        model.addColumn("Gender"); 
        model.addColumn("Wali Santri");
        model.addColumn("No HP");
        model.addColumn("Tanggal Masuk");
        model.addColumn("Kelas");
        model.addColumn("Status");
        
        try {
            DataSantri snr = new DataSantri();
            ResultSet result = snr.TampilSantri();
            while (result.next()){
                String status = (result.getInt("status") == 1) ? "Mukim" : "Tidak Mukim";
                model.addRow(new Object[]{
                    result.getInt("id_santri"),
                    result.getString("nama_santri"),
                    result.getString("tempat_lahir"),
                    result.getString("tanggal_lahir"),
                    result.getString("alamat"),
                    result.getString("jenis_kelamin"),
                    result.getString("wali_santri"),
                    result.getString("no_hp"),
                    result.getString("tanggal_masuk"),
                    result.getString("nama_kelas"),
                    status
                });
            }
            tblSantri.setModel(model);
        } catch (SQLException sQLException) {
            System.out.println("Eror Tabel : " + sQLException.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        MainPanel = new javax.swing.JPanel();
        DataSantri = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        btnHapus = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnTambah = new javax.swing.JLabel();
        btnUbah = new javax.swing.JLabel();
        jmlhSantriPutra = new javax.swing.JLabel();
        jmlhSantriPutri = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSantri = new javax.swing.JTable();
        Baground = new javax.swing.JLabel();
        InputSantri = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        cbxStatus = new javax.swing.JComboBox<>();
        cbxKelas = new javax.swing.JComboBox<>();
        btnSimpan = new javax.swing.JLabel();
        txtNoHp = new javax.swing.JTextField();
        txtIdsantri = new javax.swing.JTextField();
        txtNamleng = new javax.swing.JTextField();
        txtTempatLhir = new javax.swing.JTextField();
        txtAlamat = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        btnBatal = new javax.swing.JLabel();
        btnReset = new javax.swing.JLabel();
        txtWali1 = new javax.swing.JTextField();
        Jrperempuan = new javax.swing.JRadioButton();
        JrLaki = new javax.swing.JRadioButton();
        jTanggalMasuk = new com.toedter.calendar.JDateChooser();
        jTanggalLhir = new com.toedter.calendar.JDateChooser();
        baground = new javax.swing.JLabel();

        setLayout(new java.awt.CardLayout());

        MainPanel.setLayout(new java.awt.CardLayout());

        DataSantri.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(11, 43, 38));
        jLabel6.setText("DATA SANTRI");
        DataSantri.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 300, 50));

        btnHapus.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnHapus.setForeground(new java.awt.Color(255, 255, 255));
        btnHapus.setText("   Hapus");
        btnHapus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHapusMouseClicked(evt);
            }
        });
        DataSantri.add(btnHapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 250, 80, 40));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(11, 43, 38));
        jLabel8.setText("Santri Putri");
        DataSantri.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 130, 50));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(11, 43, 38));
        jLabel9.setText("Santri Putra");
        DataSantri.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 130, 130, 50));

        btnTambah.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnTambah.setForeground(new java.awt.Color(255, 255, 255));
        btnTambah.setText("  Tambah");
        btnTambah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTambahMouseClicked(evt);
            }
        });
        DataSantri.add(btnTambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 130, 80, 50));

        btnUbah.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnUbah.setForeground(new java.awt.Color(255, 255, 255));
        btnUbah.setText("    Ubah");
        btnUbah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUbahMouseClicked(evt);
            }
        });
        DataSantri.add(btnUbah, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 190, 80, 50));

        jmlhSantriPutra.setFont(new java.awt.Font("SansSerif", 1, 48)); // NOI18N
        jmlhSantriPutra.setForeground(new java.awt.Color(11, 43, 38));
        jmlhSantriPutra.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jmlhSantriPutra.setText("56");
        DataSantri.add(jmlhSantriPutra, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 190, 120, 50));

        jmlhSantriPutri.setFont(new java.awt.Font("SansSerif", 1, 48)); // NOI18N
        jmlhSantriPutri.setForeground(new java.awt.Color(11, 43, 38));
        jmlhSantriPutri.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jmlhSantriPutri.setText("56");
        DataSantri.add(jmlhSantriPutri, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 120, 50));

        txtSearch.setBorder(null);
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSearchKeyTyped(evt);
            }
        });
        DataSantri.add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 62, 320, 30));

        tblSantri.setModel(new javax.swing.table.DefaultTableModel(
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
        tblSantri.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSantriMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSantri);

        DataSantri.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 1030, 310));

        Baground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Data_Santri_Mentahan.png"))); // NOI18N
        DataSantri.add(Baground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1064, 655));

        MainPanel.add(DataSantri, "card2");

        InputSantri.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(11, 43, 38));
        jLabel12.setText(" Jenis Kelamin");
        InputSantri.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 450, 130, 30));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(11, 43, 38));
        jLabel14.setText("Id santri");
        InputSantri.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 80, 30));

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(11, 43, 38));
        jLabel15.setText(" Nama Lengkap");
        InputSantri.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 130, 30));

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(11, 43, 38));
        jLabel17.setText(" Kelas");
        InputSantri.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 440, 80, 40));

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(11, 43, 38));
        jLabel16.setText(" Tanggal lahir");
        InputSantri.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, 130, 40));

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(11, 43, 38));
        jLabel18.setText(" Tempat Lahir");
        InputSantri.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 280, 130, 40));

        jLabel19.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(11, 43, 38));
        jLabel19.setText(" Wali Santri");
        InputSantri.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 110, 130, 30));

        jLabel20.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(11, 43, 38));
        jLabel20.setText(" No.HP");
        InputSantri.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 200, 130, 30));

        jLabel21.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(11, 43, 38));
        jLabel21.setText(" Tanggal Masuk");
        InputSantri.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 280, 130, 30));

        jLabel22.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(11, 43, 38));
        jLabel22.setText(" Alamat");
        InputSantri.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 360, 120, 40));

        cbxStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mukim", "Tidak Mukim" }));
        cbxStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxStatusActionPerformed(evt);
            }
        });
        InputSantri.add(cbxStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 408, 350, -1));

        InputSantri.add(cbxKelas, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 488, 350, -1));

        btnSimpan.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnSimpan.setForeground(new java.awt.Color(255, 255, 255));
        btnSimpan.setText("Simpan");
        btnSimpan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSimpanMouseClicked(evt);
            }
        });
        InputSantri.add(btnSimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 580, 60, 50));

        txtNoHp.setBorder(null);
        txtNoHp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNoHpActionPerformed(evt);
            }
        });
        InputSantri.add(txtNoHp, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 240, 350, 20));

        txtIdsantri.setBorder(null);
        InputSantri.add(txtIdsantri, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, 140, 30));

        txtNamleng.setBorder(null);
        txtNamleng.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamlengActionPerformed(evt);
            }
        });
        InputSantri.add(txtNamleng, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 158, 350, 20));

        txtTempatLhir.setBorder(null);
        txtTempatLhir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTempatLhirActionPerformed(evt);
            }
        });
        InputSantri.add(txtTempatLhir, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 320, 350, 30));

        txtAlamat.setBorder(null);
        txtAlamat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAlamatActionPerformed(evt);
            }
        });
        InputSantri.add(txtAlamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 406, 350, 20));

        jLabel24.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(11, 43, 38));
        jLabel24.setText(" Status Santri");
        InputSantri.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 360, 130, 40));

        btnBatal.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnBatal.setForeground(new java.awt.Color(255, 255, 255));
        btnBatal.setText("   Batal");
        btnBatal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBatalMouseClicked(evt);
            }
        });
        InputSantri.add(btnBatal, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 580, 70, 50));

        btnReset.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnReset.setForeground(new java.awt.Color(255, 255, 255));
        btnReset.setText("   Reset");
        btnReset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnResetMouseClicked(evt);
            }
        });
        InputSantri.add(btnReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 580, 80, 50));

        txtWali1.setBorder(null);
        txtWali1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtWali1ActionPerformed(evt);
            }
        });
        InputSantri.add(txtWali1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 159, 350, 20));

        buttonGroup1.add(Jrperempuan);
        Jrperempuan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Jrperempuan.setText("Perempuan");
        InputSantri.add(Jrperempuan, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 500, -1, -1));

        buttonGroup1.add(JrLaki);
        JrLaki.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        JrLaki.setText("Laki-laki");
        InputSantri.add(JrLaki, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 500, -1, -1));
        InputSantri.add(jTanggalMasuk, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 310, 370, 40));
        InputSantri.add(jTanggalLhir, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, 370, 40));

        baground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Data Input Santri (2).png"))); // NOI18N
        InputSantri.add(baground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1070, 660));

        MainPanel.add(InputSantri, "card3");

        add(MainPanel, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void txtNoHpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNoHpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNoHpActionPerformed

    private void txtNamlengActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamlengActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamlengActionPerformed

    private void txtTempatLhirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTempatLhirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTempatLhirActionPerformed

    private void txtAlamatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAlamatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAlamatActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void txtWali1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtWali1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtWali1ActionPerformed

    private void btnBatalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBatalMouseClicked
        // TODO add your handling code here:
       MainPanel.removeAll();
       MainPanel.add(DataSantri);
       MainPanel.repaint();
       MainPanel.revalidate();
    }//GEN-LAST:event_btnBatalMouseClicked

    private void btnResetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResetMouseClicked
        // TODO add your handling code here:
        reset();
    }//GEN-LAST:event_btnResetMouseClicked

    private void btnSimpanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSimpanMouseClicked
        // TODO add your handling code here:
        DataSantri str = new DataSantri();
        DataKelas kls = new DataKelas();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    try {
        str.setNama_santri(txtNamleng.getText());
        str.setTempat_lahir(txtTempatLhir.getText());
        str.setTanggal_lahir(sdf.format(jTanggalLhir.getDate()));
        str.setAlamat(txtAlamat.getText());

        // Gender
        if (JrLaki.isSelected()) {
            str.setJenis_kelamin("Laki-laki");
        } else if (Jrperempuan.isSelected()) {
            str.setJenis_kelamin("Perempuan");
        }

        str.setWali_santri(txtWali1.getText());
        str.setNo_hp(txtNoHp.getText());
        str.setTanggal_masuk(sdf.format(jTanggalMasuk.getDate())); 

//        // ====== KONVERSI KELAS ======
        kls.setNama_kelas(cbxKelas.getSelectedItem().toString());
        ResultSet rs = kls.konversi();

        if (rs.next()) {
            str.setKelas_id(rs.getInt("id_kelas"));
        } else {
            JOptionPane.showMessageDialog(null, "Kelas tidak ditemukan!");
            return;
        }

        // Status
        str.setStatus(cbxStatus.getSelectedItem().equals("Mukim") ? 1 : 0);
        
       // ================= INSERT / UPDATE =================
        if (txtIdsantri.getText().trim().isEmpty()) { 
            str.TambahSantri();  // INSERT
            JOptionPane.showMessageDialog(null, "Data berhasil ditambah");
        } else {
            str.setId_santri(Integer.parseInt(txtIdsantri.getText()));   
            str.UbahSantri();   // UPDATE
            JOptionPane.showMessageDialog(null, "Data berhasil diperbarui");
        }
        
    } catch (SQLException sQLException) {
        JOptionPane.showMessageDialog(null, "Eror Simpan : " + sQLException.getMessage());
    }
 
    
    load_table();
    reset();

    MainPanel.removeAll();
    MainPanel.add(DataSantri);
    MainPanel.repaint();
    MainPanel.revalidate();
    
    }//GEN-LAST:event_btnSimpanMouseClicked

    private void btnUbahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUbahMouseClicked
        // TODO add your handling code here:
        int row = tblSantri.getSelectedRow();

        if (row == -1) {
            JOptionPane.showMessageDialog(null, "Pilih dulu data di tabel!");
            return;
        }

        // Ambil ID Santri yang dipilih
        String idStr = tblSantri.getValueAt(row, 0).toString();
        int id = Integer.parseInt(idStr);

        try {
            // Ambil data lengkap dari database
            DataSantri str = new DataSantri();
            ResultSet rs = str.DetailSantri(id);  // Anda pastikan method ini ada

            if (rs.next()) {

                // Isi form
                txtIdsantri.setText(rs.getString("id_santri"));
                txtNamleng.setText(rs.getString("nama_santri"));
                txtTempatLhir.setText(rs.getString("tempat_lahir"));
                txtAlamat.setText(rs.getString("alamat"));
                txtWali1.setText(rs.getString("wali_santri"));
                txtNoHp.setText(rs.getString("no_hp"));

                // tanggal lahir
                java.util.Date tglLahir = new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString("tanggal_lahir"));
                jTanggalLhir.setDate(tglLahir);

                // tanggal masuk
                java.util.Date tglMasuk = new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString("tanggal_masuk"));
                jTanggalMasuk.setDate(tglMasuk);

                // Jenis Kelamin
                String gender = rs.getString("jenis_kelamin");
                if (gender.equals("Laki-laki")) JrLaki.setSelected(true);
                else Jrperempuan.setSelected(true);

                // ComboBox
                cbxKelas.setSelectedItem(rs.getString("nama_kelas"));
                cbxStatus.setSelectedItem(rs.getInt("status") == 1 ? "Mukim" : "Tidak Mukim");
            }

        } catch (SQLException | ParseException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
            // Pastikan InputSantriFrame punya constructor (int id)
            MainPanel.removeAll();
            MainPanel.add(InputSantri);
            MainPanel.repaint();
            MainPanel.revalidate();   

    }//GEN-LAST:event_btnUbahMouseClicked

    private void btnTambahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTambahMouseClicked
        // TODO add your handling code here:
        MainPanel.removeAll();
        MainPanel.add(InputSantri);
        MainPanel.repaint();
        MainPanel.revalidate(); 
    }//GEN-LAST:event_btnTambahMouseClicked

    private void btnHapusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHapusMouseClicked
        // TODO add your handling code here:
        DataSantri str = new DataSantri();
        int baris = tblSantri.getSelectedRow();
        String idStr = tblSantri.getValueAt(baris, 0).toString();
        int id = Integer.parseInt(idStr);
        str.setId_santri(id);
        str.HapusSantri();
        load_table();
        reset();
    }//GEN-LAST:event_btnHapusMouseClicked

    private void tblSantriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSantriMouseClicked
        // TODO add your handling code here:
        int row = tblSantri.getSelectedRow();
        
        if (row != -1) {

            String id        = tblSantri.getValueAt(row, 0).toString();
            String nama      = tblSantri.getValueAt(row, 1).toString();
            String tmptLahir = tblSantri.getValueAt(row, 2).toString();
            String tglLahir  = tblSantri.getValueAt(row, 3).toString();
            String alamat    = tblSantri.getValueAt(row, 4).toString();
            String gender    = tblSantri.getValueAt(row, 5).toString();
            String wali      = tblSantri.getValueAt(row, 6).toString();
            String NoHp      = tblSantri.getValueAt(row, 7).toString();
            String tglMasuk  = tblSantri.getValueAt(row, 8).toString();
            String kelas     = tblSantri.getValueAt(row, 9).toString();
            String status    = tblSantri.getValueAt(row, 10).toString();

            

            txtIdsantri.setText(id);
            txtNamleng.setText(nama);
            txtTempatLhir.setText(tmptLahir);
            jTanggalLhir.setDate(java.sql.Date.valueOf(tglLahir));
            jTanggalMasuk.setDate(java.sql.Date.valueOf(tglMasuk));
            txtAlamat.setText(alamat);            
            JrLaki.setSelected(gender.equals("Laki-laki"));
            Jrperempuan.setSelected(gender.equals("Perempuan"));
            txtWali1.setText(wali);
            txtNoHp.setText(NoHp);
            cbxKelas.setSelectedItem(kelas);
            cbxStatus.setSelectedItem(status);
        
    }                        
    }//GEN-LAST:event_tblSantriMouseClicked

    private void txtSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyTyped
        // TODO add your handling code here:
        String key = txtSearch.getText();
        pencarian(key);
    }//GEN-LAST:event_txtSearchKeyTyped

    private void cbxStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxStatusActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Baground;
    private javax.swing.JPanel DataSantri;
    private javax.swing.JPanel InputSantri;
    private javax.swing.JRadioButton JrLaki;
    private javax.swing.JRadioButton Jrperempuan;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JLabel baground;
    private javax.swing.JLabel btnBatal;
    private javax.swing.JLabel btnHapus;
    private javax.swing.JLabel btnReset;
    private javax.swing.JLabel btnSimpan;
    private javax.swing.JLabel btnTambah;
    private javax.swing.JLabel btnUbah;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbxKelas;
    private javax.swing.JComboBox<String> cbxStatus;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jTanggalLhir;
    private com.toedter.calendar.JDateChooser jTanggalMasuk;
    private javax.swing.JLabel jmlhSantriPutra;
    private javax.swing.JLabel jmlhSantriPutri;
    private javax.swing.JTable tblSantri;
    private javax.swing.JTextField txtAlamat;
    private javax.swing.JTextField txtIdsantri;
    private javax.swing.JTextField txtNamleng;
    private javax.swing.JTextField txtNoHp;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTempatLhir;
    private javax.swing.JTextField txtWali1;
    // End of variables declaration//GEN-END:variables
}
