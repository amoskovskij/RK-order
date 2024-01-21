package main.java.com.romkos.order;

import main.java.com.romkos.order.model.CustomOrder;

import java.util.Arrays;
import java.util.Comparator;

public class SandBox {

    public static void main(String[] args) {
        CustomOrder[] customOrders = {
                new CustomOrder("10.01.2024"),
                new CustomOrder("05.01.2024"),
                new CustomOrder("11.01.2024"),
                new CustomOrder("02.02.2024"),
                new CustomOrder("01.01.2024"),
                new CustomOrder("04.01.2024"),
                new CustomOrder("10.01.2024")
        };

        Arrays.sort(customOrders, new Comparator<CustomOrder>() {
            @Override
            public int compare(CustomOrder order1, CustomOrder order2) {
                return order1.getShippingDate().compareTo(order2.getShippingDate());
            }
        });

        for (CustomOrder customOrder : customOrders) {
            System.out.println(customOrder.getShippingDate());
        }

        System.out.println(customOrders[0]);
    }

}
