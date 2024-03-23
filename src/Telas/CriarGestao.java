package Telas;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import DataBase.DadosGestao;
import DataBase.Operations;

public class CriarGestao extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtValor;
	private MaskFormatter maskData;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CriarGestao frame = new CriarGestao();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public MaskFormatter arrumaData() {
		try {
		maskData = new MaskFormatter("##/##/####");
				
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return maskData;
		
	}

	/**
	 * Create the frame.
	 */
	public CriarGestao() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 805, 704);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Data de emissão:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel.setBounds(54, 63, 174, 24);
		contentPane.add(lblNewLabel);
		
		JFormattedTextField txtData = new JFormattedTextField(arrumaData());
		txtData.setBounds(54, 97, 268, 31);
		contentPane.add(txtData);
		
		JLabel lblDataD = new JLabel("Categoria:");
		lblDataD.setFont(new Font("Arial", Font.PLAIN, 20));
		lblDataD.setBounds(54, 149, 174, 24);
		contentPane.add(lblDataD);
		
		JComboBox txtCategoria = new JComboBox();
		txtCategoria.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtCategoria.setModel(new DefaultComboBoxModel(new String[] {"-", "Alimentação", "Transporte", "Entretenimento", "Investimentos", "Educação", "Saúde", "Dividas"}));
		txtCategoria.setBounds(54, 183, 174, 31);
		contentPane.add(txtCategoria);
		
		JLabel lblValor = new JLabel("Valor:");
		lblValor.setFont(new Font("Arial", Font.PLAIN, 20));
		lblValor.setBounds(54, 250, 174, 24);
		contentPane.add(lblValor);
		
		txtValor = new JTextField();
		txtValor.setBounds(54, 284, 268, 31);
		contentPane.add(txtValor);
		txtValor.setColumns(10);
		
		JLabel lblMtodoDePagamento = new JLabel("Método de pagamento");
		lblMtodoDePagamento.setFont(new Font("Arial", Font.PLAIN, 20));
		lblMtodoDePagamento.setBounds(54, 345, 226, 24);
		contentPane.add(lblMtodoDePagamento);
		
		JComboBox txtReceita = new JComboBox();
		txtReceita.setEditable(true);
		txtReceita.setModel(new DefaultComboBoxModel(new String[] {"-", "Receita", "Despesa"}));
		txtReceita.setBounds(54, 476, 174, 24);
		contentPane.add(txtReceita);
		
		JLabel lblReceitadespesa = new JLabel("Receita/Despesa");
		lblReceitadespesa.setFont(new Font("Arial", Font.PLAIN, 20));
		lblReceitadespesa.setBounds(54, 442, 174, 24);
		contentPane.add(lblReceitadespesa);
		
		JComboBox txtMetodo = new JComboBox();
		txtMetodo.setModel(new DefaultComboBoxModel(new String[] {"-", "Boleto", "Pix", "Crédito", "Débito"}));
		txtMetodo.setBounds(54, 379, 160, 24);
		contentPane.add(txtMetodo);
		
		
		JButton btnNewButton = new JButton("Salvar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DadosGestao dg = new DadosGestao();
				dg.setEmitido(txtData.getText());
				dg.setCategoria((String) txtCategoria.getSelectedItem());
				dg.setValor(Double.parseDouble(txtValor.getText()));
				dg.setMetodo((String) txtMetodo.getSelectedItem());
				dg.setReceita((String) txtReceita.getSelectedItem());
			     if ("Despesa".equals((String) txtReceita.getSelectedItem())) {
			            dg.setValor(-Math.abs(Double.parseDouble(txtValor.getText())));
			        }
			     Operations ops = new Operations();
			     ops.CadastroGestao(dg);
			     Window window = SwingUtilities.getWindowAncestor(btnNewButton);
			     window.dispose();
}});
		
		
		
		
		
		btnNewButton.setBackground(UIManager.getColor("InternalFrame.activeTitleGradient"));
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 20));
		btnNewButton.setBounds(445, 477, 147, 31);
		contentPane.add(btnNewButton);
		
		
		
		
	
		
		
		
		
	
	}
}
