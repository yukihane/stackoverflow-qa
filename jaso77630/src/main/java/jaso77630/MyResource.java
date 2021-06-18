package jaso77630;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import lombok.Data;

@Path("API_01")
public class MyResource {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response execute(final RequestObj request) throws Exception {

        final ResponseObj response = new ResponseObj();
        response.status = "999";
        response.message = "エラー";

        return Response.status(Status.BAD_GATEWAY).entity(response).build();
    }

    public static class RequestObj {
    }

    @Data
    public static class ResponseObj {
        private String status;
        private String message;
    }
}
