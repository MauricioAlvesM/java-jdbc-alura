package br.com.alura.sql.testes;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.alura.modelo.Produto;
import br.com.alura.sql.cfactory.ConnectionFactory;
import br.com.alura.sql.dao.ProdutoDAO;

public class TesteInsercaoEListagemComProduto {

	public static void main(String[] args) throws SQLException {
		
		//Produto comoda = new Produto("Comoda", "Comoda azul");
		
		try (Connection conexao = new ConnectionFactory().recuperarConexao()) {
			ProdutoDAO produtoDao = new  ProdutoDAO(conexao);
			//produtoDao.salvar(comoda);
			
			List<Produto> listaDeProdutos = produtoDao.listar();
			listaDeProdutos.stream().forEach(lp -> System.out.println(lp));
			//listaDeProdutos.add(comoda);
			System.out.println(listaDeProdutos.size());
			System.out.println(listaDeProdutos.get(0));
			
			
		}

	}

}
