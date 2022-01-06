package engineer.saylee.relations.service;

import engineer.saylee.relations.entity.Faculty;
import engineer.saylee.relations.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyService {
    @Autowired
    FacultyRepository repository;
    public List<Faculty> getAllStudents() {
        return repository.findAll();
    }
    public Faculty save(Faculty faculty){
        return  repository.save(faculty);
    }

    public Faculty getFacultyById(Long facultyId) {
        return repository.findById(facultyId).get();
    }
}
