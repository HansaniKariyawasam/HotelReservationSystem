/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gdse41.sem1project.dao;

import edu.gdse41.sem1project.dto.SuperDTO;
import java.util.ArrayList;

/**
 *
 * @author Hansani Kariyawasam
 * @param <T>
 */
public interface SuperDAO <T extends SuperDTO>{
    public boolean add(T dto)throws Exception;
    
    public boolean update(T dto)throws Exception;
    
    public boolean delete(String key)throws Exception;
    
    public T get(String key)throws Exception;
    
    public ArrayList<T> getAll()throws Exception;
}
