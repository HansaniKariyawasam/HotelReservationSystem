/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gdse41.sem1project.view.panels;

import edu.gdse41.sem1project.controller.ControllerFactory;
import edu.gdse41.sem1project.controller.custom.UserController;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import edu.gdse41.sem1project.dto.UsersDTO;
import edu.gdse41.sem1project.view.Admin;
import java.awt.Color;

/**
 *
 * @author Hansani Kariyawasam
 */
public class AddNewUser extends javax.swing.JPanel {
    
    private edu.gdse41.sem1project.controller.custom.UserController ctrlUser;

    /**
     * Creates new form AddNewUser
     */
    public AddNewUser() {
        initComponents();
        lblPasswordMassege.setVisible(false);
        ctrlUser=(UserController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.USER);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtPassword = new javax.swing.JPasswordField();
        lblPasswordMassege = new javax.swing.JLabel();
        txtConfirmPassword = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        CBAccountType = new javax.swing.JComboBox();
        txtUsername = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblCreateAccount = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1100, 620));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPasswordMouseClicked(evt);
            }
        });
        add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 170, 200, 30));

        lblPasswordMassege.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblPasswordMassege.setForeground(new java.awt.Color(255, 0, 0));
        lblPasswordMassege.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPasswordMassege.setText("The Password does not match....");
        add(lblPasswordMassege, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 300, 220, 30));
        add(txtConfirmPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 230, 200, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("New Account Type :");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, 200, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Confirm Password :");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 230, 190, 30));

        CBAccountType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "            ", "Administrator", "Receptionist" }));
        add(CBAccountType, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 30, 120, 30));
        add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 100, 200, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Password :");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 170, 200, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Username :");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 100, 200, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/gdse41/sem1project/resources/images/User.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 180, 180));

        lblCreateAccount.setBackground(new java.awt.Color(221, 188, 9));
        lblCreateAccount.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblCreateAccount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCreateAccount.setText("Create Account");
        lblCreateAccount.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblCreateAccount.setName("lblMain"); // NOI18N
        lblCreateAccount.setOpaque(true);
        lblCreateAccount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCreateAccountMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblCreateAccountMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblCreateAccountMouseExited(evt);
            }
        });
        add(lblCreateAccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 490, 130, 50));
    }// </editor-fold>//GEN-END:initComponents

    private void txtPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPasswordMouseClicked
        lblPasswordMassege.setVisible(false);
    }//GEN-LAST:event_txtPasswordMouseClicked

    private void lblCreateAccountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCreateAccountMouseClicked
        char ch1 []=txtPassword.getPassword();
        char ch2 []=txtConfirmPassword.getPassword();
        String passwrd="";
        for(int i=0;i<ch1.length;i++){
            passwrd+=ch1[i];
            if(ch1[i]!=ch2[i]){
                lblPasswordMassege.setVisible(true);
                return ;
            }
        }

        UsersDTO u1=new UsersDTO(txtUsername.getText(),passwrd,CBAccountType.getSelectedItem().toString());
        try {
            boolean rev=ctrlUser.add(u1);
            if(rev){
                int res=JOptionPane.showConfirmDialog(this,"Do you want to create this account?","Confirmation",JOptionPane.YES_NO_OPTION);
                if(res==0){
                    JOptionPane.showMessageDialog(this,"Account created");
                    /*this.dispose();
                    new Admin().setVisible(true);*/

                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(AddNewUser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddNewUser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(AddNewUser.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_lblCreateAccountMouseClicked

    private void lblCreateAccountMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCreateAccountMouseEntered
        lblCreateAccount.setBackground(new Color(255,162,0));
        lblCreateAccount.setOpaque(true);
    }//GEN-LAST:event_lblCreateAccountMouseEntered

    private void lblCreateAccountMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCreateAccountMouseExited
        lblCreateAccount.setBackground(new Color(221,188,9));
        lblCreateAccount.setOpaque(true);
    }//GEN-LAST:event_lblCreateAccountMouseExited

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        Admin.pnlViewReports.setVisible(false);
    }//GEN-LAST:event_formMouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        Admin.pnlViewReports.setVisible(false);
    }//GEN-LAST:event_jLabel3MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox CBAccountType;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel lblCreateAccount;
    private javax.swing.JLabel lblPasswordMassege;
    private javax.swing.JPasswordField txtConfirmPassword;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
