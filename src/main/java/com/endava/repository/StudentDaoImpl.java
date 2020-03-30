package com.endava.repository;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentDaoImpl implements StudentDao {

    List<Student> listOfStudents;

    public StudentDaoImpl() {
        listOfStudents = new ArrayList<Student>();
        Student student1 = new Student("Anja", 123200007);
        Student student2 = new Student("Bojana", 143200100);
        Student student3 = new Student("Jovan", 103202005);
        Student student4 = new Student("Jovan", 104562343);
        listOfStudents.add(student1);
        listOfStudents.add(student2);
        listOfStudents.add(student3);
        listOfStudents.add(student4);
    }

    @Override
    public List<Student> findAllStudents() {
        return listOfStudents;
    }

    @Override
    public Student findStudentById(int id) {
        for (Student student : listOfStudents) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    @Override
    public boolean insertStudent(Student newStudent) {
        for (Student student : listOfStudents) {
            if (student.getId() == newStudent.getId()) {
                return false;
            }
        }
        listOfStudents.add(newStudent);
        return true;
    }

}
