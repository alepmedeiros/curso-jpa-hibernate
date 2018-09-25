package Dao;

import java.io.Serializable;
import java.util.List;

public interface NvInterfaceDao<T> {

	public void adicionar(T t);
	public void remover(T t);
	public void atualizar(Serializable id);
	//public void atualizar(T t);
	public List<T> pesquisarPorId(Serializable id);
	public List<T> pesquisarPorNome(String nome);
	public List<T> pesquisarTodos();
	public void close();
	
}
