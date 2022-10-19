package si.rso.skupina10.services;

import si.rso.skupina10.entities.MealEntity;
import si.rso.skupina10.entities.RestaurantEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;
import java.util.logging.Logger;

@ApplicationScoped
public class RestaurantsBean {


    @PersistenceContext(unitName = "restaurant-catalog-jpa")
    private EntityManager em;


    private static final Logger log = Logger.getLogger(RestaurantsBean.class.getName());


    public List<RestaurantEntity> getRestaurants() {
        try {
            Query q = em.createNamedQuery("Restaurant.getAll");
            return (List<RestaurantEntity>) q.getResultList();
        } catch (Exception e) {
            log.severe("Error at getRestaurants: " + e);
            return null;
        }
    }

    public RestaurantEntity getRestaurant(Integer restaurant_id) {
        try {
            Query q = em.createNamedQuery("Restaurant.getRestaurantById");
            q.setParameter("restaurant_id", restaurant_id);
            return (RestaurantEntity) q.getSingleResult();
        } catch (Exception e) {
            log.severe("Error at getRestaurant by id: " + e);
            return null;
        }
    }


    @Transactional
    public RestaurantEntity addRestaurant(RestaurantEntity r) {
        try {
            String name = r.getName();
            if (name.isBlank()) {
                log.info("Cannot add restaurant without a name.");
                return null;
            }
            em.persist(r);
            em.flush();
            log.info("Restaurant " + name + " was added.");
            return r;
        } catch (Exception e) {
            log.severe("Error at addRestaurant: " + e);
            return null;
        }
    }

    @Transactional
    public boolean removeRestaurant(Integer restaurant_id) {
        RestaurantEntity restaurant = getRestaurant(restaurant_id);

        if (restaurant != null) {
            //TODO see if we need to remove its meals (cascade = CascadeType.ALL)
            em.remove(restaurant);
            em.flush();
            return true;
        }
        return false;
    }
}
