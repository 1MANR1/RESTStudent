package com.example.reststudent.Student;

import java.util.ArrayList;
import java.util.List;

public class Student {
    public static int count_students;
    public static List<Student> students = new ArrayList<Student>();
    public String name;
    public long id;
    public String email;

    public static List < Student > findAll() {
        Student s1 = new Student("Iman", "iman@gmail.com");
        Student.increment();
        Student s2 = new Student("Sam", "sam@gmail.com");
        Student.increment();
        Student s3 = new Student("Joe", "joe@gmail.com");
        Student.increment();

        students.add(s1);
        students.add(s2);
        students.add(s3);
        return students;
    }
    public static void increment(){
        count_students += 1;
    }
    public static void decrement(){
        count_students -= 1;
    }

    public static void show_students(){
        for (Student s: students) {
            s.toString();
        }
    }

    public Student(String name, String email) {
        this.name = name;
        this.id = count_students+1;
        this.email = email;
    }

    public Student(String name, long id, String email) {
        this.name = name;
        this.id = id;
        this.email = email;
    }

    public void setId() {
        this.id = count_students + 1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", email='" + email + '\'' +
                '}';
    }


}
