package evouq.model;

import java.util.Date;
import java.util.Map;
import java.util.Objects;

public class User extends NamedEntity {

    private String phone;
    private String login;
    private String password;
    private Club club;
    private long age;
    private long isDeleted;
    private Date createdAt;
    private Roles role;




    public String getPhone() {
        return phone;
    }

    public long getDeleted() {
        return isDeleted;
    }

    public void setDeleted(long deleted) {
        isDeleted = deleted;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }

    public long getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(long isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "phone='" + phone + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", club=" + club +
                ", age=" + age +
                ", isDeleted=" + isDeleted +
                ", createdAt=" + createdAt +
                ", role=" + role +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age &&
                isDeleted == user.isDeleted &&
                Objects.equals(phone, user.phone) &&
                Objects.equals(login, user.login) &&
                Objects.equals(password, user.password) &&
                Objects.equals(club, user.club) &&
                Objects.equals(createdAt, user.createdAt) &&
                role == user.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(phone, login, password, club, age, isDeleted, createdAt, role);
    }
}
