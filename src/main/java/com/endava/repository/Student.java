package com.endava.repository;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "student")
public class Student {

    private String name;
    @Id
    private int id;
    @OneToMany(mappedBy = "studentId")
    private Set<Phone> studentPhoneNumbers = new HashSet<Phone>(0);

    public Student() {
        // no arguments constructor used by jackson
    }

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public Student(String name, int id, Set<Phone> studentPhoneNumbers) {
        this.name = name;
        this.id = id;
        this.studentPhoneNumbers = studentPhoneNumbers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Phone> getStudentPhoneNumbers() {
        return studentPhoneNumbers;
    }

    public void setStudentPhoneNumbers(Set<Phone> studentPhoneNumbers) {
        this.studentPhoneNumbers = studentPhoneNumbers;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", studentPhoneNumbers=" + studentPhoneNumbers +
                '}';
    }
}
