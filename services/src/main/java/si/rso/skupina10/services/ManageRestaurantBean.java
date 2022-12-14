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
import javax.transaction.Transactional;
import java.util.logging.Logger;

@ApplicationScoped
public class ManageRestaurantBean {

    @Inject
    private RestaurantsBean restaurantsBean;

    @Inject
    private MealBean mealBean;

    private static final Logger log = Logger.getLogger(ManageRestaurantBean.class.getName());

    @PostConstruct
    private void init() {
        log.info("Init ManageRestaurantBean.");
    }

    @PreDestroy
    private void destroy() {
        log.info("Destroy ManageRestaurantBean.");
    }

    @Transactional
    public MealDto createMeal(MealDto mealDto){
        MealEntity meal = new MealEntity();
        meal.setIngredients(mealDto.getIngredients());
        meal.setName(mealDto.getName());
        meal.setPrice(meal.getPrice());

        RestaurantDto restaurant = restaurantsBean.getRestaurant(mealDto.getRestaurantId());
        RestaurantEntity r = RestaurantConverter.toEntity(restaurant);
        r.setRestaurantId(mealDto.getRestaurantId());
        meal.setRestaurant(r);

        return mealBean.addMeal(MealConverter.toDto(meal));
    }
}
