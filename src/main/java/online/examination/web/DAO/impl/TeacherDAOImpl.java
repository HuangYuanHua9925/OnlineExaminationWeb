package online.examination.web.DAO.impl;

import java.util.List;




import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import online.examination.web.DAO.TeacherDAO;
import online.examination.web.model.Teacher;

/*
 * @Repository用于标注数据访问组件，即DAO组件
 * */
@Transactional
@Repository
public class TeacherDAOImpl implements TeacherDAO {
	@Autowired
	SessionFactory sessionFactory;
	
	public void save(Teacher t) {
		Session session = getCurrentSession();
		session.save(t);
		
		
	}

	public void update(Teacher t) {
		Session session = getCurrentSession();
		session.update(t);

	}

	public void delete(Teacher t) {
		Session session = getCurrentSession();
		session.delete(t);

	}

	public void saveOrUpdate(Teacher t) {
		Session session = getCurrentSession();
		session.saveOrUpdate(t);

	}

	public Teacher getById(int id) {
		Session session = getCurrentSession();
		Criteria criteria = session.createCriteria(Teacher.class);
		criteria.add(Restrictions.eq("id", id));
		return (Teacher) criteria.list().get(0);
	}

	public List<Teacher> getAll() {
		Session session = getCurrentSession();
		Query query = session.createQuery("FROM Teacher ");
		return query.list();
	}

	private Session getCurrentSession() {

		return sessionFactory.getCurrentSession();
	}

	public Teacher getTeacherByNameAndPassword(String name, String password) {
		Session session = getCurrentSession();
		String hql="FROM Teacher t WHERE t.name=:name AND t.password=:password";
		Query query=session.createQuery(hql);
		query.setParameter("name", name);
		query.setParameter("password", password);
		
		return (Teacher) query.list().get(0);
	}

	public List<Teacher> getTeachersByPage(int firstResult, int maxResults) {
		Session session=getCurrentSession();
		Query query=session.createQuery("FROM Teacher t");
		query.setFirstResult(firstResult);
		query.setMaxResults(maxResults);
		return query.list();
	}

	public int countTeachers() {
		Session session =getCurrentSession();
		Query query=session.createQuery("FROM Teacher");
		return query.list().size();
	}
}
