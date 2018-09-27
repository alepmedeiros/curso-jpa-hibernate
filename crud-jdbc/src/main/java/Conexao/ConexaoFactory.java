package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexaoFactory {

	public static Connection getConexao() {
		String url = "jdbc:firebirdsql:localhost/3050:C:\\Alessandro\\curso-jpa-hibernate\\DataBase\\CRUDJDBC.FDB?lc_ctype=WIN1252";
		String user = "SYSDBA";
		String password = "masterkey";
		
		try {
			return DriverManager.getConnection(url, user, password);
		
		} catch (SQLException e) {
			e.printStackTrace(); 
		}
		
		return null;		
	}
	
	public static void close(Connection con) {
		try {
			if (con != null)
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Connection con, Statement stmt) {
		close(con);
		try {
			if (stmt != null)
				stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
