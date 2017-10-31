package online.examination.web.service;

import java.util.List;

import online.examination.web.model.Teacher;

public interface TeacherService extends BaseService<Teacher> {
	Teacher getTeacherByNameAndPassword(String name,String password);
	List<Teacher> getTeachersByPage(int page,int pageSize);
	int countTeachers();
}
