package net.spboot.guru.university.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.spboot.guru.university.request.StudentRequest;
import net.spboot.guru.university.service.StudentServicer;

@RestController
@RequestMapping("api/v1/students")
@AllArgsConstructor
@Slf4j
public class StudentController {

    @Autowired
    private final StudentServicer studentServicer;

    @PostMapping
    public void registerStudentC(@RequestBody StudentRequest studentRepository) {
        studentServicer.registerStudent(studentRepository);
        log.info("New Student registration {} ", studentRepository);
    }

}
