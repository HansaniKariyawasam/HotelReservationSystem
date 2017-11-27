/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gdse41.sem1project.dao;

import edu.gdse41.sem1project.dao.custom.impl.GuestDAOImpl;
import edu.gdse41.sem1project.dao.custom.impl.PaymentDAOImpl;
import edu.gdse41.sem1project.dao.custom.impl.QueryDAOImpl;
import edu.gdse41.sem1project.dao.custom.impl.ReservationDAOImpl;
import edu.gdse41.sem1project.dao.custom.impl.ReservationDetailsDAOImpl;
import edu.gdse41.sem1project.dao.custom.impl.RoomDAOImpl;
import edu.gdse41.sem1project.dao.custom.impl.UserDAOImpl;

/**
 *
 * @author Hansani Kariyawasam
 */
public class DAOFactory {
    public enum DAOTypes{
        GUEST,PAYMENT,ROOM,RESERVATION,USER,RES_DETAILS,QUERY;
    }
    
    private static DAOFactory daoFactory;

    private DAOFactory() {
    }
    
    public static DAOFactory getInstance(){
        if(daoFactory ==null){
            daoFactory=new DAOFactory();
        }
        return daoFactory;
    }
    
    public SuperDAO getDAO(DAOTypes daoTypes){
        switch(daoTypes){
            case ROOM:
                return new RoomDAOImpl();
            case PAYMENT:
                return new PaymentDAOImpl();
            case GUEST:
                return new GuestDAOImpl();
            case RESERVATION:
                return new ReservationDAOImpl();
            case USER:
                return new UserDAOImpl();
            case RES_DETAILS:
                return new ReservationDetailsDAOImpl();
            case QUERY:
                return new QueryDAOImpl();
            default:
                return null;
        }
    }
}
