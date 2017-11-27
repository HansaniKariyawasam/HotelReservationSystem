/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gdse41.sem1project.controller.custom;

import edu.gdse41.sem1project.controller.SuperController;
import edu.gdse41.sem1project.dto.ReservationDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Hansani Kariyawasam
 */
public interface ReservationController extends SuperController<ReservationDTO>{

    public  ArrayList<String> getAllResIDs()throws SQLException,ClassNotFoundException;
    
    public boolean addReservation(ReservationDTO r)throws Exception;
    
    public boolean addRepeatedGuestRes(ReservationDTO r)throws Exception;
    
    public ArrayList<ReservationDTO> searchAvailability()throws Exception;
    
}
