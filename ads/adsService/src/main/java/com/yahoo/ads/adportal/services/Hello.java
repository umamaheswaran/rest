package com.yahoo.ads.adportal.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// The Java class will be hosted at the URI path "/myresource"
@Path("/myresource")
@Component
@Scope("request")

public class Hello {

    // The Java method will process HTTP GET requests
    @GET
    // The Java method will produce content identified by the MIME Media
    // type "text/plain"
    @Produces("text/plain")
    public String getIt() {
    	
        return "Hello! How are you?";
    }
}
