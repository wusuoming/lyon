package net.slowvic.webservice.client;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 * RESTful风格的WebService
 * @author xus
 * <p>
 */
@Path("/")
public interface RestHelloWorldClient {
    @GET
    @POST
    // GET、POST等HTTP method必须有至少一个
    @Path("/{text}")
    String sayHi(@PathParam("text") String text);
}
