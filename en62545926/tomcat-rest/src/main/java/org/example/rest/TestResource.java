package org.example.rest;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/test")
@Stateless
public class TestResource {

    @Inject TestBean testBean;
    @GET
    public String test() {
        return testBean.test();
    }
}
