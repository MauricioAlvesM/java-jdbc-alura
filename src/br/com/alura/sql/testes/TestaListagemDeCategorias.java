package br.com.alura.sql.testes;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.alura.modelo.Categoria;
import br.com.alura.modelo.Produto;
import br.com.alura.sql.cfactory.ConnectionFactory;
import br.com.alura.sql.dao.CategoriaDAO;

public class TestaListagemDeCategorias {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		try (Connection connection = new ConnectionFactory().recuperarConexao()) {
			CategoriaDAO categoriaDAO = new CategoriaDAO(connection);
			List<Categoria> listaDeCategorias = categoriaDAO.listarComProdutos();
			listaDeCategorias.stream().forEach(ct -> {
				System.out.println(ct.getNome());

				for (Produto produto : ct.getProdutos()) {
					System.out.println(ct.getNome() + " - " + produto.getNome());
				}

			});
		}

	}

}
