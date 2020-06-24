package org.example.rest;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/test")
@RequestScoped
public class TestResource {

    @Inject TestBean testBean;
    @GET
    public String test() {
        return testBean.test();
    }
}
