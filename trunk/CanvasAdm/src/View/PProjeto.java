package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import Modelo.VPrincipalProjetosCM;


public class PProjeto extends JPanel {

	private String liderProjeto;
	private String nomeProjeto;
	private String statusProjeto;
	/**
	 * Create the panel.
	 */
	public PProjeto(VPrincipalProjetosCM conteudo) {
		this.liderProjeto = conteudo.getLiderProjeto();
		this.nomeProjeto = conteudo.getNomeProjeto();
		this.statusProjeto = conteudo.getStatusProjeto();
		
		setBorder(new TitledBorder(null, "Líder: " + liderProjeto, TitledBorder.LEADING, TitledBorder.TOP, null, null));
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if ( e.getClickCount() == 2){
					//TODO abrir a janela do canvas
					
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
