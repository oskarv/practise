package com.endava.repository;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Phone {
    @Id
    private int id;
    private int number;
    private int studentId;

    public Phone() {
    }

    public Phone(int id, int number, int studentId) {
        this.id = id;
        this.number = number;
        this.studentId = studentId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "id=" + id +
                ", number=" + number +
                ", studentId=" + studentId +
                '}';
    }
}
