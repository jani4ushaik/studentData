package ashokit.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ashokit.entity.StudentData;

@Repository
public interface StudentDataRepo extends JpaRepository<StudentData, Long> {

}
