package si.rso.skupina10.graphql;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.kumuluz.ee.graphql.annotations.GraphQLClass;
import com.kumuluz.ee.graphql.classes.Filter;
import com.kumuluz.ee.graphql.classes.Pagination;
import com.kumuluz.ee.graphql.classes.Sort;
import com.kumuluz.ee.graphql.classes.PaginationWrapper;
import com.kumuluz.ee.graphql.utils.GraphQLUtils;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLQuery;
import si.rso.skupina10.dtos.RestaurantDto;
import si.rso.skupina10.services.RestaurantsBean;

@GraphQLClass
@ApplicationScoped
public class RestaurantQueries {

    @Inject
    private RestaurantsBean restaurantsBean;

    @GraphQLQuery
    public PaginationWrapper<RestaurantDto> getRestaurants(@GraphQLArgument(name = "page") Pagination pagination,
                                                           @GraphQLArgument(name = "sort") Sort sort,
                                                           @GraphQLArgument(name = "filter") Filter filter
    ) {
        return GraphQLUtils.process(restaurantsBean.getRestaurants(), pagination, sort, filter);
    }

    @GraphQLQuery
    public RestaurantDto getRestaurant(@GraphQLArgument(name="id") Integer id) {
        return restaurantsBean.getRestaurant(id);
    }
}
