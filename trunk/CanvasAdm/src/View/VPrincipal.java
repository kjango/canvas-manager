package View;

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

public class VPrincipal extends JFrame {

	private JPanel contentPane;
    private JTabbedPane tabbedPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			public void run() {
                
				HashMap<String, ArrayList<PProjetoCM>> hasha = new HashMap<>();
                for (int i = 0; i < 20; i++){
                	ArrayList<PProjetoCM> aba = new ArrayList<PProjetoCM>();
                    for (int j = 0; j < 100; j++){
                        aba.add(new PProjetoCM("status" + i, "lider" + j, "nome" + j));
                    }
                    hasha.put("status" + i, aba);                    
                }
                
				try {
					VPrincipal frame = new VPrincipal(hasha);
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
	public VPrincipal(HashMap<String, ArrayList<PProjetoCM>> conteudo) {
		setTitle("Canvas Manager");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 655, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		atualiza(conteudo);
		

	}
	
	public void atualiza(HashMap<String, ArrayList<PProjetoCM>> conteudo){

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
    		
    		for (PProjetoCM cont : conteudo.get(statusProjeto)) {
    			jpInner.add(new PProjeto(cont));
			}
		}
    }

}
