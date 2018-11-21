package itech.resources;

import itech.db.DbRequests;
import itech.helloWorldService.Gender;
import itech.helloWorldService.HelloWorld;
import itech.hotfix.Atmospherics;
import itech.hotfix.Temp;

import org.glassfish.jersey.client.JerseyClient;

import javax.annotation.PostConstruct;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("hotFix")
public class HotFixResource extends JerseyClient {

    @GET
    @Path("/temp")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTemp() {
    	return Response.ok().build();
    }
    
    @POST
    @Path("/setTemp")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response setTemp(Atmospherics a) {
    	
    	DbRequests.insertAtmospheric(a);
    	
    	return null;
    }

}
