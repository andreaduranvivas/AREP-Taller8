package edu.arep.controller;

import edu.arep.service.StreamService;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/secured/stream")
public class StreamController {

    @Inject
    StreamService service;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTweets(){
        System.out.println("returning last posts");
        return Response.ok(service.getLastPosts()).build();
    }
}
