package engineer.saylee.relations.controller;

import engineer.saylee.relations.entity.Course;
import engineer.saylee.relations.entity.Faculty;
import engineer.saylee.relations.entity.Student;
import engineer.saylee.relations.service.CourseService;
import engineer.saylee.relations.service.FacultyService;
import engineer.saylee.relations.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService service;

    @Autowired
    private FacultyService facultyService;

    @Autowired
    private CourseService courseService;

    @GetMapping("/students")
    public List<Student> list(){
        return service.getAllStudents();
    }

    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable Long id){
        return service.getStudentById(id);
    }

    @GetMapping("/student/new") // localhost:8080/student/new?name=some&age=xx
    public Student create(HttpServletRequest request){
        String name = request.getParameter("name");
        Integer age =  Integer.parseInt(request.getParameter("age"));
        Student student = new Student(name, age);
        return service.save(student);

    }

    @GetMapping("/student/{studentId}/assign-faculty/{facultyId}") ///localhost:3000/student/2/assign-faculty/3
    public  Student assignFaculty(@PathVariable Long studentId, @PathVariable Long facultyId){
        Student student = service.getStudentById(studentId);
        Faculty faculty = facultyService.getFacultyById(facultyId);
        student.setFaculty(faculty);
        return service.save(student);
    }

    @GetMapping("/student/{studentId}/add-course/{courseId}") ///localhost:3000/student/2/add-course/3
    public  Student addCourse(@PathVariable Long studentId, @PathVariable Long courseId){
        Student student = service.getStudentById(studentId);
        Course course = courseService.getCourseById(courseId);
        student.addCourse(course);
        return service.save(student);
    }
}
