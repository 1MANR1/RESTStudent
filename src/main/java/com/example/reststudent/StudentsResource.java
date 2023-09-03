package com.example.reststudent;


import com.example.reststudent.Student.Student;
import jakarta.ws.rs.*;

import java.util.ArrayList;
import java.util.List;


@Path("/students")
public class StudentsResource {

    @GET
    @Produces("text/plain")
    public String students() {

        List<Student> students = Student.findAll();

        String data = "\n";
        for (Student s: students) {
            data += s.toString();
        }
        return data;
    } /* http://localhost:8080/RESTStudent-1.0-SNAPSHOT/api/students */


    @Path("/{id}")
    @GET
    public String detail(@PathParam("id") long id) {

        List<Student> students = Student.findAll();

        for (Student s: students) {
            if (id == s.getId()) {
                return s.toString();
            }
        }
        return "does not exist";
    }

    @Path("/create")
    @POST
    @Produces("text/plain")
    public String create(Student s) {

        List<Student> students = Student.findAll();

//        Student new_st = new Student(s.name, s.email);
//        students.add(new_st);
        students.add(s);
        Student.increment();

        String data = "\n";
        for (Student mySt : students) {
            data += mySt.toString();
        }
        return data;
    }
    /* http://localhost:8080/RESTStudent-1.0-SNAPSHOT/api/students/create */


    @Path("/{id}")
    @PUT
    public String update(@PathParam("id") long id, Student student) {


        List<Student> students = Student.findAll();

        for (Student updateUser: students) {
            if (student.getId() == updateUser.getId()) {
                students.remove(updateUser);
                students.add(student);
                return "true\n" + student.toString();
            }
        }
        return "didn't find";
    }


    @Path("/{id}")
    @DELETE
    public String delete(@PathParam("id") Long id){


        List<Student> students = Student.findAll();

        for (Student s: students) {
            if(s.getId() == id){
                students.remove(s);
                return s.toString() + "\n ****has benn deleted";
            }
        }
        return "id doesn't exist";
    }
}
