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
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.sql.PreparedStatement;

/**
 *
 * @author IQBAL NOTEBOOK
 */
public class event extends javax.swing.JFrame {


    Connection cn = confestix.koneksi.Koneksi();
    ResultSet rs;
    Statement stm;
    DefaultTableModel tabModel;
    String sql;
    PreparedStatement ps;

    public void event() {
        Object[] judul = {
            "Ticket code", "Event", "Date", "price", "Total Ticket"
        };
        tabModel = new DefaultTableModel(null, judul);
        table_Event.setModel(tabModel);
    }

    public void showData(String where) {
        try {
            stm = cn.createStatement();

            tabModel.getDataVector().removeAllElements();
            tabModel.fireTableDataChanged();
            rs = stm.executeQuery("SELECT*FROM event" + where);
            while (rs.next()) {
                Object[] data = {
                    rs.getString("id"),
                    rs.getString("event_name"),
                    rs.getDate("event_date"),
                    rs.getString("price_ticket"),
                    rs.getString("total_ticket"),};
                tabModel.addRow(data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

     public void cleardata() {
     DefaultTableModel model = (DefaultTableModel) table_Event.getModel();
     model.setRowCount(0);
    }
    
    public void DoConnect() {
        try {
            stm = cn.createStatement();
            String sql = "select*from admin";
            rs = stm.executeQuery(sql);

            while (rs.next()) {
                int id_admin = rs.getInt("id");
                String id = Integer.toString(id_admin);

                tf_id.setText(id);
            }
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }

    }

    public void tgl() {
        Date date = new Date();
        SimpleDateFormat hari = new SimpleDateFormat("yyyy-MM-dd");
        tanggal.setText(hari.format(date));
    }

    public void clear() {
        tf_event.setText("");
        tanggal.setText("");
        tf_price.setText("");
        tf_total.setText("");
    }

    public event() {
        initComponents();
        event();
        showData("");
        DoConnect();
        tf_id.setEnabled(false);

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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tf_event = new javax.swing.JTextField();
        tanggal = new javax.swing.JTextField();
        tf_price = new javax.swing.JTextField();
        tf_total = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_Event = new javax.swing.JTable();
        save = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        edit = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        tf_id = new javax.swing.JTextField();
        refresh = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Enter Event :");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(24, 74, 64, 14);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Choose Date :");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(24, 128, 69, 14);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Price of Ticket :");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(24, 182, 74, 14);

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Enter Amount :");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(24, 236, 73, 14);

        tf_event.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(tf_event);
        tf_event.setBounds(24, 94, 200, 23);

        tanggal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tanggal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tanggalActionPerformed(evt);
            }
        });
        getContentPane().add(tanggal);
        tanggal.setBounds(24, 148, 200, 23);

        tf_price.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(tf_price);
        tf_price.setBounds(24, 202, 200, 23);

        tf_total.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(tf_total);
        tf_total.setBounds(24, 256, 73, 23);

        table_Event.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Ticket Code", "Event", "Date", "Price", "Total Ticket"
            }
        ));
        table_Event.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_EventMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_Event);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(240, 20, 452, 320);

        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        getContentPane().add(save);
        save.setBounds(20, 340, 67, 23);

        clear.setText("Clear");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });
        getContentPane().add(clear);
        clear.setBounds(170, 250, 57, 23);

        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        getContentPane().add(delete);
        delete.setBounds(140, 340, 71, 23);

        edit.setText("Update");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });
        getContentPane().add(edit);
        edit.setBounds(20, 390, 67, 23);

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("ID Admin :");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(24, 20, 50, 14);

        tf_id.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(tf_id);
        tf_id.setBounds(24, 40, 50, 23);

        refresh.setText("Refresh");
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });
        getContentPane().add(refresh);
        refresh.setBounds(140, 390, 71, 23);

        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\Mutiara\\Downloads\\confestix\\3.png")); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(0, 0, 710, 460);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        // TODO add your handling code here:
        try {
            String id = tf_id.getText();
            String tgl = tanggal.getText();
            stm = cn.createStatement();
            stm.executeUpdate("INSERT INTO event(id_admin,event_name,event_date,price_ticket,total_ticket) VALUES('" + id + "','" + tf_event.getText() + "','"
                    + tgl + "','" + tf_price.getText() + "','" + tf_total.getText() + "')");
            showData("");
            JOptionPane.showMessageDialog(null, "Simpan Berhasil");

            tf_event.setText("");
            tf_price.setText("");
            tf_total.setText("");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_saveActionPerformed

    private void tanggalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tanggalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tanggalActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_clearActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
        try {
            int jawab;

            if ((jawab = JOptionPane.showConfirmDialog(null, "Do you want delete data?", "confirm", JOptionPane.YES_NO_OPTION)) == 0) {
                stm = cn.createStatement();
                stm.executeUpdate("DELETE FROM event WHERE id ='" + tabModel.getValueAt(table_Event.getSelectedRow(), 0) + "'");
                showData("");
                clear();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        // TODO add your handling code here:
        try {
        sql = "UPDATE event SET  event_name= '"+ tf_event.getText()+"',"
            + "event_date = '"+tanggal.getText()+"',price_ticket = '"+tf_price.getText()+"'"
            + ",total_ticket = '"+tf_total.getText()+"' WHERE id = '"+tabModel.getValueAt(table_Event.getSelectedRow(), 0)+"' ";
           ps = cn.prepareStatement(sql);
           ps.execute();
           JOptionPane.showMessageDialog(null, "successful update data");
           
} catch (Exception e) {
    JOptionPane.showMessageDialog(null, "Failed update data" + e.getMessage());
}  

    }//GEN-LAST:event_editActionPerformed

    private void table_EventMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_EventMouseClicked
        // TODO add your handling code here:
        tf_event.setText(table_Event.getValueAt(table_Event.getSelectedRow(), 1).toString());
        tanggal.setText(table_Event.getValueAt(table_Event.getSelectedRow(), 2).toString());
        tf_price.setText(table_Event.getValueAt(table_Event.getSelectedRow(),3).toString());
        tf_total.setText(table_Event.getValueAt(table_Event.getSelectedRow(),4).toString());

    }//GEN-LAST:event_table_EventMouseClicked

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
        // TODO add your handling code here:
        cleardata();
        showData("");
    }//GEN-LAST:event_refreshActionPerformed

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
            java.util.logging.Logger.getLogger(event.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(event.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(event.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(event.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new event().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clear;
    private javax.swing.JButton delete;
    private javax.swing.JButton edit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton refresh;
    private javax.swing.JButton save;
    private javax.swing.JTable table_Event;
    private javax.swing.JTextField tanggal;
    private javax.swing.JTextField tf_event;
    private javax.swing.JTextField tf_id;
    private javax.swing.JTextField tf_price;
    private javax.swing.JTextField tf_total;
    // End of variables declaration//GEN-END:variables

}
