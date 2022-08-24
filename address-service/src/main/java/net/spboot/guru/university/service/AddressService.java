package net.spboot.guru.university.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import net.spboot.guru.university.model.Address;
import net.spboot.guru.university.repository.AddressRepository;

@Service
@Data
@Slf4j
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public void registerAddressByzipCode(String personId, String zipCode) {

        if (zipCode.equals("0000")) {
            // address =
            // Address.builder().personId(personId).city("Tunis").zipCode("0000").build();
            // Address address = new Address(personId, "Tunis", "0000");

            addressRepository.saveAndFlush(Address.builder().personId(personId).city("Tunis").zipCode("0000").build());

            log.info("New Address registration {} for Student {} ", personId);

        }

        if (zipCode.equals("0001")) {

            // Address.builder().personId(personId).city("Ariana").zipCode("0001").build();
            // Address address = new Address(personId, "Ariana", "0001");
            log.info("New Address registration {} for Student {} ", personId);
            addressRepository.saveAndFlush(Address.builder().personId(personId).city("Ariana").zipCode("0001").build());

        }

        if (zipCode.equals("0002")) {
            // address = Address.builder().personId(personId).city("Ben
            // Arous").zipCode("0002").build();
            // Address address = new Address(personId, "Ben Arous", "0002");
            log.info("New Address registration {} for Student {} ", personId);
            addressRepository
                    .saveAndFlush(Address.builder().personId(personId).city("Ben Arous").zipCode("0002").build());

        }

        if (zipCode.equals("0003")) {
            // address = Address.builder().personId(personId).city("Berg de
            // Lac").zipCode("0003").build();
            // Address address = new Address(personId, "Berg de Lac", "0003");
            log.info("New Address registration {} for Student {} ", personId);
            addressRepository
                    .saveAndFlush(Address.builder().personId(personId).city("Berg de Lac").zipCode("0003").build());

        }

        if (zipCode.equals("0004")) {

            // address =
            // Address.builder().personId(personId).city("Marsa").zipCode("0004").build();
            // Address address = new Address(personId, "Marsa", "0004");
            log.info("New Address registration {} for Student {} ", personId);
            addressRepository.saveAndFlush(Address.builder().personId(personId).city("Marsa").zipCode("0004").build());

        }

    }
    
    public Address getAddressBypersonId(String personId) {
        return addressRepository.findBypersonId(personId)
                .orElseThrow(() -> new RuntimeException("There is not Address by id "+ personId));
    }

}
