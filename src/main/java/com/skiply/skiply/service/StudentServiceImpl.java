package com.skiply.skiply.service;


import com.skiply.skiply.Exception.StudentAlreadyExistException;
import com.skiply.skiply.entity.Student;
import com.skiply.skiply.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Student findById(Integer id) {
        return studentRepository.findById(id).get();
    }

    @Transactional
    public Student save(Student student) {
        if(student.getId()!=null) {
            Student existingStudent
                    = studentRepository.findById(student.getId())
                    .orElse(null);
            if (existingStudent == null) {
                existingStudent = studentRepository.save(student);
                return existingStudent;
            } else
                throw new StudentAlreadyExistException(
                        "Student already exists for Id: " + student.getId());
        } else {
            return studentRepository.save(student);
        }
    }


}
