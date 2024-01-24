package com.example.studentmanagementsystem.Domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity(name= "Student")
public class Student {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Long id;
    private String Name;
    private String Department;
    private String Matric_No;
    private int Student_Level;

    public Student() {

    }

// Getter and Setter


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    public String getMatric_No() {
        return Matric_No;
    }

    public void setMatric_No(String matric_No){
        Matric_No = matric_No;
    }

    public int getStudent_Level() {
        return Student_Level;
    }
    public void setStudent_Level(int student_Level) {
        Student_Level = student_Level;
    }

    // constructor

    public Student(Long id, String name, String department, String matric_No,int student_Level) {
        this.id = id;
        Name = name;
        Department = department;
        Matric_No = matric_No;
        Student_Level = student_Level;













        
    }
}
