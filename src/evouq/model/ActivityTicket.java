package evouq.model;

import java.util.Date;
import java.util.Objects;

public class ActivityTicket extends Entity {
    private TicketType ticketType;
    private ActivityType activityType;
    private String createdAt;
    private long price;
    private Branch branch;

    public TicketType getTicketType() {
        return ticketType;
    }

    public void setTicketType(TicketType ticketType) {
        this.ticketType = ticketType;
    }

    public ActivityType getActivityType() {
        return activityType;
    }

    public void setActivityType(ActivityType activityType) {
        this.activityType = activityType;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    @Override
    public String toString() {
        return "ActivityTicket{" +
                "ticketType=" + ticketType +
                ", activityType=" + activityType +
                ", createdAt=" + createdAt +
                ", price=" + price +
                ", branch=" + branch +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActivityTicket that = (ActivityTicket) o;
        return price == that.price &&
                Objects.equals(ticketType, that.ticketType) &&
                Objects.equals(activityType, that.activityType) &&
                Objects.equals(createdAt, that.createdAt) &&
                Objects.equals(branch, that.branch);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticketType, activityType, createdAt, price, branch);
    }
}
