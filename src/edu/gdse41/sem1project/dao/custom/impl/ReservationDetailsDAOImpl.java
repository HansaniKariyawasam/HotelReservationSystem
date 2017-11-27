/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gdse41.sem1project.dao.custom.impl;

import edu.gdse41.sem1project.dao.custom.ReservationDetailsDAO;
import edu.gdse41.sem1project.dao.db.ConnectionFactory;
import edu.gdse41.sem1project.dto.ReservationDetailsDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Hansani Kariyawasam
 */
public class ReservationDetailsDAOImpl implements ReservationDetailsDAO{
    
    private Connection conn;

    public ReservationDetailsDAOImpl() {
        conn=ConnectionFactory.getInstance().getConnection();
    }
    

    @Override
    public boolean add(ReservationDetailsDTO r) throws Exception {
        String sql="Insert into ReservationDetails values(?,?,?,?,?,?)";
        PreparedStatement stm=conn.prepareStatement(sql);
        stm.setObject(1, r.getResDetailsID());
        stm.setObject(2, r.getGuestID());
        stm.setObject(3, r.getRoomID());
        stm.setObject(4, r.getResID());
        stm.setObject(5, r.getReservedDate());
        stm.setObject(6, r.getPrice());
        return stm.executeUpdate()>0;
    }

    @Override
    public boolean update(ReservationDetailsDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String key) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ReservationDetailsDTO get(String id) throws Exception {
        String sql="Select*from ReservationDetails where Res_ID=?";
        PreparedStatement stm=conn.prepareStatement(sql);
        stm.setObject(1, id);
        ResultSet rst=stm.executeQuery();
        if(rst.next()){
            ReservationDetailsDTO rd=new ReservationDetailsDTO(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5),rst.getDouble(6));
            return rd;
        }
        return null;
    }

    @Override
    public ArrayList<ReservationDetailsDTO> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
