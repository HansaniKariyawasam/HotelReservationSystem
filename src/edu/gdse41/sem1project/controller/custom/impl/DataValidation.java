/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gdse41.sem1project.controller.custom.impl;

import java.sql.SQLException;
import javax.swing.JTextField;

/**
 *
 * @author Hansani Kariyawasam
 */
public class DataValidation {
    public static boolean Validation(JTextField t)throws SQLException,ClassNotFoundException{
        boolean result=false;
        String name=t.getName();
        switch(name){
            case "telNo":
                if(t.getText().matches("^(((00|[+])\\d{2}[-]?)?(\\d{3}|\\d{3})[-]?(\\d{7}))$")){
                    result=true;
                }
            break;
            case "nic":
                if(t.getText().matches("^(\\d{9}|\\d{12})[VvXx]$")){
                    result=true;
                }
            break;
            case "email":
                if(t.getText().matches("([\\w-\\.]+)@((?:[\\w]+\\.)+)([a-zA-Z]{2,4})")){
                    result=true;
                }
            break;
            default:
                result=false;
        }
        return result;
    }
}
