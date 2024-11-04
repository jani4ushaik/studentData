package ashokit.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import ashokit.entity.StudentData;
import ashokit.repo.StudentDataRepo;

@Service
public class StudentDataServiceImpl implements StudentDataService {

	@Autowired
	private StudentDataRepo studentDataRepo;

	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	public boolean saveStudentData(StudentData studentData) {

		studentDataRepo.save(studentData);

		return true;
	}

	@Override
	public StudentData findById(Long id) {
		StudentData studentData = studentDataRepo.findById(id).get();
		return studentData;
	}

	@Override
	public void sendEmail() {

		SimpleMailMessage smm = new SimpleMailMessage();
		smm.setTo("pillisasidharreddy150@gmail.com");

		smm.setFrom("jani4ushaik@gmail.com");
		smm.setSubject("Regarding job opertunity");
		smm.setText("Hi Sasidhar reddy this is Jani bhai." + "/r/n" + "i want to give job for u");
		javaMailSender.send(smm);

	}

		@Override
	public boolean updateStudent(long id, StudentData studentData) {
		
		Optional<StudentData> optional = studentDataRepo.findById(id);

		if (optional.isPresent()) {
			StudentData studata = optional.get();
			studentData.setName(studata.getName());
			studentData.setAddress(studata.getAddress());
			studentData.setEmail(studata.getEmail());
			studentDataRepo.save(studata);
		
			return true;
		} else {
			return false;
		}
		}
	


}