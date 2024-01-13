package main.java.com.romkos.order.model;

import java.util.Objects;

public class CustomOrder extends Order {

    private String designer;
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
                + "\ndesigner = " + designer
                + ", comment = " + comment
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

    public String getDesigner() {
        return designer;
    }

    public void setDesigner(String designer) {
        this.designer = designer;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
