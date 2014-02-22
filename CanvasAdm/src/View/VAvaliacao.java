package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JButton;

public class VAvaliacao extends JFrame {

	private JPanel contentPane;
	private JTabbedPane tabbedPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VAvaliacao frame = new VAvaliacao();
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
	public VAvaliacao() {
		setTitle("Canvas Manager");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 655, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setEnabled(false);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panelBotoes = new JPanel();
		contentPane.add(panelBotoes, BorderLayout.SOUTH);
		
		JButton btnEnviar = new JButton("Enviar");
		panelBotoes.add(btnEnviar);
		
		JButton btnSalvar = new JButton("Salvar");
		panelBotoes.add(btnSalvar);
	}

}
