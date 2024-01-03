package com.example.StudentDataStorage.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.StudentDataStorage.Entity.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

}
