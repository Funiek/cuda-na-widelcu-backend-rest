package pl.ds360.cudanawidelcubackendrest.filters;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
@Provider
public class MyResponseFilter implements ContainerResponseFilter {
    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext
            responseContext) throws IOException {

        responseContext.getHeaders().add("mojNaglowek", "rsi test");
        System.out.println("Response headers: " + responseContext.getHeaders());
    }

}
