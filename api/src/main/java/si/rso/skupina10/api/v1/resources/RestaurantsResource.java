package si.rso.skupina10.api.v1.resources;

import si.rso.skupina10.dtos.RestaurantDto;
import si.rso.skupina10.services.RestaurantsBean;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.logging.Logger;


@ApplicationScoped
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("restaurants")
public class RestaurantsResource {

    private Logger log = Logger.getLogger(RestaurantsResource.class.getName());

    @Inject
    private RestaurantsBean restaurantsBean;

    @GET
    public Response getRestaurants() {
        List<RestaurantDto> restaurants = restaurantsBean.getRestaurants();

        return Response.status(Response.Status.OK).entity(restaurants).build();
    }
}
