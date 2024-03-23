package DataBase;

import java.util.Random;

public class DadosGestao {
	private static final int MIN_ID = 100000; 
 private static final int MAX_ID = 999999;
private String emitido;
private String categoria;
private Double valor;
private String metodo;
private String receita;

public static int generateRandomId() {
    Random random = new Random();
    return random.nextInt(MAX_ID - MIN_ID + 1) + MIN_ID;
}

public String getEmitido() {
	return emitido;
}

public void setEmitido(String emitido) {
	this.emitido = emitido;
}

public String getCategoria() {
	return categoria;
}

public void setCategoria(String categoria) {
	this.categoria = categoria;
}

public Double getValor() {
	return valor;
}

public void setValor(Double valor) {
	this.valor = valor;
}

public String getMetodo() {
	return metodo;
}

public void setMetodo(String metodo) {
	this.metodo = metodo;
}

public String getReceita() {
	return receita;
}

public void setReceita(String receita) {
	this.receita = receita;
}

public static int getMinId() {
	return MIN_ID;
}

public static int getMaxId() {
	return MAX_ID;
}



}
