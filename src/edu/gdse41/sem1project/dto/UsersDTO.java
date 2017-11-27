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
public class UsersDTO extends SuperDTO{
    private String username;
    private String password;
    private String privilege;

    public UsersDTO() {
    }

    
    public UsersDTO(String username, String password, String privilege) {
        this.username = username;
        this.password = password;
        this.privilege = privilege;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPrivilege() {
        return privilege;
    }

    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }
    
}
