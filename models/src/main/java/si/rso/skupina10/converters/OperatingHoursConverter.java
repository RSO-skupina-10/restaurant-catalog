package si.rso.skupina10.converters;

import si.rso.skupina10.dtos.OperatingHoursDto;
import si.rso.skupina10.dtos.RestaurantDto;
import si.rso.skupina10.entities.OperatingHoursEntity;
import si.rso.skupina10.entities.RestaurantEntity;

public class OperatingHoursConverter {

    public static OperatingHoursDto toDto(OperatingHoursEntity entity) {
        OperatingHoursDto dto = new OperatingHoursDto();
        //stack overflow
        //dto.setRestaurantDto(RestaurantConverter.toDto(entity.getRestaurant()));
        dto.setId(entity.getOperatingHoursId());

        dto.setMondayStart(entity.getMondayStart());
        dto.setMondayEnd(entity.getMondayEnd());

        dto.setTuesdayStart(entity.getTuesdayStart());
        dto.setThursdayEnd(entity.getTuesdayEnd());

        dto.setWednesdayStart(entity.getWednesdayStart());
        dto.setWednesdayEnd(entity.getWednesdayEnd());

        dto.setThursdayStart(entity.getThursdayStart());
        dto.setThursdayEnd(entity.getThursdayEnd());

        dto.setFridayStart(entity.getFridayStart());
        dto.setFridayEnd(entity.getFridayEnd());

        dto.setSaturdayStart(entity.getSaturdayStart());
        dto.setSaturdayEnd(entity.getSaturdayEnd());

        dto.setSundayStart(entity.getSundayStart());
        dto.setSundayEnd(entity.getSundayEnd());

        dto.setRestaurantId(entity.getRestaurant().getRestaurantId());

        return dto;
    }

    public static OperatingHoursEntity toEntity(OperatingHoursDto dto) {
        OperatingHoursEntity entity = new OperatingHoursEntity();
        RestaurantEntity restaurantEntity = new RestaurantEntity();
        restaurantEntity.setRestaurantId(dto.getRestaurantId());

        entity.setRestaurant(restaurantEntity);
        entity.setOperatingHoursId(dto.getId());

        //entity.setRestaurant(RestaurantConverter.toEntity(dto.getRestaurantDto()));

        entity.setMondayStart(dto.getMondayStart());
        entity.setMondayEnd(dto.getMondayEnd());

        entity.setTuesdayStart(dto.getTuesdayStart());
        entity.setThursdayEnd(dto.getTuesdayEnd());

        entity.setWednesdayStart(dto.getWednesdayStart());
        entity.setWednesdayEnd(dto.getWednesdayEnd());

        entity.setThursdayStart(dto.getThursdayStart());
        entity.setThursdayEnd(dto.getThursdayEnd());

        entity.setFridayStart(dto.getFridayStart());
        entity.setFridayEnd(dto.getFridayEnd());

        entity.setSaturdayStart(dto.getSaturdayStart());
        entity.setSaturdayEnd(dto.getSaturdayEnd());

        entity.setSundayStart(dto.getSundayStart());
        entity.setSundayEnd(dto.getSundayEnd());

        return entity;
    }
}
