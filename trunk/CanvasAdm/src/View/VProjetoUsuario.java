package View;

import Controller.ProjetoController;
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

import Modelo.PPerguntaCM;
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
public class VProjetoUsuario extends JFrame {

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
    private JButton btnAddMembro;
    private int projetoId;
    private int myUserId;
    private JButton btnSalvar;

    /**
     * Main usada para testes.
     *
     * @param args argumentos.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {

                try {
                    VProjetoUsuario frame = new VProjetoUsuario(new ProjetoController().getDadosVprojetoUsuario(14, 1));
                    frame.setVisible(true);
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
    public VProjetoUsuario(VProjetoUsuarioCM conteudo) {
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

        btnEnviar = new JButton("Enviar");
        panelBotoes.add(btnEnviar);

        btnSalvar = new JButton("Salvar");
        panelBotoes.add(btnSalvar);
        btnSalvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                //TODO salva
            }
        });

        panelMembros = new JPanel();
        panelMembros.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Integrantes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panelLateral.add(panelMembros, BorderLayout.CENTER);
        panelMembros.setLayout(new BorderLayout(0, 0));

        lblLder = new JLabel(" Líder: " + this.lider);
        panelMembros.add(lblLder, BorderLayout.NORTH);

        btnAddMembro = new JButton("Adicionar membro");
        btnAddMembro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String emailMembro = "";
                emailMembro = JOptionPane.showInputDialog(null, "Digite o email do membro.", "Novo membro", JOptionPane.QUESTION_MESSAGE);
                if (emailMembro != null) {
                    if (!emailMembro.equals("")) {
                        ProjetoController pc = new ProjetoController();
                        int id_membro = -2;
                        id_membro = pc.inserirMembro(emailMembro, projetoId);
                        if (id_membro > 0) {
                            JOptionPane.showMessageDialog(null, "Membro " + emailMembro + " adicionado com sucesso.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Erro ao adicionar membro " + emailMembro + ".", "Erro", JOptionPane.ERROR_MESSAGE);
                        }
                        atualizaMembros(pc.getMembros(projetoId));
                    } else {
                        JOptionPane.showMessageDialog(null, "Email pode ser vazio.", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                }
                
            }
        });
        panelMembros.add(btnAddMembro, BorderLayout.SOUTH);

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
    public void atualizaPerguntas(HashMap<String, ArrayList<PPerguntaCM>> conteudoPerguntas) {

        JPanel jpOuter = null;
        JPanel jpInner = null;
        JScrollPane sp = null;
        
        ProjetoController pc = new ProjetoController();
        boolean podeEditar = pc.podeEditar(myUserId, projetoId);

        tabbedPane.removeAll();

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

            for (PPerguntaCM cont : conteudoPerguntas.get(grupoPergunta)) {
                jpInner.add(new PPergunta(cont, podeEditar));
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
    public void atualizaBotoes(){
        
        ProjetoController pd = new ProjetoController();
        boolean bol = pd.podeEditar(myUserId, projetoId);
     
        btnAddMembro.setEnabled(bol);
        btnEnviar.setEnabled(bol);
        btnSalvar.setEnabled(bol);
        repaint();
    }
}
