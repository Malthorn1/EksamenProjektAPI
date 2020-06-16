/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.InstructorDTO;
import dtos.YogaClassDTO;
import errorhandling.NotFoundException;
import facades.InstructorFacade;
import facades.YogaClassFacade;
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


@Path("yoga")
public class YogaClassResource {
    
    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory(
            "pu",
            "jdbc:mysql://localhost:3307/dat3Eksamen",
            "dev",
            "ax2",
            EMF_Creator.Strategy.CREATE);
    private static final YogaClassFacade FACADE = YogaClassFacade.getFacadeExample(EMF).getFacadeExample(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
        return "{\"msg\":\"Hello World\"}";
    }

    @POST
    @RolesAllowed({"admin1"})
    @Path("add")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public String addYogaClass(String YogaClass) throws NotFoundException {
        YogaClassDTO YOGADTO = GSON.fromJson(YogaClass, YogaClassDTO.class);
        YogaClassDTO YogaClassDTO = FACADE.addYogaClass(YOGADTO);
        return GSON.toJson(YogaClassDTO);

    }
    
    
    @PUT
    @Path("edit/{value}")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public String editYogaClass(@PathParam("value") int value, String YogaClass) throws NotFoundException{
        System.out.println(YogaClass);
        YogaClassDTO YOGADTO = GSON.fromJson(YogaClass, YogaClassDTO.class);
       
        
        YogaClassDTO responseDTO = FACADE.editYogaClass(YOGADTO, value);
        return GSON.toJson(responseDTO.getId()+" Has been Updated");
    }
    
//    @POST
//    @Path("delete")
//    @Produces({MediaType.APPLICATION_JSON})
//    @Consumes({MediaType.APPLICATION_JSON})
//    public String deleteYogaClass(String YogaClass) throws NotFoundException{
//        System.out.println(YogaClass);
//        YogaClassDTO YOGADTO = GSON.fromJson(YogaClass, YogaClassDTO.class);
//       
//        
//        YogaClassDTO responseDTO = FACADE.deleteYogaClass(YOGADTO);
//        return GSON.toJson(responseDTO.getId()+" Has been Updated");
//    }
//    
    
}
