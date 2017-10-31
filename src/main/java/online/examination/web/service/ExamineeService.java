package online.examination.web.service;

import java.util.List;

import online.examination.web.DAO.BaseDAO;
import online.examination.web.model.Examinee;
import online.examination.web.model.Teacher;

public interface ExamineeService extends BaseDAO<Examinee> {
	Examinee getExamineeByNameAndPassword(String name,String password);
	List<Examinee> getExamineesByPage(int page,int pageSize);
	int countExaminees();
}
