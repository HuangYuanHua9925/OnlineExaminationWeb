package online.examination.web.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="tb_examinations")
public class Examinations {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Integer id;
	
	@Column(name="student_id",length=11)
	private Integer studentId;
	
	@Column(name="questions",length=255)
	private String questions;
	
	@Column(name="answers",length=255)
	private String answers;
	
	@Column(name="score",length=3)
	private Integer score;
	
	@Column(name="start_examination_time")
	private Date start_examination_time;
	
	@Column(name="end_examination_time")
	private Date end_examination_time;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	public String getQuestions() {
		return questions;
	}
	public void setQuestions(String questions) {
		this.questions = questions;
	}
	public String getAnswers() {
		return answers;
	}
	public void setAnswers(String answers) {
		this.answers = answers;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public Date getStart_examination_time() {
		return start_examination_time;
	}
	public void setStart_examination_time(Date start_examination_time) {
		this.start_examination_time = start_examination_time;
	}
	public Date getEnd_examination_time() {
		return end_examination_time;
	}
	public void setEnd_examination_time(Date end_examination_time) {
		this.end_examination_time = end_examination_time;
	}
	
}
