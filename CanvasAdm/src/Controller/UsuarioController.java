/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.UsuarioDAO;
import Modelo.PProjetoCM;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author kji
 */
public class UsuarioController {

    public boolean podeCriar(int id) {
        UsuarioDAO ud = new UsuarioDAO();
        return ud.podeCriar(id);
    }
    
    public int getUsuario(String email){
        UsuarioDAO ud = new UsuarioDAO();
        return ud.getIdUsuario(email);
    }

    public String getEmail(int id) {
        UsuarioDAO ud = new UsuarioDAO();
        return ud.getEmail(id);
    }
    
    public ArrayList<Integer> getTodosProjetos(int idUsuario){
        ArrayList<Integer> ret = new ArrayList<>();
        return ret;
    }
    
    public HashMap<String, ArrayList<PProjetoCM>> getDadosVPrincipalUsuario(int idUsuario){
        UsuarioDAO ud = new UsuarioDAO();
        ArrayList<PProjetoCM> conteudo = ud.getTodosProjetosUsuario(idUsuario);
        HashMap<String, ArrayList<PProjetoCM>> hasha = new HashMap<>();
        
        for (int i = 0; i < conteudo.size(); i++) {
            String sit = conteudo.get(i).getStatusProjeto();

            if (!hasha.containsKey(sit)){
                hasha.put(sit, new ArrayList<PProjetoCM>());
            }
            hasha.get(sit).add(conteudo.get(i));
            if (conteudo.get(i).getIdLider() == idUsuario){
                if (!hasha.containsKey("Líder")){
                    hasha.put("Líder", new ArrayList<PProjetoCM>());
                }
                hasha.get("Líder").add(conteudo.get(i));
            }else{
                if (!hasha.containsKey("Membro")){
                    hasha.put("Membro", new ArrayList<PProjetoCM>());
                }
                hasha.get("Membro").add(conteudo.get(i));
            }
        }
        return hasha;
    }

    public HashMap<String, ArrayList<PProjetoCM>> getDadosVPrincipalAvaliador(int idUsuario) {
        UsuarioDAO ud = new UsuarioDAO();
        ProjetoController pc = new ProjetoController();
        ArrayList<PProjetoCM> conteudo = ud.getTodosProjetosAvaliador(idUsuario);
        HashMap<String, ArrayList<PProjetoCM>> hasha = new HashMap<>();
        
        for (int i = 0; i < conteudo.size(); i++) {
            String sit = conteudo.get(i).getStatusProjeto();

            if (!hasha.containsKey(sit)){
                hasha.put(sit, new ArrayList<PProjetoCM>());
            }
            hasha.get(sit).add(conteudo.get(i));
            if (conteudo.get(i).getIdLider() == idUsuario){
                if (!hasha.containsKey("Líder")){
                    hasha.put("Líder", new ArrayList<PProjetoCM>());
                }
                hasha.get("Líder").add(conteudo.get(i));
            }
            if (pc.isMembro(idUsuario, conteudo.get(i).getProjetoId())){
                if (!hasha.containsKey("Membro")){
                    hasha.put("Membro", new ArrayList<PProjetoCM>());
                }
                hasha.get("Membro").add(conteudo.get(i));
            }
        }
        return hasha;
    }
}
