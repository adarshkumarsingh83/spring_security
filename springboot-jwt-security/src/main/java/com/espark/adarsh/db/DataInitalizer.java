package com.espark.adarsh.db;

import com.espark.adarsh.db.entity.Student;
import com.espark.adarsh.db.entity.Subject;
import com.espark.adarsh.db.entity.User;
import com.espark.adarsh.db.repository.StudentRepository;
import com.espark.adarsh.db.repository.SubjectRepository;
import com.espark.adarsh.db.repository.UserRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class DataInitalizer {

    @Bean
    ApplicationRunner init(UserRepository userRepository, StudentRepository studentRepository, SubjectRepository subjectRepository) {
        return (ApplicationArguments args) ->  dataSetup(userRepository,studentRepository,subjectRepository);
    }

    private void dataSetup(UserRepository userRepository, StudentRepository studentRepository, SubjectRepository subjectRepository) {
        //radha
        User admin = new User("adarsh@kumar", "$2a$10$LeTpxiUNFg2aP1gviLSuHe1DmVi3vOUrXt5YS.AnKFFL6s6IFHO0m", "ROLE_ADMIN");
        //adarsh
        User test = new User("radha@gmail.com", "$2a$10$E55wlprnWwfkNCKg0FR/OOKkZPAIt3ILQsaB4Pm7bbuQjdwdaCxFS", "ROLE_USER");
        userRepository.save(admin);
        userRepository.save(test);

        Student student1 = new Student(1L,"Sonu");
        Student student2 = new Student(2L,"Monu");
        studentRepository.save(student1);
        studentRepository.save(student2);

        Subject math = new Subject(1l,"Math");
        Subject science = new Subject(2l,"Science");
        subjectRepository.save(math);
        subjectRepository.save(science);
    }
}
