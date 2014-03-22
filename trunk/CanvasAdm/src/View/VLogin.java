package View;

import Modelo.Login;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

/**
 * View para o login dos usuários.
 *
 * @author Francisco
 */
public class VLogin extends JFrame {

    private JPanel contentPane;
    private JTextField textFieldUsuario;
    private JPasswordField passwordField;

    /**
     * Main usada para testes.
     *
     * @param args Argumentos.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    VLogin frame = new VLogin();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Construtor da classe.
     */
    public VLogin() {
        setTitle("Canvas Manager");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 350, 140);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(null, "Login", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JLabel lblUsurio = new JLabel("Usuário");
        panel.add(lblUsurio);

        textFieldUsuario = new JTextField();
        panel.add(textFieldUsuario);
        textFieldUsuario.setColumns(10);

        JLabel lblSenha = new JLabel("Senha");
        panel.add(lblSenha);

        passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(100, 20));
        panel.add(passwordField);

        JButton btnEntrar = new JButton("Entrar");
        btnEntrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if (textFieldUsuario.getText().length() > 0 && passwordField.getText().length() > 0) {
                    Modelo.Login login = new Login(textFieldUsuario.getText(), passwordField.getText());

                    if (Controller.LoginController.logar(login)) {
                        //cria a mainWindow
                    } else {
                        JOptionPane.showMessageDialog(null, "Login inválido");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Campos vazios");
                }
            }
        });
        panel.add(btnEntrar);
    }
}
