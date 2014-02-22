package View;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class PAvaliacao extends JPanel {
	private JTextField textFieldNota;
	private String avaliador;
	private String comentario;
	private double nota;
	
	/**
	 * Create the panel.
	 */
	public PAvaliacao(Abano conteudo) {
		avaliador = conteudo.avaliador;
		comentario = conteudo.comentario;
		nota = conteudo.nota;
		
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Avaliação de " + avaliador, TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new BorderLayout(0, 0));
		
		JPanel panelNota = new JPanel();
		add(panelNota, BorderLayout.EAST);
		panelNota.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Nota:");
		panelNota.add(lblNewLabel, BorderLayout.CENTER);
		
		textFieldNota = new JTextField();
		textFieldNota.setToolTipText("De 0 a 10");
		textFieldNota.setText(String.valueOf(nota));
		panelNota.add(textFieldNota, BorderLayout.SOUTH);
		textFieldNota.setColumns(10);
		
		JTextArea txtrComentario = new JTextArea();
		txtrComentario.setColumns(2);
		txtrComentario.setLineWrap(true);
		txtrComentario.setWrapStyleWord(true);
		txtrComentario.setText(comentario);
		add(txtrComentario, BorderLayout.CENTER);

	}

}
