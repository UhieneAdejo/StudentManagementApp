package com.example.studentmanagementsystem.Controller;

import com.example.studentmanagementsystem.Domain.Student;
import com.example.studentmanagementsystem.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/StudentHomepage")
    public String homePage(Model model){
        model.addAttribute("student",studentService.getAllStudents());
        return "home";

    }
    @GetMapping("/ShowStudentForm")
    public String showStudentForm(Model model){
        Student student = new Student();
        model.addAttribute("student",student);
        model.addAttribute("nextPage","New Student");
        return "New_Student";

    }

    @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute("student") Student student, RedirectAttributes redirectAttributes){
        studentService.saveStudent(student);
        redirectAttributes.addFlashAttribute("message", "Student enrolled");
        redirectAttributes.addFlashAttribute("color", "success");

        return "redirect:/StudentHomepage";
    }
    @GetMapping("/updateStudentRecord/{id}")
    public String showEditForm(@PathVariable("id") Integer Id, Model model, RedirectAttributes redirectAttributes) {
        try {
            Student student = studentService.getStudentById(Id);
            model.addAttribute("student", student);
            model.addAttribute("pageTitle", "Edit Student Id:" + Id);
            return "updateStudentRecord";

        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
            redirectAttributes.addFlashAttribute("color", "danger");

            return "redirect:/StudentHomepage";
        }
    }
    @PostMapping("/updateStudentRecord")
    public String updateStudentRecord(@ModelAttribute("student") Student student, RedirectAttributes redirectAttributes){
        try {
            studentService.saveStudent(student);
            redirectAttributes.addFlashAttribute("message", "Student Record updated successfully");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", "Error updating student: " + e.getMessage());
        }
        return "redirect:/StudentHomepage";
    }
    @GetMapping("deleteStudent/{id}")
    public String deleteStudent(@PathVariable long id, RedirectAttributes redirectAttributes) {
        try {
            studentService.deleteStudent(id);
            redirectAttributes.addFlashAttribute("message", "Student Deleted successfully");
            redirectAttributes.addFlashAttribute("color", "success");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
            redirectAttributes.addFlashAttribute("color", "danger");
        }

        return "redirect:/StudentHomepage";
    }
}
