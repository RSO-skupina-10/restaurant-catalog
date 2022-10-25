package si.rso.skupina10.services;

import com.kumuluz.ee.rest.beans.QueryParameters;
import com.kumuluz.ee.rest.utils.JPAUtils;
import si.rso.skupina10.converters.RestaurantConverter;
import si.rso.skupina10.dtos.RestaurantDto;
import si.rso.skupina10.entities.RestaurantEntity;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.ws.rs.core.UriInfo;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@ApplicationScoped
public class RestaurantsBean {


    @PersistenceContext(unitName = "restaurant-catalog-jpa")
    private EntityManager em;


    private static final Logger log = Logger.getLogger(RestaurantsBean.class.getName());

    @PostConstruct
    private void init() {
        log.info("Initialization of the " + RestaurantsBean.class.getSimpleName());
    }

    @PreDestroy
    private void destroy() {
        log.info("Destroy " + RestaurantsBean.class.getSimpleName());
    }


    public List<RestaurantDto> getRestaurants() {
        try {
            Query q = em.createNamedQuery("Restaurant.getAll");
            List<RestaurantEntity> resultList = (List<RestaurantEntity>) q.getResultList();
            return resultList.stream().map(RestaurantConverter::toDto).collect(Collectors.toList());
        } catch (Exception e) {
            log.severe("Error at getRestaurants: " + e);
            return null;
        }
    }

    public List<RestaurantDto> getRestaurants(UriInfo uriInfo){
        QueryParameters queryParameters = QueryParameters.query(uriInfo.getRequestUri().getQuery()).defaultOffset(0)
                .build();

        return JPAUtils.queryEntities(em, RestaurantEntity.class, queryParameters).stream()
                .map(RestaurantConverter::toDto).collect(Collectors.toList());
    }

    public RestaurantDto getRestaurant(Integer restaurantId) {
        try {
            Query q = em.createNamedQuery("Restaurant.getRestaurantById");
            q.setParameter("restaurantId", restaurantId);
            return RestaurantConverter.toDto((RestaurantEntity) q.getSingleResult());
        } catch (Exception e) {
            log.severe("Error at getRestaurant by id: " + e);
            return null;
        }
    }


    @Transactional
    public RestaurantDto addRestaurant(RestaurantDto r) {
        try {
            String name = r.getName();
            if (name.isBlank()) {
                log.info("Cannot add restaurant without a name.");
                return null;
            }
            RestaurantEntity entity = RestaurantConverter.toEntity(r);
            em.persist(entity);
            em.flush();
            log.info("Restaurant " + name + " was added.");
            return RestaurantConverter.toDto(entity);
        } catch (Exception e) {
            log.severe("Error at addRestaurant: " + e);
            return null;
        }
    }

    @Transactional
    public boolean removeRestaurant(Integer restaurantId) {
        RestaurantEntity restaurant = em.find(RestaurantEntity.class, restaurantId);

        if (restaurant != null) {
            //TODO see if we need to remove its meals (cascade = CascadeType.ALL)
            em.remove(restaurant);
            em.flush();
            return true;
        }
        return false;
    }
}
