package engineer.saylee.relations.service;

import engineer.saylee.relations.entity.Student;
import engineer.saylee.relations.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository repo;

    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    public Student save(Student student){
        return  repo.save(student);
    }

    public Student getStudentById(Long studentId) {
        return repo.findById(studentId).get();
    }
}
