/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import Base.Status;
import DAO.StatusDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rosana Local
 */
public class BuscarStatus {
    
    private List<Status> status;
    
    public List<String> getStatus(){
        StatusDAO statusDao = new StatusDAO();
        status = new ArrayList();
        status = statusDao.getAllStatus();
        List<String> descricoes = new ArrayList();
        for(Status t : this.status){
            descricoes.add(t.getDescricao());
        }
        return descricoes;
    }
    
}
