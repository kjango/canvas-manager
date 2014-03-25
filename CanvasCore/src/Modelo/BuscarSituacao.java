/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import Base.Status;
import DAO.StatusDAO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Rosana Local
 */
public class BuscarSituacao {
    
    private Map<String, Integer>  status;
    
    public Map<String, Integer>  getAllStatus(){
        StatusDAO statusDao = new StatusDAO();
       // status = new HashMap<Integer, String> ();
        status = statusDao.getAllStatus();
        return status;        
    }

    public Map<String, Integer> getStatus() {
        return status;
    }
    
    
}
