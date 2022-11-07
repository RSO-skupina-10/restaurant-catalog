package si.rso.skupina10.services;

import si.rso.skupina10.converters.MealConverter;
import si.rso.skupina10.dtos.MealDto;
import si.rso.skupina10.dtos.RestaurantDto;
import si.rso.skupina10.entities.MealEntity;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@ApplicationScoped
public class MealBean {

    @PersistenceContext(unitName = "restaurant-catalog-jpa")
    private EntityManager em;

    @Inject
    private RestaurantsBean restaurantsBean;

    private static final Logger log = Logger.getLogger(MealBean.class.getName());

    @PostConstruct
    private void init() {
        log.info("Initialization of the " + MealBean.class.getSimpleName());
    }

    @PreDestroy
    private void destroy() {
        log.info("Destroy " + MealBean.class.getSimpleName());
    }

    public List<MealDto> getMeals() {
        try {
            Query q = em.createNamedQuery("Meal.getAll");
            List<MealEntity> resultList = (List<MealEntity>) q.getResultList();
            return resultList.stream().map(MealConverter::toDto).collect(Collectors.toList());
        } catch (Exception e) {
            log.severe("Error at getMeals: " + e);
            return null;
        }
    }

    public MealDto getMeal(Integer mealId) {
        try {
            Query q = em.createNamedQuery("Meal.getMealById");
            q.setParameter("mealId", mealId);
            return MealConverter.toDto((MealEntity) q.getSingleResult());
        } catch (Exception e) {
            log.severe("Error at getMeal by id: " + e);
            return null;
        }
    }

    public List<MealDto> getRestaurantMeals(Integer restaurantId) {
        try {
            Query q = em.createNamedQuery("Meal.getMealsOfRestaurant");
            q.setParameter("restaurantId", restaurantId);
            return (List<MealDto>) q.getResultList();
        } catch (Exception e) {
            log.severe("Error getting restaurant's meals.");
            return null;
        }
    }

    @Transactional
    public MealDto addMeal(MealDto m) {
        try {
            RestaurantDto r = restaurantsBean.getRestaurant(m.getRestaurantId());
            MealEntity entity = MealConverter.toEntity(m);
            if(r != null) {
                em.persist(entity);
                em.flush();
                return MealConverter.toDto(entity);
            } else {
                log.info("Cannot add meal without a restaurant.");
                return null;
            }
        } catch (Exception e) {
            log.severe("Error addMeal: " + e);
            return null;
        }
    }

    @Transactional
    public boolean removeMeal(Integer mealId) {
        MealEntity meal = em.find(MealEntity.class, mealId);

        if(meal!=null){
            em.remove(meal);
            em.flush();
            return true;
        }
        return false;
    }

    @Transactional
    public MealEntity updateMeal(Integer mealId){
        return null;
    }
}
