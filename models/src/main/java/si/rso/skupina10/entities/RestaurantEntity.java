package si.rso.skupina10.entities;

import javax.persistence.*;
import java.util.List;
import javax.json.bind.annotation.JsonbTransient;


@Entity(name = "restaurant")
@NamedQueries(value = {
        @NamedQuery(name = "Restaurant.getAll", query = "SELECT r FROM restaurant r")
})
public class RestaurantEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer restaurant_id;

    private String name;

    @JsonbTransient
    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<MealEntity> listOfMeals;


    public Integer getRestaurant_id() {
        return restaurant_id;
    }

    public void setRestaurant_id(Integer restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MealEntity> getListOfMeals() {
        return listOfMeals;
    }

    public void setListOfMeals(List<MealEntity> listOfMeals) {
        this.listOfMeals = listOfMeals;
    }
}
