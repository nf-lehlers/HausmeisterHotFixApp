package itech.client;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Produces(MediaType.TEXT_PLAIN)
@Path("client")
public class HelloWorldClient {

    private Client client;
    public HelloWorldClient(Client client) { this.client = client; }

    @GET
    @Path("helloWorldText")
    public Response consumeHelloWorld() {

        WebTarget helloWorld = client.target("http://localhost:18181")
                .path("helloWorld").path("simpleTextString");
        Invocation.Builder invocationBuilder =
                helloWorld.request(MediaType.TEXT_PLAIN);
        Response response = invocationBuilder.get();
        System.out.println("Das ist der Response-Status..." + response.getStatus());
        return response;
    }
}
