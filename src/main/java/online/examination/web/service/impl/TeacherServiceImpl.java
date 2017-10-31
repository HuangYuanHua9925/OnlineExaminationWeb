package online.examination.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import online.examination.web.DAO.TeacherDAO;
import online.examination.web.model.Teacher;
import online.examination.web.service.TeacherService;

/*
 * @Service用于标注业务层组件
 * */

@Service()
public class TeacherServiceImpl implements TeacherService{
	@Autowired
	TeacherDAO teacherDAO;

	public void save(Teacher t) {
		teacherDAO.save(t);
		
	}

	public void update(Teacher t) {
		teacherDAO.update(t);
		
	}

	public void delete(Teacher t) {
		teacherDAO.delete(t);
		
	}

	public void saveOrUpdate(Teacher t) {
		teacherDAO.saveOrUpdate(t);
		
	}

	public Teacher getById(int id) {
		
		return teacherDAO.getById(id);
	}

	public List<Teacher> getAll() {
		
		return teacherDAO.getAll();
	}

	public Teacher getTeacherByNameAndPassword(String name, String password) {
		
		return teacherDAO.getTeacherByNameAndPassword(name, password);
	}

	public List<Teacher> getTeachersByPage(int page, int pageSize) {
		
		return teacherDAO.getTeachersByPage((page-1)*pageSize, pageSize);
	}

	public int countTeachers() {
		
		return teacherDAO.countTeachers();
	}

}
