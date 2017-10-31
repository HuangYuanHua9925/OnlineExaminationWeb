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

import online.examination.web.DAO.ExaminationsDAO;
import online.examination.web.model.Examinations;
@Transactional
@Repository
public class ExaminationsDAOImpl implements ExaminationsDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	public void save(Examinations t) {
		Session session=getCurrentSession();
		session.save(t);
	}

	public void update(Examinations t) {
		Session session=getCurrentSession();
		session.update(t);
	}

	public void delete(Examinations t) {
		Session session=getCurrentSession();
		session.delete(t);

	}

	public void saveOrUpdate(Examinations t) {
		Session session=getCurrentSession();
		session.saveOrUpdate(t);

	}

	public Examinations getById(int id) {
		Session session=getCurrentSession();
	    Criteria criteria=	session.createCriteria(Examinations.class);
	    criteria.add(Restrictions.eq("id", id));
		return (Examinations) criteria.list().get(0);
	}

	public List<Examinations> getAll() {
		Session session=getCurrentSession();
		Query query= session.createQuery("FROM Examinations");
		
		return query.list();
	}
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
}
