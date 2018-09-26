package Main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import Dao.GenericDao;
import Dao.InterfaceDao;
import Model.Genero;
import Model.Pessoa;

public class Main {

	public static void main(String[] args) throws ParseException {
		crudoGenerico();
	}
	
	@SuppressWarnings("unused")
	private static void crudTeste() {
		InterfaceDao<Pessoa> dao = new GenericDao<Pessoa>(Pessoa.class);
		
		Pessoa pessoa = new Pessoa();
		
		pessoa.setNome("Alessandro");
		pessoa.setGenero(Genero.MASCULINO);
		pessoa.setEmail("alemedeiros@bsd.com.br");
	
		dao.adicionar(pessoa);
		
		System.out.println("dados salvos " + pessoa.toString());
		
		
		Pessoa p = dao.buscarPorId(pessoa.getId());
		p.setEmail("aleportomedeiros@gmail.com");
		dao.atualizar(p);
		System.out.println("dados atualizados " + p.toString() );
		
		dao.apagar(p.getId());		
		System.out.println("Dados apagados");
		
		dao.fechar();
		
	}
	
	@SuppressWarnings("unused")
	private static void crudoGenerico() throws ParseException {
		int opcao = 0;
		System.out.println("Bem vindo ao CRUD GENERICO com HIBERNATE");
		
		Scanner in = new Scanner(System.in);
		
		do {
			InterfaceDao<Pessoa> dao = new GenericDao<Pessoa>(Pessoa.class);
			Pessoa pessoa = new Pessoa();
			
			System.out.println("------ Escolha uma das opções do CRUD ------");
			System.out.println("1 - Cadastrar pessoa");
			System.out.println("2 - Imprimir pessoas");
			System.out.println("3 - Imprimir somente uma pessoa");
			System.out.println("4 - Alterar pessoa");
			System.out.println("5 - Apagar pessoa");
			System.out.println("0 - Sair");
			System.out.println("--------------------------------------------");
			
			System.out.println("Opção: ");
			opcao = in.nextInt();
			
			switch (opcao) {
			case 1 :			
				System.out.println("Nome: ");	
				if (in.nextLine()=="") {
					System.out.println("Favor informar o nome!");
				} else {
					pessoa.setNome(in.nextLine());
				}

				System.out.println("Sexo(F/M): ");
				if (in.nextLine()=="F") {
					pessoa.setGenero(Genero.FEMENINO);
				} else {
					pessoa.setGenero(Genero.MASCULINO);
				}			
				
				System.out.println("Data de nascimento: ");
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				pessoa.setDtnasc(sdf.parse(in.nextLine()));
				
				System.out.println("E-mail: ");
				pessoa.setEmail(in.nextLine());
				
				dao.adicionar(pessoa);
				dao.fechar();
				
				break;
			case 2 :				
				List<Pessoa> lista = dao.buscarTodos();
				for(Pessoa p : lista) {
					System.out.println(p.toString());
				}
				break;
			case 3 :
				System.out.println("Favor informar o id da pessoa: ");
				if (in.nextLine() != "") {
					Pessoa p = dao.buscarPorId(Integer.parseInt(in.nextLine()));
					System.out.println(p.toString());
				}
				break;
			case 4 :
				System.out.println("Favor informar o id da pessoa: ");
				if (in.nextLine() != "") {
					Pessoa p = dao.buscarPorId(in.nextLong());
					System.out.println("Qual campo atualizar? Nome(0),Sexo(1),Data Nascimento(2),E-mail(3)");
					if (in.nextLine()!="") {
						switch (Integer.parseInt(in.nextLine())) {
						case 0:
							System.out.println("Nome: ");
							p.setNome(in.nextLine());
							break;
						case 1 :
							System.out.println("Sexo(F/M): ");
							if (in.nextLine()=="F") {
								p.setGenero(Genero.FEMENINO);
							} else {
								p.setGenero(Genero.MASCULINO);
							}
							break;
						case 2 :
							System.out.println("Data de nascimento: ");
							SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
							p.setDtnasc(sdf1.parse(in.nextLine()));
							break;
						case 3 :
							System.out.println("E-mail: ");
							p.setEmail(in.nextLine());
							break;
						default:
							break;
						}					
						dao.atualizar(p);
					}
				}
				break;
			case 5 :
				System.out.println("Favor informar o id da pessoa: ");
				dao.apagar(in.nextLong());
			default:
				break;
			}
		} while (opcao != 0);		
		
		in.close();
	}	
}
