package evouq.model;

import java.util.Objects;

public class TicketType extends NamedEntity {
    private long limVisits;

    public long getLimVisits() {
        return limVisits;
    }

    public void setLimVisits(long limVisits) {
        this.limVisits = limVisits;
    }

    @Override
    public String toString() {
        return "TicketType{" +
                "limVisits=" + limVisits +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketType that = (TicketType) o;
        return limVisits == that.limVisits;
    }

    @Override
    public int hashCode() {
        return Objects.hash(limVisits);
    }
}
