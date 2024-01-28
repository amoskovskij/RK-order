package main.java.com.romkos.order.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Manager {

    private String firstName;
    private String lastName;
    private String email;
    private List<Order> orders = new ArrayList<>();

    @Override
    public String toString() {
        return "Manager {"
                + "firstName = " + firstName
                + ", lastName = " + lastName
                + ", email = " + email
                + ",\n\t orders = " + orders
                + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manager manager = (Manager) o;
        return Objects.equals(firstName, manager.firstName)
                && Objects.equals(lastName, manager.lastName)
                && Objects.equals(email, manager.email)
                && Objects.equals(orders, manager.orders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email, orders);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Order> getOrder() {
        return orders;
    }

    public void setOrder(List<Order> orders) {
        this.orders = orders;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }
}
