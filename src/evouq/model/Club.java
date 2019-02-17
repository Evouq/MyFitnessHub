package evouq.model;

import java.util.Objects;

public class Club extends NamedEntity {
    private String email;
    private String contNumber;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContNumber() {
        return contNumber;
    }

    public void setContNumber(String contNumber) {
        this.contNumber = contNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Club club = (Club) o;
        return Objects.equals(email, club.email) &&
                Objects.equals(contNumber, club.contNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, contNumber);
    }

    @Override
    public String toString() {
        return "Club{" +
                "email='" + email + '\'' +
                ", contNumber='" + contNumber + '\'' +
                "} " + super.toString();
    }
}
