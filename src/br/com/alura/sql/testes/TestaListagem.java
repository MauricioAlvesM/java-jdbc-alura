package br.com.alura.sql.testes;

import java.sql.SQLException;

import br.com.alura.sql.cfactory.ConnectionFactory;

public class TestaListagem {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		ConnectionFactory cnf = new ConnectionFactory();
		
		
//		PreparedStatement stm = con.prepareStatement("SELECT ID, NOME, DESCRICAO FROM PRODUTO");
//		stm.execute();
//		ResultSet rst = stm.getResultSet();
//
//		while (rst.next()) {
//			// pegando resultados do banco de dados
//			// pegando o parametro id
//			Integer id = rst.getInt("ID");
//			System.out.println("ID: {"+id+"}");
//			// pegando o parametro nome
//			String nome = rst.getString("NOME");
//			System.out.println("NOME: {"+nome+"}");
//			// pegando o parametro descricao
//			String descricao = rst.getString("DESCRICAO");
//			System.out.println("DESCRICAO: {"+descricao+"}");
//			
//		}
		
		cnf.listarProdutos();
		
		
		System.out.println("Fechando conexão!");
	}

}
