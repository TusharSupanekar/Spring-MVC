package com.jsp.studentService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsp.student.Student;
import com.jsp.studentDao.StudentDao;

@Component
public class StudentService {
	
	@Autowired
	private StudentDao studentDao;
	
	public Student saveStudent(Student student) {
		return	studentDao.saveStudent(student);	
	}
	
	public List<Student> getAllStudent(){
		return studentDao.getAllStudent();
	}
	
	public boolean deleteById(int id) {
		return studentDao.deleteById(id);
	}
	
	public Student getById(int id) {
		return studentDao.getById(id);	
	}
	
	public Student updateById(int id,Student student) {
		
		Student s= studentDao.getById(id);
		s.setName(student.getName());
		s.setName(student.getEmail());
		return studentDao.updateById(s);
	}

	
	
	
	
	
	

}
