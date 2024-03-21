package Telas;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import DataBase.DadosUsers;
import DataBase.Operations;

public class telaCadastro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsername;
	private JTextField txtEmail;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					telaCadastro frame = new telaCadastro();
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
	public telaCadastro() {
		setBackground(SystemColor.text);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		Point centro = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
		
		int largura = 800;
		int altura = 500;
		
		setBounds(centro.x  - largura/2 , centro.y - altura/ 2 , 800,500);

		setContentPane(contentPane);
        getContentPane().setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Usuario");
        lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        lblNewLabel.setBounds(44, 119, 131, 24);
        contentPane.add(lblNewLabel);
        
        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setFont(new Font("Arial", Font.PLAIN, 20));
        lblEmail.setBounds(44, 190, 131, 24);
        contentPane.add(lblEmail);
        
        txtUsername = new JTextField();
        txtUsername.setBounds(44, 153, 268, 24);
        contentPane.add(txtUsername);
        txtUsername.setColumns(10);
        
        txtEmail = new JTextField();
        txtEmail.setColumns(10);
        txtEmail.setBounds(44, 239, 268, 24);
        contentPane.add(txtEmail);
        
        JLabel lblSenha = new JLabel("Senha:");
        lblSenha.setFont(new Font("Arial", Font.PLAIN, 20));
        lblSenha.setBounds(44, 302, 131, 24);
        contentPane.add(lblSenha);
        
        txtPassword = new JPasswordField();
        txtPassword.setBounds(44, 336, 268, 24);
        contentPane.add(txtPassword);
        
        JButton btnNewButton = new JButton("Cadastrar");
        btnNewButton.setBackground(UIManager.getColor("InternalFrame.activeTitleGradient"));
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		DadosUsers du = new DadosUsers();
        		du.setUsername(txtUsername.getText());
        		du.setEmail(txtEmail.getText());
        		String password = new String(txtPassword.getPassword());
        	    du.setPassword(password);
        		Operations ops = new Operations();
        		ops.Cadastro(du);
        		
        				
        		
        		
        		
        	}
        });
        btnNewButton.setBounds(477, 326, 164, 35);
        contentPane.add(btnNewButton);
	}
}
