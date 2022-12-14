package si.rso.skupina10.entities;

import javax.persistence.*;
import java.util.List;
import javax.json.bind.annotation.JsonbTransient;


@Entity(name = "restaurant")
@NamedQueries(value = {
        @NamedQuery(name = "Restaurant.getAll", query = "SELECT r FROM restaurant r"),
        @NamedQuery(name="Restaurant.getRestaurantById", query = "SELECT r FROM restaurant r WHERE r.restaurantId = :restaurantId"),
})
public class RestaurantEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer restaurantId;

    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "operatingHoursId")
    private OperatingHoursEntity operatingHours;

    @JsonbTransient
    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<MealEntity> listOfMeals;

    private String description;
    private Float lat;
    private Float lng;

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
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

    public OperatingHoursEntity getOperatingHours() {
        return operatingHours;
    }

    public void setOperatingHours(OperatingHoursEntity operatingHours) {
        this.operatingHours = operatingHours;
    }

    public String getDescription(){return description;}
    public void setDescription(String description){this.description = description;}
    public Float getLat(){return lat;}
    public void setLat(Float lat){this.lat = lat;}

    public Float getLng(){return lng;}
    public void setLng(Float lng){this.lng = lng;}
}
