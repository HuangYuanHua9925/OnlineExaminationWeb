package online.examination.web.mvc;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import online.examination.web.model.Examinee;
import online.examination.web.model.Teacher;
import online.examination.web.service.ExamineeService;
import online.examination.web.service.TeacherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
@RequestMapping(value = "/teacher")
public class TeacherController {
	@Autowired
	TeacherService teacherService;
	@Autowired
	ExamineeService examineeService;

	@RequestMapping(value = "/teacherIndex")
	public String toTeacherIndex() {

		return "teacher/teacher_index";
	}

	@RequestMapping(value = "/teacherList")
	public String toTeacherList() {
		System.out.println(1);
		return "teacher/teacher_list";
	}

	@RequestMapping(value = "/examineeList")
	public String toExamineeList() {

		return "teacher/examinee_list";
	}

	@RequestMapping(value = "/toUpdateTeacher", method = RequestMethod.GET)
	public String toUpdateTeacher(Map<String, Object> maps,
			@RequestParam(value = "id") Integer id) {
		Teacher teacher = teacherService.getById(id);
		maps.put("teacher", teacher);
		return "teacher/update_teacher";
	}
	@RequestMapping(value="/toUpdateExaminee",method=RequestMethod.GET)
	public String toUpdateExaminee(Map<String,Object> maps,@RequestParam(value="id")Integer id){
		Examinee examinee =examineeService.getById(id);
		maps.put("examinee", examinee);
		return "teacher/update_examinee";
	}
	
	@RequestMapping(value = "/toTeacherInformation", method = RequestMethod.GET)
	public String toTeacherInformation(Map<String, Object> maps,
			@RequestParam(value = "id") Integer id) {
		Teacher teacher = teacherService.getById(id);
		maps.put("teacher", teacher);
		return "teacher/teacher_information";
	}
	@RequestMapping(value = "/toExamineeInformation", method = RequestMethod.GET)
	public String toExamineeInformation(Map<String, Object> maps,
			@RequestParam(value = "id") Integer id) {
		Examinee examinee=examineeService.getById(id);
		maps.put("examinee", examinee);
		return "teacher/examinee_information";
	}
	@RequestMapping(value="/deleteTeacher",method=RequestMethod.GET)
	public void deleteTeacher(@RequestParam(value="id")Integer id){
		Teacher teacher=teacherService.getById(id);
		teacherService.delete(teacher);
	}
	
	@RequestMapping(value = "/updateTeacher", method = RequestMethod.POST)
	public String updateTeacher(
			HttpServletRequest request,
			@RequestParam(value = "id") Integer id,
			@RequestParam(value = "name") String name,
			@RequestParam(value = "sex", required = false) String sex,
			@RequestParam(value = "nationality", required = false) String nationality,
			@RequestParam(value = "tel", required = false) String tel,
			@RequestParam(value = "height", required = false) Integer height,
			@RequestParam(value = "weight", required = false) Double weight,
			@RequestParam(value = "position", required = false) String position,
			@RequestParam(value = "school", required = false) String school,
			@RequestParam(value = "file", required = false) CommonsMultipartFile file)
			throws Exception, IOException {

		Teacher teacher = teacherService.getById(id);
		teacher.setName(name);
		teacher.setHeight(height);
		teacher.setWeight(weight);
		teacher.setNationality(nationality);
		teacher.setPosition(position);
		teacher.setSchool(school);
		teacher.setSex(sex);
		teacher.setTel(tel);
		String imagePath = teacher.getAvater();
		if (file.getOriginalFilename().length()>4) {
			if (imagePath != null) {
				File originFile = new File(request.getSession()
						.getServletContext().getRealPath("/")
						+ "resources\\images\\teacher\\" + imagePath);
				if (originFile.exists()) {
					originFile.delete();
				}
			}
			String fileName = file.getOriginalFilename();
			String pathEnd = fileName.substring(fileName.length() - 4,
					fileName.length());
			String newPathName = String.valueOf(new Date().getTime());
			String path = request.getSession().getServletContext()
					.getRealPath("/")
					+ "resources\\images\\teacher\\" + newPathName + pathEnd;
			teacher.setAvater(newPathName + pathEnd);
			file.transferTo(new File(path));
		}
		teacherService.update(teacher);
		return "teacher/teacher_list";
	}
	
	@RequestMapping(value="/updateExaminee")
	public String updateExaminee(HttpServletRequest request,
			@RequestParam(value = "id") Integer id,
			@RequestParam(value = "name") String name,
			@RequestParam(value = "sex", required = false) String sex,
			@RequestParam(value = "nationality", required = false) String nationality,
			@RequestParam(value = "tel", required = false) String tel,
			@RequestParam(value = "height", required = false) Integer height,
			@RequestParam(value = "weight", required = false) Double weight,
			@RequestParam(value = "studentId", required = false) Integer studentId,
			@RequestParam(value = "_class", required = false) Integer _class,
			@RequestParam(value = "school", required = false) String school,
			@RequestParam(value = "file", required = false) CommonsMultipartFile file) throws IllegalStateException, IOException{
		Examinee examinee =examineeService.getById(id);
		examinee.setName(name);
		examinee.setSex(sex);
		examinee.setHeight(height);
		examinee.setWeight(weight);
		examinee.setSchool(school);
		examinee.setStudentId(studentId);
		examinee.setNationality(nationality);
		examinee.setTel(tel);
		examinee.set_class(_class);
		
		String imagePath = examinee.getAvater();
		if(file.getOriginalFilename().length()>4){
			if (imagePath != null) {
				File originFile = new File(request.getSession()
						.getServletContext().getRealPath("/")
						+ "resources\\images\\examinee\\" + imagePath);
				if (originFile.exists()) {
					originFile.delete();
				}
			}
			String fileName = file.getOriginalFilename();
			String pathEnd = fileName.substring(fileName.length() - 4,
					fileName.length());
			String newPathName = String.valueOf(new Date().getTime());
			String path = request.getSession().getServletContext()
					.getRealPath("/")
					+ "resources\\images\\examinee\\" + newPathName + pathEnd;
			examinee.setAvater(newPathName + pathEnd);
			file.transferTo(new File(path));
		}
		
		examineeService.update(examinee);
		
		
		return "teacher/examinee_list";
	}
	
	
	
	@RequestMapping(value = "/getTeachersByPage", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> getTeachersByPage(
			@RequestParam(value = "page") int page,
			@RequestParam(value = "pageSize") int pageSize) {
		Map<String, Object> maps = new HashMap<String, Object>();
		List<Teacher> rows = teacherService.getTeachersByPage(page, pageSize);
		int total = teacherService.countTeachers();
		maps.put("rows", rows);
		maps.put("total", total);
		return maps;
	}

	
	
	
	@RequestMapping(value = "/getExamineesByPage", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> getExamineesByPage(
			@RequestParam(value = "page") int page,
			@RequestParam(value = "pageSize") int pageSize) {
		Map<String, Object> maps = new HashMap<String, Object>();
		List<Examinee> rows = examineeService
				.getExamineesByPage(page, pageSize);
		int total = examineeService.countExaminees();
		maps.put("rows", rows);
		maps.put("total", total);
		return maps;
	}
}
