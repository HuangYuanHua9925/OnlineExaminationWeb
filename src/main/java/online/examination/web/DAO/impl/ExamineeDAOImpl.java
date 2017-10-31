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

import online.examination.web.DAO.ExamineeDAO;
import online.examination.web.model.Examinee;

@Transactional
@Repository
public class ExamineeDAOImpl implements ExamineeDAO {
	@Autowired
	SessionFactory sessionFactory;
	public void save(Examinee t) {
		Session session=getCurrentSession();
		session.save(t);

	}

	public void update(Examinee t) {
		Session session=getCurrentSession();
		session.update(t);	
	}

	public void delete(Examinee t) {
		Session session=getCurrentSession();
		session.delete(t);

	}

	public void saveOrUpdate(Examinee t) {
		Session session=getCurrentSession();
		session.saveOrUpdate(t);

	}

	public Examinee getById(int id) {
		Session session=getCurrentSession();
		Criteria criteria= session.createCriteria(Examinee.class);
		criteria.add(Restrictions.eq("id", id));
		return (Examinee) criteria.list().get(0);
	}

	public List<Examinee> getAll() {
		Session session=getCurrentSession();
		Query query= session.createQuery("FROM Examinee");
		
		return query.list();
	}
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public Examinee getExamineeByNameAndPassword(String name, String password) {
		Session session = getCurrentSession();
		String hql="FROM Examinee t WHERE t.name=:name AND t.password=:password";
		Query query=session.createQuery(hql);
		query.setParameter("name", name);
		query.setParameter("password", password);
		
		return  (Examinee) query.list().get(0);
	}

	public List<Examinee> getExamineesByPage(int firstResult, int maxResults) {
		Session session=getCurrentSession();
		Query query=session.createQuery("FROM Examinee");
		query.setFirstResult(firstResult);
		query.setMaxResults(maxResults);
		return query.list();
	}

	public int countExaminees() {
		Session session=getCurrentSession();
		Query query=session.createQuery("FROM Examinee");
		return query.list().size();
	}
}
