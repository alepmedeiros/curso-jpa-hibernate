package Dao;

import java.io.Serializable;
import java.util.List;

public interface NvInterfaceDao<T> {

	public void adicionar(T t);
	public void remover(T t);
	public void atualizar(T t, Serializable id);
	public List<T> pesquisarPorId(Serializable id);
	public List<T> pesquisarPorNome(String nome);
	public List<T> pesquisarTodos();
	public void close();
	
}
