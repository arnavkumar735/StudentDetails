package com.brillio.demo.repository;

import com.brillio.demo.exception.BranchesException;
import com.brillio.demo.exception.DuplicateNameException;
import com.brillio.demo.exception.EmptyListException;
import com.brillio.demo.students_dao.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import java.util.stream.Stream;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class StudentRepository {
    Long id= 1L;

    private static List<Student> list= new ArrayList<Student>();

    public List<Student> save(List<Student> students) {
        List<Student> list1= new ArrayList<Student>();
        Long id1=id;
        for (Student student : students) {
            Student newStudent = new Student(id, student.getName(), student.getAge(), student.getBranch(), student.getSex(),student.getPercentage());
            for(Student student1:list)
            {
                if(newStudent.getName().equals(student1.getName()) && newStudent.getAge().equals(student1.getAge()) && newStudent.getPercentage().equals(student1.getPercentage()) && newStudent.getBranch().equals(student1.getBranch()) && newStudent.getSex().equals(student1.getSex())) {
                    list1.clear();
                    id=id1;
                    throw new DuplicateNameException("Student with same details already exist");
                }
            }

            list1.add(newStudent);
            id++;
        }
        list.addAll(list1);
        return list;
    }

    public List<Student> getallStudent() {
        if(list.isEmpty())
            throw new EmptyListException("List is empty");
        else
            return list;
    }



    public List<Student> branchWiseStudent(String branch){
        List<Student> listBranchWise= new ArrayList<Student>();
        if(branch.isEmpty())
            throw new BranchesException("branch field is empty");
        else {
            for(Student student:list){
                if(student.getBranch().equals(branch))
                    listBranchWise.add(student);
            }
            if(listBranchWise.isEmpty())
            {
                throw new BranchesException("No student with branch name"+branch+" exist");
            }
            else
            return listBranchWise;
        }
    }

    public List<Student> top3StudentBranchWise(){
        List<Student> top3studentallBranch=new ArrayList<>();
            List<Student> top3student=new ArrayList<>();
            List<String> branches = list.stream()
                    .map(Student::getBranch)
                    .distinct()
                    .collect(Collectors.toList());
            System.out.println(branches);

            for (String b : branches) {
                top3student = list.stream()
                        .filter(s -> s.getBranch().equalsIgnoreCase(b))
                        .sorted(Comparator.comparingDouble(Student::getPercentage).reversed())
                        .limit(3)
                        .collect(Collectors.toList());
                top3studentallBranch.addAll(top3student);
        }
            if(top3studentallBranch.isEmpty())
            {
                throw new BranchesException("No student exist");
            }
            else
                return top3studentallBranch;
        }

    public ResponseEntity<List<Student>> getSexWiseToppersByBranch() {
        if(list.isEmpty()) {
            throw new EmptyListException("No Student found");
        }
        List<Student> sexWiseToppers = new ArrayList<>();
        Set<String> branches = list.stream()
                .map(Student::getBranch)
                .collect(Collectors.toSet());
        for (String branch : branches) {
            List<Student> toppers = list.stream()
                    .filter(s -> s.getBranch().equalsIgnoreCase(branch))
                    .collect(Collectors.groupingBy(Student::getSex))
                    .values().stream()
                    .map(l -> l.stream()
                            .max(Comparator.comparingDouble(Student::getPercentage))
                            .orElse(null))
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
            sexWiseToppers.addAll(toppers);
        }
        if (sexWiseToppers.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(sexWiseToppers);
    }



}
