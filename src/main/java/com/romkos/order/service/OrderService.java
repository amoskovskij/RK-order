package main.java.com.romkos.order.service;

import main.java.com.romkos.order.Main;
import main.java.com.romkos.order.model.CustomOrder;
import main.java.com.romkos.order.model.Order;
import main.java.com.romkos.order.model.StandardOrder;

public class OrderService {

    private String STANDARD_ORDER_TYPE = "standard";
    private String CUSTOM_ORDER_TYPE = "custom";

    public Order registerNewOrder() {
        Order order = new Order();

        System.out.print("Order type (standard / custom): ");
        String type = Main.SCANNER.nextLine();

        if (STANDARD_ORDER_TYPE.equals(type)) {
            order = buildStandardOrder();
        } else if (CUSTOM_ORDER_TYPE.equals(type)) {
            order = buildCustomOrder();
        }

        return order;
    }

    private Order buildOrder(String type) {
        Order order = new Order();
        order.setType(type);

        System.out.print("Order number (RK-1): ");
        order.setNumber(Main.SCANNER.nextLine());

        System.out.print("Shipping date (12.01.2024): ");
        order.setShippingDate(Main.SCANNER.nextLine());

        System.out.print("Client's last name (Shevchenko): ");
        order.setClientLastName(Main.SCANNER.nextLine());

        System.out.print("Client's first name (Stepan): ");
        order.setClientFirstName(Main.SCANNER.nextLine());

        System.out.print("Client's phone (067-012-34-56): ");
        order.setClientPhone(Main.SCANNER.nextLine());

        System.out.print("Order amount (1000.5): ");
        order.setAmount(Main.SCANNER.nextLine());

        System.out.print("Order prepayment (500.25): ");
        order.setAdvancePayment(Main.SCANNER.nextLine());

        System.out.print("Order delivery city (Kharkiv): ");
        order.setDeliveryCity(Main.SCANNER.nextLine());

        System.out.print("Order assembly is necessary (Y/N): ");
        order.setAssemblyNeed(Main.SCANNER.nextLine());

        System.out.print("Order type of packaging (film / cardboard): ");
        order.setPackagingType(Main.SCANNER.nextLine());

        System.out.print("Order delivery method (self-pickup / carrier, dep. No. 1): ");
        order.setDeliveryMethod(Main.SCANNER.nextLine());

        System.out.print("Order primary colors (White/Blue): ");
        order.setPrimaryColors(Main.SCANNER.nextLine());

        return order;
    }

    private StandardOrder buildStandardOrder() {
        Order order = buildOrder(STANDARD_ORDER_TYPE);
        StandardOrder standardOrder = orderToStandardOrder(order);

        System.out.print("Technologist name: ");
        standardOrder.setTechnologist(Main.SCANNER.nextLine());

        return standardOrder;
    }

    private StandardOrder orderToStandardOrder(Order order) {
        StandardOrder standardOrder = new StandardOrder();
        standardOrder.setNumber(order.getNumber());
        standardOrder.setShippingDate(order.getShippingDate());
        standardOrder.setClientLastName(order.getClientLastName());
        standardOrder.setClientFirstName(order.getClientFirstName());
        standardOrder.setClientPhone(order.getClientPhone());
        standardOrder.setAmount(order.getAmount());
        standardOrder.setAdvancePayment(order.getAdvancePayment());
        standardOrder.setDeliveryCity(order.getDeliveryCity());
        standardOrder.setAssemblyNeed(order.getAssemblyNeed());
        standardOrder.setPackagingType(order.getPackagingType());
        standardOrder.setDeliveryMethod(order.getDeliveryMethod());
        standardOrder.setPrimaryColors(order.getPrimaryColors());

        return standardOrder;
    }

    private CustomOrder buildCustomOrder() {
        Order order = buildOrder(CUSTOM_ORDER_TYPE);
        CustomOrder customOrder = orderToCustomOrder(order);

        System.out.print("Designer name: ");
        customOrder.setDesigner(Main.SCANNER.nextLine());

        System.out.print("Order comment: ");
        customOrder.setComment(Main.SCANNER.nextLine());

        return customOrder;
    }

    private CustomOrder orderToCustomOrder(Order order) {
        CustomOrder customOrder = new CustomOrder();
        customOrder.setNumber(order.getNumber());
        customOrder.setShippingDate(order.getShippingDate());
        customOrder.setClientLastName(order.getClientLastName());
        customOrder.setClientFirstName(order.getClientFirstName());
        customOrder.setClientPhone(order.getClientPhone());
        customOrder.setAmount(order.getAmount());
        customOrder.setAdvancePayment(order.getAdvancePayment());
        customOrder.setDeliveryCity(order.getDeliveryCity());
        customOrder.setAssemblyNeed(order.getAssemblyNeed());
        customOrder.setPackagingType(order.getPackagingType());
        customOrder.setDeliveryMethod(order.getDeliveryMethod());
        customOrder.setPrimaryColors(order.getPrimaryColors());

        return customOrder;
    }

}
