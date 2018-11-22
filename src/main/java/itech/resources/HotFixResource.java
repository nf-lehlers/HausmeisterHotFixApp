package itech.resources;

import itech.db.DbRequests;
import itech.helloWorldService.Gender;
import itech.helloWorldService.HelloWorld;
import itech.hotfix.Atmospherics;
import itech.hotfix.Temp;

import org.glassfish.jersey.client.JerseyClient;

import java.sql.Timestamp;
import java.util.List;

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
    	
    	return Response.ok().build();
    }
    
    @GET
    @Path("/getAllAtmospherics")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Atmospherics> getAtmosphericData() {
    	return DbRequests.loadAllAtmospherics();
    	
    }

    @GET
    @Path("/getAtmospherics/{date}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Atmospherics> getAtmosphericDataForDate(@PathParam("date") Timestamp date) {
    	return null; // TODO
    }
    
    @GET
    @Path("/getAtmospherics/hour")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Atmospherics> getAtmosphericDataForLastHour() {
    	return null; // TODO
    }
    
    @GET
    @Path("/getAtmospherics/today")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Atmospherics> getAtmosphericDataForToday() {
    	return DbRequests.loadAtmosphericsForToday(); // TODO testen
    }
    
    @GET
    @Path("/getAtmospherics/yesterday")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Atmospherics> getAtmosphericsDataForYersterday() {
    	return DbRequests.loadAtmosphericsForYesterday(); // TODO testen
    }
    
    @GET
    @Path("/getAtmospherics/week")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Atmospherics> getAtmosphericDataForLastWeek() {
    	return null; // TODO
    }
    
    @GET
    @Path("/getAtmospherics/month")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Atmospherics> getAtmosphericsDataForLastMonth() {
    	return DbRequests.loadAtmosphericsForLastMonth(); // TODO testen
    }
}