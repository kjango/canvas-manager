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
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;

import Modelo.PPerguntaCM;

public class PPergunta extends JPanel {

    private String pergunta;
    private String resposta;
    private String dica;
    private JTextArea txtrResposta;
    private JTextArea txtrPergunta;

    /**
     * Create the panel.
     */
    public PPergunta(PPerguntaCM conteudo) {
        pergunta = conteudo.getPergunta();
        resposta = conteudo.getResposta();
        dica = conteudo.getDica();

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
        panelResposta.add(txtrResposta, BorderLayout.CENTER);

    }

}
