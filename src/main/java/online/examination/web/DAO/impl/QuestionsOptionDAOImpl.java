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

import online.examination.web.DAO.QuestionsOptionDAO;
import online.examination.web.model.QuestionsOption;
@Repository
@Transactional
public class QuestionsOptionDAOImpl implements QuestionsOptionDAO {
	@Autowired
	SessionFactory sessionFactory;
	
	public void save(QuestionsOption t) {
		Session session =getCurrentSession();
		session.save(t);

	}

	public void update(QuestionsOption t) {
		Session session =getCurrentSession();
		session.update(t);

	}

	public void delete(QuestionsOption t) {
		Session session =getCurrentSession();
		session.delete(t);

	}

	public void saveOrUpdate(QuestionsOption t) {
		Session session =getCurrentSession();
		session.saveOrUpdate(t);

	}

	public QuestionsOption getById(int id) {
		Session session =getCurrentSession();
		Criteria criteria=session.createCriteria(QuestionsOption.class);
		criteria.add(Restrictions.eq("id", id));
		return (QuestionsOption) criteria.list().get(0);
	}

	public List<QuestionsOption> getAll() {
		Session session =getCurrentSession();
		Query query=session.createQuery("FROM QuestionsOption");
		
		return query.list();
	}
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
}
