package com.skiply.skiply.service;

import com.skiply.skiply.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> findAll();

    Student findById(Integer id);

    Student save(Student student);
}
