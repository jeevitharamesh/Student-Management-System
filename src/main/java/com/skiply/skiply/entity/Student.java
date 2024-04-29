package com.skiply.skiply.entity;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "Enter a valid Student name")
    @Column(name = "name", nullable = false)
    private String name;

    @NotEmpty(message = "Grade Must not be Empty or Null")
    @Column(name = "grade", nullable = false)

    private String grade;

    @NotEmpty(message = "Mobile Number Must not be Empty or Null")
    @Column(name = "mobile", nullable = false)

    private String mobile;

    public Student(){

    }

    public Student(Integer id, String name, String grade, String mobile, String schoolName) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.mobile = mobile;
        this.schoolName = schoolName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    @NotEmpty(message = "School Name cannot be Empty or Null")
    @Column(name = "school_name", nullable = false)
    private String schoolName;





}
