package net.spboot.guru.university.service;




import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.AllArgsConstructor;
import net.spboot.guru.university.feignClient.AddressFeignClientService;
import net.spboot.guru.university.model.Student;
import net.spboot.guru.university.model.StudentInfo;
import net.spboot.guru.university.repository.StudentRepository;
import net.spboot.guru.university.request.Address;
import net.spboot.guru.university.request.StudentRequest;

@Service
@AllArgsConstructor
public class StudentServicer {

    @Autowired
    private final StudentRepository studentRepository;
    
    @Autowired
    private final RestTemplate restTemplate;
    
    @Autowired
    private AddressFeignClientService addressProxy;
    
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
        
        //restTemplate.getForEntity("http://localhost:8281/api/address/{personId}/{zipCode}", Address.class, uriVaraibles);
        addressProxy.registerAddress(String.valueOf(student.getId()), student.getZipCode());
    }
    
    public StudentInfo getDetailStudent(Long id){
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id " + id));
        
      // Address address =  restTemplate.getForObject("http://localhost:8281/api/v1/address/{personId}", Address.class, id);
       Address address = addressProxy.getAddressBypersonId(String.valueOf(student.getId()));
        return new StudentInfo(student, address);
    }
}
