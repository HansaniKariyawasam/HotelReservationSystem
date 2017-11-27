/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gdse41.sem1project.view.panels;

import edu.gdse41.sem1project.controller.ControllerFactory;
import edu.gdse41.sem1project.controller.custom.GuestController;
import edu.gdse41.sem1project.controller.custom.ReservationController;
import edu.gdse41.sem1project.controller.custom.impl.DataValidation;
import edu.gdse41.sem1project.dao.db.ConnectionFactory;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import edu.gdse41.sem1project.dto.GuestDTO;
import edu.gdse41.sem1project.dto.ReservationDTO;
import edu.gdse41.sem1project.dto.ReservationDetailsDTO;
import edu.gdse41.sem1project.dto.RoomDTO;
import edu.gdse41.sem1project.id.IDGenerator;
import edu.gdse41.sem1project.view.JasperReportViewer;
import edu.gdse41.sem1project.view.Reception;
import edu.gdse41.sem1project.view.panels.titles.AvailabilityTitle;
import edu.gdse41.sem1project.view.panels.titles.ReservationTitle;
import java.awt.Color;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 *
 * @author Hansani Kariyawasam
 */
public class AddGuest extends javax.swing.JPanel {
    
    public static String guestID;
    public static String guestName;
    public static String guestTel;
    private GuestController ctrlGuest;
    private ReservationController ctrlRes;
    public static String resId;

