/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gdse41.sem1project.dto;

/**
 *
 * @author Hansani Kariyawasam
 */
public class RoomDTO extends SuperDTO{
    private String roomID;
    private String roomType;
    private String status;
    private double roomPrice;
    
    public RoomDTO(){}
    public RoomDTO(String roomID,String roomType,String status,double roomPrice){
        this.roomID=roomID;
        this.roomType=roomType;
        this.status=status;
        this.roomPrice=roomPrice;
    }
    
    public void setRoomID(String roomID){
        this.roomID=roomID;
    }
    public String getRoomID(){
        return roomID;
    }
    public void setRoomType(String roomType){
        this.roomType=roomType;
    }
    public String getRoomType(){
        return roomType;
    }
    public void setStatus(String status){
        this.status=status;
    }
    public String getStatus(){
        return status;
    }
    public void setRoomPrice(double roomPrice){
        this.roomPrice=roomPrice;
    }
    public double getRoomPrice(){
        return roomPrice;
    }
}
