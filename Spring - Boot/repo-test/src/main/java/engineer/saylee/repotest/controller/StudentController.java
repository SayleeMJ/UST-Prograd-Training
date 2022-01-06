package engineer.saylee.repotest.controller;

import engineer.saylee.repotest.entity.Student;
import engineer.saylee.repotest.service.StudentService;
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

    @GetMapping("/students")
    public List<Student> listAllStudents(){
        return  service.getALlStudents();
    }

    @GetMapping("/students/new")
    public Student create(HttpServletRequest request){
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        Integer age = Integer.parseInt(request.getParameter("age"));
        Student student = new Student(name, age, email);
        return service.createStudent(student);
    }

    @GetMapping("/students/check/email/{email}")
    public boolean checkEmail(@PathVariable String email){
       return service.checkIfEmailExist(email);
    }
}
