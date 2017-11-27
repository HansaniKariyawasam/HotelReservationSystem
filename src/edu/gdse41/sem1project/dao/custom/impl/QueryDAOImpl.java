/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gdse41.sem1project.dao.custom.impl;

import edu.gdse41.sem1project.dao.custom.QueryDAO;
import edu.gdse41.sem1project.dao.db.ConnectionFactory;
import edu.gdse41.sem1project.dto.GuestDTO;
import edu.gdse41.sem1project.dto.PaymentDTO;
import edu.gdse41.sem1project.dto.ReservationDTO;
import edu.gdse41.sem1project.dto.ReservationDetailsDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Hansani Kariyawasam
 */
public class QueryDAOImpl implements QueryDAO{
    
    private Connection conn;

    public QueryDAOImpl() {
        conn=ConnectionFactory.getInstance().getConnection();
    }
    
    @Override
    public ArrayList<ReservationDTO> searchAvailability()throws Exception{
        String sql="select check_in_date,Check_Out_Date\n" +
                    "from room,reservation,reservationdetails\n" +
                    "where reservationdetails.room_id=room.room_id and\n" +
                    "reservation.res_id=reservationdetails.res_id\n" +
                    "group by check_in_date";
        Statement stm=conn.createStatement();
        ArrayList<ReservationDTO> dates=new ArrayList<>();
        ResultSet rst=stm.executeQuery(sql);
        while(rst.next()){
            ReservationDTO r=new ReservationDTO();
            r.setCheckInDate(rst.getString(1));
            r.setCheckOutDate(rst.getString(2));
            dates.add(r);
        }
        return dates;
    }
    
