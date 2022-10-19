package si.rso.skupina10.entities;

import javax.persistence.*;

@Entity(name="meal")
@NamedQueries(value={
        @NamedQuery(name = "Meal.getAll", query = "SELECT m FROM meal m"),
        @NamedQuery(name="Meal.getMealById", query = "SELECT m FROM meal m WHERE m.meal_id = :meal_id"),
        @NamedQuery(name = "Meal.getMealsOfRestaurant", query = "SELECT m FROM meal m WHERE m.restaurant = :restaurant")
})
public class MealEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer meal_id;

    private String name;

    private Float price;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private RestaurantEntity restaurant;


    public Integer getMeal_id() {
        return meal_id;
    }

    public void setMeal_id(Integer meal_id) {
        this.meal_id = meal_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public RestaurantEntity getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(RestaurantEntity restaurant) {
        this.restaurant = restaurant;
    }
}
