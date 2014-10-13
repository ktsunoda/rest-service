package io.berkeley.rest.service;


import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@SuppressWarnings("UnusedDeclaration")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface RestService {

    @POST
    @Path("/models")
    public ModelObjectDetails createModelObject(ModelObjectDetails modelObjectDetails);


    @GET
    @Path("/models/{id}")
    public ModelObjectDetails getModelObject(@PathParam("id") String id);


    @POST
    @Path("/models/{id}")
    public ModelObjectDetails updateModelObject(@PathParam("id") String id,
                                                ModelObjectDetails modelObjectDetails);


    @DELETE
    @Path("/models/{id}")
    public void deleteModelObject(@PathParam("id") String id);
}
