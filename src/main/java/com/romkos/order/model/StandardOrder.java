package main.java.com.romkos.order.model;

import java.util.Objects;

public class StandardOrder extends Order {

    private String technologist;

    @Override
    public String toString() {
        return "StandardOrder {"
                + "\ntype = " + this.getType()
                + "\n" + super.toString()
                + "\ntechnologist = " + technologist
                + "\n}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        StandardOrder that = (StandardOrder) o;
        return Objects.equals(technologist, that.technologist);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), technologist);
    }

    public String getTechnologist() {
        return technologist;
    }

    public void setTechnologist(String technologist) {
        this.technologist = technologist;
    }
}
