package si.rso.skupina10.entities;

import javax.persistence.*;
import java.util.ArrayList;

@Entity(name="meal")
@NamedQueries(value={
        @NamedQuery(name = "Meal.getAll", query = "SELECT m FROM meal m"),
        @NamedQuery(name="Meal.getMealById", query = "SELECT m FROM meal m WHERE m.mealId = :mealId"),
        @NamedQuery(name = "Meal.getMealsOfRestaurant", query = "SELECT m FROM meal m WHERE m.restaurant = :restaurant")
})
public class MealEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer mealId;

    private String name;

    private Float price;

    @ElementCollection
    private ArrayList<String> ingredients;

    @ManyToOne
    @JoinColumn(name = "restaurantId")
    private RestaurantEntity restaurant;


    public Integer getMealId() {
        return mealId;
    }

    public void setMealId(Integer mealId) {
        this.mealId = mealId;
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

    public ArrayList<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<String> ingredients) {
        this.ingredients = ingredients;
    }
}
