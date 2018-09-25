package Main;

import Dao.NvGenericDao;
import Dao.NvInterfaceDao;
import Model.Endereco;
import Model.Pessoa;

public class Main {
		
	public static void main(String[] args) throws Exception {
	
		NvInterfaceDao<Pessoa> pessoaDao = new NvGenericDao<Pessoa>(Pessoa.class);
		NvInterfaceDao<Endereco> enderecoDao = new NvGenericDao<Endereco>(Endereco.class);
		
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Alessandro");
		
		Endereco endereco = new Endereco();
		endereco.setLogradouro("rua teste");
		endereco.setPessoa(pessoa);		
		
		enderecoDao.adicionar(endereco);
		pessoaDao.adicionar(pessoa);
	
	}
	
}
