/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Base.Projeto;
import DAO.ProjetoDAO;
import Util.StatusProjeto;
import java.util.ArrayList;

/**
 *
 * @author falbernaz
 */
public class ProjetoController {

    public int criar(String nomeProj, int idLider) {
        Projeto projeto = new Projeto(nomeProj, idLider, 1);
        ProjetoDAO pd = new ProjetoDAO();
        return pd.criar(projeto);
    }
    
    public int getIdProjeto(String nomeProj) {
        ProjetoDAO pd = new ProjetoDAO();
        return pd.getIdProjeto(nomeProj);
    }
    
    public int getIdLiderProjeto(int id_projeto){
        ProjetoDAO pd = new ProjetoDAO();
        return pd.getIdLiderProjeto(id_projeto);
    }

    public int inserirMembro(String emailMembro, int id_projeto) {
        UsuarioController uc = new UsuarioController();
        int id_membro = -1;
        id_membro = uc.getUsuario(emailMembro);
        
        if (id_membro == -1){
            return -1;
        }
        if (id_membro == getIdLiderProjeto(id_projeto)){
            return -1;
        }
        if (isMembro(id_membro, id_projeto)){
            return -1;
        }
        ProjetoDAO pd = new ProjetoDAO();
        return pd.inserirMembro(id_membro, id_projeto);
    }
    
    public ArrayList<String> getMembros(int projetoId){
        ProjetoDAO pd = new ProjetoDAO();
        UsuarioController uc = new UsuarioController();
        ArrayList<Integer> ids =  pd.getMembros(projetoId);
        ArrayList<String> emails = new ArrayList<>();
        
        for (int i = 0; i < ids.size(); i++) {
            emails.add(uc.getEmail(ids.get(i)));
        }
        System.out.println(emails);
        return emails;
    }

    private boolean isMembro(int mebroId, int projetoId) {
        ProjetoDAO pd = new ProjetoDAO();
        return pd.isMembro(mebroId, projetoId);
    }
       

    
}
