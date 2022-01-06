package engineer.saylee.repotest.repository;

import engineer.saylee.repotest.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepository extends JpaRepository<Student, Long> {
    //public boolean existByEmail(String email);

    @Query(
            " SELECT CASE WHEN COUNT(s) > 0 THEN TRUE ELSE FALSE END " +
            "FROM Student s WHERE s.email = ?1"
    )
    public Boolean checkIfEmailExists(String email);
}
