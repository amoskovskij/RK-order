package main.java.com.romkos.order.comonent;

import main.java.com.romkos.order.model.Manager;
import main.java.com.romkos.order.model.Order;
import main.java.com.romkos.order.service.ManagerService;
import main.java.com.romkos.order.service.OrderService;

public class ApplicationRunner {

    private ManagerService managerService = new ManagerService();
    private OrderService orderService = new OrderService();

    public void run() {
        if (Authenticator.auth()) {
            Manager manager = managerService.registerNewManager();

            if (manager != null) {
                System.out.println("Adding new order.");
                Order order = orderService.registerNewOrder();
                manager.setOrder(order);
                order.setManager(manager.getFirstName() + " " + manager.getLastName());
                System.out.println("Order has been created.");
            }
        }
    }

}
