/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import GUI.login;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
/**
 *
 * @author IQBAL NOTEBOOK
 */
public class adminRegist extends javax.swing.JFrame {
    Connection cn = confestix.koneksi.Koneksi();
    ResultSet rs;
    Statement stm;
    
public void bersih() {
        tf_name.setText("");
        tf_username.setText("");
        tf_password.setText("");
    }
    /**
     * Creates new form adminRegist
     */
    public adminRegist() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tf_name = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        tf_username = new javax.swing.JTextField();
        tf_password = new javax.swing.JPasswordField();
        regist = new javax.swing.JButton();
        back = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        tf_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_name.setForeground(new java.awt.Color(255, 255, 255));
        tf_name.setText("Name :");
        getContentPane().add(tf_name);
        tf_name.setBounds(45, 110, 44, 17);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Username :");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(45, 151, 70, 17);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Password :");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(45, 195, 67, 17);

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(jTextField1);
        jTextField1.setBounds(152, 107, 223, 23);

        tf_username.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(tf_username);
        tf_username.setBounds(152, 148, 223, 23);

        tf_password.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_passwordActionPerformed(evt);
            }
        });
        getContentPane().add(tf_password);
        tf_password.setBounds(152, 192, 223, 23);

        regist.setText("Regist");
        regist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registActionPerformed(evt);
            }
        });
        getContentPane().add(regist);
        regist.setBounds(290, 248, 75, 23);

        back.setBackground(new java.awt.Color(204, 0, 0));
        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        getContentPane().add(back);
        back.setBounds(29, 248, 55, 23);

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Mutiara\\Downloads\\confestix\\2.png")); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 420, 300);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_passwordActionPerformed

    private void registActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registActionPerformed
        // TODO add your handling code here:
         try {
            stm = cn.createStatement();
            stm.executeUpdate("INSERT INTO `admin` ( `username`, `password`, `nama_admin`) VALUES('"  
                    +tf_username.getText() + "','" + tf_password.getText()+ "','" + tf_name.getText()+ "')"
            );

            bersih();


            JOptionPane.showMessageDialog(null, "Registration succesfull");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error" + e.getMessage());
            bersih();
        }
    }//GEN-LAST:event_registActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
            adminLogin lgn = new adminLogin();
            setVisible(false);
            lgn.setVisible(true);
    }//GEN-LAST:event_backActionPerformed

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
            java.util.logging.Logger.getLogger(adminRegist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(adminRegist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(adminRegist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(adminRegist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new adminRegist().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton regist;
    private javax.swing.JLabel tf_name;
    private javax.swing.JPasswordField tf_password;
    private javax.swing.JTextField tf_username;
    // End of variables declaration//GEN-END:variables
}
