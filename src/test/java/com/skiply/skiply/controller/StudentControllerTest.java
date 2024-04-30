package com.skiply.skiply.controller;

import com.skiply.skiply.entity.Student;
import com.skiply.skiply.repository.StudentRepository;
import com.skiply.skiply.service.StudentService;
import com.skiply.skiply.service.StudentServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
@WebMvcTest(StudentController.class)
//@DataJpaTest
@ContextConfiguration(classes = {StudentService.class, StudentServiceImpl.class})
public class StudentControllerTest {
    @Autowired
    private MockMvc mvc;

    @InjectMocks
    StudentServiceImpl studentServiceImpl;

    @Mock
    StudentService studentService;

    @Mock
    StudentRepository studentRepository;


    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mvc = MockMvcBuilders.standaloneSetup(new StudentController()).build();
    }


    @Test
    public void getAllEmployeesAPI() throws Exception
    {
        Student student = new Student();
        student.setId(1);
        student.setName("test");
        student.setGrade("Grade 2");
        student.setMobile("234567");
        List<Student> students = new ArrayList<>();
        students.add(student);
        Mockito.when(studentRepository.findAll())
                .thenReturn(students);

        Mockito.when(studentService.findAll())
               .thenReturn(students);

        Mockito.when(studentServiceImpl.findAll())
                .thenReturn(students);


        mvc.perform(MockMvcRequestBuilders
                        .get("/students")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
            .andExpect(content().contentType("application/json"));
    }
}
