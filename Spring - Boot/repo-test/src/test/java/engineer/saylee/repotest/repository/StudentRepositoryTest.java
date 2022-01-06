package engineer.saylee.repotest.repository;

import engineer.saylee.repotest.entity.Student;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Nested
    class checkIFEmailExistsOrNot{

        @BeforeEach
        public void setup(){
            Student saylee = new Student("Saylee", 23,"saylee@gmail.com");
            studentRepository.save(saylee);
        }

        @AfterEach
        public  void  tearDown(){
            studentRepository.deleteAll();
        }

        @Test
        public void returnTrueIfEmailExists(){
            Boolean actual = studentRepository.checkIfEmailExists("saylee@gmail.com");
            assertTrue(actual);
        }

        @Test
        public void returnFalseIfEmailDoesNotExists(){
            Boolean actual = studentRepository.checkIfEmailExists("sanat@gmail.com");
            assertFalse(actual);
        }
    }

}