package online.examination.web.mvc;



import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

//还是说



import online.examination.web.model.Teacher;
import online.examination.web.service.ExamineeService;
import online.examination.web.service.TeacherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping
public class HomeController {
	@Autowired
	TeacherService teacherService;
	@Autowired
	ExamineeService examineeService;
	
	@RequestMapping({ "/", "/index" })
	public String toIndex(){
		return "index";
	}
	@RequestMapping(value="/loginOut")
	public String loginOut(HttpServletRequest request){
		HttpSession session= request.getSession();
		session.invalidate();
		return "index";
	}
	
	@RequestMapping(value="/teacherLogin",method=RequestMethod.POST)
	public  @ResponseBody Map<String,Object> teacherLogin(HttpServletRequest request,@RequestParam(value="name")String name,@RequestParam(value="password")String password){
		Map<String , Object> maps=new HashMap<String, Object>();
		Teacher teacher=teacherService.getTeacherByNameAndPassword(name, password);
		if(teacher==null){
			maps.put("result", "error");
		}
		else{
			teacher.setLoginTime(new Date());
			teacherService.update(teacher);
			request.getSession().setAttribute("currTeacher", teacher);
			maps.put("result", "success");
		}
		return maps;
		
	}
	
	
	public static void main(String[] args) {
		/*测试配置文件是否成功*/
		ApplicationContext acc = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		
		
	}
}
