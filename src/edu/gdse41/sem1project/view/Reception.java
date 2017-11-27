/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gdse41.sem1project.view;

import edu.gdse41.sem1project.dao.db.ConnectionFactory;
import edu.gdse41.sem1project.view.panels.AgentReserveRoom;
import edu.gdse41.sem1project.view.panels.ReceptionPaymentDetails;
import edu.gdse41.sem1project.view.panels.RepeatedGuestResRm;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import edu.gdse41.sem1project.view.panels.SearchRooms;
import edu.gdse41.sem1project.view.panels.titles.AvailabilityTitle;
import edu.gdse41.sem1project.view.panels.titles.CancelResTitle;
import edu.gdse41.sem1project.view.panels.titles.PaymentDetlsTitle;
import edu.gdse41.sem1project.view.panels.titles.SearchRmTitle;
import edu.gdse41.sem1project.view.panels.titles.ViewGuestHstryTitle;
import edu.gdse41.sem1project.view.panels.titles.ViewResTitle;
import java.awt.Color;
import java.awt.Component;
import java.awt.KeyEventPostProcessor;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 *
 * @author Hansani Kariyawasam
 */
public class Reception extends javax.swing.JFrame {
    
    public static String checkIn;
    public static String checkOut;
    Connection conn=ConnectionFactory.getInstance().getConnection();
    
    /**
     * Creates new form Reception
     */
    public static JPanel pnlChange=null;
    private Timer timer;
    private final SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss");
    
    public Reception() {
        initComponents();
        reserveRoomPanel.setVisible(false);
        pnlViewReports.setVisible(false);
        setLocationRelativeTo(null);
        loadPanels(new SearchRooms());
        loadTitles(new SearchRmTitle());
        
        KeyboardFocusManager kfm=KeyboardFocusManager.getCurrentKeyboardFocusManager();
        kfm.addKeyEventPostProcessor(new KeyEventPostProcessor() {

            @Override
            public boolean postProcessKeyEvent(KeyEvent e) {
                switch(e.getKeyCode()){
                    case KeyEvent.VK_F1:
                        if(e.getID()==KeyEvent.KEY_PRESSED){
                            
                            loadPanels(new SearchRooms());
                            loadTitles(new SearchRmTitle());
                            
                        }
                        break;
                    case KeyEvent.VK_F2:
                        if(e.getID()==KeyEvent.KEY_PRESSED){
                            
                            loadPanels(new edu.gdse41.sem1project.view.panels.CancelReservation());
                            loadTitles(new CancelResTitle());
                            
                        }
                        break;
                    case KeyEvent.VK_F3:
                        if(e.getID()==KeyEvent.KEY_PRESSED){
                            
                            loadPanels(new edu.gdse41.sem1project.view.panels.ViewReservation());
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
                            
                            loadPanels(new edu.gdse41.sem1project.view.panels.ViewGuestHistory());
                            loadTitles(new ViewGuestHstryTitle());
                            
                        }
                        break;
                    case KeyEvent.VK_F6:
                        if(e.getID()==KeyEvent.KEY_PRESSED){
                            loadPanels(new ReceptionPaymentDetails());
                            loadTitles(new PaymentDetlsTitle());
                        }
                }
                return true;
            }
        });
        try{
            Component[] panels=jPanel2.getComponents();
            for(Component com:panels){
                if(com instanceof JPanel){
                    JPanel pan=(JPanel)com;
                    if(pan.getName().equals("covers")){
                        Component [] components=pan.getComponents();
                        for (Component component : components) {
                           
                            if(component instanceof JLabel){
                               //Label lbl=(JLabel) component;
                                String name=((JLabel) component).getName();
                                boolean isTrue=false;
                                
                                if(isTrue){
                                    ((JLabel) component).addMouseListener(new MouseAdapter() {

                                        @Override
                                        public void mouseEntered(MouseEvent e) {
                                            ((JLabel) component).setBackground(new Color(255,162,0));
                                            ((JLabel) component).setOpaque(true);
                                        }

                                        @Override
                                        public void mouseExited(MouseEvent e) {
                                            ((JLabel) component).setBackground(new Color(221,188,9));
                                            ((JLabel) component).setOpaque(true);
                                        }  
                                    });
                                }
                            }
                        }
                    }
                }
            }
        }catch(NullPointerException e){
           
        }
    }
    
    public Reception(JPanel pnl){
        loadPanels(pnl);
    }
    
