///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package edu.gdse41.sem1project.controller.custom.impl;
//
//import edu.gdse41.sem1project.dao.db.ConnectionFactory;
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
///**
// *
// * @author Hansani Kariyawasam
// */
//public class IDController {
//    
//    private static Connection conn;
//
//    public IDController() {
//        conn=ConnectionFactory.getInstance().getConnection();
//    }
//    
//    
//    
//    public static String newID() throws SQLException, ClassNotFoundException{
//        String sql="SELECT Res_ID FROM Reservation";
//        Statement stm=conn.createStatement();
//        ResultSet rst=stm.executeQuery(sql);
//        rst.last();
//        String regId="";
//        char[] reg=rst.getString(1).toCharArray();
//        for(int i=1;i<reg.length;i++){
//            regId+=reg[i];
//        }
//        int r=Integer.parseInt(regId);
//        if(r<9){
//            return "R00"+(r+1);  
//        }else if(r<99){
//            return "R0"+(r+1);
//        }
//        return "R"+(r+1);
//    }
//    
//    public static String newGuestID()throws SQLException,ClassNotFoundException{
//        String sql="select GID from guest";
//        Statement stm=conn.createStatement();
//        ResultSet rst=stm.executeQuery(sql);
//        rst.last();
//        String guestID="";
//        char [] guest=rst.getString(1).toCharArray();
//        for(int i=1;i<guest.length;i++){
//            guestID+=guest[i];
//        }
//        int g=Integer.parseInt(guestID);
//        if(g<9){
//            return "C00"+(g+1);
//        }else if(g<99){
//            return "C0"+(g+1);
//        }
//        return "C"+(g+1);
//    }
//    
//    public static String newPaymentID()throws SQLException,ClassNotFoundException{
//        String sql="select PID from Payment";
//        Statement stm=conn.createStatement();
//        ResultSet rst=stm.executeQuery(sql);
//        rst.last();
//        String paymentID="";
//        char [] payment=rst.getString(1).toCharArray();
//        for(int i=1;i<payment.length;i++){
//            paymentID+=payment[i];
//        }
//        int p=Integer.parseInt(paymentID);
//        if(p<9){
//            return "P00"+(p+1);
//        }else if(p<99){
//            return "P0"+(p+1);
//        }
//        return "C"+(p+1);
//    }
//}
