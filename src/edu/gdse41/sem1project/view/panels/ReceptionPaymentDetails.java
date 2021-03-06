/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gdse41.sem1project.view.panels;

import edu.gdse41.sem1project.controller.ControllerFactory;
import edu.gdse41.sem1project.controller.custom.GuestController;
import edu.gdse41.sem1project.controller.custom.PaymentController;
import edu.gdse41.sem1project.controller.custom.ReservationDetailsController;
import edu.gdse41.sem1project.controller.custom.impl.GuestControllerImpl;
import edu.gdse41.sem1project.dao.db.ConnectionFactory;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import edu.gdse41.sem1project.dto.GuestDTO;
import edu.gdse41.sem1project.dto.PaymentDTO;
import edu.gdse41.sem1project.dto.ReservationDetailsDTO;
import edu.gdse41.sem1project.view.JasperReportViewer;
import edu.gdse41.sem1project.view.Reception;
import java.awt.Color;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 *
 * @author Hansani Kariyawasam
 */
public class ReceptionPaymentDetails extends javax.swing.JPanel {
    
        private GuestController ctrlGuest;
        private PaymentController ctrlPayment;
        private ReservationDetailsController ctrlResDetails;


    /**
     * Creates new form ReceptionPaymentDetails
     */
    public ReceptionPaymentDetails() {
        initComponents();
        ctrlGuest =(GuestController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.GUEST);
        ctrlPayment=(PaymentController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.PAYMENT);
        ctrlResDetails=(ReservationDetailsController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.RES_DETAILS);
        loadGuestIDs();
        loadTable();
    }
    
