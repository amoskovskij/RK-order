package main.java.com.romkos.order.service;

import main.java.com.romkos.order.Main;
import main.java.com.romkos.order.model.CustomOrder;
import main.java.com.romkos.order.model.Order;
import main.java.com.romkos.order.model.StandardOrder;

public class OrderService {

    private final String STANDARD_ORDER_TYPE = "standard";
    private final String CUSTOM_ORDER_TYPE = "custom";

    public Order registerNewOrder() {
        Order order = null;

        System.out.print("Order type (standard / custom): ");
        String type = Main.SCANNER.nextLine();

        if (STANDARD_ORDER_TYPE.equals(type) || CUSTOM_ORDER_TYPE.equals(type)) {
            order = buildOrder(type);
        } else {
            System.out.println("Unknown order type: " + type);
        }

        return order;
    }

    private Order buildOrder(String type) {
        Order order = type.equals(STANDARD_ORDER_TYPE) ? new StandardOrder() : new CustomOrder();
        order.setType(type);

        System.out.print("Order number (RK-1): ");
        order.setNumber(Main.SCANNER.nextLine());

        System.out.print("Shipping date (yyyy.mm.dd): ");
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

        if (type.equals(STANDARD_ORDER_TYPE)) {
            System.out.print("Technologist name: ");
            ((StandardOrder) order).setTechnologist(Main.SCANNER.nextLine());
        }

        if (type.equals(CUSTOM_ORDER_TYPE)) {
            System.out.print("Designer name: ");
            ((CustomOrder) order).setDesigner(Main.SCANNER.nextLine());
            System.out.print("Order comment: ");
            ((CustomOrder) order).setComment(Main.SCANNER.nextLine());
        }

        return order;
    }

}
