package org.spring.testbook.BookController;

import jakarta.annotation.Resource;
import org.spring.testbook.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

    @Resource
    private StudentService studentService;

    @GetMapping("/student")
    public String student(Model model) {
        model.addAttribute("student_list",studentService.selectAllStudent());
        return "student";
    }

    @GetMapping("/add-student")
    public String addStudent(Model model) {
        return "add-student";
    }

    @PostMapping("/add-student")
    public String addStudent(String name,String sex,int age,String grade){
        studentService.insertStudent(name, sex, age, grade);
        return "redirect:/student";
    }
}
