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
 * Classe contendo o panel que é necessário na view para a avaliação dos
 * projetos. Esse panel exibe a avaliação efetuada.
 *
 * @author Francisco
 */
public class PAvaliacao extends JPanel {

    private String pergunta;
    private String resposta;
    private String dica;
    private String avaliador;
    private String comentario;
    private double nota;
    private JTextField textFieldNota;

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public JTextField getTextFieldNota() {
        return textFieldNota;
    }

    public void setTextFieldNota(JTextField textFieldNota) {
        this.textFieldNota = textFieldNota;
    }

    public JTextArea getTxtrAvaliacao() {
        return txtrAvaliacao;
    }

    public void setTxtrAvaliacao(JTextArea txtrAvaliacao) {
        this.txtrAvaliacao = txtrAvaliacao;
    }
    private JTextArea txtrAvaliacao;

    /**
     * Cria o panel.
     *
     * @param conteudo Objeto da camada de modelo contendo tudo o que é
     * necessário para esse panel (o nome do avaliador, sua nota e seu
     * comentário)
     * @param isAvaliacao Boolean que indica se o panel vai ser usado para uma
     * avaliação ou para um parecer. Caso seja um parecer, a área do comentário
     * e nota não poderá ser modificada.
     */
    public PAvaliacao(PPerguntaAvaliacaoCM conteudo, boolean isAvaliacao) {
        pergunta = conteudo.getPergunta();
        resposta = conteudo.getResposta();
        dica = conteudo.getDica();
        avaliador = conteudo.getAvaliador();
        comentario = conteudo.getComentario();
        nota = conteudo.getNota();

        setBorder(new TitledBorder(null, "Avaliação de " + avaliador, TitledBorder.LEADING, TitledBorder.TOP, null, null));
        setLayout(new BorderLayout(0, 0));

        JPanel panelNota = new JPanel();
        add(panelNota, BorderLayout.EAST);
        panelNota.setLayout(new BorderLayout(0, 0));

        JLabel label = new JLabel("Nota:");
        panelNota.add(label, BorderLayout.NORTH);
        textFieldNota = new JTextField();

        textFieldNota.setToolTipText("De 0 a 10");
        textFieldNota.setText(String.valueOf(nota));
        textFieldNota.setColumns(10);
        panelNota.add(textFieldNota, BorderLayout.SOUTH);

        textFieldNota.setEditable(isAvaliacao);

        txtrAvaliacao = new JTextArea();
        add(txtrAvaliacao, BorderLayout.CENTER);
        txtrAvaliacao.setWrapStyleWord(true);
        txtrAvaliacao.setText(comentario);
        txtrAvaliacao.setLineWrap(true);
        txtrAvaliacao.setColumns(2);
        txtrAvaliacao.setEditable(isAvaliacao);

    }
}
