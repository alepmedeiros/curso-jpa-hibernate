package Dao;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
	
	public static void selectAllBasico() {
		String sql = "SELECT * FROM PESSOA";
		Connection con = ConexaoFactory.getConexao();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			StringBuffer sb = new StringBuffer();
			while (rs.next()) {
				sb.append(rs.getInt(1) + ",");
				sb.append(rs.getString(2) + ",");
				sb.append(rs.getInt(3) + ",");
				sb.append(rs.getString(4) + ";");
				sb.append("\n");
			}
			ConexaoFactory.close(con, stmt, rs);
			System.out.println(sb.toString());
		} catch (SQLException e) {
			System.out.println("Não foi possivel realizar a consulta " + e.getMessage());
		}
	}
	
	public static List<Pessoa> selectAll() {
		String sql = "SELECT * FROM PESSOA";
		Connection con = ConexaoFactory.getConexao();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			List<Pessoa> lista = new ArrayList<Pessoa>();
			while (rs.next()) {
				lista.add(new Pessoa(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4)));
			}
			ConexaoFactory.close(con, stmt, rs);
			return lista;
		} catch (SQLException e) {
			System.out.println("Não foi possivel realizar a consulta " + e.getMessage());
		}
		return null;
	}
	
	public static List<Pessoa> selectByName(String nome) {
		String sql = "SELECT * FROM PESSOA WHERE NOME LIKE '%" + nome + "%'";
		Connection con = ConexaoFactory.getConexao();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			List<Pessoa> lista = new ArrayList<Pessoa>();
			while (rs.next()) {
				lista.add(new Pessoa(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4)));
			}
			ConexaoFactory.close(con, stmt, rs);
			return lista;
		} catch (SQLException e) {
			System.out.println("Não foi possivel realizar a consulta " + e.getMessage());
		}
		return null;
	}

	public static void selectMetaData() {
		String sql = "select * from pessoa";
		Connection con = ConexaoFactory.getConexao();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			ResultSetMetaData rsmd =  rs.getMetaData();
			rs.next();
			int qtdColunas = rsmd.getColumnCount();
			System.out.println("Qtd colunas " + qtdColunas);
			for (int i = 1; i <= qtdColunas; i++) {
				if (i == 1) {
					System.out.println("tabela " + rsmd.getTableName(1));
				}
				System.out.println("nome coluna " + rsmd.getColumnName(i));
				System.out.println("tamanho coluna " + rsmd.getColumnDisplaySize(i));
			}
			ConexaoFactory.close(con, stmt, rs);
		} catch (SQLException e) {
			System.out.println("Não foi possivel realizar a consulta " + e.getMessage());
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
