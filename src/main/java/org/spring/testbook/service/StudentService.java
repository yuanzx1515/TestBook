package org.spring.testbook.service;

import org.spring.testbook.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> selectAllStudent();
    int countStudents();
    void insertStudent(String name, String sex, int age, String grade);
}
