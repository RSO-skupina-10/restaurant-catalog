package si.rso.skupina10.entities;

import javax.persistence.*;
import java.time.LocalTime;

@Entity(name = "operatingHours")
public class OperatingHoursEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer operatingHoursId;

    private LocalTime mondayStart;
    private LocalTime mondayEnd;

    private LocalTime tuesdayStart;

    private LocalTime tuesdayEnd;

    private LocalTime wednesdayStart;

    private LocalTime wednesdayEnd;

    private LocalTime thursdayStart;

    private LocalTime thursdayEnd;


    private LocalTime fridayStart;

    private LocalTime fridayEnd;

    private LocalTime saturdayStart;

    private LocalTime saturdayEnd;

    private LocalTime sundayStart;

    private LocalTime sundayEnd;

    @OneToOne(mappedBy = "operatingHours")
    private RestaurantEntity restaurant;

    public LocalTime getMondayStart() {
        return mondayStart;
    }

    public void setMondayStart(LocalTime mondayStart) {
        this.mondayStart = mondayStart;
    }

    public LocalTime getMondayEnd() {
        return mondayEnd;
    }

    public void setMondayEnd(LocalTime mondayEnd) {
        this.mondayEnd = mondayEnd;
    }

    public LocalTime getTuesdayStart() {
        return tuesdayStart;
    }

    public void setTuesdayStart(LocalTime tuesdayStart) {
        this.tuesdayStart = tuesdayStart;
    }

    public LocalTime getTuesdayEnd() {
        return tuesdayEnd;
    }

    public void setTuesdayEnd(LocalTime tuesdayEnd) {
        this.tuesdayEnd = tuesdayEnd;
    }

    public LocalTime getWednesdayStart() {
        return wednesdayStart;
    }

    public void setWednesdayStart(LocalTime wednesdayStart) {
        this.wednesdayStart = wednesdayStart;
    }

    public LocalTime getWednesdayEnd() {
        return wednesdayEnd;
    }

    public void setWednesdayEnd(LocalTime wednesdayEnd) {
        this.wednesdayEnd = wednesdayEnd;
    }

    public LocalTime getThursdayStart() {
        return thursdayStart;
    }

    public void setThursdayStart(LocalTime thursdayStart) {
        this.thursdayStart = thursdayStart;
    }

    public LocalTime getThursdayEnd() {
        return thursdayEnd;
    }

    public void setThursdayEnd(LocalTime thursdayEnd) {
        this.thursdayEnd = thursdayEnd;
    }

    public LocalTime getFridayStart() {
        return fridayStart;
    }

    public void setFridayStart(LocalTime fridayStart) {
        this.fridayStart = fridayStart;
    }

    public LocalTime getFridayEnd() {
        return fridayEnd;
    }

    public void setFridayEnd(LocalTime fridayEnd) {
        this.fridayEnd = fridayEnd;
    }

    public LocalTime getSaturdayStart() {
        return saturdayStart;
    }

    public void setSaturdayStart(LocalTime saturdayStart) {
        this.saturdayStart = saturdayStart;
    }

    public LocalTime getSaturdayEnd() {
        return saturdayEnd;
    }

    public void setSaturdayEnd(LocalTime saturdayEnd) {
        this.saturdayEnd = saturdayEnd;
    }

    public LocalTime getSundayStart() {
        return sundayStart;
    }

    public void setSundayStart(LocalTime sundayStart) {
        this.sundayStart = sundayStart;
    }

    public LocalTime getSundayEnd() {
        return sundayEnd;
    }

    public void setSundayEnd(LocalTime sundayEnd) {
        this.sundayEnd = sundayEnd;
    }

    public Integer getOperatingHoursId() {
        return operatingHoursId;
    }

    public void setOperatingHoursId(Integer operatingHoursId) {
        this.operatingHoursId = operatingHoursId;
    }

    public RestaurantEntity getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(RestaurantEntity restaurant) {
        this.restaurant = restaurant;
    }
}
