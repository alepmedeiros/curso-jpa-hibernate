package Main;

import Dao.NvGenericDao;
import Dao.NvInterfaceDao;
import Model.Endereco;
import Model.Genero;
import Model.Pessoa;
import Model.TipoPessoa;
import antlr.collections.List;


public class Main {
		
	public static void main(String[] args) throws Exception {
	
		NvInterfaceDao<Pessoa> pessoaDao = new NvGenericDao<Pessoa>(Pessoa.class);
		//NvInterfaceDao<Endereco> enderecoDao = new NvGenericDao<Endereco>(Endereco.class);
		
		
		Pessoa pessoa = new Pessoa();
		//pessoa.setNome("Kauan");
		pessoa.setTipo(TipoPessoa.FORNECEDOR);
		
		/*Endereco endereco = new Endereco();
		endereco.setLogradouro("rua outro teste");
		endereco.setPessoa(pessoa);		
		
		pessoaDao.adicionar(pessoa);
		enderecoDao.adicionar(endereco);*/
		
		pessoaDao.atualizar(6);
		
	
	}
	
}
