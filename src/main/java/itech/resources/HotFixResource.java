package itech.resources;

import itech.helloWorldService.Gender;
import itech.helloWorldService.HelloWorld;
import itech.hotfix.Temp;

import org.glassfish.jersey.client.JerseyClient;

import javax.annotation.PostConstruct;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("helloWorld")
public class HotFixResource extends JerseyClient {

    @Path("/simpleTextString")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String helloWorldString() {
        String helloWorld = HelloWorld.helloWorldString();
        return helloWorld;
    }
    
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
    public Response setTemp(Temp t) {
    	
    	return null;
    }

}
