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
    
    public HashMap<String, ArrayList<PProjetoCM>> getDadosVPrincipal(int idUsuario){
        UsuarioDAO ud = new UsuarioDAO();
        ArrayList<PProjetoCM> conteudo = ud.getTodosProjetos(idUsuario);
        HashMap<String, ArrayList<PProjetoCM>> hasha = new HashMap<>();
        System.out.println("conteudo size: " + conteudo.size());
        for (int i = 0; i < conteudo.size(); i++) {
            String sit = conteudo.get(i).getStatusProjeto();
            if (sit.equals("Excluído")){
                continue;
            }
            if (!hasha.containsKey(sit)){
                hasha.put(sit, new ArrayList<PProjetoCM>());
                System.out.println("Inserindo" + sit);
            }
            hasha.get(sit).add(conteudo.get(i));
            if (conteudo.get(i).getIdLider() == idUsuario){
                if (!hasha.containsKey("Líder")){
                    hasha.put("Líder", new ArrayList<PProjetoCM>());
                    
                }
                hasha.get("Líder").add(conteudo.get(i));
                System.out.println("Inserindo líder");
            }else{
                if (!hasha.containsKey("Membro")){
                    hasha.put("Membro", new ArrayList<PProjetoCM>());
                }
                hasha.get("Membro").add(conteudo.get(i));
                System.out.println("Inserindo membro");
            }
        }
        return hasha;
    }
}
