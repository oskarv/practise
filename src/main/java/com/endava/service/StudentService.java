package com.endava.service;

import com.endava.repository.Student;
import com.endava.repository.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private StudentDao studentDao;

    @Autowired
    public StudentService(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public Student findStudentById(int id) {
        return studentDao.findStudentById(id);
    }


    public boolean insertStudent(Student student) {
        return studentDao.insertStudent(student);
    }

    public List<Student> findAllStudents() {
        return studentDao.findAllStudents();
    }
}
