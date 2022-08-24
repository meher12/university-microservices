package net.spboot.guru.university.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.spboot.guru.university.model.Student;
import net.spboot.guru.university.model.StudentInfo;
import net.spboot.guru.university.repository.StudentRepository;
import net.spboot.guru.university.request.StudentRequest;
import net.spboot.guru.university.service.StudentServicer;

@RestController
@RequestMapping("api/v1/students")
@AllArgsConstructor
@Slf4j
@RefreshScope
public class StudentController {
    
    @Autowired
    private final StudentRepository studentRepository;

    @Autowired
    private final StudentServicer studentServicer;

    @PostMapping
    public void registerStudentC(@RequestBody StudentRequest studentRepository) {
        studentServicer.registerStudent(studentRepository);
        log.info("New Student registration {} ", studentRepository);
    }
    
    @GetMapping("/{studentId}")
    public ResponseEntity<StudentInfo>  getDetailStudent(@PathVariable("studentId") Long studentId) {
        
        StudentInfo studentInfo = studentServicer.getDetailStudent(studentId);

         return new ResponseEntity<>(studentInfo, HttpStatus.OK);
       }
        
       
    

}
