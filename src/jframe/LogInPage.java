/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jframe;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import javax.swing.border.MatteBorder;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author claud
 */
public class LogInPage extends javax.swing.JFrame {

    /**
     * Creates new form SignUpPage
     */
    public LogInPage() {
        initComponents();
        phone_icon.setVisible(false);
        label_email.setVisible(false);
        txt_contact.setVisible(false);

    }

    //validarea datelor 
    public boolean validateLogin() {

        String pwd = txt_password.getText();
        String email = txt_email.getText();
        String contact = txt_contact.getText();

        if (pwd.equals("")) {
            JOptionPane.showMessageDialog(this, "Nu ai introdus parola!");
            return false;
        }
        if (txt_email.isVisible() && email.equals("") || !email.matches("^(.+)@(.+)$") && !txt_contact.isVisible()) {
            JOptionPane.showMessageDialog(this, "Nu ai introdus un email valid!");
            return false;
        }
        if (txt_contact.isVisible() && contact.equals("") && !txt_email.isVisible()) {
            JOptionPane.showMessageDialog(this, "Nu ai introdus un numar de telefon!");
            return false;
        }

        return true;

    }

    //verificarea credentialelor
    public void login() {

        String pwd = txt_password.getText();
        String email = txt_email.getText();
        String contact = txt_contact.getText();
        String nume = null;

        try {
            Connection con = DBConnection.getConnection();
            if (txt_email.isVisible() && !txt_contact.isVisible()) {
                PreparedStatement pst = con.prepareStatement("select * from users where email = ? and password = ?");

                pst.setString(1, email);
                pst.setString(2, pwd);

                ResultSet rs = pst.executeQuery();
                if (rs.next()) {

                    JOptionPane.showMessageDialog(this, "Te-ai logat cu succes!");
                    HomePage home = new HomePage();
                    home.setVisible(true);
                    this.dispose();

                } else {
                    JOptionPane.showMessageDialog(this, "Email sau parola incorecte!");
                }
            } else {
                PreparedStatement pst = con.prepareStatement("select * from users where contact = ? and password = ?");

                pst.setString(1, contact);
                pst.setString(2, pwd);

                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(this, "Te-ai logat cu succes!");
                    HomePage home = new HomePage();
                    home.setVisible(true);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Numar de telefon sau parola incorecte!");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
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

        jPanel1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        email_icon = new javax.swing.JLabel();
        txt_email = new app.bolivia.swing.JCTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_password = new app.bolivia.swing.JCTextField();
        txt_contact = new app.bolivia.swing.JCTextField();
        phone_icon = new javax.swing.JLabel();
        rSMaterialButtonCircle2 = new rojerusan.RSMaterialButtonCircle();
        lable_exit = new javax.swing.JLabel();
        label_tel = new javax.swing.JLabel();
        label_login2 = new javax.swing.JLabel();
        label_email = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/background2.png"))); // NOI18N
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(-500, 0, 1100, 830));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 0, 495, 830));

        jPanel2.setBackground(new java.awt.Color(102, 102, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("LogIn Page");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, 140, 50));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Intra in cont");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 140, 50));

