package engineer.saylee.repotest.service;

import engineer.saylee.repotest.entity.Student;
import engineer.saylee.repotest.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getALlStudents(){
        return studentRepository.findAll();
    }

    public Student getStudentId(Long id){
        return studentRepository.findById(id).get();
    }

    public Student createStudent(Student student){
        return  studentRepository.save(student);
    }

//    public boolean checkIfEmailExist(String email) {
//        return studentRepository.existByEmail(email);
//    }

    public boolean checkIfEmailExist(String email) {
        return studentRepository.checkIfEmailExists(email);
    }
}
