/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gdse41.sem1project.dao.custom.impl;

import edu.gdse41.sem1project.dao.custom.ReservationDAO;
import edu.gdse41.sem1project.dao.db.ConnectionFactory;
import edu.gdse41.sem1project.dto.ReservationDTO;
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
public class ReservationDAOImpl implements ReservationDAO{
    
    private Connection conn;

    public ReservationDAOImpl() {
        conn=ConnectionFactory.getInstance().getConnection();
    }
    

    @Override
    public boolean add(ReservationDTO r1) throws Exception {
        String sql="Insert into Reservation values(?,?,?,?)";
        PreparedStatement stm=conn.prepareStatement(sql);
        stm.setObject(1, r1.getResID());
        stm.setObject(2, r1.getCheckInDate());
        stm.setObject(3, r1.getCheckOutDate());
        stm.setObject(4, r1.getAgent());
        return stm.executeUpdate()>0;
    }

    @Override
    public boolean update(ReservationDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String key) throws Exception {
        String sql="Delete from Reservation where Res_id=?";
        PreparedStatement stm=conn.prepareStatement(sql);
        stm.setObject(1, key);
        return stm.executeUpdate()>0;
    }

    @Override
    public ReservationDTO get(String id) throws Exception {
        String sql="Select*from Reservation where Res_ID=?";
        PreparedStatement stm=conn.prepareStatement(sql);
        stm.setObject(1, id);
        ResultSet rst=stm.executeQuery();
        if(rst.next()){
            ReservationDTO r1=new ReservationDTO(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4));
            return r1;
        }
        return null;
    }

    @Override
    public ArrayList<ReservationDTO> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<String> getAllResIDs() throws SQLException, ClassNotFoundException {
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery("Select*from Reservation");
        ArrayList<String> reservationIDs=new ArrayList<>();
        while(rst.next()){
            reservationIDs.add(rst.getString(1));
        }
        return reservationIDs;
    }
    
}
