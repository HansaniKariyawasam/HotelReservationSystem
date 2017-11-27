/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gdse41.sem1project.controller.custom.impl;

import edu.gdse41.sem1project.controller.ControllerFactory;
import edu.gdse41.sem1project.controller.custom.PaymentController;
import edu.gdse41.sem1project.controller.custom.ReservationController;
import edu.gdse41.sem1project.controller.custom.ReservationDetailsController;
import edu.gdse41.sem1project.dao.DAOFactory;
import edu.gdse41.sem1project.dao.custom.QueryDAO;
import edu.gdse41.sem1project.dao.custom.ReservationDAO;
import edu.gdse41.sem1project.dao.db.ConnectionFactory;
import edu.gdse41.sem1project.dto.ReservationDTO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Hansani Kariyawasam
 */
public class ReservationControllerImpl implements ReservationController{
    
    private Connection conn;
    private ReservationDAO reservationDAO;
    private QueryDAO queryDAO;

    public ReservationControllerImpl() {
        conn=ConnectionFactory.getInstance().getConnection();
        reservationDAO=(ReservationDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.RESERVATION);
        queryDAO=(QueryDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.QUERY);
    }
    
    @Override
    public  ArrayList<String> getAllResIDs()throws SQLException,ClassNotFoundException{
        return reservationDAO.getAllResIDs();
    }
    
    @Override
    public boolean add(ReservationDTO r1) throws Exception {
        return reservationDAO.add(r1);
    }

    @Override
    public boolean update(ReservationDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String id) throws Exception {
        return reservationDAO.delete(id);
    }

    @Override
    public ReservationDTO search(String id) throws Exception {
        return reservationDAO.get(id);
    }

    @Override
    public ArrayList<ReservationDTO> view() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public  boolean addReservation(ReservationDTO r1) throws Exception {
        return reservationDAO.add(r1);
    }

    @Override
    public boolean addRepeatedGuestRes(ReservationDTO r) throws Exception {
        ReservationDetailsController ctrlResDetails=(ReservationDetailsController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.RES_DETAILS);
        PaymentController ctrlPayment=(PaymentController) ControllerFactory.getInstance().getController(ControllerFactory.ControllerTypes.PAYMENT);
        try{
            conn.setAutoCommit(false);
            boolean result=reservationDAO.add(r);
            if(result){
                boolean isAdded=ctrlResDetails.addDetails(r.getResDetails());
                if(isAdded){
                    boolean added=ctrlPayment.add(r.getPayment());
                    if(added){
                        conn.commit();
                        return true;
                    }
                }
            }
            conn.rollback();
            return false;
        }finally{
            conn.setAutoCommit(true);
        }
    }

    @Override
    public ArrayList<ReservationDTO> searchAvailability() throws Exception {
        return queryDAO.searchAvailability();
    }
}
