package main.java.com.romkos.order;

import main.java.com.romkos.order.model.CustomOrder;

import java.util.Arrays;
import java.util.Comparator;

public class SandBox {

    public static void main(String[] args) {
        CustomOrder[] customOrders = {
                new CustomOrder("2024.01.10"),
                new CustomOrder("2024.01.05"),
                new CustomOrder("2024.01.11"),
                new CustomOrder("2024.02.02"),
                new CustomOrder("2024.01.01"),
                new CustomOrder("2024.01.04"),
                new CustomOrder("2024.01.10")
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
    }

}
