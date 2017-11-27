/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gdse41.sem1project.controller.custom.impl;

import edu.gdse41.sem1project.controller.custom.GuestController;
import edu.gdse41.sem1project.dao.DAOFactory;
import edu.gdse41.sem1project.dao.custom.GuestDAO;
import edu.gdse41.sem1project.dao.custom.QueryDAO;
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
public class GuestControllerImpl implements GuestController{
    
    private Connection conn;
    private GuestDAO guestDAO;
    private QueryDAO queryDAO;

    public GuestControllerImpl() {
        conn=ConnectionFactory.getInstance().getConnection();
        guestDAO=(GuestDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.GUEST);
        queryDAO=(QueryDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.QUERY);
    }
    
    @Override
    public boolean add(GuestDTO g1) throws Exception {
        return guestDAO.add(g1);
    }

    @Override
    public boolean update(GuestDTO g1) throws Exception {
        return guestDAO.update(g1);
    }

    @Override
    public boolean delete(String id) throws Exception {
        return guestDAO.delete(id);
    }

    @Override
    public GuestDTO search(String id) throws Exception {
        return guestDAO.get(id);
    }

    @Override
    public ArrayList<GuestDTO> view() throws Exception {
        return guestDAO.getAll();
    }

    @Override
    public  ArrayList<String> getAllGuestIDs()throws SQLException,ClassNotFoundException{
        return guestDAO.getAllGuestIDs();
    }
    
    @Override
    public ArrayList<String> getAllGuestHistroyIDs(String agent)throws SQLException,ClassNotFoundException{
            return queryDAO.getAllGuestHistroyIDs(agent);
        
    }

    @Override
    public ArrayList<GuestDTO> loadGuestDetails() throws SQLException, ClassNotFoundException {
        return queryDAO.loadGuestDetails();
    }

    @Override
    public boolean addNewReservation(GuestDTO g) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<GuestDTO> searchGuest(String name) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
