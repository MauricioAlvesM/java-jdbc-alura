package br.com.alura.sql.cfactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {

	private Connection con;
	public DataSource dataSource;

	public ConnectionFactory() {
		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
		comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC");
		comboPooledDataSource.setUser("root");
		comboPooledDataSource.setPassword("root");
		
		comboPooledDataSource.setMaxPoolSize(15);
		this.dataSource = comboPooledDataSource;
	}

	// TestaConexao
	public Connection recuperarConexao() throws SQLException {
		return this.dataSource.getConnection();

	}

	// adicionando variavel no produto
	public void adicionarVariavel(String nome, String descricao, PreparedStatement stm) throws SQLException {
		stm.setString(1, nome);
		stm.setString(2, descricao);

		stm.execute();
		try (ResultSet rst = stm.getGeneratedKeys()) {

			while (rst.next()) {
				Integer id = rst.getInt(1);
				System.out.println("O id criado foi: " + id);
			}
		}

	}

	// adicionando produto
	public void adicionarProduto(String nome, String descricao) throws SQLException {
		try (Connection conexao = recuperarConexao()) {

			conexao.setAutoCommit(false);

			try (PreparedStatement stm = conexao.prepareStatement("INSERT INTO PRODUTO (nome, descricao) VALUES (?,?)",
					Statement.RETURN_GENERATED_KEYS)) {

				adicionarVariavel(nome, descricao, stm);

				conexao.commit();

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Rollback executado");
				conexao.rollback();
			}
		}
	}

	// removendo produto
	public void removerProduto(int produto, int quant) throws SQLException {
		con = recuperarConexao();
		PreparedStatement stm = con.prepareStatement("DELETE FROM PRODUTO WHERE ID > ?");
		stm.setInt(produto, quant);
		stm.execute();
		Integer linhasModificadas = stm.getUpdateCount();
		System.out.println("Quantidades de linhas que foram modificadas: " + linhasModificadas);
	}

	// listando produto
	public void listarProdutos() throws SQLException {
		con = recuperarConexao();
		PreparedStatement stm = con.prepareStatement("SELECT ID, NOME, DESCRICAO FROM PRODUTO");
		stm.execute();
		ResultSet rst = stm.getResultSet();

		while (rst.next()) {
			// pegando resultados do banco de dados
			// pegando o parametro id
			Integer id = rst.getInt("ID");
			System.out.println("ID: {" + id + "}");
			// pegando o parametro nome
			String nome = rst.getString("NOME");
			System.out.println("NOME: {" + nome + "}");
			// pegando o parametro descricao
			String descricao = rst.getString("DESCRICAO");
			System.out.println("DESCRICAO: {" + descricao + "}");

		}

	}
}
