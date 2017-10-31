package online.examination.web.service.impl;

import java.util.List;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.examination.web.DAO.ExamineeDAO;
import online.examination.web.model.Examinee;
import online.examination.web.service.ExamineeService;

@Service
public class ExamineeServiceImpl implements ExamineeService {
	@Autowired
	ExamineeDAO examineeDAO;
	public void save(Examinee t) {
		examineeDAO.save(t);
	}

	public void update(Examinee t) {
		examineeDAO.update(t);

	}

	public void delete(Examinee t) {
		examineeDAO.delete(t);

	}

	public void saveOrUpdate(Examinee t) {
		examineeDAO.saveOrUpdate(t);

	}

	public Examinee getById(int id) {
		
		return examineeDAO.getById(id);
	}

	public List<Examinee> getAll() {
		return examineeDAO.getAll();
	}

	public Examinee getExamineeByNameAndPassword(String name, String password) {
		
		return examineeDAO.getExamineeByNameAndPassword(name, password);
	}

	public List<Examinee> getExamineesByPage(int page, int pageSize) {
	
		return examineeDAO.getExamineesByPage((page-1)*pageSize, pageSize);
	}

	public int countExaminees() {
		
		return examineeDAO.countExaminees();
	}

}
