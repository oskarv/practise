package com.endava.repository;

import java.util.List;

public interface StudentDao {

    List<Student> findAllStudents();

    Student findStudentById(int id);

    boolean insertStudent(Student student);
}
