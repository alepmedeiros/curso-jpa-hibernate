package Main;

import Dao.PessoaDao;
import Model.Pessoa;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Alessandro");
		
		PessoaDao dao = new PessoaDao();
		dao.salvar(pessoa);
		
	}
	
}
