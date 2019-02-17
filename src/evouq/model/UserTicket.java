package evouq.model;

import java.util.Objects;

public class UserTicket extends Entity {
    private User user;
    private String to;
    private String from;
    private String purchaseDate;
    private ActivityTicket activityTicket;
    private Schedule schedule;
    private long countVisit;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public ActivityTicket getActivityTicket() {
        return activityTicket;
    }

    public void setActivityTicket(ActivityTicket activityTicket) {
        this.activityTicket = activityTicket;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public long getCountVisit() {
        return countVisit;
    }

    public void setCountVisit(long countVisit) {
        this.countVisit = countVisit;
    }

    @Override
    public String toString() {
        return "UserTicket{" +
                "user=" + user +
                ", to='" + to + '\'' +
                ", from='" + from + '\'' +
                ", purchaseDate='" + purchaseDate + '\'' +
                ", activityTicket=" + activityTicket +
                ", schedule=" + schedule +
                ", countVisit=" + countVisit +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserTicket that = (UserTicket) o;
        return countVisit == that.countVisit &&
                Objects.equals(user, that.user) &&
                Objects.equals(to, that.to) &&
                Objects.equals(from, that.from) &&
                Objects.equals(purchaseDate, that.purchaseDate) &&
                Objects.equals(activityTicket, that.activityTicket) &&
                Objects.equals(schedule, that.schedule);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, to, from, purchaseDate, activityTicket, schedule, countVisit);
    }
}
