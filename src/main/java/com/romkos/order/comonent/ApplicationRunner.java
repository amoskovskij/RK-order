package main.java.com.romkos.order.comonent;

import main.java.com.romkos.order.model.Manager;
import main.java.com.romkos.order.model.Order;
import main.java.com.romkos.order.service.ManagerService;
import main.java.com.romkos.order.service.OrderService;

public class ApplicationRunner {

    private final ManagerService managerService = new ManagerService();
    private final OrderService orderService = new OrderService();

    public void run() {
        if (Authenticator.auth()) {
            Manager manager = managerService.registerNewManager();

            if (manager != null) {
                System.out.println("Adding new order.");
                Order order = orderService.registerNewOrder();

                if (order != null) {
                    manager.setOrder(order);
                    order.setManagerName(manager.getLastName() + " " + manager.getFirstName());
                    System.out.println("Order has been created.");
                }

                System.out.println(manager);
                System.out.println(order);
            }
        }
    }

}
