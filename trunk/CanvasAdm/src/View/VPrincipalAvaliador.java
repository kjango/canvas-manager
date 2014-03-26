package View;

import Base.Usuario;
import Controller.ProjetoController;
import Controller.UsuarioController;
import Controller.WindowController;
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

public class VPrincipalAvaliador extends JFrame {

    private JPanel contentPane;
    private JTabbedPane tabbedPane;
    private JButton btnAtualiza;
    private int usuarioId;
    private HashMap<String, ArrayList<PProjetoCM>> conteudo;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {

//                HashMap<String, ArrayList<PProjetoCM>> hasha = new HashMap<>();
//                UsuarioController uc = UsuarioController.getInstance();
//                hasha = uc.getDadosVPrincipalAvaliador(5);

                try {
//                    WindowController.getInstance().criaVPrincipalAvaliador(5);
                    WindowController.getInstance().criaVPrincipalAdmin(5);
//                    VPrincipalAvaliador frame = new VPrincipalAvaliador(hasha, 5);
//                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    private boolean isAdmin;

    /**
     * Create the frame.
     */
    public VPrincipalAvaliador(HashMap<String, ArrayList<PProjetoCM>> cont, int usr) {
        usuarioId = usr;
        conteudo = cont;
        if (UsuarioController.getInstance().getTipoUsuario(usuarioId) == 3){
            isAdmin = true;
        }else{
            isAdmin = false;
        }
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

        btnAtualiza = new JButton("Atualiza");
        btnAtualiza.setEnabled(true);
        btnAtualiza.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                atualiza();
            }
        });
        panel.add(btnAtualiza);

        atualiza();


    }

    public void atualiza() {
        ProjetoController pc = ProjetoController.getInstance();
        if (isAdmin){
            conteudo = WindowController.getInstance().getDadosVPrincipalAdmin(usuarioId);
        }else{
            conteudo = WindowController.getInstance().getDadosVPrincipalAvaliador(usuarioId);
        }

        JPanel jpOuter = null;
        JPanel jpInner = null;
        JScrollPane sp = null;

        tabbedPane.removeAll();

        Set<String> keys = conteudo.keySet();
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

            for (PProjetoCM con : conteudo.get(statusProjeto)) {
                jpInner.add(new PProjeto(con));
            }
        }
        repaint();
    }
}
