package View;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;

import Modelo.PPerguntaAvaliacaoCM;

/**
 * Classe contendo o panel que é necessário na view para a avaliação dos projetos. Esse panel exibe a pergunta, a resposta e a avaliação efetuada.
 * @author Francisco
 */
public class PPerguntaAvaliacao extends JPanel {

    private String pergunta;
    private String resposta;
    private String dica;
    private String avaliador;
    private String comentario;
    private double nota;
    private JTextField textFieldNota;
    private JTextArea txtrResposta;
    private JTextArea txtrPergunta;
    private JTextArea txtrAvaliacao;

    /**
     * Cria o panel.
     * @param conteudo Objeto da camada de modelo contendo tudo o que é necessário para esse panel (a pergunta, a resposta, a dica da pergunta, o nome do avaliador, sua nota e seu comentário)
     * @param isAvaliacao Boolean que indica se o panel vai ser usado para uma avaliação ou para um parecer. Caso seja um parecer, a área do comentário e nota não poderá ser modificada.
     */
    public PPerguntaAvaliacao(PPerguntaAvaliacaoCM conteudo, boolean isAvaliacao) {
        pergunta = conteudo.getPergunta();
        resposta = conteudo.getResposta();
        dica = conteudo.getDica();
        avaliador = conteudo.getAvaliador();
        comentario = conteudo.getComentario();
        nota = conteudo.getNota();

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
        txtrResposta.setBackground(new Color(240, 240, 240));
        txtrResposta.setEditable(false);
        txtrResposta.setColumns(2);
        panelResposta.add(txtrResposta, BorderLayout.CENTER);

        JPanel panelAvaliacao = new JPanel();
        panelAvaliacao.setBorder(new TitledBorder(null, "Avaliação de " + avaliador, TitledBorder.LEADING, TitledBorder.TOP, null, null));
        add(panelAvaliacao, BorderLayout.SOUTH);
        panelAvaliacao.setLayout(new BorderLayout(0, 0));

        JPanel panelNota = new JPanel();
        panelAvaliacao.add(panelNota, BorderLayout.EAST);
        panelNota.setLayout(new BorderLayout(0, 0));

        JLabel label = new JLabel("Nota:");
        panelNota.add(label, BorderLayout.NORTH);
        textFieldNota = new JTextField();

        textFieldNota.setToolTipText("De 0 a 10");
        textFieldNota.setText(String.valueOf(nota));
        textFieldNota.setColumns(10);
        panelNota.add(textFieldNota, BorderLayout.SOUTH);

        txtrAvaliacao = new JTextArea();
        txtrAvaliacao.setWrapStyleWord(true);
        txtrAvaliacao.setText(comentario);
        txtrAvaliacao.setLineWrap(true);
        txtrAvaliacao.setColumns(2);
        panelAvaliacao.add(txtrAvaliacao, BorderLayout.CENTER);

        textFieldNota.setEditable(isAvaliacao);
        txtrAvaliacao.setEditable(isAvaliacao);

    }

}
