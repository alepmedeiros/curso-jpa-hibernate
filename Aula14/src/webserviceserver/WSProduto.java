package webserviceserver;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import persistence.ProdutoDao;

import com.google.gson.Gson;

import entity.Produto;

@Path("/produto")
public class WSProduto {

	
	@GET
	@Path("/listar")
	@Produces("application/json")
	public String listar(){
		try {
			return new ProdutoDao().findAllString();
		} catch (Exception ex) {
			return null;
		}
	}
	
	
	@GET
	@Path("/cadastrar/{nome}/{preco}/{quantidade}/{promocao}/{valor}")
	@Produces("text/plain")
	public String cadastrar(@PathParam("nome") String nome,
							@PathParam("preco") String preco,
							@PathParam("quantidade") String quantidade,
							@PathParam("promocao") String promocao,
							@PathParam("valor") String valor){
		try {
			Produto p = new Produto(null, nome, new Double(preco), new Integer(quantidade), promocao, new Double(valor));
			new ProdutoDao().create(p);
			return "produto cadastrado";
		} catch (Exception ex) {
			return "Erro: " + ex.getMessage();
		}
	}
	
	@GET
	@Path("/listarGson")
	@Produces("text/plain")
	public String listargson(){
		try {
			List<Produto> lista = new ProdutoDao().findAll();
			return new Gson().toJson(lista);
		} catch (Exception ex) {
			return ex.getMessage();
		}
	}
	
	
	
}
