package Dao;

import java.io.Serializable;
import java.util.List;

public interface InterfaceDao<T> {

	//public void salve(T t);
	//public void update(Serializable id);
	//public void delete(Serializable id);
	//public T select(Serializable id);
	
	public void salvar(T t);
	public void adicionar(T t);
	public void atualizar(T t);
	public void apagar(final Serializable id);
	public T buscarPorId(final Serializable id);
	public List<T> buscarTodos();
	public void fechar();
}
