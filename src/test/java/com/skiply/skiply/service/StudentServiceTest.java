package com.skiply.skiply.service;

import com.skiply.skiply.entity.Student;
import com.skiply.skiply.repository.StudentRepository;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private  StudentServiceImpl studentService;

    @Test
    public void getStudent(){
        Student student1 = new Student(1, "John", "Grade 5","12345678","test");
        Student student2 = new Student(1, "John", "Grade 5","12345678","test");
        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        Mockito.when(studentRepository.findAll()).thenReturn(students);
        List<Student> s =  studentService.findAll();
        assertNotNull(s);
    }

    @Test
    public void saveStudent(){

        Student student1 = new Student(1, "John", "Grade 5","12345678","test");
        Mockito.when(studentRepository.save(student1)).thenReturn(student1);
        Student student = studentService.save(student1);
        assertNotNull(student);

    }

}
