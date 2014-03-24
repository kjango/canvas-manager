/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Base.Projeto;
import DAO.IODica;
import DAO.ProjetoDAO;
import Modelo.PPerguntaCM;
import Modelo.VProjetoUsuarioCM;
import Util.StatusProjeto;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public boolean isMembro(int membroId, int projetoId) {
        ProjetoDAO pd = new ProjetoDAO();
        return pd.isMembro(membroId, projetoId);
    }
    
    public boolean podeEditar(int usuarioId, int projetoId){
        ProjetoDAO pd = new ProjetoDAO();
        return pd.podeEditar(usuarioId, projetoId);
    }
    
    public VProjetoUsuarioCM getDadosVprojetoUsuario(int projetoId, int usuarioId){
        ProjetoDAO pd = new ProjetoDAO();
        VProjetoUsuarioCM ret = pd.getBasicoProjeto(projetoId);
        ret.setMyUserId(usuarioId);
        ret.setConteudoMembros(pd.getNomesMembros(projetoId));
        ret.setConteudoPerguntas(pd.getPerguntasVProjetoUsuario(projetoId));
        //adicionando as respostas
        HashMap<String, ArrayList<PPerguntaCM>> cont = ret.getConteudoPerguntas();
        for (String chave : ret.getConteudoPerguntas().keySet()) {
            ArrayList<PPerguntaCM> grupo = cont.get(chave);
            for (int i = 0; i < grupo.size(); i++){
                grupo.get(i).setResposta(pd.getResposta(grupo.get(i).getPerguntaId(), projetoId));
//                try {
//                    grupo.get(i).setDica(IODica.getText(grupo.get(i).getPerguntaId()));
//                } catch (IOException ex) {
//                    Logger.getLogger(ProjetoController.class.getName()).log(Level.SEVERE, null, ex);
//                }
            }
        }
        
        return ret;
    }
    
}
