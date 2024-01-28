package main.java.com.romkos.order.comonent;

import main.java.com.romkos.order.Main;
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
                registerOrders(manager);
                System.out.println(manager);
            }
        }
    }

    private void registerOrders(Manager manager) {
        boolean continueAddOrders = true;

        while(continueAddOrders) {
            addOrder(manager);

            System.out.print("Do you want to add more orders for current manager? (Y/N): ");
            String answer = Main.SCANNER.nextLine();

            if (answer.toLowerCase().startsWith("n")) {
                continueAddOrders = false;
            }
        }
    }

    private void addOrder(Manager manager) {
        System.out.println("Adding new order.");
        Order order = orderService.registerNewOrder();

        if (order != null) {
            manager.addOrder(order);
            order.setManagerName(manager.getLastName() + " " + manager.getFirstName());
            System.out.println("Order has been created.");
        }
    }
}
