package com.example.studentmanagementsystem.Repository;

import com.example.studentmanagementsystem.Domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
