package ashokit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ashokit.entity.StudentData;
import ashokit.service.StudentDataService;

@RestController
public class StudentDataController {
	@Autowired
	private StudentDataService studentDataService;
	
	@PostMapping("/student")
	public boolean saveStudentData (@RequestBody StudentData studentData) {
		boolean save = studentDataService.saveStudentData(studentData);
		return save;
         
	}
	
	@GetMapping("/student/{id}")
	public StudentData findById(@PathVariable("id") Long id) {
		StudentData byId = studentDataService.findById(id);
		return byId;
	}
	
	public boolean updateStudent(Long id,StudentData studentData) {
		
		 boolean updateStudent = studentDataService.updateStudent(id, studentData);
		
		return false;
		
	}
	
	
	
	
	
	
	
	
	@GetMapping("/sendEmail")
	public String sendEmail() {
		studentDataService.sendEmail();
		return "email send successfully";
	}
	
}