/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author falbernaz
 */
import Controller.ProjetoController;
import Modelo.PPerguntaAvaliacaoCM;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;

import Modelo.PPerguntaCM;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

/**
 * Classe utilizada para exibir as perguntas e respostas do Canvas. Ela ajuda a
 * compor a view principal.
 *
 * @author Francisco
 */
public class PPerguntaAdmin extends JPanel {

    private String pergunta;
    private String resposta;
    private String dica;
    private JTextArea txtrResposta;
    private int perguntaId;
    private int projetoId;
    private int respostaId;

    public int getProjetoId() {
        return projetoId;
    }

    public void setProjetoId(int projetoId) {
        this.projetoId = projetoId;
    }

    public int getPerguntaId() {
        return perguntaId;
    }

    public void setPerguntaId(int perguntaId) {
        this.perguntaId = perguntaId;
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public String getResposta() {
        return txtrResposta.getText();
    }

    public void setResposta(String txtResposta) {
        this.txtrResposta.setText(txtResposta);
    }
    private JTextArea txtrPergunta;
    private JPanel panelAvaliacoes;

    /**
     * Cria o panel.
     *
     * @param conteudo Objeto da camada de modelo contendo tudo o que é
     * necessário para esse panel (a pergunta, a resposta e a dica da pergunta)
     */
    public PPerguntaAdmin(PPerguntaCM conteudo) {
        pergunta = conteudo.getPergunta();
        resposta = conteudo.getResposta();
        respostaId = conteudo.getRespostaId();
        dica = conteudo.getDica();
        perguntaId = conteudo.getPerguntaId();
        projetoId = conteudo.getProjetoId();

        setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
        setLayout(new BorderLayout(0, 0));

        JPanel panelPergunta = new JPanel();
        panelPergunta.setToolTipText(dica);
        panelPergunta.setBorder(new TitledBorder(null, "Pergunta", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        add(panelPergunta, BorderLayout.NORTH);
        panelPergunta.setLayout(new BorderLayout(0, 0));

        txtrPergunta = new JTextArea();
        txtrPergunta.setToolTipText(dica);
        txtrPergunta.setText(pergunta);
        txtrPergunta.setWrapStyleWord(true);
        txtrPergunta.setLineWrap(true);
        txtrPergunta.setBackground(new Color(240, 240, 240));
        txtrPergunta.setEditable(false);
        txtrPergunta.setColumns(2);
        panelPergunta.add(txtrPergunta, BorderLayout.NORTH);

        JPanel panelResposta = new JPanel();
        panelResposta.setBorder(new TitledBorder(null, "Resposta", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        add(panelResposta, BorderLayout.CENTER);
        panelResposta.setLayout(new BorderLayout(0, 0));

        txtrResposta = new JTextArea();
        txtrResposta.setText(resposta);
        txtrResposta.setLineWrap(true);
        txtrResposta.setWrapStyleWord(true);
        txtrResposta.setBackground(new Color(255, 255, 255));
        txtrResposta.setColumns(2);
        txtrResposta.setEditable(false);
        txtrResposta.setBackground(new Color(240, 240, 240));

        panelResposta.add(txtrResposta, BorderLayout.CENTER);

        panelAvaliacoes = new JPanel();
        add(panelAvaliacoes, BorderLayout.SOUTH);
        atualizaAvaliacoes();

    }

    public void atualizaAvaliacoes() {

        JScrollPane sp = null;

        ProjetoController pc = ProjetoController.getInstance();
        ArrayList<PPerguntaAvaliacaoCM> conteudoAvaliacoes = pc.getAvaliacoes(respostaId);

//        sp = new JScrollPane();
//        sp.setAutoscrolls(true);

//        sp.setViewportView(panelAvaliacoes);
        panelAvaliacoes.setLayout(new GridLayout(0, 1, 0, 0));

        for (PPerguntaAvaliacaoCM cont : conteudoAvaliacoes) {
            PAvaliacao pa = new PAvaliacao(cont);
            panelAvaliacoes.add(pa);
        }

        repaint();
    }
}
