package si.rso.skupina10.dtos;

import java.util.List;

public class RestaurantDto {

    private Integer id;

    private String name;

    private List<MealDto> listOfMealDtos;

    private OperatingHoursDto operatingHoursDto;

    private String description;
    private Float lat;
    private Float lng;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MealDto> getListOfMealDtos() {
        return listOfMealDtos;
    }

    public void setListOfMealDtos(List<MealDto> listOfMealDtos) {
        this.listOfMealDtos = listOfMealDtos;
    }

    public OperatingHoursDto getOperatingHoursDto() {
        return operatingHoursDto;
    }

    public void setOperatingHoursDto(OperatingHoursDto operatingHoursDto) {
        this.operatingHoursDto = operatingHoursDto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription(){return description;}
    public void setDescription(String description){this.description = description;}
    public Float getLat(){return lat;}
    public void setLat(Float lat){this.lat = lat;}

    public Float getLng(){return lng;}
    public void setLng(Float lng){this.lng = lng;}

    public String toString() {
        return "Restaurant id: " + id + ", name: " + name;
    }
}
