package net.slowvic.webservice;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/")
public class RestHelloWorldImpl implements RestHelloWorld {
    @GET
    @POST
    // GET、POST等HTTP method必须有至少一个
    @Path("/{text}")
    public String sayHi(@PathParam("text") String text) {
        System.out.println("sayHi called");
        return "Hello," + text;
    }

}
