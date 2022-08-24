package net.spboot.guru.university.service;




import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.AllArgsConstructor;
import net.spboot.guru.university.model.Student;
import net.spboot.guru.university.repository.StudentRepository;
import net.spboot.guru.university.request.Address;
import net.spboot.guru.university.request.StudentRequest;

@Service
@AllArgsConstructor

public class StudentServicer {

    @Autowired
    private final StudentRepository studentRepository;
    
    private final RestTemplate restTemplate;
    
    public void registerStudent(StudentRequest studentRequest) {
        Student student = Student.builder()
                .firstName(studentRequest.firstName())
                .lastName(studentRequest.lastName())
                .email(studentRequest.email())
                .zipCode(studentRequest.zipCode())       
                .build();
        
        studentRepository.saveAndFlush(student);
        
        Map<String, String> uriVaraibles = new HashMap<>();
        uriVaraibles.put("personId", String.valueOf(student.getId()));
        uriVaraibles.put("zipCode", student.getZipCode());
        
        restTemplate.getForEntity("http://localhost:8281/api/v1/address/{personId}/{zipCode}", Address.class, uriVaraibles);
    }
}
