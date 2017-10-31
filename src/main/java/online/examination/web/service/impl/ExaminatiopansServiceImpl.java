package online.examination.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.examination.web.DAO.ExaminationsDAO;
import online.examination.web.model.Examinations;
import online.examination.web.service.ExaminationsService;
@Service
public class ExaminatiopansServiceImpl implements ExaminationsService {
	@Autowired
	ExaminationsDAO examinationsDAO;
	public void save(Examinations t) {
		examinationsDAO.save(t);

	}

	public void update(Examinations t) {
		examinationsDAO.update(t);

	}

	public void delete(Examinations t) {
		examinationsDAO.delete(t);

	}

	public void saveOrUpdate(Examinations t) {
		examinationsDAO.saveOrUpdate(t);

	}

	public Examinations getById(int id) {
		
		return examinationsDAO.getById(id);
	}

	public List<Examinations> getAll() {
		return examinationsDAO.getAll();
	}

}
