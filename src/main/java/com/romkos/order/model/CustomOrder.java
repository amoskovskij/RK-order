package main.java.com.romkos.order.model;

public class CustomOrder extends Order {

    private String designer;
    private String comment;

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
