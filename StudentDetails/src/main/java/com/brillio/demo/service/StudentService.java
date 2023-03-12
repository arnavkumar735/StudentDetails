package com.brillio.demo.service;

import com.brillio.demo.repository.StudentRepository;
import com.brillio.demo.students_dao.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private StudentRepository studentRepository = new StudentRepository();
    public List<Student> saveStudent(List<Student> students) {
        return studentRepository.save(students);
    }

    public List<Student> getAllStudent(){
        return studentRepository.getallStudent();
    }

    public List<Student> branchWiseStudent(String branch){
        return studentRepository.branchWiseStudent(branch);
    }


    public List<Student> top3StudentBranchWise(){
        return studentRepository.top3StudentBranchWise();
    }

    public ResponseEntity<List<Student>> getSexWiseToppersByBranch() {
        return studentRepository.getSexWiseToppersByBranch();
    }
}
