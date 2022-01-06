package engineer.saylee.relations.repository;

import engineer.saylee.relations.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
