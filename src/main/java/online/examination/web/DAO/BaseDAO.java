package online.examination.web.DAO;

import java.util.List;

public interface BaseDAO<T> {
	void save(T t);
	void update(T t);
	void delete(T t);
	void saveOrUpdate(T t);
	T getById(int id);
	List<T> getAll();
}
