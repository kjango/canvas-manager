package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import Modelo.PProjetoCM;

/**
 * Classe com o panel usado na view VPrincipal, para a listagem dos projetos disponíveis.
 * @author Francisco
 */
public class PProjeto extends JPanel {

    private String liderProjeto;
    private String nomeProjeto;
    private String statusProjeto;

    /**
     * Cria o panel.
     * @param conteudo Objeto da camada de modelo contendo tudo o que é necessário para esse panel (nome do líder do projeto, nome do projeto e status do projeto)
     */
    public PProjeto(PProjetoCM conteudo) {
        this.liderProjeto = conteudo.getLiderProjeto();
        this.nomeProjeto = conteudo.getNomeProjeto();
        this.statusProjeto = conteudo.getStatusProjeto();

        setBorder(new TitledBorder(null, "Líder: " + liderProjeto, TitledBorder.LEADING, TitledBorder.TOP, null, null));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    
                }
            }
        });


        setLayout(new BorderLayout(0, 0));
//		
//		JLabel lblAutor = new JLabel("Autor: " + liderProjeto);
//		add(lblAutor, BorderLayout.NORTH);

        JTextArea txtrNomeprojeto = new JTextArea();
        txtrNomeprojeto.setWrapStyleWord(true);
        txtrNomeprojeto.setColumns(2);
        txtrNomeprojeto.setEditable(false);
        txtrNomeprojeto.setLineWrap(true);
        txtrNomeprojeto.setText(nomeProjeto);
        txtrNomeprojeto.setBackground(new Color(240, 240, 240));
        add(txtrNomeprojeto, BorderLayout.CENTER);

        JLabel lblStatus = new JLabel("Status: " + statusProjeto);
        add(lblStatus, BorderLayout.SOUTH);

    }
}
