/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gdse41.sem1project.view.panels;

import com.sun.org.apache.xml.internal.dtm.DTM;
import edu.gdse41.sem1project.controller.ControllerFactory;
import edu.gdse41.sem1project.controller.custom.GuestController;
import edu.gdse41.sem1project.controller.custom.PaymentController;
import edu.gdse41.sem1project.controller.custom.impl.GuestControllerImpl;
import edu.gdse41.sem1project.view.Admin;
import edu.gdse41.sem1project.view.Reception;
import java.awt.Component;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Hansani Kariyawasam
 */
public class AdminPaymentDetails extends javax.swing.JPanel {
    
    private GuestController ctrlGuest;
    private PaymentController ctrlPayment;

    /**
     * Creates new form panel
     */
    public AdminPaymentDetails() {
        initComponents();
        ctrlPayment=(PaymentController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.PAYMENT);
        ctrlGuest=(GuestController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.GUEST);
        loadGuestIDs();
        loadTable();
    }
    
    private void loadTable(){
        DefaultTableModel dtm=(DefaultTableModel) tblPaymentDetails.getModel();
        try {
            int i=0;
            ArrayList<Object []> detailsList=ctrlPayment.paymentDetails(null);
            for (Object[] d : detailsList) {
                dtm.addRow(d);
                if(dtm.getValueAt(i, 3)!=dtm.getValueAt(i, 4)){
                    
                }
                i++;
                
            }
        } catch (Exception ex) {
            Logger.getLogger(AdminPaymentDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    private void loadGuestIDs(){
        try {
            ArrayList<String> guestIDs=ctrlGuest.getAllGuestIDs();
            for(int i=0;i<guestIDs.size();i++){
                cmbGuestId.addItem(guestIDs.get(i));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CancelReservation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CancelReservation.class.getName()).log(Level.SEVERE, null, ex);
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

        jLabel6 = new javax.swing.JLabel();
        cmbGuestId = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPaymentDetails = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1100, 620));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Guset ID :");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 150, 30));

        cmbGuestId.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbGuestIdItemStateChanged(evt);
            }
        });
        add(cmbGuestId, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, 130, 30));

        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseClicked(evt);
            }
        });

        tblPaymentDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Reservation ID", "Guest Name", "Paid Date", "Total Amount", "Paid Amount", "Due Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPaymentDetails.getTableHeader().setReorderingAllowed(false);
        tblPaymentDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPaymentDetailsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPaymentDetails);
        if (tblPaymentDetails.getColumnModel().getColumnCount() > 0) {
            tblPaymentDetails.getColumnModel().getColumn(0).setResizable(false);
            tblPaymentDetails.getColumnModel().getColumn(0).setPreferredWidth(10);
            tblPaymentDetails.getColumnModel().getColumn(1).setResizable(false);
            tblPaymentDetails.getColumnModel().getColumn(2).setResizable(false);
            tblPaymentDetails.getColumnModel().getColumn(3).setResizable(false);
            tblPaymentDetails.getColumnModel().getColumn(4).setResizable(false);
            tblPaymentDetails.getColumnModel().getColumn(5).setResizable(false);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 1000, 380));
    }// </editor-fold>//GEN-END:initComponents

    private void cmbGuestIdItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbGuestIdItemStateChanged
        String id=(String) cmbGuestId.getSelectedItem();
        try {
            ArrayList<Object []> detailsList=ctrlPayment.paymentDetails(id);
            DefaultTableModel dtm=(DefaultTableModel) tblPaymentDetails.getModel();
            
            for (Object[] d : detailsList) {                
                for(int i=0;i<tblPaymentDetails.getRowCount();i++){
                    System.out.println("Enter");
                    if(tblPaymentDetails.getValueAt(i, 0).equals(d[0])){
                        tblPaymentDetails.setRowSelectionInterval(i, i);
                        break;
                    }
                }   
            }
        } catch (Exception ex) {
            Logger.getLogger(AdminPaymentDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_cmbGuestIdItemStateChanged

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        Admin.pnlViewReports.setVisible(false);
    }//GEN-LAST:event_formMouseClicked

    private void tblPaymentDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPaymentDetailsMouseClicked
        Admin.pnlViewReports.setVisible(false);
    }//GEN-LAST:event_tblPaymentDetailsMouseClicked

    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked
        Reception.reserveRoomPanel.setVisible(false);
        Reception.pnlViewReports.setVisible(false);
    }//GEN-LAST:event_jScrollPane1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cmbGuestId;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPaymentDetails;
    // End of variables declaration//GEN-END:variables
}
