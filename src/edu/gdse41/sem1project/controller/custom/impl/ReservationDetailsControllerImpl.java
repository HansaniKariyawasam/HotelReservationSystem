/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gdse41.sem1project.controller.custom.impl;

import edu.gdse41.sem1project.controller.ControllerFactory;
import edu.gdse41.sem1project.controller.custom.ReservationDetailsController;
import edu.gdse41.sem1project.dao.DAOFactory;
import edu.gdse41.sem1project.dao.custom.QueryDAO;
import edu.gdse41.sem1project.dao.custom.ReservationDetailsDAO;
import edu.gdse41.sem1project.dao.db.ConnectionFactory;
import edu.gdse41.sem1project.dto.ReservationDetailsDTO;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author Hansani Kariyawasam
 */
public class ReservationDetailsControllerImpl implements ReservationDetailsController{
    
    private Connection conn;
    private ReservationDetailsDAO resDetailsDAO;
    private QueryDAO queryDAO;
    private ReservationDetailsController ctrlResDetails;

    public ReservationDetailsControllerImpl() {
        conn=ConnectionFactory.getInstance().getConnection();
        resDetailsDAO=(ReservationDetailsDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.RES_DETAILS);
        queryDAO=(QueryDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.QUERY);
        
    }
    
    @Override
    public boolean addDetails(ArrayList<ReservationDetailsDTO> resDetails)throws Exception {
        ctrlResDetails=(ReservationDetailsControllerImpl) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.RES_DETAILS);
        for (ReservationDetailsDTO resDetail : resDetails) {
            boolean isAdd=ctrlResDetails.addDetails(resDetail);
            if(!isAdd){
                return false;
            }
        }
        return true;
    }
    
    @Override
    public boolean addDetails(ReservationDetailsDTO r)throws Exception{
        return resDetailsDAO.add(r);
    }
    

    
    @Override
    public boolean add(ReservationDetailsDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(ReservationDetailsDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ReservationDetailsDTO search(String id) throws Exception {
        return resDetailsDAO.get(id);
    }

    @Override
    public ArrayList<ReservationDetailsDTO> view() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ReservationDetailsDTO> resDetails(String id) throws Exception {
        return queryDAO.searchResDetails(id);
    }

    @Override
    public ArrayList<Object[]> viewResDetails() throws Exception {
        return queryDAO.viewReservationDetails();
    }
  
    
}
