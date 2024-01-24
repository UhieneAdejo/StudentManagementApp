package com.example.studentmanagementsystem.Service;

import com.example.studentmanagementsystem.Domain.Student;
import com.example.studentmanagementsystem.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class StudentServiceImpl implements StudentService{
    @Autowired
    StudentRepository studentRepository;
    @Override
    public Student saveStudent(Student student) {

        return studentRepository.save(student);
    }
    @Override
    public Student getStudentById(long Id) {
        Optional<Student> student = studentRepository.findById(Id);
        Student emptyStudent = null;
        if (student.isPresent()) {
            emptyStudent = student.get();
            return emptyStudent;
        }
        else {
            throw new RuntimeException("Student not found");
        }
    }
    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
    @Override
    public Student updateStudentRecord(Student student) {
       Optional<Student> optionalStudent = studentRepository.findById(student.getId());
       if(optionalStudent.isPresent()){
           Student updateStudent = new Student();
           updateStudent.setId(student.getId());
           updateStudent.setName(student.getName());
           updateStudent.setDepartment(student.getDepartment());
           updateStudent.setMatric_No(student.getMatric_No());
           updateStudent.setStudent_Level(student.getStudent_Level());
           studentRepository.save(updateStudent);
           return updateStudent;
       }
        else{
            throw new RuntimeException("Student not found");
       }
    }
    @Override
    public void deleteStudent(long Id) {
        studentRepository.deleteById(Id);

    }
}
