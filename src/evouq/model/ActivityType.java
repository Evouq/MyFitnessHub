package evouq.model;

import java.util.Objects;

public class ActivityType extends NamedEntity {
    private long duration;


    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "ActivityType{" +
                "duration=" + duration +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActivityType that = (ActivityType) o;
        return duration == that.duration;
    }

    @Override
    public int hashCode() {
        return Objects.hash(duration);
    }
}
