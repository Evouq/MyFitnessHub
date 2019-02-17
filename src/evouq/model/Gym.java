package evouq.model;

import java.util.Objects;

public class Gym extends Entity {
    private Branch branch;
    private String address;
    private String phone;

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Gym{" +
                "branch=" + branch +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gym gym = (Gym) o;
        return Objects.equals(branch, gym.branch) &&
                Objects.equals(address, gym.address) &&
                Objects.equals(phone, gym.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(branch, address, phone);
    }
}
