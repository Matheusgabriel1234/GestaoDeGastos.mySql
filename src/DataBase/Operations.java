package DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

public boolean autenticar(String username,String email,String password) {
	try {
		String aut = "SELECT * FROM  tabela_users WHERE username = ? AND email = ? AND password = ?";
		PreparedStatement ps = conexao.prepareStatement(aut);
		ps.setString(1, username);
		ps.setString(2, email);
		ps.setString(3, password);
		ResultSet rs = ps.executeQuery();
		return  rs.next();
		
	}catch(SQLException e) {
		e.printStackTrace();
	}
	
	return false;
}

public void CadastroGestao(DadosGestao obj) {
	try {
		String insert = "INSERT INTO tabela_gestao(id,emitido,categoria,valor,metodo,receita)" + "VALUES(?,?,?,?,?,?)";
		
		PreparedStatement ps = conexao.prepareStatement(insert);
		ps.setString(1, Integer.toString(obj.generateRandomId()));
		ps.setString(2, obj.getEmitido());
		ps.setString(3,obj.getCategoria());
		ps.setString(4, Double.toString(obj.getValor()));
		ps.setString(5, obj.getMetodo());
		ps.setString(6, obj.getReceita());
		
		ps.execute();
		ps.close();
		
		
	}catch(SQLException e) {
	  
		e.printStackTrace();
	
	}
}

public List<DadosGestao> listarGestao(){
	String infoSql = "select * from tabela_gestao";
	List<DadosGestao> list = new ArrayList<>();
	try {
		PreparedStatement ps = conexao.prepareStatement(infoSql);
		ResultSet result = ps.executeQuery();
		
		while(result.next()) {
			DadosGestao dg = new DadosGestao();
			dg.setEmitido(result.getString("emitido"));
			dg.setCategoria(result.getString("categoria"));
			dg.setValor(result.getDouble("valor"));
			dg.setMetodo(result.getString("metodo"));
		    dg.setReceita(result.getString("receita"));
		    list.add(dg);
		
		}
	} catch (SQLException e) {
		
		e.printStackTrace();
	} 
	return list;
	
	
}



}