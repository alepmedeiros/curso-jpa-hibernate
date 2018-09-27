package persistence;

import java.util.ArrayList;
import java.util.List;

import entity.Produto;

public class ProdutoDao extends Dao{
	
	public void create (Produto p) throws Exception{
		open();
			stmt = con.prepareStatement("insert into produto values(null, ?,?,?,?,?)");
				stmt.setString(1, p.getNomeProduto());
				stmt.setDouble(2, p.getPreco());
				stmt.setInt(3, p.getQuantidade());
				stmt.setString(4, p.getPromocao());
				stmt.setDouble(5, p.getValor());
			stmt.execute();
			stmt.close();
		close();
	}
	
	public List<Produto> findAll()throws Exception{
		open();
			stmt = con.prepareStatement("select*from produto");
			rs = stmt.executeQuery();
			List<Produto>lista = new ArrayList<Produto>();
			while(rs.next()){
				Produto p = new Produto(rs.getInt(1), 
										rs.getString(2), 
										rs.getDouble(3), 
										rs.getInt(4),
										rs.getString(5),
										rs.getDouble(6));
			lista.add(p);
			}
		close();
		return lista;
	}
	
	public String findAllString() throws Exception{
		open();
			stmt = con.prepareStatement("select*from produto");
			rs = stmt.executeQuery();
			StringBuffer sb = new StringBuffer();
			while(rs.next()){
				sb.append(rs.getInt(1) + ",");
				sb.append(rs.getString(2) + ",");
				sb.append(rs.getDouble(3) + ",");
				sb.append(rs.getInt(4) + ",");
				sb.append(rs.getString(5) + ",");
				sb.append(rs.getDouble(6) + ";");	
			}
		close();
		return sb.toString();
	}
	
	
	public static void main(String[] args) {
		try {
			String produtos = new ProdutoDao().findAllString();
			System.out.println(produtos);
			
			String linhas[] = produtos.split(""
					+ ";");
			for(String colunas : linhas){
				String coluna[] = colunas.split(",");
				System.out.println(coluna[0]);
				System.out.println(coluna[1]);
				System.out.println(coluna[2]);
				System.out.println(coluna[3]);
				System.out.println(coluna[4]);
				System.out.println(coluna[5]);
				System.out.println("------------------");
			}
		} catch (Exception ex) {
			System.out.println("Erro: " + ex.getMessage());
			ex.printStackTrace();
		}		
	}
}
