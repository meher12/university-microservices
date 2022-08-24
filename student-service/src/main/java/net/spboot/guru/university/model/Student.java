package net.spboot.guru.university.model;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
public class Student {

    @Id
    @SequenceGenerator(name = "student_id_sequence", sequenceName = " student_id_sequence ")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "student_id_sequence")
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String zipCode;
}
