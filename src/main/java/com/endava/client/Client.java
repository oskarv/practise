package com.endava.client;

import com.endava.repository.Student;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

public class Client {

    public static void main(String[] args) {

        RestTemplate restTemplate = new RestTemplate();

        // find student with id
        Student student = restTemplate.getForObject("http://localhost:8080/student?id=123200007", Student.class);
        System.out.println(student);

        // insert student
        Student newStudent = new Student("Milos", 133200007);
        HttpEntity<Student> request = new HttpEntity<>(newStudent);
        ResponseEntity<Student> responseStudent = restTemplate.postForEntity("http://localhost:8080/student", request, Student.class);
        System.out.println(responseStudent.getStatusCode());

        try {
            // tries to insert same student again
            restTemplate.postForEntity("http://localhost:8080/student", request, Student.class);
        } catch (HttpClientErrorException.BadRequest e) {
            System.out.println(e.getMessage());
        }

        // find all students
        ResponseEntity<Student[]> responseEntity = restTemplate.getForEntity("http://localhost:8080/student/all", Student[].class);
        Student[] students = responseEntity.getBody();
        System.out.println(Arrays.toString(students));

        // find all students with same name
        ResponseEntity<Student[]> responseEntityNames = restTemplate.getForEntity("http://localhost:8080/student/name?name=Jovan", Student[].class);
        Student[] studentsWithSameName = responseEntityNames.getBody();
        System.out.println(Arrays.toString(studentsWithSameName));
    }
}
