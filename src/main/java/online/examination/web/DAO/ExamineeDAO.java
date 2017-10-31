package online.examination.web.DAO;

import java.util.List;

import online.examination.web.model.Examinee;

public interface ExamineeDAO extends BaseDAO<Examinee> {
	Examinee getExamineeByNameAndPassword(String name,String password);
	List<Examinee> getExamineesByPage(int firstResult,int maxResults);
	int countExaminees();
}
