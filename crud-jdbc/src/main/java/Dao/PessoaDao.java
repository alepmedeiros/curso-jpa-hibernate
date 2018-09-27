package Dao;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import Conexao.ConexaoFactory;
import Entity.Pessoa;

public class PessoaDao {

	public static void save(Pessoa pessoa) {
		String sql = "INSERT INTO PESSOA (NOME, SEXO, EMAIL) VALUES ('"+pessoa.getNome()+"',"+pessoa.getSexo()+",'"+pessoa.getEmail()+"')";
		Connection con = ConexaoFactory.getConexao();
		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate(sql);
			ConexaoFactory.close(con, stmt);
			System.out.println("Registro inserido com sucesso");
		} catch (SQLException e) {
			System.out.println("Ocorreu um erro ao inserir o registro " + e.getMessage());
		}
	}
	
	public static void update(Pessoa pessoa) {
		String sql = "UPDATE PESSOA SET NOME='"+pessoa.getNome()+"', SEXO="+pessoa.getSexo()+", EMAIL='"+pessoa.getEmail()+"' WHERE ID="+pessoa.getId();
		Connection con = ConexaoFactory.getConexao();
		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate(sql);
			ConexaoFactory.close(con, stmt);
			System.out.println("Registro atualizado com sucesso");
		} catch (SQLException e) {
			System.out.println("Ocorreu um erro ao atualizar o registro " + e.getMessage());
		}
	}
	
	public static void delete(Pessoa pessoa) {
		if (pessoa == null || pessoa.getId() == null) {
			System.out.println("Não foi possivel excluir o registro");
			return;
		}
		String sql = "DELETE FROM PESSOA WHERE ID = "+pessoa.getId();
		Connection con = ConexaoFactory.getConexao();
		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate(sql);
			ConexaoFactory.close(con, stmt);
			System.out.println("Registro apagado com sucesso");
		} catch (SQLException e) {
			System.out.println("Ocorreu um erro ao apagar o registro " + e.getMessage());
		}
	}
	
}
