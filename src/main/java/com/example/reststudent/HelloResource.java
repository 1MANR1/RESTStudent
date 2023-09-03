package com.example.reststudent;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

@Path("/hello-world")
public class HelloResource {
    @GET
    @Produces("text/plain")
    public String hello() {
        return "Hello, World!!!!!";
    } /* http://localhost:8080/RESTStudent-1.0-SNAPSHOT/api/hello-world */

}