package si.rso.skupina10.dtos;

import java.util.List;

public class RestaurantDto {

    private String name;

    private List<MealDto> listOfMealDtos;

    private OperatingHoursDto operatingHoursDto;

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
}
