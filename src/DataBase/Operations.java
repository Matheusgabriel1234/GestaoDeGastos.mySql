package DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Operations {
private Connection conexao;

public  Operations() {
	this.conexao = new DataBaseConnection().getConnection();
	
}

public void Cadastro(DadosUsers obj) {
	try {
		String insert = "INSERT INTO tabela_users(id,username,email,password)" + "VALUES(?,?,?,?)";
		
		PreparedStatement ps = conexao.prepareStatement(insert);
		ps.setString(1, Integer.toString(obj.generateRandomId()));
		ps.setString(2, obj.getUsername());
		ps.setString(3, obj.getEmail());
		ps.setString(4, obj.getPassword());
		
		ps.execute();
		ps.close();
		JOptionPane.showMessageDialog(null,"Dados Cadastrados com sucesso!!!");
		
	}catch(SQLException e) {
	  
		e.printStackTrace();
	
	}
}
}