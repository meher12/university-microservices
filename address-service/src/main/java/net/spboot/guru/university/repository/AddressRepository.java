package net.spboot.guru.university.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.spboot.guru.university.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{
    
    Optional<Address> findBypersonId(String personId);

}
