/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gdse41.sem1project.view;

import edu.gdse41.sem1project.backup.BackUp;
import edu.gdse41.sem1project.dao.db.ConnectionFactory;
import edu.gdse41.sem1project.view.panels.AdminPaymentDetails;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import edu.gdse41.sem1project.view.panels.titles.AddNewUserTitle;
import edu.gdse41.sem1project.view.panels.titles.ManageRmsTitle;
import edu.gdse41.sem1project.view.panels.titles.PaymentDetlsTitle;
import edu.gdse41.sem1project.view.panels.titles.ViewGuestHstryTitle;
import edu.gdse41.sem1project.view.panels.titles.ViewResTitle;
import java.awt.Color;
import java.awt.KeyEventPostProcessor;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 *
 * @author Hansani Kariyawasam
 */
public class Admin extends javax.swing.JFrame {

    /**
     * Creates new form Admin
     */
    private Timer timer;
    private final SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss");
    Connection conn=ConnectionFactory.getInstance().getConnection();
    
    public Admin() {
        initComponents();
        loadPanels(new edu.gdse41.sem1project.view.panels.AddRoom());
        loadTitles(new ManageRmsTitle());
        pnlViewReports.setVisible(false);
        
        KeyboardFocusManager kfm=KeyboardFocusManager.getCurrentKeyboardFocusManager();
        kfm.addKeyEventPostProcessor(new KeyEventPostProcessor() {

            @Override
            public boolean postProcessKeyEvent(KeyEvent e) {
                switch(e.getKeyCode()){
                    case KeyEvent.VK_F1:
                        if(e.getID()==KeyEvent.KEY_PRESSED){
                            
                            loadPanels(new edu.gdse41.sem1project.view.panels.AddRoom());
                            loadTitles(new ManageRmsTitle());
                            
                        }
                        break;
                    case KeyEvent.VK_F2:
                        if(e.getID()==KeyEvent.KEY_PRESSED){
                            
                            loadPanels(new edu.gdse41.sem1project.view.panels.AddNewUser());
                            loadTitles(new AddNewUserTitle());
                            
                        }
                        break;
                    case KeyEvent.VK_F3:
                        if(e.getID()==KeyEvent.KEY_PRESSED){
                            
                            loadPanels(new edu.gdse41.sem1project.view.panels.AdminViewReservation());
                            loadTitles(new ViewResTitle());
                            
                        }
                        break;
                    case KeyEvent.VK_F4:
                        if(e.getID()==KeyEvent.KEY_PRESSED){
                            
                            try {
                                JasperReport compiledReport=(JasperReport) JRLoader.loadObject(Reception.class.getResourceAsStream("/edu/gdse41/sem1project/reports/Birthday Greetings.jasper"));
                                JasperPrint filledReport=JasperFillManager.fillReport(compiledReport, new HashMap<>(), conn);
                                JasperReportViewer jasperViewer=new JasperReportViewer(filledReport);
                                jasperViewer.setVisible(true);
                                jasperViewer.setTitle("Guests' Birthdays Details");
                            } catch (JRException ex) {
                                Logger.getLogger(Reception.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                        }
                        break;
                    case KeyEvent.VK_F5:
                        if(e.getID()==KeyEvent.KEY_PRESSED){
                            
                            loadPanels(new edu.gdse41.sem1project.view.panels.AdminViewGuestHistory());
                            loadTitles(new ViewGuestHstryTitle());
                            
                        }
                        break;
                        
                    case KeyEvent.VK_F6:
                        if(e.getID()==KeyEvent.KEY_PRESSED){
                            
                            loadPanels(new AdminPaymentDetails());
                            loadTitles(new PaymentDetlsTitle());
                            
                        }
                }
                return true;
            }
        });
    }
    
    private void loadPanels(JPanel panel){
        pnlMain.removeAll();
        pnlMain.revalidate();
        pnlMain.add(panel);
        
    }
    
    private void loadTitles(JPanel panel){
        pnltitle.removeAll();
        pnltitle.revalidate();
        pnltitle.add(panel);
        
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
        lblClose = new javax.swing.JLabel();
        lblMinimize = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblAddUser1 = new javax.swing.JLabel();
        lblAddRoom1 = new javax.swing.JLabel();
        lblViewRes1 = new javax.swing.JLabel();
        lblViewPayment = new javax.swing.JLabel();
        lblGuestHistory = new javax.swing.JLabel();
        lblLogOut = new javax.swing.JLabel();
        lblViewReports = new javax.swing.JLabel();
        lblRestore = new javax.swing.JLabel();
        lblBackUp = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pnlViewReports = new javax.swing.JPanel();
        lblGuestDetails = new javax.swing.JLabel();
        lblBdys = new javax.swing.JLabel();
        lblRes = new javax.swing.JLabel();
        lblResDetails = new javax.swing.JLabel();
        lblMonthlyIncome = new javax.swing.JLabel();
        lblAnnualIncome = new javax.swing.JLabel();
        pnlMain = new javax.swing.JPanel();
        pnltitle = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/gdse41/sem1project/resources/images/Untitled-4.png"))); // NOI18N
        lblClose.setToolTipText("Close ");
        lblClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCloseMouseClicked(evt);
            }
        });
        jPanel1.add(lblClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(1340, 0, 20, 30));

        lblMinimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/gdse41/sem1project/resources/images/Untitled-4_1.png"))); // NOI18N
        lblMinimize.setToolTipText("Minimize");
        lblMinimize.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblMinimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMinimizeMouseClicked(evt);
            }
        });
        jPanel1.add(lblMinimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 0, 20, 30));

        jPanel2.setBackground(new java.awt.Color(221, 188, 9));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblAddUser1.setBackground(new java.awt.Color(221, 188, 9));
        lblAddUser1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lblAddUser1.setText(" [F2]  Add a User");
        lblAddUser1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblAddUser1.setName("lblMain"); // NOI18N
        lblAddUser1.setOpaque(true);
        lblAddUser1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAddUser1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblAddUser1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblAddUser1MouseExited(evt);
            }
        });
        jPanel2.add(lblAddUser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 250, 60));

        lblAddRoom1.setBackground(new java.awt.Color(221, 188, 9));
        lblAddRoom1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lblAddRoom1.setText(" [F1]  Manage Rooms");
        lblAddRoom1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblAddRoom1.setName("lblMain"); // NOI18N
        lblAddRoom1.setOpaque(true);
        lblAddRoom1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                lblAddRoom1MouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lblAddRoom1MouseMoved(evt);
            }
        });
        lblAddRoom1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAddRoom1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblAddRoom1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblAddRoom1MouseExited(evt);
            }
        });
        jPanel2.add(lblAddRoom1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 250, 60));

        lblViewRes1.setBackground(new java.awt.Color(221, 188, 9));
        lblViewRes1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lblViewRes1.setText(" [F3]  View Reservation");
        lblViewRes1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblViewRes1.setName("lblMain"); // NOI18N
        lblViewRes1.setOpaque(true);
        lblViewRes1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblViewRes1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblViewRes1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblViewRes1MouseExited(evt);
            }
        });
        jPanel2.add(lblViewRes1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 250, 60));

        lblViewPayment.setBackground(new java.awt.Color(221, 188, 9));
        lblViewPayment.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lblViewPayment.setText(" [F6]  Payment Details");
        lblViewPayment.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblViewPayment.setName("lblMain"); // NOI18N
        lblViewPayment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblViewPaymentMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblViewPaymentMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblViewPaymentMouseExited(evt);
            }
        });
        jPanel2.add(lblViewPayment, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 250, 60));

        lblGuestHistory.setBackground(new java.awt.Color(221, 188, 9));
        lblGuestHistory.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lblGuestHistory.setText(" [F5] View Guest History");
        lblGuestHistory.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblGuestHistory.setName("lblMain"); // NOI18N
        lblGuestHistory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblGuestHistoryMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblGuestHistoryMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblGuestHistoryMouseExited(evt);
            }
        });
        jPanel2.add(lblGuestHistory, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 250, 60));

        lblLogOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/gdse41/sem1project/resources/images/LogOut.png"))); // NOI18N
        lblLogOut.setToolTipText("Log out");
        lblLogOut.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblLogOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLogOutMouseClicked(evt);
            }
        });
        jPanel2.add(lblLogOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 560, 50, 50));

        lblViewReports.setBackground(new java.awt.Color(221, 188, 9));
        lblViewReports.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lblViewReports.setText(" [F4]  View Reports");
        lblViewReports.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblViewReports.setName("lblMain"); // NOI18N
        lblViewReports.setOpaque(true);
        lblViewReports.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblViewReportsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblViewReportsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblViewReportsMouseExited(evt);
            }
        });
        jPanel2.add(lblViewReports, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 250, 60));

        lblRestore.setBackground(new java.awt.Color(221, 188, 9));
        lblRestore.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lblRestore.setText(" [F8]  Restore Database");
        lblRestore.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblRestore.setName("lblMain"); // NOI18N
        lblRestore.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRestoreMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblRestoreMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblRestoreMouseExited(evt);
            }
        });
        jPanel2.add(lblRestore, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 500, 250, 60));

        lblBackUp.setBackground(new java.awt.Color(221, 188, 9));
        lblBackUp.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lblBackUp.setText(" [F7]  Back Up Database");
        lblBackUp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblBackUp.setName("lblMain"); // NOI18N
        lblBackUp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBackUpMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblBackUpMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblBackUpMouseExited(evt);
            }
        });
        jPanel2.add(lblBackUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 250, 60));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 270, 620));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/gdse41/sem1project/resources/images/logo.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 150));

        pnlViewReports.setBackground(new java.awt.Color(255, 255, 255));
        pnlViewReports.setName("covers"); // NOI18N
        pnlViewReports.setOpaque(false);
        pnlViewReports.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblGuestDetails.setBackground(new java.awt.Color(221, 188, 9));
        lblGuestDetails.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblGuestDetails.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblGuestDetails.setText(" Guest Details");
        lblGuestDetails.setName("lblMain"); // NOI18N
        lblGuestDetails.setOpaque(true);
        lblGuestDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblGuestDetailsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblGuestDetailsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblGuestDetailsMouseExited(evt);
            }
        });
        pnlViewReports.add(lblGuestDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 230, 40));

        lblBdys.setBackground(new java.awt.Color(221, 188, 9));
        lblBdys.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblBdys.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblBdys.setText(" Upcoming Birthdays");
        lblBdys.setName("lblMain"); // NOI18N
        lblBdys.setOpaque(true);
        lblBdys.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBdysMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblBdysMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblBdysMouseExited(evt);
            }
        });
        pnlViewReports.add(lblBdys, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 230, 40));

        lblRes.setBackground(new java.awt.Color(221, 188, 9));
        lblRes.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblRes.setText(" Upcoming Reservation");
        lblRes.setOpaque(true);
        lblRes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblResMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblResMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblResMouseExited(evt);
            }
        });
        pnlViewReports.add(lblRes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 230, 40));

        lblResDetails.setBackground(new java.awt.Color(221, 188, 9));
        lblResDetails.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblResDetails.setText(" Reservation Details");
        lblResDetails.setOpaque(true);
        lblResDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblResDetailsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblResDetailsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblResDetailsMouseExited(evt);
            }
        });
        pnlViewReports.add(lblResDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 230, 40));

        lblMonthlyIncome.setBackground(new java.awt.Color(221, 188, 9));
        lblMonthlyIncome.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblMonthlyIncome.setText(" Monthly Income");
        lblMonthlyIncome.setOpaque(true);
        lblMonthlyIncome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMonthlyIncomeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblMonthlyIncomeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblMonthlyIncomeMouseExited(evt);
            }
        });
        pnlViewReports.add(lblMonthlyIncome, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 230, 40));

        lblAnnualIncome.setBackground(new java.awt.Color(221, 188, 9));
        lblAnnualIncome.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblAnnualIncome.setText(" Annual Income");
        lblAnnualIncome.setOpaque(true);
        lblAnnualIncome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAnnualIncomeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblAnnualIncomeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblAnnualIncomeMouseExited(evt);
            }
        });
        pnlViewReports.add(lblAnnualIncome, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 230, 40));

        jPanel1.add(pnlViewReports, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 360, 230, 300));

        pnlMain.setBackground(new java.awt.Color(255, 255, 255));
        pnlMain.setLayout(new java.awt.CardLayout());
        jPanel1.add(pnlMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 150, 1100, 620));

        pnltitle.setBackground(new java.awt.Color(255, 255, 255));
        pnltitle.setLayout(new java.awt.CardLayout());
        jPanel1.add(pnltitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 10, 670, 140));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 770));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblLogOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogOutMouseClicked
        int res=JOptionPane.showConfirmDialog(this,"Do you want to log out?","Confirmation",JOptionPane.YES_NO_OPTION);
        if(res==0){
            new LogIn().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_lblLogOutMouseClicked

    private void lblCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMouseClicked
        System.exit(0);
    }//GEN-LAST:event_lblCloseMouseClicked

    private void lblMinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMinimizeMouseClicked
        setExtendedState(Admin.ICONIFIED);
    }//GEN-LAST:event_lblMinimizeMouseClicked

    private void lblAddUser1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAddUser1MouseClicked
        loadPanels(new edu.gdse41.sem1project.view.panels.AddNewUser());
        loadTitles(new AddNewUserTitle());
    }//GEN-LAST:event_lblAddUser1MouseClicked

    private void lblAddUser1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAddUser1MouseEntered
        pnlViewReports.setVisible(false);
        lblAddUser1.setBackground(new Color(255,162,0));
        lblAddUser1.setOpaque(true);        
    }//GEN-LAST:event_lblAddUser1MouseEntered

    private void lblAddUser1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAddUser1MouseExited
        lblAddUser1.setBackground(new Color(221,188,9));
        lblAddUser1.setOpaque(true);
    }//GEN-LAST:event_lblAddUser1MouseExited

    private void lblAddRoom1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAddRoom1MouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_lblAddRoom1MouseDragged

    private void lblAddRoom1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAddRoom1MouseMoved

    }//GEN-LAST:event_lblAddRoom1MouseMoved

    private void lblAddRoom1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAddRoom1MouseClicked
        loadPanels(new edu.gdse41.sem1project.view.panels.AddRoom());
        loadTitles(new ManageRmsTitle());
    }//GEN-LAST:event_lblAddRoom1MouseClicked

    private void lblAddRoom1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAddRoom1MouseEntered
        pnlViewReports.setVisible(false);
        lblAddRoom1.setBackground(new Color(255,162,0));
        lblAddRoom1.setOpaque(true);
    }//GEN-LAST:event_lblAddRoom1MouseEntered

    private void lblAddRoom1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAddRoom1MouseExited
        lblAddRoom1.setBackground(new Color(221,188,9));
        lblAddRoom1.setOpaque(true);
    }//GEN-LAST:event_lblAddRoom1MouseExited

    private void lblViewRes1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblViewRes1MouseClicked
        loadPanels(new edu.gdse41.sem1project.view.panels.AdminViewReservation());
        loadTitles(new ViewResTitle());
    }//GEN-LAST:event_lblViewRes1MouseClicked

    private void lblViewRes1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblViewRes1MouseEntered
        pnlViewReports.setVisible(false);
        lblViewRes1.setBackground(new Color(255,162,0));
        lblViewRes1.setOpaque(true);
    }//GEN-LAST:event_lblViewRes1MouseEntered

    private void lblViewRes1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblViewRes1MouseExited
        lblViewRes1.setBackground(new Color(221,188,9));
        lblViewRes1.setOpaque(true);
    }//GEN-LAST:event_lblViewRes1MouseExited

    private void lblViewPaymentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblViewPaymentMouseClicked
        loadPanels(new edu.gdse41.sem1project.view.panels.AdminPaymentDetails());
        loadTitles(new PaymentDetlsTitle());
    }//GEN-LAST:event_lblViewPaymentMouseClicked

    private void lblViewPaymentMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblViewPaymentMouseEntered
        pnlViewReports.setVisible(false);
        lblViewPayment.setBackground(new Color(255,162,0));
        lblViewPayment.setOpaque(true);
    }//GEN-LAST:event_lblViewPaymentMouseEntered

    private void lblViewPaymentMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblViewPaymentMouseExited
        lblViewPayment.setBackground(new Color(221,188,9));
        lblViewPayment.setOpaque(true);
    }//GEN-LAST:event_lblViewPaymentMouseExited

    private void lblGuestHistoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGuestHistoryMouseClicked
        loadPanels(new edu.gdse41.sem1project.view.panels.AdminViewGuestHistory());
        loadTitles(new ViewGuestHstryTitle());
    }//GEN-LAST:event_lblGuestHistoryMouseClicked

    private void lblGuestHistoryMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGuestHistoryMouseEntered
        pnlViewReports.setVisible(false);
        lblGuestHistory.setBackground(new Color(255,162,0));
        lblGuestHistory.setOpaque(true);
    }//GEN-LAST:event_lblGuestHistoryMouseEntered

    private void lblGuestHistoryMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGuestHistoryMouseExited
        lblGuestHistory.setBackground(new Color(221,188,9));
        lblGuestHistory.setOpaque(true);
    }//GEN-LAST:event_lblGuestHistoryMouseExited

    private void lblViewReportsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblViewReportsMouseClicked

    }//GEN-LAST:event_lblViewReportsMouseClicked

    private void lblViewReportsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblViewReportsMouseEntered
        pnlViewReports.setVisible(true);
        lblViewReports.setBackground(new Color(255,162,0));
        lblViewReports.setOpaque(true);
    }//GEN-LAST:event_lblViewReportsMouseEntered

    private void lblViewReportsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblViewReportsMouseExited
        lblViewReports.setBackground(new Color(221,188,9));
        lblViewReports.setOpaque(true);
    }//GEN-LAST:event_lblViewReportsMouseExited

    private void lblGuestDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGuestDetailsMouseClicked
        try {
            JasperReport compiledReport=(JasperReport) JRLoader.loadObject(Reception.class.getResourceAsStream("/edu/gdse41/sem1project/reports/Guest Details.jasper"));
            JasperPrint filledReport=JasperFillManager.fillReport(compiledReport, new HashMap<>(), conn);
            JasperReportViewer jasperViewer=new JasperReportViewer(filledReport);
            jasperViewer.setVisible(true);
            jasperViewer.setTitle("Guest Details Report");
        } catch (JRException ex) {
            Logger.getLogger(Reception.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lblGuestDetailsMouseClicked

    private void lblGuestDetailsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGuestDetailsMouseEntered
        lblGuestDetails.setBackground(new Color(255,162,0));
        lblGuestDetails.setOpaque(true);
    }//GEN-LAST:event_lblGuestDetailsMouseEntered

    private void lblGuestDetailsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGuestDetailsMouseExited
        lblGuestDetails.setBackground(new Color(221,188,9));
        lblGuestDetails.setOpaque(true);
    }//GEN-LAST:event_lblGuestDetailsMouseExited

    private void lblBdysMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBdysMouseClicked
        try {
            JasperReport compiledReport=(JasperReport) JRLoader.loadObject(Reception.class.getResourceAsStream("/edu/gdse41/sem1project/reports/Birthday Greetings.jasper"));
            JasperPrint filledReport=JasperFillManager.fillReport(compiledReport, new HashMap<>(), conn);
            JasperReportViewer jasperViewer=new JasperReportViewer(filledReport);
            jasperViewer.setVisible(true);
            jasperViewer.setTitle("Guests' Birthdays Details");
        } catch (JRException ex) {
            Logger.getLogger(Reception.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lblBdysMouseClicked

    private void lblBdysMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBdysMouseEntered
        lblBdys.setBackground(new Color(255,162,0));
        lblBdys.setOpaque(true);
    }//GEN-LAST:event_lblBdysMouseEntered

    private void lblBdysMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBdysMouseExited
        lblBdys.setBackground(new Color(221,188,9));
        lblBdys.setOpaque(true);
    }//GEN-LAST:event_lblBdysMouseExited

    private void lblResMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblResMouseClicked
        try {
            JasperReport compiledReport=(JasperReport) JRLoader.loadObject(Reception.class.getResourceAsStream("/edu/gdse41/sem1project/reports/Booking Details.jasper"));
            JasperPrint filledReport=JasperFillManager.fillReport(compiledReport, new HashMap<>(), conn);
            JasperReportViewer jasperViewer=new JasperReportViewer(filledReport);
            jasperViewer.setVisible(true);
            jasperViewer.setTitle("Reservation Details");
        } catch (JRException ex) {
            Logger.getLogger(Reception.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lblResMouseClicked

    private void lblResMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblResMouseEntered
        lblRes.setBackground(new Color(255,162,0));
        lblRes.setOpaque(true);
    }//GEN-LAST:event_lblResMouseEntered

    private void lblResMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblResMouseExited
        lblRes.setBackground(new Color(221,188,9));
        lblRes.setOpaque(true);
    }//GEN-LAST:event_lblResMouseExited

    private void lblResDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblResDetailsMouseClicked
        try {
            JasperReport compiledReport=(JasperReport) JRLoader.loadObject(Reception.class.getResourceAsStream("/edu/gdse41/sem1project/reports/Registration Details.jasper"));
            JasperPrint filledReport=JasperFillManager.fillReport(compiledReport, new HashMap<>(), conn);
            JasperReportViewer jasperViewer=new JasperReportViewer(filledReport);
            jasperViewer.setVisible(true);
            jasperViewer.setTitle("Reservstion History");
        } catch (JRException ex) {
            Logger.getLogger(Reception.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lblResDetailsMouseClicked

    private void lblResDetailsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblResDetailsMouseEntered
        lblResDetails.setBackground(new Color(255,162,0));
        lblResDetails.setOpaque(true);
    }//GEN-LAST:event_lblResDetailsMouseEntered

    private void lblResDetailsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblResDetailsMouseExited
        lblResDetails.setBackground(new Color(221,188,9));
        lblResDetails.setOpaque(true);
    }//GEN-LAST:event_lblResDetailsMouseExited

    private void lblMonthlyIncomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMonthlyIncomeMouseClicked
        try {
            JasperReport compiledReport=(JasperReport) JRLoader.loadObject(Reception.class.getResourceAsStream("/edu/gdse41/sem1project/reports/Monthly Income.jasper"));
            HashMap<String,Object> parameters=new HashMap<>();
            String year=JOptionPane.showInputDialog("Please input a year :\n [Ex: 2016]");
            String month=JOptionPane.showInputDialog("Please input a month :\n[Ex: May]");
            parameters.put("paraYear", Integer.parseInt(year));
            parameters.put("paraMonth", month);
            JasperPrint filledReport=JasperFillManager.fillReport(compiledReport, parameters, conn);
            JasperReportViewer jasperViewer=new JasperReportViewer(filledReport);
            jasperViewer.setVisible(true);
            jasperViewer.setTitle("Monthly Income Report");
        } catch (JRException ex) {
            Logger.getLogger(Reception.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lblMonthlyIncomeMouseClicked

    private void lblMonthlyIncomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMonthlyIncomeMouseEntered
        lblMonthlyIncome.setBackground(new Color(255,162,0));
        lblMonthlyIncome.setOpaque(true);
    }//GEN-LAST:event_lblMonthlyIncomeMouseEntered

    private void lblMonthlyIncomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMonthlyIncomeMouseExited
        lblMonthlyIncome.setBackground(new Color(221,188,9));
        lblMonthlyIncome.setOpaque(true);
    }//GEN-LAST:event_lblMonthlyIncomeMouseExited

    private void lblAnnualIncomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAnnualIncomeMouseClicked
       try {
            JasperReport compiledReport=(JasperReport) JRLoader.loadObject(Reception.class.getResourceAsStream("/edu/gdse41/sem1project/reports/Annual Income.jasper"));
            HashMap<String,Object> parameters=new HashMap<>();
            String year=JOptionPane.showInputDialog("Please input a year :\n [Ex: 2016]");
            parameters.put("paraYear", year);
            JasperPrint filledReport=JasperFillManager.fillReport(compiledReport, parameters, conn);
            JasperReportViewer jasperrViewer=new JasperReportViewer(filledReport);
            jasperrViewer.setVisible(true);
            jasperrViewer.setTitle("Annual Income Report");
        } catch (JRException ex) {
            Logger.getLogger(Reception.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lblAnnualIncomeMouseClicked

    private void lblAnnualIncomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAnnualIncomeMouseEntered
        lblAnnualIncome.setBackground(new Color(255,162,0));
        lblAnnualIncome.setOpaque(true);
    }//GEN-LAST:event_lblAnnualIncomeMouseEntered

    private void lblAnnualIncomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAnnualIncomeMouseExited
        lblAnnualIncome.setBackground(new Color(221,188,9));
        lblAnnualIncome.setOpaque(true);
    }//GEN-LAST:event_lblAnnualIncomeMouseExited

    private void lblRestoreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRestoreMouseClicked
        int res=JOptionPane.showConfirmDialog(this, "Do you want to restore the database", "Restore COnfirmation", JOptionPane.YES_NO_OPTION);
        if(res==0){
        JFileChooser fileChooser=new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("SQL", "sql"));
        int i=fileChooser.showOpenDialog(fileChooser);
        if(i==JFileChooser.APPROVE_OPTION){
            File file =fileChooser.getSelectedFile();
            String source=file.getAbsolutePath();
            System.out.println(source);
            try {
                new BackUp().restoreDB(source);
            } catch (IOException ex) {
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        }
    }//GEN-LAST:event_lblRestoreMouseClicked

    private void lblRestoreMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRestoreMouseEntered
        lblRestore.setBackground(new Color(255,162,0));
        lblRestore.setOpaque(true);
    }//GEN-LAST:event_lblRestoreMouseEntered

    private void lblRestoreMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRestoreMouseExited
        lblRestore.setBackground(new Color(221,188,9));
        lblRestore.setOpaque(true);
    }//GEN-LAST:event_lblRestoreMouseExited

    private void lblBackUpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBackUpMouseClicked
        int res=JOptionPane.showConfirmDialog(this, "Do you want to backup the database", "Backup Confirmation", JOptionPane.YES_NO_OPTION);
        if(res==0){
            JFileChooser filechsr=new JFileChooser();
            filechsr.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int i=filechsr.showOpenDialog(null);
            if(i==JFileChooser.APPROVE_OPTION){
                File file=filechsr.getSelectedFile();
                String path=file.getAbsolutePath();
                System.out.println(path);
                try {
                    new BackUp().backupDB(path);
                } catch (IOException ex) {
                    Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_lblBackUpMouseClicked

    private void lblBackUpMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBackUpMouseEntered
        lblBackUp.setBackground(new Color(255,162,0));
        lblBackUp.setOpaque(true);
    }//GEN-LAST:event_lblBackUpMouseEntered

    private void lblBackUpMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBackUpMouseExited
        lblBackUp.setBackground(new Color(221,188,9));
        lblBackUp.setOpaque(true);
    }//GEN-LAST:event_lblBackUpMouseExited

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblAddRoom1;
    private javax.swing.JLabel lblAddUser1;
    private javax.swing.JLabel lblAnnualIncome;
    private javax.swing.JLabel lblBackUp;
    private javax.swing.JLabel lblBdys;
    private javax.swing.JLabel lblClose;
    private javax.swing.JLabel lblGuestDetails;
    private javax.swing.JLabel lblGuestHistory;
    private javax.swing.JLabel lblLogOut;
    private javax.swing.JLabel lblMinimize;
    private javax.swing.JLabel lblMonthlyIncome;
    private javax.swing.JLabel lblRes;
    private javax.swing.JLabel lblResDetails;
    private javax.swing.JLabel lblRestore;
    private javax.swing.JLabel lblViewPayment;
    private javax.swing.JLabel lblViewReports;
    private javax.swing.JLabel lblViewRes1;
    private javax.swing.JPanel pnlMain;
    public static javax.swing.JPanel pnlViewReports;
    public javax.swing.JPanel pnltitle;
    // End of variables declaration//GEN-END:variables
}
