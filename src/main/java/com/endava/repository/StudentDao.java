package com.endava.repository;

import java.util.List;

public interface StudentDao {

    List<Student> findAllStudents();

    Student findStudentById(int id);

    List<Student> findStudentsByName(String name);

    void insertStudent(Student student);

    boolean deleteStudent(int id);
}
