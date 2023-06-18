package pl.ds360.cudanawidelcubackendrest.exceptions;


import pl.ds360.cudanawidelcubackendrest.exceptions.ErrorMessage;
import pl.ds360.cudanawidelcubackendrest.exceptions.RecipeNotFoundException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class MyExceptionMapper implements ExceptionMapper<RecipeNotFoundException> {

    @Override
    public Response toResponse(RecipeNotFoundException ex) {
        ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), 500);
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(errorMessage)
                .build();
    }
}
