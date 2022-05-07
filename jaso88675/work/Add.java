package com.example;
import java.math.BigDecimal;

import javax.ws.rs.core.Application;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("add")
public class Add {
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String add(@QueryParam("x") String ax, @QueryParam("y") String ay) {
    BigDecimal x = new BigDecimal(ax);
    BigDecimal y = new BigDecimal(ay);
    return x.add(y).toString();
  }

  public static void main(String[] args) {
    Add a = new Add();
    System.out.println(a.add(args[0], args[1]));
  }
}

