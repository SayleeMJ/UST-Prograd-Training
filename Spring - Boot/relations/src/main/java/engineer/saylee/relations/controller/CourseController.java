package engineer.saylee.relations.controller;

import engineer.saylee.relations.entity.Course;
import engineer.saylee.relations.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RestController
public class CourseController {
    @Autowired
    CourseService service;

    @GetMapping("/courses")
    public List<Course> list(){
        return service.getAllcourses();
    }

    @GetMapping("/course/{id}")
    public Course getStudent(@PathVariable Long id){
        return service.getCourseById(id);
    }

    @GetMapping("/course/new") // localhost:8080/student/new?name=some&age=xx
    public Course create(HttpServletRequest request){
        String name = request.getParameter("name");
        Course course = new Course(name);
        return service.save(course);

    }
}
