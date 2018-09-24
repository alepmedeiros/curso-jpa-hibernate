package Main;

import Dao.NvGenericDao;
import Dao.NvInterfaceDao;
import Dao.PessoaDao;
import Model.Pessoa;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		NvInterfaceDao<Pessoa> pessoaDao = new NvGenericDao<Pessoa>(Pessoa.class);
		
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Alessandro");
		pessoaDao.adicionar(pessoa);
		
	}
	
}
