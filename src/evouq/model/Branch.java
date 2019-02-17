package evouq.model;

import java.sql.Time;
import java.util.Objects;

public class Branch extends Entity {

    private Time startHour;
    private Time endHour;
    private String address;
    private Club club;
    private User user;

    public Time getStartHour() {
        return startHour;
    }

    public void setStartHour(Time startHour) {
        this.startHour = startHour;
    }

    public Time getEndHour() {
        return endHour;
    }

    public void setEndHour(Time endHour) {
        this.endHour = endHour;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Branch{" +
                "startHour=" + startHour +
                ", endHour=" + endHour +
                ", address='" + address + '\'' +
                ", club=" + club +
                ", user=" + user +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Branch branch = (Branch) o;
        return Objects.equals(startHour, branch.startHour) &&
                Objects.equals(endHour, branch.endHour) &&
                Objects.equals(address, branch.address) &&
                Objects.equals(club, branch.club) &&
                Objects.equals(user, branch.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startHour, endHour, address, club, user);
    }
}
