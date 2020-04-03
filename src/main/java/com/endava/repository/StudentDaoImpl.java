package com.endava.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentDaoImpl implements StudentDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public StudentDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Student> findAllStudents() {
        return jdbcTemplate.query("SELECT * FROM student", new BeanPropertyRowMapper(Student.class));
    }

    @Override
    public Student findStudentById(int id) {
        try {
            return (Student) jdbcTemplate.queryForObject("SELECT * FROM student where id = ? ",
                    new Object[]{id}, new BeanPropertyRowMapper(Student.class));
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Student> findStudentsByName(String name) {
        return jdbcTemplate.query("SELECT * FROM student WHERE name = ?", new Object[]{name}, new BeanPropertyRowMapper(Student.class));
    }

    @Override
    public boolean insertStudent(Student newStudent) {
        int result = jdbcTemplate.update("INSERT INTO student (id, name) VALUES (?, ?)",
                newStudent.getId(), newStudent.getName());
        return result == 1;
    }

    @Override
    public boolean deleteStudent(int id) {
        int result = jdbcTemplate.update("DELETE from student WHERE id = ? ", id);
        return result == 1;
    }
}
