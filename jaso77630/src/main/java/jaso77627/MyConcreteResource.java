package jaso77627;

import jakarta.ws.rs.Path;

@Path("/example1")
public class MyConcreteResource extends MyAbstractResource<Response1, Request1> {

    @Override
    protected Response1 executeSub(final Request1 request) {

        final Response1 reponse = new Response1();
        reponse.status = "00";
        reponse.message = "";

        return reponse;
    }
}
