package net.spboot.guru.university.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.spboot.guru.university.request.Address;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentInfo {
    
    private Student student;
    private Address address;

}
