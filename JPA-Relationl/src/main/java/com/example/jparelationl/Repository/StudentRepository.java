package com.example.jparelationl.Repository;

import com.example.jparelationl.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {

    Student findStudentById(Integer id);
}
