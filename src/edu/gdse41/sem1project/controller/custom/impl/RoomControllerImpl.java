/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gdse41.sem1project.controller.custom.impl;

import edu.gdse41.sem1project.controller.custom.RoomController;
import edu.gdse41.sem1project.dao.DAOFactory;
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
public class RoomControllerImpl implements RoomController{
    
    private static Connection conn;
    private RoomDAO roomDAO;

    public RoomControllerImpl() {
        conn=ConnectionFactory.getInstance().getConnection();
        roomDAO=(RoomDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ROOM);
    }
    
    
    @Override
    public boolean add(RoomDTO r1) throws Exception {
        return roomDAO.add(r1);
    }

    @Override
    public boolean update(RoomDTO r1) throws Exception {
        return roomDAO.update(r1);
    }

    @Override
    public boolean delete(String id) throws Exception {
        return roomDAO.delete(id);
    }

    @Override
    public RoomDTO search(String id) throws Exception {
        return roomDAO.get(id);
    }

    @Override
    public ArrayList<RoomDTO> view() throws Exception {
       return roomDAO.getAll();
    }
    
    @Override
    public  ArrayList<RoomDTO> getRooms(String id)throws SQLException,ClassNotFoundException{
        return roomDAO.getRooms(id);
    }
    
    @Override
    public ArrayList<String> getAllRoomIDs()throws SQLException,ClassNotFoundException{
        return roomDAO.getAllRoomIDs();
    }

    
    
    
}
