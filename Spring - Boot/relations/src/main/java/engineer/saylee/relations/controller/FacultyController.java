package engineer.saylee.relations.controller;

import engineer.saylee.relations.entity.Faculty;
import engineer.saylee.relations.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class FacultyController {
    @Autowired
    FacultyService service;

    @GetMapping("/faculties")
    public List<Faculty> list(){
        return service.getAllStudents();
    }

    @GetMapping("/faculty/{id}")
    public Faculty getFacultyById(@PathVariable Long id){
        return service.getFacultyById(id);
    }

    @GetMapping("/faculty/new") // localhost:8080/student/new?name=some&age=xx
    public Faculty create(HttpServletRequest request){
        String name = request.getParameter("name");
        Faculty faculty = new Faculty(name);
        return service.save(faculty);

    }
}
