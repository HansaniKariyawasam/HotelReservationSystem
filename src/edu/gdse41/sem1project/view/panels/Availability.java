/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gdse41.sem1project.view.panels;

import edu.gdse41.sem1project.controller.ControllerFactory;
import edu.gdse41.sem1project.controller.custom.ReservationController;
import edu.gdse41.sem1project.controller.custom.RoomController;
import edu.gdse41.sem1project.dto.ReservationDTO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.WARNING_MESSAGE;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import edu.gdse41.sem1project.dto.RoomDTO;
import edu.gdse41.sem1project.view.Reception;
import edu.gdse41.sem1project.view.panels.titles.GuestDetlsTitle;
import edu.gdse41.sem1project.view.panels.titles.SearchRmTitle;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author Hansani Kariyawasam
 */
public class Availability extends javax.swing.JPanel {
    
    public static ArrayList<Object[]> rows=new ArrayList<>();
    private RoomController ctrlRm;
    private ReservationController ctrlRes;

    /**
     * Creates new form Availability
     */
    public Availability() {
        initComponents();
        
        ctrlRm=(RoomController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.ROOM);
        ctrlRes=(ReservationController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.RESERVATION);
        loadAvailability();
        table2.removeAll();
    }
    
    private void loadAvailability(){
        try {
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            Date date=new Date();
            String checkIn=SearchRooms.checkIn;
            String checkOut=SearchRooms.checkOut;
            
//            String checkIn=Reception.checkIn;
//            String checkOut=Reception.checkOut;
           
            LocalDate cIn=LocalDate.parse(checkIn);
            LocalDate cOut=LocalDate.parse(checkOut);
            ArrayList<ReservationDTO> dates=ctrlRes.searchAvailability();
            ArrayList<RoomDTO> roomList=ctrlRm.view();
            DefaultTableModel dtm=(DefaultTableModel)table1.getModel();
            for (ReservationDTO d : dates) {
                LocalDate dbCheckIn=LocalDate.parse(d.getCheckInDate());
                LocalDate dbCheckOut=LocalDate.parse(d.getCheckOutDate());
                if((dbCheckIn.isAfter(cIn) && dbCheckIn.isBefore(cOut))||(dbCheckOut.isAfter(cIn) && dbCheckOut.isBefore(cOut))){
                    JOptionPane.showMessageDialog(table1, "There are no rooms available on this day");
                    dtm.setRowCount(0);
                    break;
                }
                dtm.setRowCount(0);
                for(RoomDTO r1:roomList){
                    Object [] rowData={r1.getRoomID(),r1.getRoomType(),r1.getStatus(),r1.getRoomPrice()};
                    dtm.addRow(rowData);

                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Availability.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Availability.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Availability.class.getName()).log(Level.SEVERE, null, ex);
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
        table1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        table2 = new javax.swing.JTable();
        lblBack = new javax.swing.JLabel();
        lblReserve = new javax.swing.JLabel();
        lblNext = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1100, 620));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Room ID", "Room Type", "Status", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        table1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(table1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 850, 160));

        table2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Room ID", "Room Type", "Status", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table2.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(table2);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 350, 850, 160));

        lblBack.setBackground(new java.awt.Color(221, 188, 9));
        lblBack.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lblBack.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBack.setText("Back");
        lblBack.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblBack.setName("lblMain"); // NOI18N
        lblBack.setOpaque(true);
        lblBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBackMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblBackMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblBackMouseExited(evt);
            }
        });
        add(lblBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 540, 170, 50));

        lblReserve.setBackground(new java.awt.Color(221, 188, 9));
        lblReserve.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lblReserve.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblReserve.setText("Reserve Room");
        lblReserve.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblReserve.setName("lblMain"); // NOI18N
        lblReserve.setOpaque(true);
        lblReserve.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblReserveMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblReserveMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblReserveMouseExited(evt);
            }
        });
        add(lblReserve, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 260, 160, 50));

        lblNext.setBackground(new java.awt.Color(221, 188, 9));
        lblNext.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lblNext.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNext.setText("Next");
        lblNext.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblNext.setName("lblMain"); // NOI18N
        lblNext.setOpaque(true);
        lblNext.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblNextMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblNextMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblNextMouseExited(evt);
            }
        });
        add(lblNext, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 540, 170, 50));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(221, 188, 9));
        jLabel2.setText("Reserved Rooms");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, 270, 40));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(221, 188, 9));
        jLabel3.setText("Available Rooms");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 270, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void lblBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBackMouseClicked
            Reception frmMain=(Reception) SwingUtilities.getWindowAncestor(this);
            frmMain.pnlMain.removeAll();
            SearchRooms s=new SearchRooms();
            frmMain.pnlMain.add(s);
            frmMain.pnltitle.removeAll();
            SearchRmTitle title=new SearchRmTitle();
            frmMain.pnltitle.add(title);
            frmMain.pnlMain.updateUI();
        
    }//GEN-LAST:event_lblBackMouseClicked

    private void lblReserveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblReserveMouseClicked
        DefaultTableModel dtm=(DefaultTableModel)table1.getModel();
        Object [] rowData={dtm.getValueAt(table1.getSelectedRow(),0),dtm.getValueAt(table1.getSelectedRow(),1),dtm.getValueAt(table1.getSelectedRow(),2),dtm.getValueAt(table1.getSelectedRow(),3)};
        rows.add(rowData);
        dtm.removeRow(table1.getSelectedRow());
        DefaultTableModel dtm2=(DefaultTableModel)table2.getModel();
        dtm2.addRow(rowData);
    }//GEN-LAST:event_lblReserveMouseClicked

    private void lblNextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNextMouseClicked
        if(table2.getRowCount()==0){
            JOptionPane.showMessageDialog(this,"First you must select and reserve a room","Warning Message",WARNING_MESSAGE);
        }else{
            Reception frmMain=(Reception) SwingUtilities.getWindowAncestor(this);
            frmMain.pnlMain.removeAll();
            AddGuest a=new AddGuest();
            frmMain.pnlMain.add(a);
            frmMain.pnltitle.removeAll();
            GuestDetlsTitle title=new GuestDetlsTitle();
            frmMain.pnltitle.add(title);
            frmMain.pnlMain.updateUI();
        }
    }//GEN-LAST:event_lblNextMouseClicked

    private void lblReserveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblReserveMouseEntered
        lblReserve.setBackground(new Color(255,162,0));
        lblReserve.setOpaque(true);
    }//GEN-LAST:event_lblReserveMouseEntered

    private void lblReserveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblReserveMouseExited
        lblReserve.setBackground(new Color(221,188,9));
        lblReserve.setOpaque(true);
    }//GEN-LAST:event_lblReserveMouseExited

    private void lblBackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBackMouseEntered
        lblBack.setBackground(new Color(255,162,0));
        lblBack.setOpaque(true);
    }//GEN-LAST:event_lblBackMouseEntered

    private void lblBackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBackMouseExited
        lblBack.setBackground(new Color(221,188,9));
        lblBack.setOpaque(true);
    }//GEN-LAST:event_lblBackMouseExited

    private void lblNextMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNextMouseEntered
        lblNext.setBackground(new Color(255,162,0));
        lblNext.setOpaque(true);
    }//GEN-LAST:event_lblNextMouseEntered

    private void lblNextMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNextMouseExited
        lblNext.setBackground(new Color(221,188,9));
        lblNext.setOpaque(true);
    }//GEN-LAST:event_lblNextMouseExited

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        Reception.reserveRoomPanel.setVisible(false);
        Reception.pnlViewReports.setVisible(false);
    }//GEN-LAST:event_formMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblBack;
    private javax.swing.JLabel lblNext;
    private javax.swing.JLabel lblReserve;
    private javax.swing.JTable table1;
    private javax.swing.JTable table2;
    // End of variables declaration//GEN-END:variables
}