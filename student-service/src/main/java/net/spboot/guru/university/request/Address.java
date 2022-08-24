package net.spboot.guru.university.request;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Address {

    @Id
    @SequenceGenerator(name = "address_id_sequence", sequenceName = "address_id_sequence")

    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "address_id_sequence")
    private long id;
    private String personId;
    private String city;
    private String zipCode;
    
    


  

}
