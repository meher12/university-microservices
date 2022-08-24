package net.spboot.guru.university.request;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    @SequenceGenerator(name = "address_id_sequence", sequenceName = "address_id_sequence")

    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "address_id_sequence")
    private long id;
    private String personId;
    private String city;
    private String zipCode;
    
    
    public Address(String personId, String city, String zipCode) {
        this.personId = personId;
        this.city = city;
        this.zipCode = zipCode;
    }
    
    


  

}
