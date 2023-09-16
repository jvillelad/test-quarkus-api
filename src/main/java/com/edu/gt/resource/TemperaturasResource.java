package com.edu.gt.resource;


import com.edu.gt.dto.Temperatura;
import com.edu.gt.service.impl.TemperaturaService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jboss.logging.annotations.Pos;

import java.util.List;

@Path("/temperaturas")
public class TemperaturasResource {

    @Inject
    private TemperaturaService temperaturas;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Temperatura medicion() {
        return new Temperatura("Guatemala", 25, 32);
    }

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Temperatura> list() {
        return temperaturas.obtenerTemperaturas();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Temperatura guardar(Temperatura temp) {
        System.out.println("Init guardar");
        temperaturas.addTemperatura(temp);
        return temp;
    }

    @GET
    @Path("/maxima")
    @Produces(MediaType.TEXT_PLAIN)
    public Response maxima() {
        if (temperaturas.isEmpty())
            return Response.status(400).entity("ho hay temperatura").build();

        int temperaturaMaxiam = temperaturas.maxima();
        return Response.ok(Integer.toString(temperaturaMaxiam)).build();
    }

    @DELETE
    @Path("/eliminar")
    @Produces(MediaType.APPLICATION_JSON)
    public Response eliminarTodasLasTemperaturas() {
        if (temperaturas.isEmpty()) {
            return Response.status(400).entity("No hay un listado de temperaturas").build();
        }

        temperaturas.eliminarTodasLasTemperaturas();
        return Response.ok("Lista de temperaturas eliminada").build();
    }


}

