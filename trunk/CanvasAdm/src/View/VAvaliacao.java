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

public class VAvaliacao extends JFrame {

    private JPanel contentPane;
    private JTabbedPane tabbedPane;
    private JButton btnEnviar;
    private boolean isAvaliacao;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {

                HashMap<String, ArrayList<PPerguntaCM>> hasha = new HashMap<>();
                for (int i = 0; i < 20; i++) {
                    ArrayList<PPerguntaCM> aba = new ArrayList<PPerguntaCM>();
                    for (int j = 0; j < 100; j++) {
                        aba.add(new PPerguntaCM("pergunta" + j, "resposta" + j, "dica" + j, "grupo" + i, "avaliador" + i, "comentario" + 1, (double) j));
                    }
                    hasha.put("grupo" + i, aba);
                }

                try {
                    VAvaliacao frame = new VAvaliacao(hasha, "projetoso", false);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public VAvaliacao(HashMap<String, ArrayList<PPerguntaCM>> conteudo, String nomeProjeto, Boolean isAvaliacao) {
        this.isAvaliacao = isAvaliacao;
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
                jpInner.add(new PPergunta(cont, isAvaliacao));
            }
        }
    }
}
