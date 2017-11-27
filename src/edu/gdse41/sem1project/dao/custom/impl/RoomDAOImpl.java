/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gdse41.sem1project.dao.custom.impl;

import edu.gdse41.sem1project.dao.custom.RoomDAO;
import edu.gdse41.sem1project.dao.db.ConnectionFactory;
import edu.gdse41.sem1project.dto.RoomDTO;
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
public class RoomDAOImpl implements RoomDAO{
    
    private Connection conn;

    public RoomDAOImpl() {
        conn=ConnectionFactory.getInstance().getConnection();
    }
    

    @Override
    public boolean add(RoomDTO r1) throws Exception {
        String sql="insert into Room values(?,?,?,?)";
        PreparedStatement stm=conn.prepareStatement(sql);
        stm.setObject(1, r1.getRoomID());
        stm.setObject(2, r1.getRoomType());
        stm.setObject(3, r1.getStatus());
        stm.setObject(4, r1.getRoomPrice());
        return stm.executeUpdate()>0;
    }

    @Override
    public boolean update(RoomDTO r1) throws Exception {
        String sql="Update Room set Room_Type=?,Status=?,Room_Price=? where Room_ID=? ";
        PreparedStatement stm=conn.prepareStatement(sql);
        stm.setObject(1, r1.getRoomType());
        stm.setObject(2, r1.getStatus());
        stm.setObject(3, r1.getRoomPrice());
        stm.setObject(4, r1.getRoomID());
        return stm.executeUpdate()>0;
    }

    @Override
    public boolean delete(String id) throws Exception {
        String sql="Delete from Room where Room_ID=? ";
        PreparedStatement stm=conn.prepareStatement(sql);
        stm.setObject(1, id);
        return stm.executeUpdate()>0;
    }

    @Override
    public RoomDTO get(String id) throws Exception {
        String sql="select*from Room where Room_ID=?";
        PreparedStatement stm=conn.prepareStatement(sql);
        stm.setObject(1, id);
        ResultSet rst=stm.executeQuery();
        if(rst.next()){
            RoomDTO r1=new RoomDTO(rst.getString(1),rst.getString(2),rst.getString(3),Double.parseDouble(rst.getString(4)));
            return r1;
        }
        return null;
    }

    @Override
    public ArrayList<RoomDTO> getAll() throws Exception {
         String sql="Select*from Room";
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        ArrayList<RoomDTO> roomList=new ArrayList<>();
        while(rst.next()){
            RoomDTO r1=new RoomDTO(rst.getString(1),rst.getString(2),rst.getString(3),rst.getDouble(4));
            roomList.add(r1);
        }
        return roomList;
    }

    @Override
    public ArrayList<String> getAllRoomIDs() throws SQLException, ClassNotFoundException {
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery("Select*From Room");
        ArrayList<String> roomID=new ArrayList<>();
        while(rst.next()){
            roomID.add(rst.getString(1));
        }
        return roomID;
    }

    @Override
    public ArrayList<RoomDTO> getRooms(String id) throws SQLException, ClassNotFoundException {
        String sql="Select*from Room where Room_ID=?";
        PreparedStatement stm=conn.prepareStatement(sql);
        ResultSet rst=stm.executeQuery();
        ArrayList<RoomDTO> roomList=new ArrayList<>();
        while(rst.next()){
            RoomDTO r1=new RoomDTO(rst.getString(1),rst.getString(2),rst.getString(3),rst.getDouble(4));
            roomList.add(r1);
        }
        return roomList;
    }
    
}
