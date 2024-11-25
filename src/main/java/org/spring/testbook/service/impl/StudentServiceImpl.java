package org.spring.testbook.service.impl;

import jakarta.annotation.Resource;
import org.spring.testbook.Mapper.StudentMapper;
import org.spring.testbook.entity.Student;
import org.spring.testbook.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    StudentMapper studentMapper;


    @Override
    public List<Student> selectAllStudent() {
        return studentMapper.selectAllStudent();
    }

    @Override
    public int countStudents() {
        return studentMapper.countStudents();
    }

    @Override
    public void insertStudent(String name, String sex, int age, String grade) {
        studentMapper.insertStudent(name, sex, age, grade);
    }
}
