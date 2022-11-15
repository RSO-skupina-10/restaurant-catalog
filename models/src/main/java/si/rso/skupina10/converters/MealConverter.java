package si.rso.skupina10.converters;

import si.rso.skupina10.dtos.MealDto;
import si.rso.skupina10.entities.MealEntity;
import si.rso.skupina10.entities.RestaurantEntity;

public class MealConverter {

    public static MealDto toDto(MealEntity entity) {
        MealDto dto = new MealDto();
        dto.setPrice(entity.getPrice());
        dto.setName(entity.getName());
        dto.setIngredients(entity.getIngredients());
        dto.setRestaurantId(entity.getRestaurant().getRestaurantId());

        return dto;
    }

    public static MealEntity toEntity(MealDto dto) {
        MealEntity entity = new MealEntity();

        RestaurantEntity r = new RestaurantEntity();
        r.setRestaurantId(dto.getRestaurantId());
        entity.setRestaurant(r);
        entity.setIngredients(dto.getIngredients());
        entity.setPrice(dto.getPrice());
        entity.setName(dto.getName());

        return entity;
    }
}
