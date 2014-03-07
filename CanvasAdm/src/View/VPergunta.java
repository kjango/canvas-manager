package View;

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

/**
 * Classe contendo a view para o preenchimento das respostas às perguntas do canvas.
 * @author Francisco
 */
public class VPergunta extends JFrame {

    private JPanel contentPane;
    private JTabbedPane tabbedPane;
    private JButton btnEnviar;

    /**
     * Main usada para testes.
     * @param args Argumentos.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {

                HashMap<String, ArrayList<PPerguntaCM>> hasha = new HashMap<>();
                for (int i = 0; i < 20; i++) {
                    ArrayList<PPerguntaCM> aba = new ArrayList<PPerguntaCM>();
                    for (int j = 0; j < 100; j++) {
                        aba.add(new PPerguntaCM("pergunta" + j, "resposta" + j, "dica" + j, "grupo" + i));
                    }
                    hasha.put("grupo" + i, aba);
                }

                try {
                    VPergunta frame = new VPergunta(hasha, "projetoso");
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Construtor da classe.
     * @param conteudo Lista de objetos da camada de modelo contendo tudo o que é necessário para os panels dessa view (a pergunta, a resposta e a dica da pergunta e o grupo da pergunta).
     * @param nomeProjeto Nome do projeto.
     */
    public VPergunta(HashMap<String, ArrayList<PPerguntaCM>> conteudo, String nomeProjeto) {
        setTitle(nomeProjeto);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 655, 455);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        contentPane.add(tabbedPane, BorderLayout.CENTER);

        JPanel panelBotoes = new JPanel();
        contentPane.add(panelBotoes, BorderLayout.SOUTH);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                //TODO salva
            }
        });

        btnEnviar = new JButton("Enviar");
        panelBotoes.add(btnEnviar);
        panelBotoes.add(btnSalvar);

        atualiza(conteudo);

    }

    /**
     * Método para atualizar toda a view.
     * @param conteudo Lista de objetos da camada de modelo contendo tudo o que é necessário para os panels dessa view (a pergunta, a resposta e a dica da pergunta e o grupo da pergunta).
     */
    public void atualiza(HashMap<String, ArrayList<PPerguntaCM>> conteudo) {

        JPanel jpOuter = null;
        JPanel jpInner = null;
        JScrollPane sp = null;

        tabbedPane.removeAll();

        Set<String> keys = conteudo.keySet();
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

            for (PPerguntaCM cont : conteudo.get(grupoPergunta)) {
                jpInner.add(new PPergunta(cont));
            }
        }
    }
}
