package si.rso.skupina10.api.v1.resources;

import org.eclipse.microprofile.metrics.annotation.Metered;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import si.rso.skupina10.dtos.MealDto;
import si.rso.skupina10.dtos.RestaurantDto;
import si.rso.skupina10.services.RestaurantsBean;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.List;
import java.util.logging.Logger;


@ApplicationScoped
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/restaurants")
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
    @Metered(name = "restaurant_get_all_meter")
    public Response getRestaurants() {
        List<RestaurantDto> restaurants = restaurantsBean.getRestaurants(uriInfo);

        return Response.status(Response.Status.OK).entity(restaurants).build();
    }

    @GET
    @Path("{id}")
    @Operation(description = "Get info about restaurant with id.", summary = "Restaurant info")
    @APIResponses({
            @APIResponse(responseCode = "200", description = "Restaurant info",
                    content = @Content(schema = @Schema(implementation = RestaurantDto.class))
            ), @APIResponse(responseCode = "404", description = "Restaurant not found")
    })
    @Metered(name = "restaurant_get_by_id_meter")
    public Response getRestaurantById(@PathParam("id") Integer id) {
        RestaurantDto restaurantDto = restaurantsBean.getRestaurant(id);
        if (restaurantDto != null) {
            return Response.ok(restaurantDto).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @Path("{id}/meals")
    @Operation(description = "Get meals of restaurant with id.", summary = "Restaurant meals")
    @APIResponses({
            @APIResponse(responseCode = "200", description = "Restaurant meals",
                    content = @Content(schema = @Schema(implementation = MealDto.class, type = SchemaType.ARRAY))
            ), @APIResponse(responseCode = "404", description = "Not found")
    })
    @Metered(name = "meals_get_all_by_restaurant_id_meter")
    public Response getRestaurantMeals(@PathParam("id") Integer id) {
        RestaurantDto restaurantDto = restaurantsBean.getRestaurant(id);
        if (restaurantDto != null) {
            List<MealDto> mealDtos = restaurantDto.getListOfMealDtos();
            return Response.ok(mealDtos).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    @Operation(description = "Add new restaurant", summary = "Add new restaurant")
    @APIResponses({
            @APIResponse(responseCode = "201", description = "New restaurant added", content = @Content(schema = @Schema(implementation = RestaurantDto.class))),
            @APIResponse(responseCode = "400", description = "Error adding new restaurant")
    })
    @Metered(name = "restaurant_add_new_meter")
    public Response addNewRestaurant(@RequestBody(
            description = "Restaurant DTO object",
            required = true,
            content = @Content(
                    schema = @Schema(implementation = RestaurantDto.class)
            )
    ) RestaurantDto restaurantDto) {
        RestaurantDto newRestaurant = restaurantsBean.addRestaurant(restaurantDto);
        if (newRestaurant == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.status(Response.Status.CREATED).build();
    }

    @DELETE
    @Path("{id}")
    @Operation(description = "Delete restaurant", summary = "Delete restaurant by id")
    @APIResponses({
            @APIResponse(responseCode = "204", description = "Restaurant deleted"),
            @APIResponse(responseCode = "400", description = "Error deleting restaurant")
    })
    @Metered(name = "restaurant_delete_meter")
    public Response deleteRestaurant(@PathParam("id") Integer id) {
        boolean deleted = restaurantsBean.removeRestaurant(id);
        if(deleted) {
            return Response.status(Response.Status.NO_CONTENT).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
}
