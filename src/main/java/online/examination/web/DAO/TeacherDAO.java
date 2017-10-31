package online.examination.web.DAO;

import java.util.List;

import online.examination.web.model.Teacher;
 
public interface TeacherDAO extends BaseDAO<Teacher> {
	Teacher getTeacherByNameAndPassword(String name,String password);
	List<Teacher> getTeachersByPage(int firstResult,int maxResults);
	int countTeachers();
}
