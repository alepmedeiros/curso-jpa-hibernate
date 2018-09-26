package Dao;

import java.io.Serializable;

public interface InterfaceDao<T> {

	public void salve(T t);
	public void update(Serializable id);
	public void delete(Serializable id);
	public T select(Serializable id);
}
