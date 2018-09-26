package Main;

import Dao.GenericDao;
import Dao.InterfaceDao;
import Model.Genero;
import Model.Pessoa;

public class Main {

	public static void main(String[] args) {
		InterfaceDao<Pessoa> dao = new GenericDao<Pessoa>(Pessoa.class);
		
		Pessoa pessoa = new Pessoa();
		
		pessoa.setNome("Alessandro");
		pessoa.setGenero(Genero.MASCULINO);
		pessoa.setEmail("alemedeiros@bsd.com.br");
	
		dao.salve(pessoa);
		
		System.out.println("dados salvos " + pessoa.getNome() + " " +
				pessoa.getGenero() + " " + pessoa.getEmail());
		
		Pessoa p2 = dao.select(pessoa.getId());
		p2.setEmail("aleportomedeiros@gmail.com");
		dao.update(p2.getId());
		System.out.println("dados atualizados " + p2.getEmail());
		
		dao.delete(p2.getId());
		
		System.out.println("Dados apagados");
	}
	
}
