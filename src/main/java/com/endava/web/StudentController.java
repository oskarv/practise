package com.endava.web;

import com.endava.exception.StudentBadRequestDuplicatedId;
import com.endava.exception.StudentBadRequestInvalidInput;
import com.endava.exception.StudentNotFoundException;
import com.endava.repository.Student;
import com.endava.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET, produces = "application/json")
    public Student findStudentById(@PathVariable int id) {
        if (studentService.findStudentById(id) == null) {
            throw new StudentNotFoundException();
        }
        return studentService.findStudentById(id);
    }

    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET, produces = "application/json")
    public List<Student> findStudentsByName(@PathVariable String name) {
        return studentService.findStudentsByName(name);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public void insertStudent(@RequestBody Student newStudent) {
        if (newStudent.getName() == null || newStudent.getId() < 0) {
            throw new StudentBadRequestInvalidInput();
        } else {
            try {
                studentService.insertStudent(newStudent);
            } catch (DuplicateKeyException e) {
                throw new StudentBadRequestDuplicatedId();
            }
        }
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteStudent(@RequestParam int id) {
        if (id < 0) {
            throw new StudentBadRequestInvalidInput();
        }
        boolean result = studentService.deleteStudent(id);
        if (!result) {
            throw new StudentNotFoundException();
        }
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
    public List<Student> findAllStudents() {
        return studentService.findAllStudents();
    }
}
