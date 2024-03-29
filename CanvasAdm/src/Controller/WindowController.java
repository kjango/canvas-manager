/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.ProjetoDAO;
import DAO.UsuarioDAO;
import Modelo.ComentarioNotaCM;
import Modelo.PPerguntaAvaliacaoCM;
import Modelo.PPerguntaCM;
import Modelo.PProjetoCM;
import Modelo.VProjetoAvaliadorCM;
import Modelo.VProjetoUsuarioCM;
import View.VPrincipalAvaliador;
import View.VPrincipalUsuario;
import View.VProjetoAdmin;
import View.VProjetoAvaliador;
import View.VProjetoUsuario;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author falbernaz
 */
public class WindowController {

    private static WindowController instance = null;

    protected WindowController() {

    }

    public static WindowController getInstance() {
        if (instance == null) {
            instance = new WindowController();
        }
        return instance;
    }

    public void criaVPrincipalUsuario(int usuarioId) {
        VPrincipalUsuario frame = new VPrincipalUsuario(getDadosVPrincipalUsuario(usuarioId), usuarioId);
        frame.setVisible(true);
    }

    public HashMap<String, ArrayList<PProjetoCM>> getDadosVPrincipalUsuario(int idUsuario) {
        UsuarioDAO ud = new UsuarioDAO();
        ArrayList<PProjetoCM> conteudo = ud.getTodosProjetosUsuario(idUsuario);
        HashMap<String, ArrayList<PProjetoCM>> hasha = new HashMap<>();

        for (int i = 0; i < conteudo.size(); i++) {
            String sit = conteudo.get(i).getStatusProjeto();

            if (!hasha.containsKey(sit)) {
                hasha.put(sit, new ArrayList<PProjetoCM>());
            }
            hasha.get(sit).add(conteudo.get(i));
            if (conteudo.get(i).getIdLider() == idUsuario) {
                if (!hasha.containsKey("Líder")) {
                    hasha.put("Líder", new ArrayList<PProjetoCM>());
                }
                hasha.get("Líder").add(conteudo.get(i));
            } else {
                if (!hasha.containsKey("Membro")) {
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

            if (!hasha.containsKey(sit)) {
                hasha.put(sit, new ArrayList<PProjetoCM>());
            }
            hasha.get(sit).add(conteudo.get(i));
            if (conteudo.get(i).getIdLider() == idUsuario) {
                if (!hasha.containsKey("Líder")) {
                    hasha.put("Líder", new ArrayList<PProjetoCM>());
                }
                hasha.get("Líder").add(conteudo.get(i));
            }
            if (pc.isMembro(idUsuario, conteudo.get(i).getProjetoId())) {
                if (!hasha.containsKey("Membro")) {
                    hasha.put("Membro", new ArrayList<PProjetoCM>());
                }
                hasha.get("Membro").add(conteudo.get(i));
            }
        }
        return hasha;
    }

    public VProjetoUsuarioCM getDadosVProjetoUsuario(int projetoId, int usuarioId) {
        ProjetoDAO pd = new ProjetoDAO();
        VProjetoUsuarioCM ret = pd.getBasicoProjeto(projetoId);
        ret.setMyUserId(usuarioId);
        ret.setConteudoMembros(pd.getNomesMembros(projetoId));
        ret.setConteudoPerguntas(pd.getPerguntasVProjetoUsuario(projetoId));
        //adicionando as respostas
        HashMap<String, ArrayList<PPerguntaCM>> cont = ret.getConteudoPerguntas();
        for (String chave : ret.getConteudoPerguntas().keySet()) {
            ArrayList<PPerguntaCM> grupo = cont.get(chave);
            for (int i = 0; i < grupo.size(); i++) {
                grupo.get(i).setResposta(pd.getResposta(grupo.get(i).getPerguntaId(), projetoId));
            }
        }

        return ret;
    }

    public VProjetoAvaliadorCM getDadosVProjetoAvaliador(int projetoId, int usuarioId) {
        ProjetoDAO pd = new ProjetoDAO();
        VProjetoUsuarioCM aux = pd.getBasicoProjeto(projetoId);
        VProjetoAvaliadorCM ret = new VProjetoAvaliadorCM(aux.getNomeProjeto(), aux.getIdProjeto(), aux.getNomelider(), aux.getLiderId(), aux.getStatusProjeto(), usuarioId);
        ret.setMyUserId(usuarioId);
        ret.setConteudoMembros(pd.getNomesMembros(projetoId));
        ret.setConteudoPerguntas(pd.getPerguntasVProjetoAvaliador(usuarioId, projetoId));

        //adicionando os comentários e notas
        HashMap<String, ArrayList<PPerguntaAvaliacaoCM>> cont = ret.getConteudoPerguntas();
        for (String chave : ret.getConteudoPerguntas().keySet()) {
            ArrayList<PPerguntaAvaliacaoCM> grupo = cont.get(chave);
            for (int i = 0; i < grupo.size(); i++) {
                ComentarioNotaCM cn = pd.getComentarioNota(usuarioId, grupo.get(i).getRespostaId());
                grupo.get(i).setComentario(cn.getComentario());
                grupo.get(i).setNota(cn.getNota());
            }
        }
        return ret;
    }

    public void criaVProjeto(int projetoId, int usuarioId) {
        ProjetoController pc = ProjetoController.getInstance();
        if (pc.podeAvaliar(usuarioId, projetoId)) {
            VProjetoAvaliador frame = new VProjetoAvaliador(getDadosVProjetoAvaliador(projetoId, usuarioId));
            frame.setVisible(true);
        } else if (pc.podeEmitirParecer(usuarioId, projetoId)) {
            VProjetoAdmin frame = new VProjetoAdmin(getDadosVProjetoAdmin(projetoId, usuarioId));
            frame.setVisible(true);
        } else {
            VProjetoUsuario frame = new VProjetoUsuario(getDadosVProjetoUsuario(projetoId, usuarioId));
            frame.setVisible(true);
        }

    }

    public void criaVPrincipalAvaliador(int usuarioId) {
        VPrincipalAvaliador frame = new VPrincipalAvaliador(getDadosVPrincipalAvaliador(usuarioId), usuarioId);
        frame.setVisible(true);
    }

    public void criaVPrincipalAdmin(int usuarioId) {
        VPrincipalAvaliador frame = new VPrincipalAvaliador(getDadosVPrincipalAdmin(usuarioId), usuarioId);
        frame.setVisible(true);
    }

    public HashMap<String, ArrayList<PProjetoCM>> getDadosVPrincipalAdmin(int usuarioId) {
        UsuarioDAO ud = new UsuarioDAO();
        ProjetoController pc = new ProjetoController();
        ArrayList<PProjetoCM> conteudo = ud.getTodosProjetosAdmin(usuarioId);
        HashMap<String, ArrayList<PProjetoCM>> hasha = new HashMap<>();

        for (int i = 0; i < conteudo.size(); i++) {
            String sit = conteudo.get(i).getStatusProjeto();

            if (!hasha.containsKey(sit)) {
                hasha.put(sit, new ArrayList<PProjetoCM>());
            }
            hasha.get(sit).add(conteudo.get(i));

            if (conteudo.get(i).getIdLider() == usuarioId) {
                if (!hasha.containsKey("Líder")) {
                    hasha.put("Líder", new ArrayList<PProjetoCM>());
                }
                hasha.get("Líder").add(conteudo.get(i));
            }
            if (pc.isMembro(usuarioId, conteudo.get(i).getProjetoId())) {
                if (!hasha.containsKey("Membro")) {
                    hasha.put("Membro", new ArrayList<PProjetoCM>());
                }
                hasha.get("Membro").add(conteudo.get(i));
            }
        }
        return hasha;
    }

    private VProjetoUsuarioCM getDadosVProjetoAdmin(int projetoId, int usuarioId) {
        ProjetoDAO pd = new ProjetoDAO();
        VProjetoUsuarioCM ret = pd.getBasicoProjeto(projetoId);
        ret.setMyUserId(usuarioId);
        ret.setConteudoMembros(pd.getNomesMembros(projetoId));
        ret.setConteudoPerguntas(pd.getPerguntasVProjetoUsuario(projetoId));
        //adicionando as respostas
        HashMap<String, ArrayList<PPerguntaCM>> cont = ret.getConteudoPerguntas();
        for (String chave : ret.getConteudoPerguntas().keySet()) {
            ArrayList<PPerguntaCM> grupo = cont.get(chave);
            for (int i = 0; i < grupo.size(); i++) {
                grupo.get(i).setResposta(pd.getResposta(grupo.get(i).getPerguntaId(), projetoId));
                grupo.get(i).setRespostaId(pd.getIdResposta(grupo.get(i).getPerguntaId(), projetoId));
            }
        }

        return ret;
    }
}
