package online.examination.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.examination.web.DAO.QuestionsOptionDAO;
import online.examination.web.model.QuestionsOption;
import online.examination.web.service.QuestionsOptionService;
@Service
public class QuestionsOptionServiceImpl implements QuestionsOptionService {
	@Autowired
	QuestionsOptionDAO questionsOptionDAO;
	public void save(QuestionsOption t) {
		questionsOptionDAO.save(t);

	}

	public void update(QuestionsOption t) {
		questionsOptionDAO.update(t);

	}

	public void delete(QuestionsOption t) {
		questionsOptionDAO.delete(t);

	}

	public void saveOrUpdate(QuestionsOption t) {
		questionsOptionDAO.saveOrUpdate(t);

	}

	public QuestionsOption getById(int id) {
		
		return questionsOptionDAO.getById(id);
	}

	public List<QuestionsOption> getAll() {
		return questionsOptionDAO.getAll();
	}

}
