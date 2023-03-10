/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import static java.lang.Integer.parseInt;
import java.sql.*;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class FormKasir extends javax.swing.JInternalFrame {
    static Connection conn;
    static Statement stat = null;
    static ResultSet rset = null;
    static PreparedStatement pstat;
    static CallableStatement cstat;
    static String query;
    DefaultTableModel modelKas = new DefaultTableModel
    (new Object[] {"Id","Nama", "No HP"}, 0);
    
    
    public FormKasir() {
        initComponents();
        tbKasir.setModel(modelKas);
        koneksi();
        read();
        genNewId();
    }
    
    public void koneksi() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection
            ("jdbc:oracle:thin:@localhost:1521:XE", "BENGKEL", "BENGKEL");
            System.out.println("Koneksi database sukses");
        } catch (Exception ex) {
            System.out.println
            ("Terjadi kesalahan: " + ex.getMessage());
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        labelJudul = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        tfId = new javax.swing.JLabel();
        tfNama = new javax.swing.JTextField();
        tfNo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        reset = new javax.swing.JButton();
        tambah = new javax.swing.JButton();
        ubah = new javax.swing.JButton();
        hapus = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbKasir = new javax.swing.JTable();
        btCari = new javax.swing.JButton();
        tfCari = new javax.swing.JTextField();

        setClosable(true);

        labelJudul.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelJudul.setText("Master Kasir");

        jLabel1.setText("ID");

        tfId.setText("P000");

        jLabel3.setText("No. HP");

        jLabel2.setText("Nama");

        reset.setText("Reset");
        reset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resetMouseClicked(evt);
            }
        });

        tambah.setText("Tambah");
        tambah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tambahMouseClicked(evt);
            }
        });

        ubah.setText("Ubah");
        ubah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ubahMouseClicked(evt);
            }
        });

        hapus.setText("Hapus");
        hapus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hapusMouseClicked(evt);
            }
        });

        tbKasir.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nama", "No. HP", "Password", "Alamat"
            }
        ));
        tbKasir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbKasirMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbKasir);

        btCari.setText("Cari");
        btCari.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btCariMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelJudul)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfId)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(tfNama, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfNo, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(reset)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(tambah)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ubah)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(hapus)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tfCari, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btCari)
                .addGap(24, 24, 24))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelJudul)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfId))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reset)
                    .addComponent(tambah)
                    .addComponent(ubah)
                    .addComponent(hapus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCari)
                    .addComponent(tfCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Master Kasir", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCariMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btCariMouseClicked
        // TODO add your handling code here:
        read();
    }//GEN-LAST:event_btCariMouseClicked

    private void tbKasirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbKasirMouseClicked
        // TODO add your handling code here:
        int baris = tbKasir.getSelectedRow();
        String id = tbKasir.getModel().getValueAt(baris, 0).toString();
        String nama = tbKasir.getModel().getValueAt(baris, 1).toString();
        String nohp = tbKasir.getModel().getValueAt(baris, 2).toString();
        
        tfId.setText(id);
        tfNama.setText(nama);
        tfNo.setText(nohp);
    }//GEN-LAST:event_tbKasirMouseClicked

    private void hapusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hapusMouseClicked
        // TODO add your handling code here:
        try{
            query = "delete from kasir where id_kasir=?";
            pstat = conn.prepareStatement(query);
            pstat.setString(1, tfId.getText());

            int jum = pstat.executeUpdate();
            if (jum > 0) {
                JOptionPane.showMessageDialog(null, "Data kasir berhasil dihapus");
                reset();
            } else {
                JOptionPane.showMessageDialog(null, "Tdk ada data kasir yg dihapus");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Data gagal dihapus");
        }
        read();
        genNewId();
        reset();
    }//GEN-LAST:event_hapusMouseClicked

    private void ubahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ubahMouseClicked
        // TODO add your handling code here:
        try{
            query = "update kasir set nama_kasir=?, "
            + "no_hpkasir=? "
            + "where id_kasir=?";
            pstat = conn.prepareStatement(query);

            pstat.setString(3, tfId.getText());
            pstat.setString(1, tfNama.getText());
            pstat.setString(2, tfNo.getText());

            int jum = pstat.executeUpdate();
            if (jum > 0) {
                JOptionPane.showMessageDialog(null, "Data kasir berhasil diubah");
                reset();
            } else {
                JOptionPane.showMessageDialog(null, "Tdk ada data kasir yg diubah");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Data gagal diubah");
        }
        read();
        genNewId();
        reset();
    }//GEN-LAST:event_ubahMouseClicked

    private void tambahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tambahMouseClicked
        // TODO add your handling code here:
        try
        {
            query = "{call simpanKasir(?,?)}";
            pstat = conn.prepareStatement(query);

            pstat.setString(1, tfNama.getText());
            pstat.setString(2, tfNo.getText());

            int jum = pstat.executeUpdate();
            if (jum > 0) {
                JOptionPane.showMessageDialog(null, "Data kasir berhasil disimpan");
                reset();
            } else {
                JOptionPane.showMessageDialog(null, "Tdk ada data kasir yg disimpan");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Data gagal ditambahkan");
        }
        read();
        genNewId();
        reset();
    }//GEN-LAST:event_tambahMouseClicked

    private void resetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetMouseClicked
        // TODO add your handling code here:
        reset();
    }//GEN-LAST:event_resetMouseClicked
    
        void genNewId(){
        try {
            query = query = "select generateidkas() from dual";
            stat = conn.createStatement();
            rset = stat.executeQuery(query);
            
            while (rset.next()) { 
                String id = rset.getString(1);
                
                tfId.setText(id);
            }
        } catch(Exception e){
            System.out.println(e);
        }
    }
    
    void read() {
        try {
            query = "select * from kasir "
                    + "where lower(id_kasir) like '%" + tfCari.getText().toLowerCase()  + "%' or "
                    + "lower(nama_kasir) like '%" + tfCari.getText().toLowerCase() + "%' or "
                    + "lower(no_hpkasir) like '%" + tfCari.getText().toLowerCase() + "%' "
                    + "order by 1 desc";
            stat = conn.createStatement();
            rset = stat.executeQuery(query);
            modelKas.setRowCount(0); //clear data di jtable
            
            while (rset.next()) { //lopping selama ada baris data
                Vector data = new Vector();
                data.add(rset.getString(1));
                data.add(rset.getString(2));
                data.add(rset.getString(4));
                modelKas.addRow(data);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    void reset(){
        tfId.setText("");
        tfNama.setText("");
        tfNo.setText("");
        genNewId();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCari;
    private javax.swing.JButton hapus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel labelJudul;
    private javax.swing.JButton reset;
    private javax.swing.JButton tambah;
    private javax.swing.JTable tbKasir;
    private javax.swing.JTextField tfCari;
    private javax.swing.JLabel tfId;
    private javax.swing.JTextField tfNama;
    private javax.swing.JTextField tfNo;
    private javax.swing.JButton ubah;
    // End of variables declaration//GEN-END:variables
}
