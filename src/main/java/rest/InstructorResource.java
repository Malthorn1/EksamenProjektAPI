/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.CoursesDTO;
import dtos.InstructorDTO;
import errorhandling.NotFoundException;
import facades.InstructorFacade;
import facades.courseFacade;
import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import utils.EMF_Creator;


@Path("instructor")
public class InstructorResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory(
            "pu",
            "jdbc:mysql://localhost:3307/dat3Eksamen",
            "dev",
            "ax2",
            EMF_Creator.Strategy.CREATE);
    private static final InstructorFacade FACADE = InstructorFacade.getFacadeExample(EMF).getFacadeExample(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
        return "{\"msg\":\"Hello World\"}";
    }

    @POST
    @Path("add")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public String addInstructor(String Instrutor) {
        InstructorDTO IDTO = GSON.fromJson(Instrutor, InstructorDTO.class);
        InstructorDTO InstructorDTO = FACADE.addInstructor(IDTO);
        return GSON.toJson(InstructorDTO);

    }
    @PUT 
    @Path("edit/{value}")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response editInstructor(@PathParam("value") int value, String instructor) throws NotFoundException{
        System.out.println(instructor);
        InstructorDTO IDTO = GSON.fromJson(instructor, InstructorDTO.class);
       
        
        InstructorDTO responseDTO = FACADE.editInstructor(IDTO.getName(), value);
        return Response.ok(responseDTO).build();
    }
    
    @Path("delete")
    @RolesAllowed({"admin1"})
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public String deletePerson(String Instructor) throws NotFoundException {
        InstructorDTO p = GSON.fromJson(Instructor, InstructorDTO.class);
        System.out.println(p.getId());
        InstructorDTO result = FACADE.deleteInstructor(p.getId());
        return GSON.toJson(result);
    }
    
    
    
    
}
