package com.endava.repository;

import java.util.List;

public interface StudentDao {

    List<Student> findAllStudents();

    Student findStudentById(int id);

    List<Student> findStudentsByName(String name);

    boolean insertStudent(Student student);
}
