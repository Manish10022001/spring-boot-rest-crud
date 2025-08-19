package com.restapi.demo.rest;

import com.restapi.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    //define the field
    public List<Student> theStudent;
    //load the field , but only once
    @PostConstruct
    public void loadData(){
        theStudent = new ArrayList<>();
        theStudent.add(new Student("Manish","Shirsat"));
        theStudent.add(new Student("Ajinkya","Shirsat"));
        theStudent.add(new Student("Lionel","Messi"));
    }
    //defining endpoint for "/students" - return a list of students
    @GetMapping("/student")
    public List<Student> getStudents(){ //in method, List<Student> because returning list of students
        /* we want to load student data only once, but bbelow code loads it every time method is called so used @PostConstruct, which loads data only once
        List<Student> theStudent = new ArrayList<>();
        theStudent.add(new Student("Manish","Shirsat"));
        theStudent.add(new Student("Ajinkya","Shirsat"));
        theStudent.add(new Student("Lionel","Messi"));
        */
        return theStudent;
    }
    @GetMapping("/student/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        // just index into the list ... keep it simple for now

        // check the studentId again list size
    //updated the rest service to throw exception if not found
        if(studentId>theStudent.size() || studentId < 0){
            throw new StudentNotFoundException("Student id not found - "+studentId);
        }
        return theStudent.get(studentId); //.get() to get index number
    }

    // Add an exception handler using @ExceptionHandler
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){

        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
