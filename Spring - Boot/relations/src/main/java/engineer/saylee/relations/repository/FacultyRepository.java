package engineer.saylee.relations.repository;

import engineer.saylee.relations.entity.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
}