    private void loadTable(){
        DefaultTableModel dtm=(DefaultTableModel) tblPaymetDtls.getModel();
            try {
                ArrayList<Object []> detailsList=ctrlPayment.paymentDetails(null);
                for (Object[] d : detailsList) {
                    dtm.addRow(d);
                }
            } catch (Exception ex) {
                Logger.getLogger(ReceptionPaymentDetails.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    private void loadGuestIDs(){
        try {
            ArrayList<String> guestIDs=ctrlGuest.getAllGuestIDs();
            for(int i=0;i<guestIDs.size();i++){
                cbGuestId.addItem(guestIDs.get(i));
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

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtGuestNme = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtPID = new javax.swing.JTextField();
        cbGuestId = new javax.swing.JComboBox();
        txtPaymentDate = new javax.swing.JTextField();
        lblGuestDtls = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        txtResId = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtAdvanced = new javax.swing.JTextField();
        lblPrintInvoice = new javax.swing.JLabel();
        txtDueAmount = new javax.swing.JTextField();
        lblPaymentDtls = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPaymetDtls = new javax.swing.JTable();
        lblPay1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1100, 620));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Guest Name :");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, 140, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Guest ID :");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 120, 30));

        txtGuestNme.setEditable(false);
        add(txtGuestNme, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 300, 190, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Payment ID :");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 240, 120, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Payment Date :");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 300, 140, 30));

        txtPID.setEditable(false);
        add(txtPID, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 240, 190, 30));

        cbGuestId.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbGuestIdItemStateChanged(evt);
            }
        });
        add(cbGuestId, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 240, 110, 30));

        txtPaymentDate.setEditable(false);
        add(txtPaymentDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 300, 190, 30));

        lblGuestDtls.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(lblGuestDtls, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 1040, 150));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Total Amount :");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 460, 140, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Res ID :");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, 120, 30));

        txtTotal.setEditable(false);
        add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 460, 190, 30));

        txtResId.setEditable(false);
        add(txtResId, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 400, 190, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Advance :");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 400, 120, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Due Amount :");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 460, 140, 30));

        txtAdvanced.setEditable(false);
        add(txtAdvanced, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 400, 190, 30));

        lblPrintInvoice.setBackground(new java.awt.Color(221, 188, 9));
        lblPrintInvoice.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lblPrintInvoice.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPrintInvoice.setText("Print Invoice");
        lblPrintInvoice.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblPrintInvoice.setOpaque(true);
        lblPrintInvoice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPrintInvoiceMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblPrintInvoiceMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblPrintInvoiceMouseExited(evt);
            }
        });
        add(lblPrintInvoice, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 550, 180, 50));

        txtDueAmount.setEditable(false);
        add(txtDueAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 460, 190, 30));

        lblPaymentDtls.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(lblPaymentDtls, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 1040, 150));

        tblPaymetDtls.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Reservation ID", "Guest Name", "Paid Date", "Total Amount", "Advanced", "Due Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPaymetDtls.getTableHeader().setReorderingAllowed(false);
        tblPaymetDtls.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPaymetDtlsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPaymetDtls);
        if (tblPaymetDtls.getColumnModel().getColumnCount() > 0) {
            tblPaymetDtls.getColumnModel().getColumn(0).setResizable(false);
            tblPaymetDtls.getColumnModel().getColumn(0).setPreferredWidth(5);
            tblPaymetDtls.getColumnModel().getColumn(1).setResizable(false);
            tblPaymetDtls.getColumnModel().getColumn(2).setResizable(false);
            tblPaymetDtls.getColumnModel().getColumn(3).setResizable(false);
            tblPaymetDtls.getColumnModel().getColumn(4).setResizable(false);
            tblPaymetDtls.getColumnModel().getColumn(5).setResizable(false);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 1040, 190));

        lblPay1.setBackground(new java.awt.Color(221, 188, 9));
        lblPay1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lblPay1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPay1.setText("Add");
        lblPay1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblPay1.setOpaque(true);
        lblPay1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPay1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblPay1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblPay1MouseExited(evt);
            }
        });
        add(lblPay1, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 470, 150, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void cbGuestIdItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbGuestIdItemStateChanged
        String id=cbGuestId.getSelectedItem().toString();
            try {
                PaymentDTO p1=ctrlPayment.searchPaymentDetails(id);
                txtGuestNme.setText(p1.getGuestName());
                txtPID.setText(p1.getPaymentID());
                txtPaymentDate.setText(p1.getPaymentDate());
                txtResId.setText(p1.getResID());
                DefaultTableModel dtm=(DefaultTableModel) tblPaymetDtls.getModel();
                for(int i=0;i<tblPaymetDtls.getRowCount();i++){
                    if(((String)dtm.getValueAt(i, 0)).equals(p1.getResID())){
                        txtTotal.setText(dtm.getValueAt(i, 3).toString());
                        txtAdvanced.setText(dtm.getValueAt(i, 4).toString());
                        txtDueAmount.setText(dtm.getValueAt(i, 5).toString());
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(ReceptionPaymentDetails.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_cbGuestIdItemStateChanged

    private void lblPrintInvoiceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPrintInvoiceMouseClicked
        String gid=(String) cbGuestId.getSelectedItem();
        Connection conn=ConnectionFactory.getInstance().getConnection();
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String curDate=sdf.format(date);
        try {
            JasperReport compiledReport=(JasperReport) JRLoader.loadObject(ReceptionPaymentDetails.class.getResourceAsStream("/edu/gdse41/sem1project/reports/Invoice_1.jasper"));
            HashMap<String,Object> parameters=new HashMap<>();
            parameters.put("name", txtGuestNme.getText());
            parameters.put("pid", txtPID.getText());
            parameters.put("curDate", curDate);
            parameters.put("checkIn", "");
            parameters.put("checkOut", "");
            parameters.put("subTot", txtTotal.getText());
            parameters.put("advance", txtAdvanced.getText());
            parameters.put("due", txtDueAmount.getText());
            parameters.put("id", gid);
            JasperPrint filledReport=JasperFillManager.fillReport(compiledReport, parameters, conn);
            JasperReportViewer jasperViewer=new JasperReportViewer(filledReport);
            jasperViewer.setVisible(true);
            jasperViewer.setTitle("Invoice");
        } catch (JRException ex) {
            Logger.getLogger(ReceptionPaymentDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_lblPrintInvoiceMouseClicked

    private void tblPaymetDtlsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPaymetDtlsMouseClicked
        Reception.reserveRoomPanel.setVisible(false);
        Reception.pnlViewReports.setVisible(false);
        DefaultTableModel dtm=(DefaultTableModel) tblPaymetDtls.getModel();
        String res_id=(String) dtm.getValueAt(tblPaymetDtls.getSelectedRow(), 0);
        ReservationDetailsDTO d;
        try {
            d = ctrlResDetails.search(res_id);
            cbGuestId.setSelectedItem(d.getGuestID());
        } catch (Exception ex) {
            Logger.getLogger(ReceptionPaymentDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_tblPaymetDtlsMouseClicked

    private void lblPrintInvoiceMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPrintInvoiceMouseEntered
        lblPrintInvoice.setBackground(new Color(255,162,0));
        lblPrintInvoice.setOpaque(true);
    }//GEN-LAST:event_lblPrintInvoiceMouseEntered

    private void lblPrintInvoiceMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPrintInvoiceMouseExited
        lblPrintInvoice.setBackground(new Color(221,188,9));
        lblPrintInvoice.setOpaque(true);
    }//GEN-LAST:event_lblPrintInvoiceMouseExited

    private void lblPay1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPay1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblPay1MouseClicked

    private void lblPay1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPay1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lblPay1MouseEntered

    private void lblPay1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPay1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_lblPay1MouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbGuestId;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblGuestDtls;
    private javax.swing.JLabel lblPay1;
    private javax.swing.JLabel lblPaymentDtls;
    private javax.swing.JLabel lblPrintInvoice;
    private javax.swing.JTable tblPaymetDtls;
    private javax.swing.JTextField txtAdvanced;
    private javax.swing.JTextField txtDueAmount;
    private javax.swing.JTextField txtGuestNme;
    private javax.swing.JTextField txtPID;
    private javax.swing.JTextField txtPaymentDate;
    private javax.swing.JTextField txtResId;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