        email_icon.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        email_icon.setForeground(new java.awt.Color(255, 255, 255));
        email_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Secured_Letter_50px.png"))); // NOI18N
        jPanel2.add(email_icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, 50, 50));

        txt_email.setBackground(new java.awt.Color(102, 102, 255));
        txt_email.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_email.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_email.setPlaceholder("Email...");
        txt_email.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_emailMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txt_emailMouseExited(evt);
            }
        });
        txt_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_emailActionPerformed(evt);
            }
        });
        jPanel2.add(txt_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 280, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Secure_50px.png"))); // NOI18N
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 350, 50, 50));

        txt_password.setBackground(new java.awt.Color(102, 102, 255));
        txt_password.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_password.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_password.setPlaceholder("Parola...");
        txt_password.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_passwordMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txt_passwordMouseExited(evt);
            }
        });
        txt_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_passwordActionPerformed(evt);
            }
        });
        jPanel2.add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 360, -1, -1));

        txt_contact.setBackground(new java.awt.Color(102, 102, 255));
        txt_contact.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_contact.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_contact.setPlaceholder("Telefon...");
        txt_contact.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_contactMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txt_contactMouseExited(evt);
            }
        });
        txt_contact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_contactActionPerformed(evt);
            }
        });
        jPanel2.add(txt_contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 280, -1, -1));

        phone_icon.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        phone_icon.setForeground(new java.awt.Color(255, 255, 255));
        phone_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Google_Mobile_50px.png"))); // NOI18N
        jPanel2.add(phone_icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, 50, 50));

        rSMaterialButtonCircle2.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonCircle2.setText("Login");
        rSMaterialButtonCircle2.setActionCommand("Intra in cont");
        rSMaterialButtonCircle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle2ActionPerformed(evt);
            }
        });
        jPanel2.add(rSMaterialButtonCircle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 620, 250, 60));

        lable_exit.setBackground(new java.awt.Color(255, 255, 255));
        lable_exit.setFont(new java.awt.Font("Segoe UI", 1, 25)); // NOI18N
        lable_exit.setForeground(new java.awt.Color(255, 255, 255));
        lable_exit.setText("EXIT");
        lable_exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lable_exitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lable_exitMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lable_exitMousePressed(evt);
            }
        });
        jPanel2.add(lable_exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 740, 60, -1));

        label_tel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        label_tel.setForeground(new java.awt.Color(255, 255, 255));
        label_tel.setText("Logheaza-te cu nr. de telefon");
        label_tel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_telMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                label_telMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                label_telMouseExited(evt);
            }
        });
        jPanel2.add(label_tel, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 420, 260, 40));

        label_login2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        label_login2.setForeground(new java.awt.Color(255, 255, 255));
        label_login2.setText("Nu ai cont? Inregistreaza-te...");
        label_login2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_login2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                label_login2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                label_login2MouseExited(evt);
            }
        });
        jPanel2.add(label_login2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 680, 230, 30));

        label_email.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        label_email.setForeground(new java.awt.Color(255, 255, 255));
        label_email.setText("Logheaza-te cu adresa de email");
        label_email.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_emailMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                label_emailMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                label_emailMouseExited(evt);
            }
        });
        jPanel2.add(label_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 420, 260, 40));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, 530, 830));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/background1.png"))); // NOI18N
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 830));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 830));

        setSize(new java.awt.Dimension(1523, 828));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_emailActionPerformed

    private void txt_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_passwordActionPerformed

    private void txt_contactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_contactActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_contactActionPerformed

    private void rSMaterialButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2ActionPerformed
        if (validateLogin()) {
            login();
        }
    }//GEN-LAST:event_rSMaterialButtonCircle2ActionPerformed

    private void lable_exitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lable_exitMouseEntered
        lable_exit.setForeground(Color.red);
    }//GEN-LAST:event_lable_exitMouseEntered

    private void lable_exitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lable_exitMouseExited
        lable_exit.setForeground(Color.white);
    }//GEN-LAST:event_lable_exitMouseExited

    private void lable_exitMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lable_exitMousePressed

        System.exit(0);
    }//GEN-LAST:event_lable_exitMousePressed

    private void txt_emailMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_emailMouseEntered
        txt_email.setBorder(new MatteBorder(0, 0, 2, 0, Color.red));
    }//GEN-LAST:event_txt_emailMouseEntered

    private void txt_emailMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_emailMouseExited
        txt_email.setBorder(new MatteBorder(0, 0, 2, 0, Color.white));
    }//GEN-LAST:event_txt_emailMouseExited

    private void txt_passwordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_passwordMouseEntered
        txt_password.setBorder(new MatteBorder(0, 0, 2, 0, Color.red));
    }//GEN-LAST:event_txt_passwordMouseEntered

    private void txt_passwordMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_passwordMouseExited
        txt_password.setBorder(new MatteBorder(0, 0, 2, 0, Color.white));
    }//GEN-LAST:event_txt_passwordMouseExited

    private void txt_contactMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_contactMouseEntered
        txt_contact.setBorder(new MatteBorder(0, 0, 2, 0, Color.red));
    }//GEN-LAST:event_txt_contactMouseEntered

    private void txt_contactMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_contactMouseExited
        txt_contact.setBorder(new MatteBorder(0, 0, 2, 0, Color.white));
    }//GEN-LAST:event_txt_contactMouseExited

    private void label_telMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_telMouseClicked
        txt_email.setVisible(false);
        txt_contact.setVisible(true);
        email_icon.setVisible(false);
        phone_icon.setVisible(true);
        label_email.setVisible(true);
        label_tel.setVisible(false);
        txt_email.setText("");
    }//GEN-LAST:event_label_telMouseClicked

    private void label_telMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_telMouseEntered
        label_tel.setForeground(Color.red);
    }//GEN-LAST:event_label_telMouseEntered

    private void label_telMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_telMouseExited
        label_tel.setForeground(Color.white);
    }//GEN-LAST:event_label_telMouseExited

    private void label_login2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_login2MouseClicked
        label_login2.setForeground(Color.magenta);
        SignUpPage sign = new SignUpPage();
        sign.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_label_login2MouseClicked

    private void label_login2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_login2MouseEntered
        label_login2.setForeground(Color.red);
    }//GEN-LAST:event_label_login2MouseEntered

    private void label_login2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_login2MouseExited
        label_login2.setForeground(Color.white);
    }//GEN-LAST:event_label_login2MouseExited

    private void label_emailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_emailMouseClicked
        txt_email.setVisible(true);
        txt_contact.setVisible(false);
        email_icon.setVisible(true);
        phone_icon.setVisible(false);
        label_email.setVisible(false);
        label_tel.setVisible(true);
        txt_contact.setText("");
    }//GEN-LAST:event_label_emailMouseClicked

    private void label_emailMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_emailMouseEntered
        label_email.setForeground(Color.red);
    }//GEN-LAST:event_label_emailMouseEntered

    private void label_emailMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_emailMouseExited
        label_email.setForeground(Color.white);
    }//GEN-LAST:event_label_emailMouseExited

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
            java.util.logging.Logger.getLogger(LogInPage.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LogInPage.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LogInPage.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LogInPage.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LogInPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel email_icon;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel label_email;
    private javax.swing.JLabel label_login2;
    private javax.swing.JLabel label_tel;
    private javax.swing.JLabel lable_exit;
    private javax.swing.JLabel phone_icon;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle2;
    private app.bolivia.swing.JCTextField txt_contact;
    private app.bolivia.swing.JCTextField txt_email;
    private app.bolivia.swing.JCTextField txt_password;
    // End of variables declaration//GEN-END:variables
}