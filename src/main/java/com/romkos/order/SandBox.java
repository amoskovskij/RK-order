package main.java.com.romkos.order;

import main.java.com.romkos.order.comparator.CustomOrderShippingDateComparator;
import main.java.com.romkos.order.model.CustomOrder;

import java.util.Arrays;

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

        Arrays.sort(customOrders, new CustomOrderShippingDateComparator());

        for (CustomOrder customOrder : customOrders) {
            System.out.println(customOrder.getShippingDate());
        }
    }

}
