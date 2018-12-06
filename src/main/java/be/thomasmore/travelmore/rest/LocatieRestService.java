package be.thomasmore.travelmore.rest;

import be.thomasmore.travelmore.domain.Locatie;
import be.thomasmore.travelmore.service.LocatieService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by freman on 18/10/2018.
 */
@Path("/locaties")
public class LocatieRestService {

    @Inject
    private LocatieService locatieService;

    @GET
    @Path("/getlocatie")
    @Produces({ MediaType.APPLICATION_JSON })
    public Locatie getLocatieById(@QueryParam("id") int id) {
        return locatieService.findById(id);
    }

    @POST
    @Path("/addlocatie")
    @Produces({ MediaType.APPLICATION_JSON })
    @Consumes({ MediaType.APPLICATION_JSON })
    public Response addLocatie(Locatie location) {
        if (null != locatieService.findById(location.getId())) {
            return Response
                    .status(Response.Status.NOT_MODIFIED)
                    .entity("location id should not be set.").build();
        }

        locatieService.insert(location);
        return Response.status(Response.Status.CREATED).entity(location).build();
    }

    @GET
    @Path("/getlocaties")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({ MediaType.APPLICATION_JSON })
    public List<Locatie> getLocaties()
    {
        return locatieService.findAllLocations();
    }


    @DELETE
    @Path("/deletelocatie")
    @Produces({ MediaType.APPLICATION_JSON })
    public void removeLocatieById(@QueryParam("id") int id)
    {
        locatieService.delete(id);
    }
}
