package net.spboot.guru.university.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.spboot.guru.university.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

}
