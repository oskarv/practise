package com.endava.repository;

import com.endava.exception.StudentBadRequestDuplicatedId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentDaoImpl implements StudentDao {

    private StudentRepository studentRepository;

    @Autowired
    public StudentDaoImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student findStudentById(int id) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()) {
            return student.get();
        }
        return null;
    }

    @Override
    public List<Student> findStudentsByName(String name) {
        return studentRepository.findStudentsByName(name);
    }

    @Override
    public void insertStudent(Student newStudent) {
        if (!studentRepository.existsById(newStudent.getId())) {
            studentRepository.save(newStudent);
        } else {
            throw new StudentBadRequestDuplicatedId();
        }
    }

    @Override
    public boolean deleteStudent(int id) {
        studentRepository.deleteById(id);
        return true;
    }
}
