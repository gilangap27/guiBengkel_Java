
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class FormBarang extends javax.swing.JInternalFrame {
    static Connection conn;
    static Statement stat = null;
    static ResultSet rset = null;
    static PreparedStatement pstat;
    static CallableStatement cstat;
    static String query;
    
    public FormBarang() {
        initComponents();
        koneksi();
        isiMerk();
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
        btCetak = new javax.swing.JButton();
        cbMerk = new javax.swing.JComboBox<>();

        setClosable(true);

        labelJudul.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelJudul.setText("Laporan Barang");

        btCetak.setText("Cetak");
        btCetak.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btCetakMouseClicked(evt);
            }
        });

        cbMerk.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelJudul, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbMerk, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(11, 11, 11)
                .addComponent(btCetak)
                .addContainerGap(292, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelJudul)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCetak)
                    .addComponent(cbMerk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(371, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Barang", jPanel1);

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

    private void btCetakMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btCetakMouseClicked
        // TODO add your handling code here:
        try {
            Map <String, Object> mapParam = new HashMap<String, Object>();
            mapParam.put("merk", cbMerk.getSelectedItem());
            
            JasperPrint jp = JasperFillManager.fillReport
            (getClass().getResourceAsStream("laporanBarang.jasper"), mapParam, conn);
            JasperViewer.viewReport(jp, false);
        } catch (Exception e){
            System.out.println(e);
        }
    }//GEN-LAST:event_btCetakMouseClicked

    void isiMerk() {
        try {
            query = "select DISTINCT merk_sukucadang from suku_cadang";
            stat = conn.createStatement();
            rset = stat.executeQuery(query);
            cbMerk.removeAllItems(); //clear data di combo
            
            cbMerk.addItem("==Merk==");
            while (rset.next()) { //lopping selama ada baris data
                cbMerk.addItem (rset.getString(1));
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCetak;
    private javax.swing.JComboBox<String> cbMerk;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel labelJudul;
    // End of variables declaration//GEN-END:variables
}
