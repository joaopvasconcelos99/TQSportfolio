package com.example.P2_Test_Container;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public Student save(Student student) {
        return studentRepository.save(student);
    }

}