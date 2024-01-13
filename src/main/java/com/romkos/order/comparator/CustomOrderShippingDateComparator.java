package main.java.com.romkos.order.comparator;

import main.java.com.romkos.order.model.CustomOrder;

import java.util.Comparator;

public class CustomOrderShippingDateComparator implements Comparator<CustomOrder> {
    @Override
    public int compare(CustomOrder order1, CustomOrder order2) {
        return order1.getShippingDate().compareTo(order2.getShippingDate());
    }
}
