package Telas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

import DataBase.DadosUsers;
import DataBase.Operations;

public class TelaLogin {

	private JFrame frame;
	private JTextField txtUser;
	private JTextField txtEmail;
	private JPasswordField txtSenha;
	private JTextField txtCliqueAquiPara;
	private JTextField txtErro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin window = new TelaLogin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 795, 602);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel.setBounds(258, 123, 147, 24);
		frame.getContentPane().add(lblNewLabel);
		
		txtUser = new JTextField();
		txtUser.setBounds(258, 157, 243, 24);
		frame.getContentPane().add(txtUser);
		txtUser.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Arial", Font.BOLD, 20));
		lblEmail.setBounds(258, 217, 147, 24);
		frame.getContentPane().add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(258, 251, 243, 24);
		frame.getContentPane().add(txtEmail);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Arial", Font.BOLD, 20));
		lblSenha.setBounds(258, 309, 147, 24);
		frame.getContentPane().add(lblSenha);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(258, 343, 243, 24);
		frame.getContentPane().add(txtSenha);
		 ;
		
		
		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				DadosUsers du = new DadosUsers();
				du.setUsername(txtUser.getText());
				du.setEmail(txtEmail.getText());
				char[] passwordChars = txtSenha.getPassword();
				String password = new String(passwordChars);
				du.setPassword(password);
				
				 try {
			            Operations ops = new Operations();
			            boolean autenticado = ops.autenticar(du.getUsername(),du.getEmail(),du.getPassword());
			           
			            if (!autenticado) {
			                txtErro.setVisible(true);
			                txtErro.setText("Erro: Nome de usuário, e-mail ou senha incorretos.");
			                txtErro.setForeground(Color.RED);
			            }else {
			            JOptionPane.showMessageDialog(null, "Consta no banco de dados");
			            TelaPrincipal tp = new TelaPrincipal();
			            tp.setVisible(true);
			            }
			            } catch(Exception err) {
			          
			            txtErro.setVisible(true);
			            txtErro.setText("Erro ao autenticar o usuário.");
			            txtErro.setForeground(Color.RED);
			            err.printStackTrace();
			        }
			    }
			});
				
			
		
		btnNewButton.setBackground(UIManager.getColor("InternalFrame.activeTitleGradient"));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnNewButton.setBounds(264, 430, 180, 31);
		frame.getContentPane().add(btnNewButton);
		
		txtCliqueAquiPara = new JTextField();
		txtCliqueAquiPara.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				telaCadastro tc = new telaCadastro();
				tc.setVisible(true);
			}
		});
		txtCliqueAquiPara.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		txtCliqueAquiPara.setEditable(false);
		txtCliqueAquiPara.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtCliqueAquiPara.setText("Clique aqui para se cadastrar");
		txtCliqueAquiPara.setBounds(434, 503, 302, 31);
		frame.getContentPane().add(txtCliqueAquiPara);
		txtCliqueAquiPara.setColumns(10);
		
		txtErro = new JTextField();
		txtErro.setEditable(false);
		txtErro.setForeground(Color.RED);
		txtErro.setFont(new Font("Arial", Font.PLAIN, 15));
		txtErro.setText("Usuario, email ou senha incorretos!!!");
		txtErro.setBounds(254, 381, 311, 39);
		frame.getContentPane().add(txtErro);
		txtErro.setColumns(10);
		txtErro.setVisible(false);
	}
}
