package View;

import Base.Usuario;
import Controller.ProjetoController;
import Controller.UsuarioController;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import Modelo.PProjetoCM;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class VPrincipalUsuario extends JFrame {

    private JPanel contentPane;
    private JTabbedPane tabbedPane;
    private JButton btnNovoProjeto;
    private Usuario usuario;
    private HashMap<String, ArrayList<PProjetoCM>> conteudo;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {

                HashMap<String, ArrayList<PProjetoCM>> hasha = new HashMap<>();
                for (int i = 0; i < 20; i++) {
                    ArrayList<PProjetoCM> aba = new ArrayList<PProjetoCM>();
                    for (int j = 0; j < 100; j++) {
                        aba.add(new PProjetoCM("status" + i, "lider" + j, "nome" + j));
                    }
                    hasha.put("status" + i, aba);
                }

                try {
                    VPrincipalUsuario frame = new VPrincipalUsuario(hasha, new Usuario(1, "User2", "Email1", "curso1", 1, null, null, null, 1));
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
    public VPrincipalUsuario(HashMap<String, ArrayList<PProjetoCM>> cont, Usuario usr) {
        usuario = usr;
        conteudo = cont;
        setTitle("Canvas Manager");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 655, 455);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        contentPane.add(tabbedPane, BorderLayout.CENTER);

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.SOUTH);

        btnNovoProjeto = new JButton("Novo projeto");
        btnNovoProjeto.setEnabled(false);
        btnNovoProjeto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String nomeProj = "";
                nomeProj = JOptionPane.showInputDialog(null, "Digite o nome do novo plano.", "Novo plano de negócios", JOptionPane.QUESTION_MESSAGE);
                if (nomeProj != null){

                    if (!nomeProj.equals("")){
                        ProjetoController pc = new ProjetoController();
                        if (pc.getIdProjeto(nomeProj) == -1){
                            int plano = -2;
                            plano = pc.criar(nomeProj, usuario.getId());
                            if (plano > 0){
                                JOptionPane.showMessageDialog(null, "Plano " + nomeProj + " criado com sucesso.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                            }else{
                                JOptionPane.showMessageDialog(null, "Erro ao criar plano " + nomeProj + ".", "Erro", JOptionPane.ERROR_MESSAGE);
                            }
                        }else{
                            JOptionPane.showMessageDialog(null, "Já existe um plano de projeto com o nome " + nomeProj + ".", "Erro", JOptionPane.ERROR_MESSAGE);
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "Nome do plano não pode ser vazio.", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                }
                atualiza(conteudo);
            }
        });
        panel.add(btnNovoProjeto);

        atualiza(conteudo);


    }

    public void atualiza(HashMap<String, ArrayList<PProjetoCM>> cont) {

        JPanel jpOuter = null;
        JPanel jpInner = null;
        JScrollPane sp = null;

        tabbedPane.removeAll();
        
        UsuarioController uc = new UsuarioController();
        btnNovoProjeto.setEnabled(uc.podeCriar(usuario.getId()));

        Set<String> keys = cont.keySet();
        for (String statusProjeto : keys) {
            sp = new JScrollPane();
            jpInner = new JPanel();
            jpOuter = new JPanel();

            jpOuter.add(sp);
            tabbedPane.addTab(statusProjeto, null, jpOuter, null);
            jpOuter.setLayout(new BorderLayout(0, 0));

            jpOuter.add(sp);
            sp.setAutoscrolls(true);

            sp.setViewportView(jpInner);
            jpInner.setLayout(new GridLayout(0, 1, 0, 0));

            for (PProjetoCM con : cont.get(statusProjeto)) {
                jpInner.add(new PProjeto(con));
            }
        }
        repaint();
    }
}
