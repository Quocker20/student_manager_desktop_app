package com.student.project;

import java.util.Date;

/**
 *
 * @author quoca
 */

public class Student {

    private int id;
    private String name;
    private String email;
    private Date dateOfBirth;

    public Student(int id, String name, String email, Date dateOfBirth) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + ", email=" + email + ", dateOfBirth=" + dateOfBirth + '}';
    }

}
