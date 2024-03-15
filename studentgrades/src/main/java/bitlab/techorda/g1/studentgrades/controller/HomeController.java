package bitlab.techorda.g1.studentgrades.controller;

import bitlab.techorda.g1.studentgrades.db.DBManager;
import bitlab.techorda.g1.studentgrades.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller

public class HomeController {

    @GetMapping(value = "/home")
    public String indexPage(Model model){
        ArrayList<Student> allStudents = DBManager.getAllStudents();
        model.addAttribute("allStudentsAttribute",allStudents);
        return "index";
    }

    @GetMapping(value = "/addStudentPage")
    public String addStudentPage(){
        return "addStudent";
    }

    @PostMapping(value = "/addStudent")
    public String addStudent(@RequestParam(name = "name") String studentName,
                             @RequestParam (name = "surname") String studentSurname,
                             @RequestParam(name = "exam") int exam){
        Student student = new Student();
        student.setName(studentName);
        student.setSurname(studentSurname);
        student.setExam(exam);
        DBManager.addStudent(student);
        return "redirect:/home";
    }
}
