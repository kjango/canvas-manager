/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Base.Projeto;
import DAO.ProjetoDAO;
import java.util.ArrayList;

/**
 *
 * @author falbernaz
 */
public class ProjetoController {

    private static ProjetoController instance = null;

    protected ProjetoController() {

    }

    public static ProjetoController getInstance() {
        if (instance == null) {
            instance = new ProjetoController();
        }
        return instance;
    }

    public int criar(String nomeProj, int idLider) {
        Projeto projeto = new Projeto(nomeProj, idLider, 1);
        ProjetoDAO pd = new ProjetoDAO();
        return pd.criar(projeto);
    }

    public int getIdProjeto(String nomeProj) {
        ProjetoDAO pd = new ProjetoDAO();
        return pd.getIdProjeto(nomeProj);
    }

    public int getIdLiderProjeto(int id_projeto) {
        ProjetoDAO pd = new ProjetoDAO();
        return pd.getIdLiderProjeto(id_projeto);
    }

    public int inserirMembro(String emailMembro, int id_projeto) {
        UsuarioController uc = new UsuarioController();
        int id_membro = -1;
        id_membro = uc.getIdUsuario(emailMembro);

        if (id_membro == -1) {
            return -1;
        }
        if (id_membro == getIdLiderProjeto(id_projeto)) {
            return -1;
        }
        if (isMembro(id_membro, id_projeto)) {
            return -1;
        }
        ProjetoDAO pd = new ProjetoDAO();
        return pd.inserirMembro(id_membro, id_projeto);
    }

    public ArrayList<String> getMembros(int projetoId) {
        ProjetoDAO pd = new ProjetoDAO();
        UsuarioController uc = new UsuarioController();
        ArrayList<Integer> ids = pd.getMembros(projetoId);
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

    public boolean podeEditar(int usuarioId, int projetoId) {
        ProjetoDAO pd = new ProjetoDAO();
        return pd.podeEditar(usuarioId, projetoId);
    }

    public int salvaResposta(int perguntaId, int projetoId, String resposta) {
        ProjetoDAO pd = new ProjetoDAO();
        int idResposta = pd.salvaResposta(perguntaId, projetoId, resposta);
        if (idResposta == -1) {
            idResposta = pd.insereResposta(perguntaId, projetoId, resposta);
        }
        return idResposta;
    }

    public boolean podeEnviar(int projetoId) {
        ProjetoDAO pd = new ProjetoDAO();
        return pd.podeEnviar(projetoId);
    }

    public boolean podeFinalizarAvaliacao(int projetoId) {
        ProjetoDAO pd = new ProjetoDAO();
        return pd.podeFinalizarAvaliacao(projetoId);
    }

    public int finalizaAvaliacao(int projetoId) {
        ProjetoDAO pd = new ProjetoDAO();
        return pd.finalizaAvaliacao(projetoId);
    }

    public int enviaProjetoAvaliacao(int projetoId) {
        ProjetoDAO pd = new ProjetoDAO();
        return pd.enviaProjetoAvaliacao(projetoId);
    }

    public boolean podeAvaliar(int usuarioId, int projetoId) {
        return new ProjetoDAO().podeAvaliar(usuarioId, projetoId);
    }

    public boolean podeEmitirParecer(int usuarioId, int projetoId) {
        return new ProjetoDAO().podeEmitirParecer(usuarioId, projetoId);
    }

    public int salvaComentario(int avaliadorId, int respostaId, String comentario, double nota) {
        ProjetoDAO pd = new ProjetoDAO();
        int idComentario = pd.salvaComentario(avaliadorId, respostaId, comentario, nota);
        if (idComentario == -1) {
            idComentario = pd.insereComentario(avaliadorId, respostaId, comentario, nota);
        }
        return idComentario;
    }

}