    /**
     * Creates new form AddGuest
     */
    public AddGuest() {
        initComponents();
        loadGuestID();
        ctrlGuest = (GuestController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.GUEST);
        ctrlRes =(ReservationController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.RESERVATION);
        txtagent.setText("Direct");
        try {
            resId=IDGenerator.getNewID("Reservation", "Res_id", "R");
        } catch (SQLException ex) {
            Logger.getLogger(AddGuest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddGuest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void loadGuestID(){
        
        try {
            txtGusetID.setText(IDGenerator.getNewID("Guest", "GID", "C"));
        } catch (SQLException ex) {
            Logger.getLogger(AddGuest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddGuest.class.getName()).log(Level.SEVERE, null, ex);
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

        pnlCover = new javax.swing.JPanel();
        txtGusetID = new javax.swing.JTextField();
        txtNIC = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox();
        txtpassport = new javax.swing.JTextField();
        txtf_name = new javax.swing.JTextField();
        txtdob = new org.jdesktop.swingx.JXDatePicker();
        txtl_name = new javax.swing.JTextField();
        txtagent = new javax.swing.JTextField();
        txtnatinality = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtTel = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblErrorTel = new javax.swing.JLabel();
        lblBack = new javax.swing.JLabel();
        lblNext1 = new javax.swing.JLabel();
        lblPrint = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1100, 620));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlCover.setBackground(new java.awt.Color(255, 255, 255));
        pnlCover.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtGusetID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtGusetID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGusetIDActionPerformed(evt);
            }
        });
        pnlCover.add(txtGusetID, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 200, 30));

        txtNIC.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtNIC.setName("nic"); // NOI18N
        txtNIC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNICKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNICKeyTyped(evt);
            }
        });
        pnlCover.add(txtNIC, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 20, 200, 30));

        jComboBox1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mr", "Mrs", "Miss" }));
        pnlCover.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, 80, 30));

        txtpassport.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pnlCover.add(txtpassport, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 80, 200, 30));

        txtf_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtf_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtf_nameActionPerformed(evt);
            }
        });
        pnlCover.add(txtf_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 200, 30));

        txtdob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdobActionPerformed(evt);
            }
        });
        pnlCover.add(txtdob, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 140, 200, 30));

        txtl_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pnlCover.add(txtl_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 210, 200, 30));

        txtagent.setEditable(false);
        txtagent.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtagent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtagentActionPerformed(evt);
            }
        });
        pnlCover.add(txtagent, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 200, 200, 30));

        txtnatinality.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pnlCover.add(txtnatinality, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 270, 200, 30));

        txtEmail.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtEmail.setName("email"); // NOI18N
        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEmailKeyTyped(evt);
            }
        });
        pnlCover.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 410, 200, 30));

        txtTel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTel.setName("telNo"); // NOI18N
        txtTel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelActionPerformed(evt);
            }
        });
        txtTel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTelKeyReleased(evt);
            }
        });
        pnlCover.add(txtTel, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 490, 200, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Passport Number :");
        pnlCover.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 80, 200, 30));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel10.setText("Contact Details");
        pnlCover.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 240, 60));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 102, 102));
        jLabel13.setText("Mobile Number :");
        pnlCover.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 490, 150, 30));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setText("Nationality :");
        pnlCover.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 150, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("First Name :");
        pnlCover.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 150, 30));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setText("E-mail :");
        pnlCover.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, 150, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("NIC :");
        pnlCover.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 20, 150, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Last Name:");
        pnlCover.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 150, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Agent :");
        pnlCover.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 200, 150, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Guset ID :");
        pnlCover.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 150, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Date Of Birth :");
        pnlCover.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 140, 150, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Title :");
        pnlCover.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 150, 30));

        lblErrorTel.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        lblErrorTel.setForeground(new java.awt.Color(255, 0, 0));
        pnlCover.add(lblErrorTel, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 530, 180, 20));

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
        pnlCover.add(lblBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 540, 170, 50));

        lblNext1.setBackground(new java.awt.Color(221, 188, 9));
        lblNext1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lblNext1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNext1.setText("Next");
        lblNext1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblNext1.setName("lblMain"); // NOI18N
        lblNext1.setOpaque(true);
        lblNext1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblNext1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblNext1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblNext1MouseExited(evt);
            }
        });
        pnlCover.add(lblNext1, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 540, 170, 50));

        lblPrint.setBackground(new java.awt.Color(221, 188, 9));
        lblPrint.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lblPrint.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPrint.setText("Registration Card");
        lblPrint.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblPrint.setName("lblMain"); // NOI18N
        lblPrint.setOpaque(true);
        lblPrint.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPrintMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblPrintMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblPrintMouseExited(evt);
            }
        });
        pnlCover.add(lblPrint, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 550, 200, 50));

        add(pnlCover, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 620));
    }// </editor-fold>//GEN-END:initComponents

    private void txtTelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelActionPerformed

    private void txtTelKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelKeyReleased
        
    }//GEN-LAST:event_txtTelKeyReleased

    private void txtEmailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyTyped
        
    }//GEN-LAST:event_txtEmailKeyTyped

    private void txtNICKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNICKeyReleased
       
    }//GEN-LAST:event_txtNICKeyReleased

    private void txtNICKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNICKeyTyped
        
    }//GEN-LAST:event_txtNICKeyTyped

    private void txtGusetIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGusetIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGusetIDActionPerformed

    private void txtagentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtagentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtagentActionPerformed

    private void txtf_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtf_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtf_nameActionPerformed

    private void lblBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBackMouseClicked
            Reception frmMain=(Reception) SwingUtilities.getWindowAncestor(this);
            frmMain.pnlMain.removeAll();
            Availability avl=new Availability();
            frmMain.add(avl);
            frmMain.removeAll();
            AvailabilityTitle title=new AvailabilityTitle();
            frmMain.pnltitle.add(title);
            frmMain.pnlMain.updateUI();
        
    }//GEN-LAST:event_lblBackMouseClicked

    private void lblNext1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNext1MouseClicked
        ArrayList<Object[]> rows=Availability.rows;
        ArrayList<RoomDTO> roomsData = new ArrayList<>();
        boolean email = true;
        boolean tel = true;
        boolean nic = true;
        try {
            email = DataValidation.Validation(txtEmail);
            tel=DataValidation.Validation(txtTel);
            nic=DataValidation.Validation(txtNIC);
        } catch (SQLException ex) {
            Logger.getLogger(AgentAddGuest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AgentAddGuest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(!email || !tel || !nic){
            if(!email){
                txtEmail.setText("");
            }
            if(!tel){
                txtTel.setText("");
            }
            if(!nic){
                txtNIC.setText("");
            }
            return;
        }else{
            
            for (Object[] row : rows) {
                RoomDTO r=new RoomDTO(row[0].toString(),row[1].toString(),row[2].toString(),Double.parseDouble(row[3].toString()));
                roomsData.add(r);
                
            }
            
            Date date=txtdob.getDate();
            Date d=new Date();
            DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
            String dob=dateFormat.format(date);
            String curDate=dateFormat.format(d);
            try {
                guestID=txtGusetID.getText();
                guestTel=txtTel.getText();
                GuestDTO g1=new GuestDTO(guestID,txtf_name.getText(),txtl_name.getText(),dob,txtnatinality.getText(),txtpassport.getText(),txtNIC.getText(),guestTel);
                guestName=g1.getFName()+" "+g1.getLName();
                
                String checkIn=SearchRooms.checkIn;
                String checkOut=SearchRooms.checkOut;
                String agent=txtagent.getText();
                ReservationDTO r1=new ReservationDTO(resId,checkIn,checkOut,agent);
                ArrayList<ReservationDetailsDTO> resDetails=new ArrayList<>();
                int count=0;
                String lastId=IDGenerator.getNewID("ReservationDetails", "ResDetails_ID", "D");
                String resDetils_id;
                for (RoomDTO r : roomsData) { 
                    if(count==0){
                        resDetils_id=IDGenerator.getNewID("ReservationDetails", "ResDetails_ID", "D");
                    }else{
                        lastId=IDGenerator.getNewID(lastId, "D");
                        resDetils_id=lastId;
                    }
                    ReservationDetailsDTO res=new ReservationDetailsDTO(resDetils_id,guestID,r.getRoomID(),resId,curDate,r.getRoomPrice());
                    resDetails.add(res);
                    count++;
                }
                GuestDTO details=new GuestDTO(guestID,txtf_name.getText(),txtl_name.getText(),txtnatinality.getText(),dob,txtpassport.getText(),txtNIC.getText(),guestTel,r1,resDetails);
                boolean result=ctrlGuest.addNewReservation(details);
            } catch (SQLException ex) {
                Logger.getLogger(AddGuest.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(AddGuest.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(AddGuest.class.getName()).log(Level.SEVERE, null, ex);
            }
            Reception frmMain=(Reception) SwingUtilities.getWindowAncestor(this);
            frmMain.pnlMain.removeAll();
            ReservationForm res=new ReservationForm();
            frmMain.pnlMain.add(res);
            frmMain.pnltitle.removeAll();
            ReservationTitle title=new ReservationTitle();
            frmMain.pnltitle.add(title);
            frmMain.pnlMain.updateUI();
            
        }
    }//GEN-LAST:event_lblNext1MouseClicked

    private void txtdobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdobActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdobActionPerformed

    private void lblPrintMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPrintMouseClicked
        Date date=txtdob.getDate();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String dob=sdf.format(date);
        try {
            Connection con=ConnectionFactory.getInstance().getConnection();
            JasperReport compiledReport=(JasperReport) JRLoader.loadObject(AddGuest.class.getResourceAsStream("/edu/gdse41/sem1project/reports/Registration.jasper"));
            Map<String,Object> parameters=new HashMap<>();
            parameters.put("agent", "");
            parameters.put("res_id", resId);
            parameters.put("checkIn", SearchRooms.checkIn);
            parameters.put("checkOut", SearchRooms.checkOut);
            parameters.put("noOfAdults", ""+SearchRooms.noOfAdults);
            parameters.put("noOfKids", ""+SearchRooms.noOfKids);
            parameters.put("lastName", txtl_name.getText());
            parameters.put("nic", txtNIC.getText());
            parameters.put("firstName", txtf_name.getText());
            parameters.put("nationality", txtnatinality.getText());
            parameters.put("dob", dob);
            parameters.put("passport", txtpassport.getText());
            parameters.put("tel", txtTel.getText());
            parameters.put("email", txtEmail.getText());
            JasperPrint filledReport=JasperFillManager.fillReport(compiledReport, parameters, new JREmptyDataSource());
            JasperReportViewer jasperViewer=new JasperReportViewer(filledReport);
            jasperViewer.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(AddGuest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lblPrintMouseClicked

    private void lblPrintMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPrintMouseEntered
        lblPrint.setBackground(new Color(255,162,0));
        lblPrint.setOpaque(true);
    }//GEN-LAST:event_lblPrintMouseEntered

    private void lblPrintMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPrintMouseExited
        lblPrint.setBackground(new Color(221,188,9));
        lblPrint.setOpaque(true);
    }//GEN-LAST:event_lblPrintMouseExited

    private void lblBackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBackMouseEntered
        lblBack.setBackground(new Color(255,162,0));
        lblBack.setOpaque(true);
    }//GEN-LAST:event_lblBackMouseEntered

    private void lblBackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBackMouseExited
        lblBack.setBackground(new Color(221,188,9));
        lblBack.setOpaque(true);
    }//GEN-LAST:event_lblBackMouseExited

    private void lblNext1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNext1MouseEntered
        lblNext1.setBackground(new Color(255,162,0));
        lblNext1.setOpaque(true);
    }//GEN-LAST:event_lblNext1MouseEntered

    private void lblNext1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNext1MouseExited
        lblNext1.setBackground(new Color(221,188,9));
        lblNext1.setOpaque(true);
    }//GEN-LAST:event_lblNext1MouseExited

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblBack;
    private javax.swing.JLabel lblErrorTel;
    private javax.swing.JLabel lblNext1;
    private javax.swing.JLabel lblPrint;
    private javax.swing.JPanel pnlCover;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtGusetID;
    private javax.swing.JTextField txtNIC;
    private javax.swing.JTextField txtTel;
    private javax.swing.JTextField txtagent;
    private org.jdesktop.swingx.JXDatePicker txtdob;
    private javax.swing.JTextField txtf_name;
    private javax.swing.JTextField txtl_name;
    private javax.swing.JTextField txtnatinality;
    private javax.swing.JTextField txtpassport;
    // End of variables declaration//GEN-END:variables
}
