package com.example.exercice_student.controller;

import com.example.exercice_student.model.Student;
import com.example.exercice_student.service.IStudentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
public class StudentController {

   private final IStudentService studentService;

    @Value("${academy.name}")
    private  String academyName;

    @Value("${academy.contact}")
    private String academyContact;

    public StudentController(IStudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping  // http://localhost:8080
    public String home(Model model){
        model.addAttribute("name",academyName);
        model.addAttribute("contact",academyContact);
        return "home";
    }

    @GetMapping("/students") // http://localhost:8080/students http://localhost:8080/students?search=toto
    public String showAllStudents(@RequestParam(name = "search",required = false) String search, Model model){
        if(search == null){
            model.addAttribute("students",studentService.getAllStudents());

        }else {
            model.addAttribute("students",studentService.searchStudents(search));
        }
       return "list";
    }

    @GetMapping("/student/{id}")  // http://localhost:8080/student/x
    public String showStudent(@PathVariable Long id,Model model){
        model.addAttribute("student",studentService.getStudentById(id));
        return "detail";
    }

    @GetMapping("/formulaire") // http://localhost:8080/formulaire
    public String formAddStudent(Model model){
        model.addAttribute("student",new Student());

        return "form";
    }

    @PostMapping("/student")
    public String addStudent(@Valid @ModelAttribute("student") Student student, BindingResult result){
        if (result.hasErrors()){
            return "/form";
        }else {
            if(student.getId() != null){
                studentService.updateStudent(student.getId(),student);
            } else {
            studentService.createStudent(student);
                System.out.println("coucou");
            }
        }
        return "redirect:/students";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("studentId") Long id){
        studentService.deleteStudent(id);
        return "redirect:/students";
    }

    @GetMapping("/update")
    public String formUpdateStudent(@RequestParam("studentId") Long id,Model model){
        Student student = studentService.getStudentById(id);
        model.addAttribute("student",student);
        return "form";
    }


}
