
package ashokit.service;

import ashokit.entity.StudentData;



public interface StudentDataService {

	
	public boolean saveStudentData(StudentData  studentData);
	
	public StudentData findById(Long id);
	
	public void sendEmail();
	
	public boolean updateStudent (long id,StudentData studentData);
	
	
}
