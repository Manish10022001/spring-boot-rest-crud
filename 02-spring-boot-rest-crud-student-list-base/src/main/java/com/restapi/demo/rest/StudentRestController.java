package com.restapi.demo.rest;

import com.restapi.demo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    //defining endpoint for "/students" - return a list of students
    @GetMapping("/students")
    public List<Student> getStudents(){ //in method, List<Student> because returning list of students
        List<Student> theStudent = new ArrayList<>();
        theStudent.add(new Student("Manish","Shirsat"));
        theStudent.add(new Student("Ajinkya","Shirsat"));
        theStudent.add(new Student("Lionel","Messi"));

        return theStudent;
    }

}
