package Dao;

import java.io.Serializable;
import java.util.List;

public interface InterfaceDao<T> {

	//CRUD
	public void save(T t);
	public T getList(Class<T> clazz, Serializable id);
	public void update(T t);
	public void delete(T t);
	
	//List all
	public List<T> list();
}
