package si.rso.skupina10.converters;

import si.rso.skupina10.dtos.MealDto;
import si.rso.skupina10.dtos.RestaurantDto;
import si.rso.skupina10.entities.MealEntity;
import si.rso.skupina10.entities.OperatingHoursEntity;
import si.rso.skupina10.entities.RestaurantEntity;

import java.util.List;
import java.util.stream.Collectors;

public class RestaurantConverter {

    public static RestaurantDto toDto(RestaurantEntity entity) {
        RestaurantDto dto = new RestaurantDto();
        dto.setId(entity.getRestaurantId());

        dto.setName(entity.getName());

        List<MealEntity> lme = entity.getListOfMeals();
        dto.setListOfMealDtos(lme.stream().map(MealConverter::toDto).collect(Collectors.toList()));

        OperatingHoursEntity ohe = entity.getOperatingHours();

        dto.setOperatingHoursDto(OperatingHoursConverter.toDto(ohe));
        dto.setDescription(entity.getDescription());
        dto.setLat(entity.getLat());
        dto.setLng(entity.getLng());

        return dto;
    }

    public static RestaurantEntity toEntity(RestaurantDto dto) {
        RestaurantEntity entity = new RestaurantEntity();

        entity.setRestaurantId(dto.getId());
        entity.setOperatingHours(OperatingHoursConverter.toEntity(dto.getOperatingHoursDto()));
        entity.setName(dto.getName());
        entity.setLat(dto.getLat());
        entity.setLng(dto.getLng());
        entity.setDescription(dto.getDescription());

        List<MealDto> mealDtos = dto.getListOfMealDtos();
        entity.setListOfMeals(mealDtos.stream().map(MealConverter::toEntity).collect(Collectors.toList()));

        return entity;
    }

}