    @Override
    public ArrayList<Object[]> viewReservationDetails()throws Exception{
        String sql="select reservationdetails.res_id,reservationdetails.gid,\n" +
                    "CONCAT(f_name, \" \" ,l_name),nic,passport,\n" +
                    "reservationdetails.room_id,room_type,Reserved_Date,\n" +
                    "Check_In_Date,Check_Out_Date,agent\n" +
                    "from reservation,reservationdetails,room,guest\n" +
                    "where reservation.res_id=reservationdetails.res_id and\n" +
                    "room.room_id=reservationdetails.room_id and\n" +
                    "reservationdetails.gid=guest.gid\n" +
                    "order by res_id asc";
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        ArrayList<Object[]> resList=new ArrayList<>();
        while(rst.next()){
            Object [] res={rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5),rst.getString(6),rst.getString(7),rst.getString(8),rst.getString(9),rst.getString(10),rst.getString(11)};
            resList.add(res);
        }
        return resList;
    }
    
    @Override
    public ArrayList<Object []> viewPaymentDetails(String id)throws Exception{
        ResultSet rst;
        if(id!=null){
            String sql="select reservationdetails.res_id,CONCAT(f_name, \" \" ,l_name),paymentDate,sum((day(Check_Out_Date)-day(Check_In_Date))*price),\n" +
                        "amountPaid,sum((day(Check_Out_Date)-day(Check_In_Date))*price)-amountPaid\n" +
                        "from reservation,reservationdetails,guest,Payment\n" +
                        "where guest.gid=reservationdetails.gid and\n" +
                        "reservation.res_id=reservationdetails.res_id and\n" +
                        "payment.res_id=reservation.res_id and\n" +
                        "reservationdetails.gid=?";
            PreparedStatement stm=conn.prepareStatement(sql);
            stm.setObject(1, id);
            rst=stm.executeQuery();
        }else{
            System.out.println("Enter");
            String sql="select reservationdetails.res_id,CONCAT(f_name, \" \" ,l_name),paymentDate,sum((day(Check_Out_Date)-day(Check_In_Date))*price),\n" +
                        "amountPaid,sum((day(Check_Out_Date)-day(Check_In_Date))*price)-amountPaid\n" +
                        "from reservation,reservationdetails,guest,Payment\n" +
                        "where guest.gid=reservationdetails.gid and\n" +
                        "reservation.res_id=reservationdetails.res_id and\n" +
                        "payment.res_id=reservation.res_id \n" +
                        "group by reservationdetails.res_id";
            Statement stm=conn.createStatement();
            rst=stm.executeQuery(sql);
        }
        ;
        ArrayList<Object []> detailslist=new ArrayList<>();
        while(rst.next()){
            Object [] o={rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5),rst.getString(6)};
            detailslist.add(o);
        }
        return detailslist;
    }
    
    @Override
    public ArrayList<String> getAllGuestHistroyIDs(String agent)throws SQLException,ClassNotFoundException{
            if(agent!=null){    
                String sql="select distinct gid from reservationDetails, reservation where reservationDetails.res_id=reservation.res_id && reservation.agent=?; ";
                PreparedStatement stm=conn.prepareStatement(sql);
                stm.setObject(1,agent);
                ResultSet rst=stm.executeQuery();
                ArrayList<String> guestIDs=new ArrayList<>();
                while(rst.next()){
                    guestIDs.add(rst.getString(1));
                }
                return guestIDs;
            }else{
                String sql="select*from guest";
                Statement stm=conn.createStatement();
                ResultSet rst=stm.executeQuery(sql);
                ArrayList<String> guestIDs=new ArrayList<>();
                while(rst.next()){
                    guestIDs.add(rst.getString(1));
                }
                return guestIDs;
            }
        
    }
    
    @Override
    public ArrayList<GuestDTO> loadGuestDetails()throws SQLException,ClassNotFoundException{
        String sql="select  reservationdetails.gid,agent,f_name,l_name,DOB,Nationality,NIC,Passport,tel\n" +
                    "from guest,reservation,reservationdetails\n" +
                    "where guest.gid=reservationdetails.gid and\n" +
                    "reservation.res_id=reservationdetails.res_id\n" +
                    "group by reservationdetails.gid;";
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        ArrayList<GuestDTO> guestDetails=new ArrayList<>();
        while(rst.next()){
            GuestDTO g=new GuestDTO(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5),rst.getString(6),rst.getString(7),rst.getString(8),rst.getString(9));
            guestDetails.add(g);
        }
        return guestDetails;
    }
    

    @Override
    public ArrayList<ReservationDetailsDTO> searchResDetails(String id)throws Exception{
        String sql="select res_id,guest.gid,Reserved_Date,f_name,l_name,tel\n" +
                    "from reservationdetails,guest\n" +
                    "where reservationdetails.gid=guest.gid and\n" +
                    "guest.gid=? group by reservationdetails.res_id";
        PreparedStatement stm=conn.prepareStatement(sql);
        stm.setObject(1, id);
        ResultSet rst=stm.executeQuery();
        ArrayList<ReservationDetailsDTO> resDetails=new ArrayList<>();
        while(rst.next()){
            ReservationDetailsDTO r=new ReservationDetailsDTO(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5),rst.getString(6));
            resDetails.add(r);
        }
        return resDetails;
    }
    
    @Override
    public PaymentDTO searchPaymentDetails(String id)throws Exception{
            String sql="select pid,paymentDate,CONCAT(f_name, \" \" ,l_name),reservationdetails.res_id\n" +
                        "from reservationdetails,guest,reservation,payment\n" +
                        "where reservationdetails.res_id=reservation.res_id and\n" +
                        "payment.res_id=reservation.res_id and\n" +
                        "reservationdetails.gid=guest.gid and \n" +
                        "reservationdetails.gid=?";
            PreparedStatement stm=conn.prepareStatement(sql);
            stm.setObject(1, id);
            ResultSet rst=stm.executeQuery();
            if(rst.next()){
                PaymentDTO p1=new PaymentDTO();//(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4));
                p1.setPaymentID(rst.getString(1));
                p1.setPaymentDate(rst.getString(2));
                p1.setGuestName(rst.getString(3));
                p1.setResID(rst.getString(4));
                return p1;
            }
            return null;
    }
    
}
