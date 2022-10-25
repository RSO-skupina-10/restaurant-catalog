package si.rso.skupina10.services;

import si.rso.skupina10.entities.MealEntity;
import si.rso.skupina10.entities.RestaurantEntity;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;
import java.util.logging.Logger;

@ApplicationScoped
public class MealBean {

    @PersistenceContext(unitName = "restaurant-catalog-jpa")
    private EntityManager em;

    private static final Logger log = Logger.getLogger(MealBean.class.getName());

    @PostConstruct
    private void init() {
        log.info("Initialization of the " + MealBean.class.getSimpleName());
    }

    @PreDestroy
    private void destroy() {
        log.info("Destroy " + MealBean.class.getSimpleName());
    }

    public List<MealEntity> getMeals() {
        try {
            Query q = em.createNamedQuery("Meal.getAll");
            return (List<MealEntity>) q.getResultList();
        } catch (Exception e) {
            log.severe("Error at getMeals: " + e);
            return null;
        }
    }

    public MealEntity getMeal(Integer mealId) {
        try {
            Query q = em.createNamedQuery("Meal.getMealById");
            q.setParameter("mealId", mealId);
            return (MealEntity) q.getSingleResult();
        } catch (Exception e) {
            log.severe("Error at getMeal by id: " + e);
            return null;
        }
    }

    @Transactional
    public MealEntity addMeal(MealEntity m) {
        try {
            RestaurantEntity r = m.getRestaurant();
            if(r != null) {
                em.persist(r);
                em.flush();
                return m;
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
    public MealEntity updateMeal(Integer mealId){
        return null;
    }
}
