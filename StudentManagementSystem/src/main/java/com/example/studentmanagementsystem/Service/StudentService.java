package com.example.studentmanagementsystem.Service;

import com.example.studentmanagementsystem.Domain.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    Student saveStudent(Student student);
    Student getStudentById(long Id);
    List<Student> getAllStudents();
    Student updateStudentRecord(Student student);
    void deleteStudent(long Id);

}
