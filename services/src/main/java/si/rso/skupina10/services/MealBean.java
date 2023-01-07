package si.rso.skupina10.services;

import si.rso.skupina10.converters.MealConverter;
import si.rso.skupina10.converters.RestaurantConverter;
import si.rso.skupina10.dtos.MealDto;
import si.rso.skupina10.dtos.RestaurantDto;
import si.rso.skupina10.entities.MealEntity;
import si.rso.skupina10.entities.RestaurantEntity;

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
            RestaurantEntity restaurantEntity = RestaurantConverter.toEntity(r);
            MealEntity entity = MealConverter.toEntity(m);
            entity.setRestaurant(restaurantEntity);
            beginTx();
            em.persist(entity);
            em.flush();
            commitTx();
            return MealConverter.toDto(entity);
        } catch (Exception e) {
            rollbackTx();
            log.severe("Error addMeal: " + e);
            return null;
        }
    }

    @Transactional
    public boolean removeMeal(Integer mealId) {
        MealEntity meal = em.find(MealEntity.class, mealId);

        if(meal!=null){
            try{
                beginTx();
                em.remove(meal);
                em.flush();
                commitTx();
                return true;
            } catch (Exception e){
                rollbackTx();
            }

        }
        return false;
    }

    @Transactional
    public MealEntity updateMeal(Integer mealId){
        return null;
    }

    private void beginTx() {
        if (!em.getTransaction().isActive()) {
            em.getTransaction().begin();
        }
    }

    private void commitTx() {
        if (em.getTransaction().isActive()) {
            em.getTransaction().commit();
        }
    }

    private void rollbackTx() {
        if (em.getTransaction().isActive()) {
            em.getTransaction().rollback();
        }
    }
}
