/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gdse41.sem1project.controller.custom;

import edu.gdse41.sem1project.controller.SuperController;
import edu.gdse41.sem1project.dto.GuestDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Hansani Kariyawasam
 */
public interface GuestController extends SuperController<GuestDTO>{
    public  ArrayList<String> getAllGuestIDs()throws SQLException,ClassNotFoundException;
    
    public  ArrayList<String> getAllGuestHistroyIDs(String agent)throws SQLException,ClassNotFoundException;
    
    public ArrayList<GuestDTO> loadGuestDetails()throws SQLException,ClassNotFoundException;
    
    public boolean addNewReservation(GuestDTO g)throws Exception;
    
    public ArrayList<GuestDTO> searchGuest(String name)throws Exception;
    
}
