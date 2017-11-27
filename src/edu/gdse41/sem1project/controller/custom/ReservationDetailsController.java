/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gdse41.sem1project.controller.custom;

import edu.gdse41.sem1project.controller.SuperController;
import edu.gdse41.sem1project.dto.ReservationDetailsDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Hansani Kariyawasam
 */
public interface ReservationDetailsController extends SuperController<ReservationDetailsDTO>{
    public ArrayList<ReservationDetailsDTO> resDetails(String id)throws Exception;
    
    public boolean addDetails(ArrayList<ReservationDetailsDTO> resDetails)throws Exception;
    
    public boolean addDetails(ReservationDetailsDTO r)throws Exception;
    
    public ArrayList<Object[]> viewResDetails()throws Exception;
}
