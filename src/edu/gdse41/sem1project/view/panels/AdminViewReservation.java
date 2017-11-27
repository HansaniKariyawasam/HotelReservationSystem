/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gdse41.sem1project.view.panels;

import edu.gdse41.sem1project.controller.ControllerFactory;
import edu.gdse41.sem1project.controller.custom.ReservationController;
import edu.gdse41.sem1project.controller.custom.ReservationDetailsController;
import edu.gdse41.sem1project.controller.custom.impl.ReservationControllerImpl;
import edu.gdse41.sem1project.view.Admin;
import edu.gdse41.sem1project.view.Reception;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Hansani Kariyawasam
 */
public class AdminViewReservation extends javax.swing.JPanel {
    
    private ReservationController ctrlRes;
    private ReservationDetailsController ctrlResDetails;

    /**
     * Creates new form AdminViewReservation
     */
    public AdminViewReservation() {
        initComponents();
        ctrlRes=(ReservationController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.RESERVATION);
        ctrlResDetails=(ReservationDetailsController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.RES_DETAILS);
        loadTable();
    }
    
    private void loadTable(){
        try {
            ArrayList<Object[]> detailsList=ctrlResDetails.viewResDetails();
            DefaultTableModel dtm=(DefaultTableModel) tblResDetails.getModel();
            for (Object[] d : detailsList) {
                dtm.addRow(d);
            }
        } catch (Exception ex) {
            Logger.getLogger(AdminViewReservation.class.getName()).log(Level.SEVERE, null, ex);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tblResDetails = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1100, 620));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseClicked(evt);
            }
        });

        tblResDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Res ID", "GID", "Guest Name", "NIC", "Passport", "Room ID", "Room Type", "Reserve  Date", "Check In", "Check Out", "Agent"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblResDetails.getTableHeader().setReorderingAllowed(false);
        tblResDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblResDetailsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblResDetails);
        if (tblResDetails.getColumnModel().getColumnCount() > 0) {
            tblResDetails.getColumnModel().getColumn(0).setResizable(false);
            tblResDetails.getColumnModel().getColumn(0).setPreferredWidth(30);
            tblResDetails.getColumnModel().getColumn(1).setResizable(false);
            tblResDetails.getColumnModel().getColumn(1).setPreferredWidth(30);
            tblResDetails.getColumnModel().getColumn(2).setResizable(false);
            tblResDetails.getColumnModel().getColumn(2).setPreferredWidth(110);
            tblResDetails.getColumnModel().getColumn(3).setResizable(false);
            tblResDetails.getColumnModel().getColumn(4).setResizable(false);
            tblResDetails.getColumnModel().getColumn(5).setResizable(false);
            tblResDetails.getColumnModel().getColumn(5).setPreferredWidth(35);
            tblResDetails.getColumnModel().getColumn(6).setResizable(false);
            tblResDetails.getColumnModel().getColumn(6).setPreferredWidth(90);
            tblResDetails.getColumnModel().getColumn(7).setResizable(false);
            tblResDetails.getColumnModel().getColumn(8).setResizable(false);
            tblResDetails.getColumnModel().getColumn(9).setResizable(false);
            tblResDetails.getColumnModel().getColumn(10).setResizable(false);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 1020, 490));
    }// </editor-fold>//GEN-END:initComponents

    private void tblResDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblResDetailsMouseClicked
        Admin.pnlViewReports.setVisible(false);
    }//GEN-LAST:event_tblResDetailsMouseClicked

    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked
        Reception.reserveRoomPanel.setVisible(false);
        Reception.pnlViewReports.setVisible(false);
    }//GEN-LAST:event_jScrollPane1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblResDetails;
    // End of variables declaration//GEN-END:variables
}