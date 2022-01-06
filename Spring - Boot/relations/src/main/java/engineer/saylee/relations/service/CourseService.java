package engineer.saylee.relations.service;

import engineer.saylee.relations.entity.Course;
import engineer.saylee.relations.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    CourseRepository courseRepository;

    public Course save(Course course) {
         return courseRepository.save(course);
    }

    public Course getCourseById(Long id) {
        return courseRepository.findById(id).get();
    }

    public List<Course> getAllcourses() {
        return courseRepository.findAll();
    }
}
