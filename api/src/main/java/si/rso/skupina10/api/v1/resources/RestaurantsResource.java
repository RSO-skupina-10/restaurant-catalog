package si.rso.skupina10.api.v1.resources;

import com.kumuluz.ee.rest.beans.QueryParameters;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.headers.Header;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import si.rso.skupina10.dtos.RestaurantDto;
import si.rso.skupina10.services.RestaurantsBean;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.List;
import java.util.logging.Logger;


@ApplicationScoped
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("restaurants")
public class RestaurantsResource {

    private Logger log = Logger.getLogger(RestaurantsResource.class.getName());

    @Context
    protected UriInfo uriInfo;

    @Inject
    private RestaurantsBean restaurantsBean;

    @Operation(description = "Get all restaurants.", summary = "Get all restaurants")
    @APIResponses({
            @APIResponse(responseCode = "200",
                    description = "List of restaurants data",
                    content = @Content(schema = @Schema(implementation = RestaurantDto.class, type = SchemaType.ARRAY))
                    //,headers = {@Header(name = "X-Total-Count", description = "Number of objects in list")}
            )})
    @GET
    public Response getRestaurants() {
        List<RestaurantDto> restaurants = restaurantsBean.getRestaurants(uriInfo);

        return Response.status(Response.Status.OK).entity(restaurants).build();
    }
}
