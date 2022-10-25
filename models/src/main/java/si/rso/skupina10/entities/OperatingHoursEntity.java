package si.rso.skupina10.entities;

import javax.persistence.*;
import java.sql.Time;

@Entity(name="operatingHours")
public class OperatingHoursEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer operatingHoursId;

    private Time mondayStart;
    private Time mondayEnd;

    private Time tuesdayStart;
    private Time tuesdayEnd;

    private Time wednesdayStart;
    private Time wednesdayEnd;

    private Time thursdayStart;
    private Time thursdayEnd;

    private Time fridayStart;
    private Time fridayEnd;

    private Time saturdayStart;
    private Time saturdayEnd;

    private Time sundayStart;
    private Time sundayEnd;

    @OneToOne(mappedBy = "operatingHours")
    private RestaurantEntity restaurant;

    public Time getMondayStart() {
        return mondayStart;
    }

    public void setMondayStart(Time mondayStart) {
        this.mondayStart = mondayStart;
    }

    public Time getMondayEnd() {
        return mondayEnd;
    }

    public void setMondayEnd(Time mondayEnd) {
        this.mondayEnd = mondayEnd;
    }

    public Time getTuesdayStart() {
        return tuesdayStart;
    }

    public void setTuesdayStart(Time tuesdayStart) {
        this.tuesdayStart = tuesdayStart;
    }

    public Time getTuesdayEnd() {
        return tuesdayEnd;
    }

    public void setTuesdayEnd(Time tuesdayEnd) {
        this.tuesdayEnd = tuesdayEnd;
    }

    public Time getWednesdayStart() {
        return wednesdayStart;
    }

    public void setWednesdayStart(Time wednesdayStart) {
        this.wednesdayStart = wednesdayStart;
    }

    public Time getWednesdayEnd() {
        return wednesdayEnd;
    }

    public void setWednesdayEnd(Time wednesdayEnd) {
        this.wednesdayEnd = wednesdayEnd;
    }

    public Time getThursdayStart() {
        return thursdayStart;
    }

    public void setThursdayStart(Time thursdayStart) {
        this.thursdayStart = thursdayStart;
    }

    public Time getThursdayEnd() {
        return thursdayEnd;
    }

    public void setThursdayEnd(Time thursdayEnd) {
        this.thursdayEnd = thursdayEnd;
    }

    public Time getFridayStart() {
        return fridayStart;
    }

    public void setFridayStart(Time fridayStart) {
        this.fridayStart = fridayStart;
    }

    public Time getFridayEnd() {
        return fridayEnd;
    }

    public void setFridayEnd(Time fridayEnd) {
        this.fridayEnd = fridayEnd;
    }

    public Time getSaturdayStart() {
        return saturdayStart;
    }

    public void setSaturdayStart(Time saturdayStart) {
        this.saturdayStart = saturdayStart;
    }

    public Time getSaturdayEnd() {
        return saturdayEnd;
    }

    public void setSaturdayEnd(Time saturdayEnd) {
        this.saturdayEnd = saturdayEnd;
    }

    public Time getSundayStart() {
        return sundayStart;
    }

    public void setSundayStart(Time sundayStart) {
        this.sundayStart = sundayStart;
    }

    public Time getSundayEnd() {
        return sundayEnd;
    }

    public void setSundayEnd(Time sundayEnd) {
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
