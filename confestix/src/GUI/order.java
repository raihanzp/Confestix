/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import Model.Modelprogram;
import Logic.Calculation;
import Logic.logic;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author IQBAL NOTEBOOK
 */
public class order extends javax.swing.JFrame {

    Modelprogram calculation = new Calculation();

    Connection cn = confestix.koneksi.Koneksi();
    ResultSet rs;
    Statement stm;
    PreparedStatement ps;
    static int x;

    public void tgl() {
        Date date = new Date();
        SimpleDateFormat hari = new SimpleDateFormat("yyyy-MM-dd");
        tanggal.setText(hari.format(date));
    }

    public void showCombo() {
        try {
            stm = cn.createStatement();
            String sql = "select event_name from event";
            rs = stm.executeQuery(sql);

            while (rs.next()) {
                Object[] ob = new Object[3];
                ob[0] = rs.getString(1);

                cb_event.addItem((String) ob[0]);
            }
            rs.close();
            stm.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void DoConnect() {
        try {
            stm = cn.createStatement();
            String sql = "select*from user";
            rs = stm.executeQuery(sql);

            while (rs.next()) {
                int id_user = rs.getInt("id_user");
                String name = rs.getString("name");
                String id = Integer.toString(id_user);

                tf_id.setText(id);
            }
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }

    }

    /**
     * Creates new form order
     */
    public order() {
        initComponents();
        showCombo();
        DoConnect();
        tf_id.setEnabled(false);
        tf_eventID.setEnabled(false);
        tanggal.setEnabled(false);
        tf_price.setEnabled(false);
        tf_stock.setEnabled(false);
        //tf_price.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cb_event = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        tf_amount = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tanggal = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        tf_total = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        tf_id = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tf_price = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tf_eventID = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tf_stock = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Choose The Event :");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(58, 106, 110, 15);

        cb_event.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cb_event.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Select one--" }));
        cb_event.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_eventActionPerformed(evt);
            }
        });
        getContentPane().add(cb_event);
        cb_event.setBounds(186, 103, 132, 21);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Amount of The Ticket :");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(37, 259, 131, 15);

        tf_amount.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(tf_amount);
        tf_amount.setBounds(186, 259, 93, 21);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Date of The Event :");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(57, 181, 111, 15);

        tanggal.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(tanggal);
        tanggal.setBounds(186, 181, 93, 21);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton1.setText("Calculated");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(186, 337, 87, 23);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Total Price :");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(102, 377, 66, 15);
        getContentPane().add(tf_total);
        tf_total.setBounds(186, 377, 93, 20);

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton2.setText("Submit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(186, 415, 93, 23);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("User ID :");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(120, 71, 48, 15);

        tf_id.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(tf_id);
        tf_id.setBounds(186, 68, 43, 21);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Price :");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(134, 301, 34, 15);

        tf_price.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(tf_price);
        tf_price.setBounds(186, 298, 93, 21);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Event ID :");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(112, 145, 56, 15);

        tf_eventID.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(tf_eventID);
        tf_eventID.setBounds(186, 142, 44, 21);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Ticket Stock :");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(91, 220, 77, 15);

        tf_stock.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(tf_stock);
        tf_stock.setBounds(186, 220, 93, 21);

        jButton3.setBackground(new java.awt.Color(204, 0, 0));
        jButton3.setText("Back");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(10, 470, 65, 23);

        jLabel9.setIcon(new javax.swing.ImageIcon("C:\\Users\\Mutiara\\Downloads\\confestix\\8.png")); // NOI18N
        getContentPane().add(jLabel9);
        jLabel9.setBounds(0, 0, 400, 510);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String enterAmount = tf_amount.getText();
        String enterPrice = tf_price.getText();
        int amount = Integer.parseInt(enterAmount);
        int price = Integer.parseInt(enterPrice);

        Modelprogram modelprogram = new Modelprogram();
        modelprogram.setTicketprice(price);
        modelprogram.setAmountticket(amount);
        logic lgc = new logic();

        String total = lgc.sum_Totalprice(modelprogram);
        tf_total.setText(total);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cb_eventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_eventActionPerformed
        // TODO add your handling code here:
        try {
            stm = cn.createStatement();
            String sql = "select * from event where event_name= '" + cb_event.getSelectedItem() + "'";
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                tf_eventID.setText(rs.getString("id"));
                tanggal.setText(rs.getString("event_date"));
                tf_price.setText(rs.getString("price_ticket"));
                tf_stock.setText(rs.getString("total_ticket"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "GAGAL");
        }
    }//GEN-LAST:event_cb_eventActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try {
            stm = cn.createStatement();
            stm.executeUpdate("INSERT INTO `ticketdetail` ( `id_user`, `id_event`,`ticket_amount`, `total_price`) VALUES('"
                    + tf_id.getText() + "','" + tf_eventID.getText() + "','" + tf_amount.getText() + "','" + tf_total.getText() + "')");
        } catch (Exception e) {
            e.printStackTrace();
        }

        int amount = Integer.parseInt(tf_amount.getText());
        int jum = Integer.parseInt(tf_stock.getText());
        int jumlah = jum - amount;
        if (jumlah < 0) {
            JOptionPane.showMessageDialog(this, "Ticket out of Stock");
        }
        try {
            String sql = "UPDATE event SET total_ticket='" + jumlah + "' WHERE id='" + tf_eventID.getText() + "'";
            ps = cn.prepareStatement(sql);
            ps.execute();
            
            receipt rcp = new receipt();
            setVisible(false);
            rcp.setVisible(true);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "ERROR " + e.getMessage());
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        login back = new login();
        back.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new order().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cb_event;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField tanggal;
    private javax.swing.JTextField tf_amount;
    private javax.swing.JTextField tf_eventID;
    private javax.swing.JTextField tf_id;
    private javax.swing.JTextField tf_price;
    private javax.swing.JTextField tf_stock;
    private javax.swing.JTextField tf_total;
    // End of variables declaration//GEN-END:variables
}
