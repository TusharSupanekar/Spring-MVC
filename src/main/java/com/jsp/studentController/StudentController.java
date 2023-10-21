package com.jsp.studentController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.student.Student;
import com.jsp.studentService.StudentService;



@Controller                                  
public class StudentController {
	@Autowired
	StudentService studentService;
	
	@RequestMapping("/createstudent")
	public ModelAndView createStudent() {
		   ModelAndView modelAndView = new ModelAndView("studentform.jsp");
		   modelAndView.addObject("student1",new Student());
		   return modelAndView;
	}
	
	@RequestMapping("/studentadd")
	public ModelAndView studentadd(@ModelAttribute Student student) {
	       ModelAndView modelAndView = new ModelAndView("home.jsp");
	       studentService.saveStudent(student);
	       modelAndView.addObject("saved", student.getName()+ " has been saved");
	       return modelAndView;
	}
	
	@RequestMapping("/viewAllStudents")
	public ModelAndView getAllStudent() {
	       ModelAndView modelAndView = new ModelAndView("viewAll.jsp");
	       List<Student> student= studentService.getAllStudent();
	       modelAndView.addObject("student", student);
	       return modelAndView;
	}
	
	@RequestMapping("/delete")
	public ModelAndView deleteStudentById(@RequestParam(name="id") int id) {
	       ModelAndView modelAndView = new ModelAndView("home.jsp");
	       boolean res = studentService.deleteById(id);
	       	modelAndView.addObject("saved", "Student with following id deleted : " + id);
	       	return modelAndView;	
	}

	@RequestMapping("/update")
	public ModelAndView updateStudentById() {
	       ModelAndView modelAndView = new ModelAndView("updatestudentform.jsp");
	       modelAndView.addObject("studentupdate", new Student());
	       return modelAndView;	
	}
	
	@RequestMapping("/updatestudent")
	public ModelAndView finalUpdate(@ModelAttribute Student student) {
		   ModelAndView modelAndView = new ModelAndView("home.jsp");
		   studentService.updateById(student.getId(), student);
		   modelAndView.addObject("saved", student.getId()+" has been updated");
	       return modelAndView;	

	}

	
	

}
