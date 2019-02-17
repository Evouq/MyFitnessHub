package evouq.model;

import java.util.Date;
import java.util.Objects;

public class Schedule extends Entity {
   private User user;
   private Gym gym;
   private ActivityType activityType;
   private Date to;
   private Date from;
   private Date startHour;
   private Boolean monday;
   private Boolean tuesday;
   private Boolean wednesday;
   private Boolean thursday;
   private Boolean friday;
   private Boolean saturday;
   private Boolean sunday;



    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Gym getGym() {
        return gym;
    }

    public void setGym(Gym gym) {
        this.gym = gym;
    }

    public ActivityType getActivityType() {
        return activityType;
    }

    public void setActivityType(ActivityType activityType) {
        this.activityType = activityType;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getStartHour() {
        return startHour;
    }

    public void setStartHour(Date startHour) {
        this.startHour = startHour;
    }

    public Boolean getMonday() {
        return monday;
    }

    public void setMonday(Boolean monday) {
        this.monday = monday;
    }

    public Boolean getTuesday() {
        return tuesday;
    }

    public void setTuesday(Boolean tuesday) {
        this.tuesday = tuesday;
    }

    public Boolean getWednesday() {
        return wednesday;
    }

    public void setWednesday(Boolean wednesday) {
        this.wednesday = wednesday;
    }

    public Boolean getThursday() {
        return thursday;
    }

    public void setThursday(Boolean thursday) {
        this.thursday = thursday;
    }

    public Boolean getFriday() {
        return friday;
    }

    public void setFriday(Boolean friday) {
        this.friday = friday;
    }

    public Boolean getSaturday() {
        return saturday;
    }

    public void setSaturday(Boolean saturday) {
        this.saturday = saturday;
    }

    public Boolean getSunday() {
        return sunday;
    }

    public void setSunday(Boolean sunday) {
        this.sunday = sunday;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "userRule=" + user +
                ", gym=" + gym +
                ", activityType=" + activityType +
                ", to=" + to +
                ", from=" + from +
                ", startHour='" + startHour + '\'' +
                ", monday=" + monday +
                ", tuesday=" + tuesday +
                ", wednesday=" + wednesday +
                ", thursday=" + thursday +
                ", friday=" + friday +
                ", saturday=" + saturday +
                ", sunday=" + sunday +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Schedule schedule = (Schedule) o;
        return Objects.equals(user, schedule.user) &&
                Objects.equals(gym, schedule.gym) &&
                Objects.equals(activityType, schedule.activityType) &&
                Objects.equals(to, schedule.to) &&
                Objects.equals(from, schedule.from) &&
                Objects.equals(startHour, schedule.startHour) &&
                Objects.equals(monday, schedule.monday) &&
                Objects.equals(tuesday, schedule.tuesday) &&
                Objects.equals(wednesday, schedule.wednesday) &&
                Objects.equals(thursday, schedule.thursday) &&
                Objects.equals(friday, schedule.friday) &&
                Objects.equals(saturday, schedule.saturday) &&
                Objects.equals(sunday, schedule.sunday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, gym, activityType, to, from, startHour, monday, tuesday, wednesday, thursday, friday, saturday, sunday);
    }
}
