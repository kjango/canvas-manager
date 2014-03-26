package View;

import Controller.ProjetoController;
import Controller.WindowController;
import Modelo.PPerguntaAvaliacaoCM;
import Modelo.VProjetoAvaliadorCM;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import Modelo.VProjetoUsuarioCM;
import javax.swing.JTextPane;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 * View usada para a avaliação e parecer de um projeto.
 *
 * @author Francisco
 */
public class VProjetoAvaliador extends JFrame {

    private JPanel contentPane;
    private JTabbedPane tabbedPane;
    private JButton btnEnviar;
    private int status;
    private JPanel panelBotoes;
    private JPanel panelMembros;
    private JScrollPane scrollPane;
    private JTextPane txtpnMembros;
    private JLabel lblLder;
    private String lider;
    private int projetoId;
    private int myUserId;
    private JButton btnSalvar;
    private ArrayList<PPerguntaAvaliacao> myPPerguntas;

    /**
     * Main usada para testes.
     *
     * @param args argumentos.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {

                try {
                    WindowController.getInstance().criaVProjeto(2, 6);
//                    VProjetoUsuario frame = new VProjetoUsuario(ProjetoController.getInstance().getDadosVprojetoUsuario(18, 3));
//                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Cria o frame.
     *
     * @param conteudoPerguntas Lista de objetos da camada de modelo contendo
     * tudo o que é necessário para os panels dessa view (a pergunta, a resposta
     * e a dica da pergunta, grupo da pergunta, avaliador, nota e comentário).
     * @param nomeProjeto String contendo o nome do projeto.
     * @param lider String contendo o nome do líder do projeto
     * @param status Boolean indicando se é uma avaliação ou um parecer.
     */
    public VProjetoAvaliador(VProjetoAvaliadorCM conteudo) {
        this.myPPerguntas = new ArrayList<>();
        this.myUserId = conteudo.getMyUserId();
        this.status = conteudo.getStatusProjeto();
        this.lider = conteudo.getNomelider();
        this.projetoId = conteudo.getIdProjeto();
        setTitle(conteudo.getNomeProjeto());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 655, 455);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        contentPane.add(tabbedPane, BorderLayout.CENTER);

        JPanel panelLateral = new JPanel();
        contentPane.add(panelLateral, BorderLayout.WEST);
        panelLateral.setLayout(new BorderLayout(0, 0));

        panelBotoes = new JPanel();
        panelBotoes.setBorder(new TitledBorder(null, "A\u00E7\u00F5es", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panelLateral.add(panelBotoes, BorderLayout.SOUTH);

        btnEnviar = new JButton("Finalizar");
        panelBotoes.add(btnEnviar);
        btnEnviar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                //TODO finaliza
                salvaAvaliacoes();
                ProjetoController pc = ProjetoController.getInstance();
                if (pc.podeFinalizarAvaliacao(projetoId)){
                    pc.finalizaAvaliacao(projetoId);
                    JOptionPane.showMessageDialog(null, "Avaliação finalizada com sucesso.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                    atualizaTudo();
                }else{
                    JOptionPane.showMessageDialog(null, "Todas as respostas devem ser comentadas antes de finalizar a avaliação.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnSalvar = new JButton("Salvar");
        panelBotoes.add(btnSalvar);
        btnSalvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                salvaAvaliacoes();
                JOptionPane.showMessageDialog(null, "Comentários salvos com sucesso.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        panelMembros = new JPanel();
        panelMembros.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Integrantes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panelLateral.add(panelMembros, BorderLayout.CENTER);
        panelMembros.setLayout(new BorderLayout(0, 0));

        lblLder = new JLabel(" Líder: " + this.lider);
        panelMembros.add(lblLder, BorderLayout.NORTH);

        txtpnMembros = new JTextPane();
        txtpnMembros.setEditable(false);
        txtpnMembros.setBackground(new Color(240, 240, 240));
        txtpnMembros.setText("Membros:");
        panelMembros.add(txtpnMembros);

        scrollPane = new JScrollPane(txtpnMembros);
        panelMembros.add(scrollPane);

        atualizaPerguntas(conteudo.getConteudoPerguntas());
        atualizaMembros(conteudo.getConteudoMembros());


    }

    /**
     * Método para atualizar as abas contendo as perguntas da view.
     *
     * @param conteudoPerguntas Lista de objetos da camada de modelo contendo
     * tudo o que é necessário para os panels dessa view (a pergunta, a resposta
     * e a dica da pergunta, grupo da pergunta, avaliador, nota e comentário).
     */
    public void atualizaPerguntas(HashMap<String, ArrayList<PPerguntaAvaliacaoCM>> conteudoPerguntas) {

        JPanel jpOuter = null;
        JPanel jpInner = null;
        JScrollPane sp = null;

        ProjetoController pc = ProjetoController.getInstance();
        boolean podeEditar = pc.podeAvaliar(myUserId, projetoId);

        tabbedPane.removeAll();
        myPPerguntas.removeAll(myPPerguntas);

        Set<String> keys = conteudoPerguntas.keySet();
        for (String grupoPergunta : keys) {
            sp = new JScrollPane();
            jpInner = new JPanel();
            jpOuter = new JPanel();

            jpOuter.add(sp);
            tabbedPane.addTab(grupoPergunta, null, jpOuter, null);
            jpOuter.setLayout(new BorderLayout(0, 0));

            jpOuter.add(sp);
            sp.setAutoscrolls(true);

            sp.setViewportView(jpInner);
            jpInner.setLayout(new GridLayout(0, 1, 0, 0));

            for (PPerguntaAvaliacaoCM cont : conteudoPerguntas.get(grupoPergunta)) {
                PPerguntaAvaliacao pp = new PPerguntaAvaliacao(cont, podeEditar);
                myPPerguntas.add(pp);
                jpInner.add(pp);
            }
        }
        atualizaBotoes();
        repaint();
    }

    /**
     * Método para atualizar as informações dos membros
     *
     * @param conteudoMembros informações sobre os membros do projeto
     */
    public void atualizaMembros(ArrayList<String> conteudoMembros) {

        lblLder.setText("Líder: " + lider);
        for (int i = 0; i < conteudoMembros.size(); i++) {
            txtpnMembros.setText(txtpnMembros.getText() + "\n" + conteudoMembros.get(i));
        }

        repaint();
    }

    /**
     * Método para atualizar os botões
     *
     *
     */
    public void atualizaBotoes() {

        ProjetoController pd = ProjetoController.getInstance();
        boolean bol = pd.podeAvaliar(myUserId, projetoId);
        btnEnviar.setEnabled(bol);
        btnSalvar.setEnabled(bol);
        repaint();
    }

    public void salvaAvaliacoes() {
        ProjetoController pc = ProjetoController.getInstance();
        for (int i = 0; i < myPPerguntas.size(); i++) {
            if (!myPPerguntas.get(i).getComentario().equals("")) {
                int comentarioId = pc.salvaComentario(myUserId, myPPerguntas.get(i).getRespostaId(), myPPerguntas.get(i).getComentario(), myPPerguntas.get(i).getNota());
            }
        }
    }
    
    public void atualizaTudo(){
        VProjetoAvaliadorCM dados = WindowController.getInstance().getDadosVProjetoAvaliador(projetoId, myUserId);
        atualizaBotoes();
        atualizaMembros(dados.getConteudoMembros());
        atualizaPerguntas(dados.getConteudoPerguntas());
    }
}