    public static void loadStaticPanel(JPanel pnl){
        new Reception(pnl);
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

        jPanel2 = new javax.swing.JPanel();
        pnlViewReports = new javax.swing.JPanel();
        lblGuestDetails = new javax.swing.JLabel();
        lblBdys = new javax.swing.JLabel();
        lblRes = new javax.swing.JLabel();
        lblResDetails = new javax.swing.JLabel();
        lblMonthlyIncome = new javax.swing.JLabel();
        lblAnnualIncome = new javax.swing.JLabel();
        lblClose = new javax.swing.JLabel();
        reserveRoomPanel = new javax.swing.JPanel();
        lblBookingAgent = new javax.swing.JLabel();
        lblCheckAvailable = new javax.swing.JLabel();
        lblRepeat = new javax.swing.JLabel();
        pnlMain = new javax.swing.JPanel();
        lblMinimize = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblViewReservation = new javax.swing.JLabel();
        lblCancelReserv = new javax.swing.JLabel();
        lblGuestHistory = new javax.swing.JLabel();
        lblReserveRoom = new javax.swing.JLabel();
        lblViewPayment = new javax.swing.JLabel();
        lblLogOut = new javax.swing.JLabel();
        lblViewPayment1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pnltitle = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jPanel2.add(pnlViewReports, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 460, 230, 300));

        lblClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/gdse41/sem1project/resources/images/Untitled-4.png"))); // NOI18N
        lblClose.setToolTipText("Close ");
        lblClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCloseMouseClicked(evt);
            }
        });
        jPanel2.add(lblClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(1340, 0, 20, 30));

        reserveRoomPanel.setBackground(new java.awt.Color(255, 255, 255));
        reserveRoomPanel.setName("covers"); // NOI18N
        reserveRoomPanel.setOpaque(false);
        reserveRoomPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblBookingAgent.setBackground(new java.awt.Color(221, 188, 9));
        lblBookingAgent.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblBookingAgent.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblBookingAgent.setText(" Booking (Agent)");
        lblBookingAgent.setName("lblMain"); // NOI18N
        lblBookingAgent.setOpaque(true);
        lblBookingAgent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBookingAgentMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblBookingAgentMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblBookingAgentMouseExited(evt);
            }
        });
        reserveRoomPanel.add(lblBookingAgent, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 230, 40));

        lblCheckAvailable.setBackground(new java.awt.Color(221, 188, 9));
        lblCheckAvailable.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblCheckAvailable.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblCheckAvailable.setText(" Direct Booking");
        lblCheckAvailable.setName("lblMain"); // NOI18N
        lblCheckAvailable.setOpaque(true);
        lblCheckAvailable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCheckAvailableMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblCheckAvailableMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblCheckAvailableMouseExited(evt);
            }
        });
        reserveRoomPanel.add(lblCheckAvailable, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 230, 40));

        lblRepeat.setBackground(new java.awt.Color(221, 188, 9));
        lblRepeat.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblRepeat.setText("Repeated Guest");
        lblRepeat.setOpaque(true);
        lblRepeat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRepeatMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblRepeatMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblRepeatMouseExited(evt);
            }
        });
        reserveRoomPanel.add(lblRepeat, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 230, 40));

        jPanel2.add(reserveRoomPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 190, 230, 160));

        pnlMain.setBackground(new java.awt.Color(255, 255, 255));
        pnlMain.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlMainMouseEntered(evt);
            }
        });
        pnlMain.setLayout(new java.awt.CardLayout());
        jPanel2.add(pnlMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 150, 1100, 620));

        lblMinimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/gdse41/sem1project/resources/images/Untitled-4_1.png"))); // NOI18N
        lblMinimize.setToolTipText("Minimize");
        lblMinimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMinimizeMouseClicked(evt);
            }
        });
        jPanel2.add(lblMinimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 0, 20, 30));

        jPanel3.setBackground(new java.awt.Color(221, 188, 9));
        jPanel3.setName("covers"); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblViewReservation.setBackground(new java.awt.Color(221, 188, 9));
        lblViewReservation.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lblViewReservation.setText(" [F3]  View Reservation");
        lblViewReservation.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblViewReservation.setName("lblMain"); // NOI18N
        lblViewReservation.setOpaque(true);
        lblViewReservation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblViewReservationMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblViewReservationMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblViewReservationMouseExited(evt);
            }
        });
        jPanel3.add(lblViewReservation, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 250, 80));

        lblCancelReserv.setBackground(new java.awt.Color(221, 188, 9));
        lblCancelReserv.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lblCancelReserv.setText(" [F2]  Cancel Reservation");
        lblCancelReserv.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblCancelReserv.setName("lblMain"); // NOI18N
        lblCancelReserv.setOpaque(true);
        lblCancelReserv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCancelReservMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblCancelReservMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblCancelReservMouseExited(evt);
            }
        });
        jPanel3.add(lblCancelReserv, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 250, 80));

        lblGuestHistory.setBackground(new java.awt.Color(221, 188, 9));
        lblGuestHistory.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lblGuestHistory.setText(" [F5]  View Guest History");
        lblGuestHistory.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblGuestHistory.setName("lblMain"); // NOI18N
        lblGuestHistory.setOpaque(true);
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
        jPanel3.add(lblGuestHistory, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 250, 80));

        lblReserveRoom.setBackground(new java.awt.Color(221, 188, 9));
        lblReserveRoom.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lblReserveRoom.setText(" [F1]   Reserve a Room");
        lblReserveRoom.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblReserveRoom.setName("lblMain"); // NOI18N
        lblReserveRoom.setOpaque(true);
        lblReserveRoom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblReserveRoomMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblReserveRoomMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblReserveRoomMouseExited(evt);
            }
        });
        jPanel3.add(lblReserveRoom, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 250, 80));

        lblViewPayment.setBackground(new java.awt.Color(221, 188, 9));
        lblViewPayment.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lblViewPayment.setText(" [F4]  View Reports");
        lblViewPayment.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblViewPayment.setName("lblMain"); // NOI18N
        lblViewPayment.setOpaque(true);
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
        jPanel3.add(lblViewPayment, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 250, 80));

        lblLogOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/gdse41/sem1project/resources/images/LogOut.png"))); // NOI18N
        lblLogOut.setToolTipText("Log out");
        lblLogOut.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblLogOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLogOutMouseClicked(evt);
            }
        });
        jPanel3.add(lblLogOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 570, 45, 50));

        lblViewPayment1.setBackground(new java.awt.Color(221, 188, 9));
        lblViewPayment1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lblViewPayment1.setText(" [F6]  Payment Details");
        lblViewPayment1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblViewPayment1.setName("lblMain"); // NOI18N
        lblViewPayment1.setOpaque(true);
        lblViewPayment1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblViewPayment1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblViewPayment1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblViewPayment1MouseExited(evt);
            }
        });
        jPanel3.add(lblViewPayment1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, 250, 80));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 270, 620));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/gdse41/sem1project/resources/images/logo.png"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 150));

        pnltitle.setBackground(new java.awt.Color(255, 255, 255));
        pnltitle.setLayout(new java.awt.CardLayout());
        jPanel2.add(pnltitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 10, 670, 140));
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 770));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 770));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMouseClicked
        System.exit(0);
    }//GEN-LAST:event_lblCloseMouseClicked

    private void lblMinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMinimizeMouseClicked
        setExtendedState(Reception.ICONIFIED);
    }//GEN-LAST:event_lblMinimizeMouseClicked

    private void lblViewReservationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblViewReservationMouseClicked
        
            loadPanels(new edu.gdse41.sem1project.view.panels.ViewReservation());
            loadTitles(new ViewResTitle());
        
    }//GEN-LAST:event_lblViewReservationMouseClicked

    private void lblViewReservationMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblViewReservationMouseEntered
        reserveRoomPanel.setVisible(false);
        pnlViewReports.setVisible(false);
        lblViewReservation.setBackground(new Color(255,162,0));
        lblViewReservation.setOpaque(true);
    }//GEN-LAST:event_lblViewReservationMouseEntered

    private void lblViewReservationMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblViewReservationMouseExited
        lblViewReservation.setBackground(new Color(221,188,9));
        lblViewReservation.setOpaque(true);
    }//GEN-LAST:event_lblViewReservationMouseExited

    private void lblCancelReservMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCancelReservMouseClicked
    
            loadPanels(new edu.gdse41.sem1project.view.panels.CancelReservation());
            loadTitles(new CancelResTitle());
        
    }//GEN-LAST:event_lblCancelReservMouseClicked

    private void lblCancelReservMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCancelReservMouseEntered

        reserveRoomPanel.setVisible(false);
        pnlViewReports.setVisible(false);
        lblCancelReserv.setBackground(new Color(255,162,0));
        lblCancelReserv.setOpaque(true);
    }//GEN-LAST:event_lblCancelReservMouseEntered

    private void lblCancelReservMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCancelReservMouseExited
        lblCancelReserv.setBackground(new Color(221,188,9));
        lblCancelReserv.setOpaque(true);
    }//GEN-LAST:event_lblCancelReservMouseExited

    private void lblGuestHistoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGuestHistoryMouseClicked
        loadPanels(new edu.gdse41.sem1project.view.panels.ViewGuestHistory());
        loadTitles(new ViewGuestHstryTitle());
    }//GEN-LAST:event_lblGuestHistoryMouseClicked

    private void lblGuestHistoryMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGuestHistoryMouseEntered
        pnlViewReports.setVisible(false);
        reserveRoomPanel.setVisible(false);
        lblGuestHistory.setBackground(new Color(255,162,0));
        lblGuestHistory.setOpaque(true);
    }//GEN-LAST:event_lblGuestHistoryMouseEntered

    private void lblGuestHistoryMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGuestHistoryMouseExited
        lblGuestHistory.setBackground(new Color(221,188,9));
        lblGuestHistory.setOpaque(true);
    }//GEN-LAST:event_lblGuestHistoryMouseExited

    private void lblReserveRoomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblReserveRoomMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblReserveRoomMouseClicked

    private void lblReserveRoomMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblReserveRoomMouseEntered
        reserveRoomPanel.setVisible(true);
        pnlViewReports.setVisible(false);
        lblReserveRoom.setBackground(new Color(255,162,0));
        lblReserveRoom.setOpaque(true);
    }//GEN-LAST:event_lblReserveRoomMouseEntered

    private void lblReserveRoomMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblReserveRoomMouseExited
        lblReserveRoom.setBackground(new Color(221,188,9));
        lblReserveRoom.setOpaque(true);
    }//GEN-LAST:event_lblReserveRoomMouseExited

    private void lblViewPaymentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblViewPaymentMouseClicked
        
    }//GEN-LAST:event_lblViewPaymentMouseClicked

    private void lblViewPaymentMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblViewPaymentMouseEntered
        pnlViewReports.setVisible(true);
        reserveRoomPanel.setVisible(false);
        lblViewPayment.setBackground(new Color(255,162,0));
        lblViewPayment.setOpaque(true);
    }//GEN-LAST:event_lblViewPaymentMouseEntered

    private void lblViewPaymentMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblViewPaymentMouseExited
        lblViewPayment.setBackground(new Color(221,188,9));
        lblViewPayment.setOpaque(true);
    }//GEN-LAST:event_lblViewPaymentMouseExited

    private void lblCheckAvailableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCheckAvailableMouseClicked
       
            loadPanels(new SearchRooms());
            loadTitles(new SearchRmTitle());
        
    }//GEN-LAST:event_lblCheckAvailableMouseClicked

    private void lblCheckAvailableMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCheckAvailableMouseEntered
       lblCheckAvailable.setBackground(new Color(255,162,0));
       lblCheckAvailable.setOpaque(true);
    }//GEN-LAST:event_lblCheckAvailableMouseEntered

    private void lblCheckAvailableMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCheckAvailableMouseExited
       lblCheckAvailable.setBackground(new Color(221,188,9));
       lblCheckAvailable.setOpaque(true);
    }//GEN-LAST:event_lblCheckAvailableMouseExited

    private void lblBookingAgentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBookingAgentMouseClicked
        loadPanels(new AgentReserveRoom());
        loadTitles(new AvailabilityTitle());
    }//GEN-LAST:event_lblBookingAgentMouseClicked

    private void lblBookingAgentMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBookingAgentMouseEntered
       lblBookingAgent.setBackground(new Color(255,162,0));
       lblBookingAgent.setOpaque(true);
    }//GEN-LAST:event_lblBookingAgentMouseEntered

    private void lblBookingAgentMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBookingAgentMouseExited
       lblBookingAgent.setBackground(new Color(221,188,9));
       lblBookingAgent.setOpaque(true);
    }//GEN-LAST:event_lblBookingAgentMouseExited

    private void lblLogOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogOutMouseClicked
        int res=JOptionPane.showConfirmDialog(this,"Do you want to log out?","Confirmation",JOptionPane.YES_NO_OPTION);
        if(res==0){
            new LogIn().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_lblLogOutMouseClicked

    private void pnlMainMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlMainMouseEntered
        //reserveRoomPanel.setVisible(false);
    }//GEN-LAST:event_pnlMainMouseEntered

    private void lblRepeatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRepeatMouseClicked
        loadPanels(new RepeatedGuestResRm());
        loadTitles(new AvailabilityTitle());
    }//GEN-LAST:event_lblRepeatMouseClicked

    private void lblViewPayment1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblViewPayment1MouseClicked
        loadPanels(new ReceptionPaymentDetails());
        loadTitles(new PaymentDetlsTitle());
    }//GEN-LAST:event_lblViewPayment1MouseClicked

    private void lblViewPayment1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblViewPayment1MouseEntered
        lblViewPayment1.setBackground(new Color(255,162,0));
        lblViewPayment1.setOpaque(true);
    }//GEN-LAST:event_lblViewPayment1MouseEntered

    private void lblViewPayment1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblViewPayment1MouseExited
        lblViewPayment1.setBackground(new Color(221,188,9));
        lblViewPayment1.setOpaque(true);
    }//GEN-LAST:event_lblViewPayment1MouseExited

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

    private void lblRepeatMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRepeatMouseEntered
        lblRepeat.setBackground(new Color(255,162,0));
        lblRepeat.setOpaque(true);
    }//GEN-LAST:event_lblRepeatMouseEntered

    private void lblRepeatMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRepeatMouseExited
        lblRepeat.setBackground(new Color(221,188,9));
        lblRepeat.setOpaque(true);
    }//GEN-LAST:event_lblRepeatMouseExited

    private void lblResDetailsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblResDetailsMouseEntered
        lblResDetails.setBackground(new Color(255,162,0));
        lblResDetails.setOpaque(true);
    }//GEN-LAST:event_lblResDetailsMouseEntered

    private void lblResDetailsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblResDetailsMouseExited
        lblResDetails.setBackground(new Color(221,188,9));
        lblResDetails.setOpaque(true);
    }//GEN-LAST:event_lblResDetailsMouseExited

    private void lblResMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblResMouseEntered
        lblRes.setBackground(new Color(255,162,0));
        lblRes.setOpaque(true);
    }//GEN-LAST:event_lblResMouseEntered

    private void lblResMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblResMouseExited
        lblRes.setBackground(new Color(221,188,9));
        lblRes.setOpaque(true);
    }//GEN-LAST:event_lblResMouseExited

    private void lblMonthlyIncomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMonthlyIncomeMouseEntered
        lblMonthlyIncome.setBackground(new Color(255,162,0));
        lblMonthlyIncome.setOpaque(true);
    }//GEN-LAST:event_lblMonthlyIncomeMouseEntered

    private void lblMonthlyIncomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMonthlyIncomeMouseExited
        lblMonthlyIncome.setBackground(new Color(221,188,9));
        lblMonthlyIncome.setOpaque(true);
    }//GEN-LAST:event_lblMonthlyIncomeMouseExited

    private void lblAnnualIncomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAnnualIncomeMouseEntered
        lblAnnualIncome.setBackground(new Color(255,162,0));
        lblAnnualIncome.setOpaque(true);
    }//GEN-LAST:event_lblAnnualIncomeMouseEntered

    private void lblAnnualIncomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAnnualIncomeMouseExited
        lblAnnualIncome.setBackground(new Color(221,188,9));
        lblAnnualIncome.setOpaque(true);
    }//GEN-LAST:event_lblAnnualIncomeMouseExited

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
            java.util.logging.Logger.getLogger(Reception.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reception.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reception.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reception.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reception().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    public javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblAnnualIncome;
    private javax.swing.JLabel lblBdys;
    private javax.swing.JLabel lblBookingAgent;
    private javax.swing.JLabel lblCancelReserv;
    private javax.swing.JLabel lblCheckAvailable;
    private javax.swing.JLabel lblClose;
    private javax.swing.JLabel lblGuestDetails;
    private javax.swing.JLabel lblGuestHistory;
    private javax.swing.JLabel lblLogOut;
    private javax.swing.JLabel lblMinimize;
    private javax.swing.JLabel lblMonthlyIncome;
    private javax.swing.JLabel lblRepeat;
    private javax.swing.JLabel lblRes;
    private javax.swing.JLabel lblResDetails;
    private javax.swing.JLabel lblReserveRoom;
    private javax.swing.JLabel lblViewPayment;
    private javax.swing.JLabel lblViewPayment1;
    private javax.swing.JLabel lblViewReservation;
    public javax.swing.JPanel pnlMain;
    public static javax.swing.JPanel pnlViewReports;
    public javax.swing.JPanel pnltitle;
    public static javax.swing.JPanel reserveRoomPanel;
    // End of variables declaration//GEN-END:variables
}
