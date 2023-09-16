package com.edu.gt.resource;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

import java.util.Optional;

@Path("/HolaMundo")
public class TestResource {


    @GET
    @Produces (MediaType.TEXT_PLAIN)
    public String holaMundo(){
        return "Hola Mundo";
    }


    @GET
    @Path("/Saludar")
    @Produces (MediaType.TEXT_PLAIN)
    public String saludar(@QueryParam("mensaje") String mensaje){
        return Optional.ofNullable(mensaje)
                .map(n -> "> " + n)
                .orElse("No se que decir");
    }
}
