/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gdse41.sem1project.dao.custom;

import edu.gdse41.sem1project.dao.SuperDAO;
import edu.gdse41.sem1project.dto.GuestDTO;
import edu.gdse41.sem1project.dto.PaymentDTO;
import edu.gdse41.sem1project.dto.ReservationDTO;
import edu.gdse41.sem1project.dto.ReservationDetailsDTO;
import edu.gdse41.sem1project.dto.SuperDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Hansani Kariyawasam
 */
public interface QueryDAO extends SuperDAO<SuperDTO>{
    @Override
    public default boolean add(SuperDTO dto) throws Exception {return true;}

    @Override
    public default boolean update(SuperDTO dto) throws Exception {return true;}
        

    @Override
    public default boolean delete(String key) throws Exception {return true;}
        

    @Override
    public default SuperDTO get(String key) throws Exception {return null;}
        
    @Override
    public default ArrayList<SuperDTO> getAll() throws Exception {return null;}
    
    public  ArrayList<String> getAllGuestHistroyIDs(String agent)throws SQLException,ClassNotFoundException;
    
    public ArrayList<GuestDTO> loadGuestDetails()throws SQLException,ClassNotFoundException;
    
    public ArrayList<ReservationDetailsDTO> searchResDetails(String id)throws Exception;
    
    public ArrayList<Object []> viewPaymentDetails(String id)throws Exception;
    
    public PaymentDTO searchPaymentDetails(String id)throws Exception;
    
    public ArrayList<ReservationDTO> searchAvailability()throws Exception;
    
    public ArrayList<Object[]> viewReservationDetails()throws Exception;
}
