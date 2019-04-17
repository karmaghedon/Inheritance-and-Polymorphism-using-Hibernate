/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.PersonDao;
import dao.StudentDao;
import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import methods.ProcessResponse;
import org.hibernate.Transaction;
import pojo.Person;
import pojo.Student;

/**
 *
 * @author nicolaenastas
 */
@Stateless()
@Path("")
@Consumes(MediaType.APPLICATION_JSON)
public class PersonWebService {

    @Path("insert/Student")
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response createStudent(String json) {
        ProcessResponse process = new ProcessResponse();

        // int response = process.createPerson(json);
        return Response.ok(process.createPerson(json)).build();
    }

    @Path("insert/Employee")
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response createEmployee(String json) {
        ProcessResponse process = new ProcessResponse();

        // int response = process.createPerson(json);
        return Response.ok(process.createPerson(json)).build();
    }

    @Path("listAll")
    @GET
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public String listAll() {
        ProcessResponse process = new ProcessResponse();
        String response = process.processResponse();
        return response;
    }

    @Path("listAllFilter")
    @GET
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public String listAllFilter() {
        ProcessResponse process = new ProcessResponse();
        String response = process.processResponseFilter();
        return response;
    }

    @Path("findById/{id}")
    @GET
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public String findById(@PathParam("id") int id) {
        ProcessResponse process = new ProcessResponse();
        String response = process.findById(id);
        return response;
    }

    @Path("delete/{id}")
    @DELETE
    public void delete(@PathParam("id") Integer id) {
        ProcessResponse process = new ProcessResponse();
        process.deltePerson(id);
    }

}
