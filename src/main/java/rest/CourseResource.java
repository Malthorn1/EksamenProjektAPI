/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.CourseDTO;
import dtos.CoursesDTO;
import facades.courseFacade;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import utils.EMF_Creator;


@Path("course")
public class CourseResource {
    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory(
                "pu",
                "jdbc:mysql://localhost:3307/dat3Eksamen",
                "dev",
                "ax2",
                EMF_Creator.Strategy.CREATE);
    private static final courseFacade FACADE =  courseFacade.getFacadeExample(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
            
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
        return "{\"msg\":\"Hello World\"}";
    }
    
    
    @Path("courses")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getUniqueCourses() {
        List<CourseDTO> cDTO = FACADE.getUniqueCourses(); 
        
        
       return GSON.toJson(cDTO);

    }
    
}
