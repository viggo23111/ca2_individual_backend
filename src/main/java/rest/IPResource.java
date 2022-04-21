package rest;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.IPDTO;
import dtos.JokeDTO;
import facades.IPFacade;
import facades.JokeFacade;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.io.IOException;

/**
 * REST Web Service
 *
 * @author lam
 */
@Path("ip")
public class IPResource {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @Context
    private UriInfo context;

   
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    //@RolesAllowed("user")
    public Response getIP() throws IOException {
        IPFacade ipf = new IPFacade();
        IPDTO ipDTO = ipf.getIP();
        return Response.ok().entity(GSON.toJson(ipDTO)).build();
    }

    @GET
    @Path("/{ip}")
    //@RolesAllowed("admin")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getIPInfo(@PathParam("ip") String ip) throws IOException {
        IPFacade ipf = new IPFacade();
        IPDTO ipDTO = ipf.getIPInfo(ip);
        System.out.println(ipDTO.getCity());
        IPDTO ipDTO2 = ipf.getIPInfo("87.48.15.41");
        System.out.println(ipDTO2.getIp());
        System.out.println(ipDTO2.getCity());
        return Response.ok().entity(GSON.toJson(ipDTO)).build();
    }

   
}
