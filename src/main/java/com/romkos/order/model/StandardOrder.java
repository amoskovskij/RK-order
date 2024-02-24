package main.java.com.romkos.order.model;

import java.util.Objects;

public class StandardOrder extends Order {

    private Technologist technologist;

    @Override
    public String toString() {
        return "StandardOrder {"
                + "\ntype = " + this.getType()
                + "\n" + super.toString()
                + "\ntechnologist = " + getTechnologist()
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

    public Technologist getTechnologist() {
        return technologist;
    }

    public void setTechnologist(Technologist technologist) {
        this.technologist = technologist;
    }

    public enum Technologist {
        Moskovskyi("1"),
        Kryvokulskyi("2"),
        Plyahovets("3"),
        UNKNOWN("0");

        private final String value;

        Technologist(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public static Technologist getTechnologistByValue(String value) {
            for (Technologist t : Technologist.values()) {
                if (t.value.equals(value)) {
                    return t;
                }
            }
            System.out.println("Unable to parse value '" + value + "'. Using default value: " + UNKNOWN);
            return UNKNOWN;
        }
    }
}
