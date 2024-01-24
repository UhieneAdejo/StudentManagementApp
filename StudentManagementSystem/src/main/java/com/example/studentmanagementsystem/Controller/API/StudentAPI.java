package com.example.studentmanagementsystem.Controller.API;

import com.example.studentmanagementsystem.Domain.Student;
import com.example.studentmanagementsystem.Repository.StudentRepository;
import com.example.studentmanagementsystem.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
public class StudentAPI {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    StudentService studentService;
    @RequestMapping("/student")
    @GetMapping("/student")
    public ResponseEntity<List<Student>> getAllStudent(){
        return ResponseEntity.ok().body(studentService.getAllStudents());
    }
    @GetMapping
    public ResponseEntity<Student> getStudentById(@PathVariable long id){
        return ResponseEntity.ok().body(studentService.getStudentById(id));
    }
    @PostMapping("/student")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student){
        return ResponseEntity.ok().body(studentService.saveStudent(student));
    }
    @PutMapping("/student/{id}")
    public ResponseEntity<Student> updateStudentRecord(@PathVariable long Id, @RequestBody Student student){
        return ResponseEntity.ok().body(studentService.updateStudentRecord(student));
    }
    @DeleteMapping("/student/{id}")
    public HttpStatus deleteStudent(@PathVariable long id ){
        studentService.deleteStudent(id);
        return HttpStatus.OK;
    }



}
