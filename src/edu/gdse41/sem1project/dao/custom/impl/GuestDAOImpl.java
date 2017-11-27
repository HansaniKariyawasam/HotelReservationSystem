/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gdse41.sem1project.dao.custom.impl;

import edu.gdse41.sem1project.dao.custom.GuestDAO;
import edu.gdse41.sem1project.dao.db.ConnectionFactory;
import edu.gdse41.sem1project.dto.GuestDTO;
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
public class GuestDAOImpl implements GuestDAO{
    
    private Connection conn;

    public GuestDAOImpl() {
        conn=ConnectionFactory.getInstance().getConnection();
    }
    
    

    @Override
    public boolean add(GuestDTO g1) throws Exception {
        String sql="Insert into Guest values(?,?,?,?,?,?,?,?)";
        PreparedStatement stm=conn.prepareStatement(sql);
        stm.setObject(1, g1.getGuestID());
        stm.setObject(2, g1.getFName());
        stm.setObject(3, g1.getLName());
        stm.setObject(4, g1.getDOB());
        stm.setObject(5, g1.getNationality());
        stm.setObject(6, g1.getNIC());
        stm.setObject(7, g1.getPassport());
        stm.setObject(8, g1.getTel());
        return stm.executeUpdate()>0;
    }

    @Override
    public boolean update(GuestDTO g1) throws Exception {
        String sql="Update Guest set f_name=?,l_name=?,dob=?,Nationality=?,NIC=?,Passport=?,tel=? where GID=?";
        PreparedStatement stm=conn.prepareStatement(sql);
        stm.setObject(1, g1.getFName());
        stm.setObject(2, g1.getLName());
        stm.setObject(3, g1.getDOB());
        stm.setObject(4, g1.getNationality());
        stm.setObject(5, g1.getNIC());
        stm.setObject(6, g1.getPassport());
        stm.setObject(7, g1.getTel());
        stm.setObject(8, g1.getGuestID());
        return stm.executeUpdate()>0;
    }

    @Override
    public boolean delete(String id) throws Exception {
        String sql="Delete from Guest where GID=?";
        PreparedStatement stm=conn.prepareStatement(sql);
        stm.setObject(1, id);
        return stm.executeUpdate()>0;
    }

    @Override
    public GuestDTO get(String id) throws Exception {
        String sql="Select*from Guest where GID=?";
        PreparedStatement stm=conn.prepareStatement(sql);
        stm.setObject(1, id);
        ResultSet rst=stm.executeQuery();
        if(rst.next()){
            GuestDTO g1=new GuestDTO(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5),rst.getString(6),rst.getString(7),rst.getString(8));
            return g1;
        }
        return null;
    }

    @Override
    public ArrayList<GuestDTO> getAll() throws Exception {
        String sql="Select*from Guest";
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery(sql);
        ArrayList<GuestDTO> guestList=new ArrayList<>();
        while(rst.next()){
            GuestDTO g1=new GuestDTO(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5),rst.getString(6),rst.getString(7),rst.getString(8));
            guestList.add(g1);
        }
        return guestList;
    }

    @Override
    public ArrayList<String> getAllGuestIDs() throws SQLException, ClassNotFoundException {
        Statement stm=conn.createStatement();
        ResultSet rst=stm.executeQuery("Select*from Guest");
        ArrayList<String> guestIDs=new ArrayList<>();
        while(rst.next()){
            guestIDs.add(rst.getString(1));
        }
        return guestIDs;
    }

    @Override
    public ArrayList<GuestDTO> searchGuest(String name) throws Exception {
        String sql="select gid,CONCAT(f_name, \" \" ,l_name),tel from guest\n" +
                    "where f_name=?";
        PreparedStatement stm=conn.prepareStatement(sql);
        stm.setObject(1, name);
        //Statement stm=conn.createStatement();
        ArrayList<GuestDTO> nameLsit=new ArrayList<>();
        ResultSet rst=stm.executeQuery();
        while(rst.next()){
            GuestDTO g=new GuestDTO();
            g.setGuestId(rst.getString(1));
            g.setFName(rst.getString(2));
            g.setTel(rst.getString(3));
            nameLsit.add(g);
        }
        return nameLsit;
    }
    
}
