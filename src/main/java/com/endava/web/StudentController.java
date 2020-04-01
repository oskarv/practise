package com.endava.web;

import com.endava.repository.Student;
import com.endava.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(value = "/id", method = RequestMethod.GET, produces = "application/json")
    public Student findStudentById(@RequestParam int id) {
        if (studentService.findStudentById(id) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student with id=" + id + " doesn't exist.");
        }
        return studentService.findStudentById(id);
    }

    @RequestMapping(value = "/name", method = RequestMethod.GET, produces = "application/json")
    public List<Student> findStudentsByName(@RequestParam String name) {
        return studentService.findStudentsByName(name);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public void insertStudent(@RequestBody Student student) {
        if (!studentService.insertStudent(student)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Student with id=" + student.getId() + " already exists.");
        }
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
    public List<Student> findAllStudents() {
        return studentService.findAllStudents();
    }
}