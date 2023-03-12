package com.brillio.demo.controller;

import com.brillio.demo.repository.StudentRepository;
import com.brillio.demo.service.StudentService;
import com.brillio.demo.students_dao.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentsController {

    @Autowired
    StudentService studentService;

    @GetMapping("/getAllStudent")
    public List<Student> getAllStudent()
    {
        return studentService.getAllStudent();
    }
    @PostMapping("/saveStudent")
    public List<Student> addStudent(@RequestBody List<Student> students) {
        return studentService.saveStudent(students);
    }


    @PostMapping("/branchWiseStudent")
    public List<Student> branchWiseStudent(@RequestParam String branch){
        return studentService.branchWiseStudent(branch);
    }

    @PostMapping("/top3StudentBranchWise")
    public List<Student> top3StudentBranchWise(){
        return studentService.top3StudentBranchWise();
    }

    @GetMapping("/sexWiseToppers")
    public ResponseEntity<List<Student>> getSexWiseToppersByBranch() {
       return studentService.getSexWiseToppersByBranch();
    }



}
