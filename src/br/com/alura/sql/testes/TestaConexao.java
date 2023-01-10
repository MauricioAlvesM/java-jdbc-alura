package br.com.alura.sql.testes;

import java.sql.SQLException;

import br.com.alura.sql.cfactory.ConnectionFactory;

public class TestaConexao {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		ConnectionFactory cnf = new ConnectionFactory();
		
		for (int i = 0; i< 20; i++) {
			cnf.recuperarConexao();
			System.out.println("Conexao:" + i);
		}
		
		System.out.println("Fechando conexão!");

	}

}
