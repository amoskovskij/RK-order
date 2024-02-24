package main.java.com.romkos.order.model;

import java.util.Objects;

public class CustomOrder extends Order {

    private Designer designer;
    private String comment;

    public CustomOrder() { }

    public CustomOrder(String shippingDate) {
        this.setShippingDate(shippingDate);
    }

    @Override
    public String toString() {
        return "CustomOrder {"
                + "\ntype = " + this.getType()
                + "\n" + super.toString()
                + "\ndesigner = " + getDesigner()
                + ", comment = " + getComment()
                + "\n}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CustomOrder that = (CustomOrder) o;
        return Objects.equals(designer, that.designer)
                && Objects.equals(comment, that.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), designer, comment);
    }

    public Designer getDesigner() {
        return designer;
    }

    public void setDesigner(Designer designer) {
        this.designer = designer;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public enum Designer {
        Sydorenko("1"),
        Yakymenko("2"),
        Plyahovets("3"),
        Moskovskyi("4"),
        UNKNOWN("0");

        private final String value;

        Designer(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public static Designer getDesignerByValue(String value) {
            for (Designer d : Designer.values()) {
                if (d.value.equals(value)) {
                    return d;
                }
            }
            System.out.println("Unable to parse value '" + value + "'. Using default value: " + UNKNOWN);
            return UNKNOWN;
        }
    }
}
