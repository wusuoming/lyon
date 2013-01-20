package net.slowvic.webservice;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 * RESTful风格的WebService，本接口上的注解，对于纯客户端调用必可不少
 * @author xus
 * <p>
 */
@Path("/")
public interface RestHelloWorld {
    @GET
    @POST
    // GET、POST等HTTP method必须有至少一个
    @Path("/{text}")
    String sayHi(@PathParam("text") String text);
}
