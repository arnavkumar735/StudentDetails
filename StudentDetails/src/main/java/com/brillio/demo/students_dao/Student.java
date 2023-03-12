package com.brillio.demo.students_dao;

import lombok.*;



import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Getter
@Setter
@ToString
public class Student {
    @Id
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private Integer age;
    @NonNull
    private String branch;

    @NonNull
    private String sex;
    @NonNull
    private Double percentage;

    public Student(Long id, @NonNull String name, @NonNull Integer age, @NonNull String branch,@NonNull String sex, @NonNull Double percentage) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.branch = branch;
        this.sex=sex;
        this.percentage = percentage;
    }


}
