package Telas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DataBase.DadosGestao;
import DataBase.Operations;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TelaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTable tabelaGestao;
	private JTextField txtTotal;
	private JButton btnNewButton;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
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
	public TelaPrincipal() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				
			}
			@Override
			public void windowOpened(WindowEvent e) {
				carregar();
					
				
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 855, 675);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 121, 605, 374);
		contentPane.add(scrollPane);
		
		tabelaGestao = new JTable();
		tabelaGestao.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tabelaGestao.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Emitido", "Categoria", "Valor", "M\u00E9todo", "Receita ou despesa"
			}
		));
		scrollPane.setViewportView(tabelaGestao);
		
		textField = new JTextField();
		textField.setBounds(10, 68, 620, 32);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Digite algo para pesquisar:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 33, 461, 24);
		contentPane.add(lblNewLabel);
		
		txtTotal = new JTextField();
		txtTotal.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTotal.setEditable(false);
		txtTotal.setBounds(10, 540, 381, 32);
		contentPane.add(txtTotal);
		txtTotal.setColumns(10);
		
		btnNewButton = new JButton("Novo");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CriarGestao cg = new CriarGestao();
				cg.setVisible(true);
				
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 16));
		btnNewButton.setBounds(666, 155, 117, 32);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Atualizar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				carregar();
			}
		});
		btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 20));
		btnNewButton_1.setBounds(666, 231, 117, 32);
		contentPane.add(btnNewButton_1);
	
    
	
		
	}
	
	public void carregar() {
		Operations ops = new Operations();
		List<DadosGestao> list = ops.listarGestao();
		DefaultTableModel model = (DefaultTableModel) tabelaGestao.getModel();
		double total = 0;
		
		model.setRowCount(0);
		for(DadosGestao linha: list) {
			model.addRow(new Object[] {
					linha.getEmitido(),
					linha.getCategoria(),
					linha.getValor(),
					linha.getMetodo(),
					linha.getReceita()
					
			});
			total += linha.getValor();
		}
		txtTotal.setText("Perca/Ganho total: " + total );
		
		if(total < 0) {
			txtTotal.setForeground(Color.RED);
		}else {
			txtTotal.setForeground(Color.GREEN);
		}
		
	}
	
	public void ContarLinhas() {
		int qntdLinhas = 0;
		qntdLinhas = tabelaGestao.getRowCount();
		
	}
}
