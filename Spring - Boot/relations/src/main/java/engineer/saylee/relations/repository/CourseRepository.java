package engineer.saylee.relations.repository;

import engineer.saylee.relations.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
