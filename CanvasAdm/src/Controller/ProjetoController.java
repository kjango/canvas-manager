/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Base.Projeto;
import DAO.ProjetoDAO;

/**
 *
 * @author falbernaz
 */
public class ProjetoController {

    public int inserir(String nomeProj, int idLider) {
        Projeto projeto = new Projeto(nomeProj, idLider);
        ProjetoDAO pd = new ProjetoDAO();
        return pd.inserir(projeto);
    }
    
}
