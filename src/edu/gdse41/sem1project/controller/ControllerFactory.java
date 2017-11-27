/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gdse41.sem1project.controller;

import edu.gdse41.sem1project.controller.custom.impl.GuestControllerImpl;
import edu.gdse41.sem1project.controller.custom.impl.PaymentControllerImpl;
import edu.gdse41.sem1project.controller.custom.impl.ReservationControllerImpl;
import edu.gdse41.sem1project.controller.custom.impl.ReservationDetailsControllerImpl;
import edu.gdse41.sem1project.controller.custom.impl.RoomControllerImpl;
import edu.gdse41.sem1project.controller.custom.impl.UserControllerImpl;

/**
 *
 * @author Hansani Kariyawasam
 */
public class ControllerFactory {
    public enum ControllerTypes{
        GUEST,PAYMENT,ROOM,RESERVATION,USER,RES_DETAILS;
    }
    
    private static ControllerFactory controllerFactory;
    
    private ControllerFactory(){
        
    }
    public static ControllerFactory getInstance(){
        if(controllerFactory==null){
            controllerFactory=new ControllerFactory();
        }
        return controllerFactory;
    }
    
    public SuperController getController(ControllerTypes controller){
        switch(controller){
            case ROOM:
                return new RoomControllerImpl();
            case PAYMENT:
                return new PaymentControllerImpl();
            case GUEST:
                return new GuestControllerImpl();
            case RESERVATION:
                return new ReservationControllerImpl();
            case USER:
                return new UserControllerImpl();
            case RES_DETAILS:
                return new ReservationDetailsControllerImpl();
            default:
                return null;
        }
    }
}
