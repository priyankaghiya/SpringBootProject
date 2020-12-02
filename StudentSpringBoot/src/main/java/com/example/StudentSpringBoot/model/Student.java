package com.example.StudentSpringBoot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student
{
    @Id
    int stdId;

    @Column(name="stdPass")
    String stdPass;

    @Column(name="stdName")
    String stdName;

    @Column(name="stdAge")
    int stdAge;

    public Student()
    {   }

    public Student(int stdId, String stdPass)
    {
        this.stdId = stdId;
        this.stdPass = stdPass;
    }

    public Student(int stdId, String stdPass, String stdName, int stdAge)
    {
        this.stdId = stdId;
        this.stdPass = stdPass;
        this.stdName = stdName;
        this.stdAge = stdAge;
    }

    public int getStdId() {
        return stdId;
    }

    public void setStdId(int stdId) {
        this.stdId = stdId;
    }

    public String getStdPass() {
        return stdPass;
    }

    public void setStdPass(String stdPass) {
        this.stdPass = stdPass;
    }

    public String getStdName() {
        return stdName;
    }

    public void setStdName(String stdName) {
        this.stdName = stdName;
    }

    public int getStdAge() {
        return stdAge;
    }

    public void setStdAge(int stdAge) {
        this.stdAge = stdAge;
    }
}
