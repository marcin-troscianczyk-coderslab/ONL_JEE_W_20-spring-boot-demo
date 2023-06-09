package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.model.Student;

import java.util.Arrays;
import java.util.List;

@Controller
class StudentController {

    @GetMapping(path = "/student/form")
    String showAddForm(Model model) {
        model.addAttribute("student", new Student());
        //model.addAttribute("countries", Arrays.asList("Poland", "Germany", "France", "Russia", "Denmark"));
        return "student/form";
    }

    @PostMapping(path = "/student/form", produces = "text/plain;charset=utf-8")
    @ResponseBody
    String processAddForm(Student student) {

        return student.toString();

    }

    @ModelAttribute("countries")
    public List<String> countries() {
        return Arrays.asList("Poland", "Germany", "France", "Russia", "Denmark");
    }

}
