package Main;

import Dao.PessoaDao;
import Entity.Pessoa;

public class Main {

	public static void main(String[] args) {
		atualizar();
	}
	
	public static void inserir() {
		Pessoa pessoa = new Pessoa("Aline",0,"aline@gmail.com");
		PessoaDao.save(pessoa);
	}
	
	public static void atualizar(){
		Pessoa pessoa = new Pessoa(3,"Aline",0,"aline@gmail.com");
		PessoaDao.update(pessoa);
	}
	
	public static void apagar() {
		Pessoa pessoa = new Pessoa();
		pessoa.setId(1);
		PessoaDao.delete(pessoa);
	}

}
