package br.com.alura.sql.testes;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.alura.sql.cfactory.ConnectionFactory;

public class TestaInsercaoComParametro {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		ConnectionFactory factory = new ConnectionFactory();
		Connection con = factory.recuperarConexao();
		factory.adicionarProduto("Arroz", "arroz camil");
		con.close();	
		
		
		
	}

}
