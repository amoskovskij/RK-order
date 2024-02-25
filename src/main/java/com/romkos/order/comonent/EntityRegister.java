package main.java.com.romkos.order.comonent;

import main.java.com.romkos.order.Main;
import main.java.com.romkos.order.model.Manager;
import main.java.com.romkos.order.model.Order;
import main.java.com.romkos.order.service.ManagerService;
import main.java.com.romkos.order.service.OrderService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class EntityRegister {

    private final ManagerService managerService = new ManagerService();
    private final OrderService orderService = new OrderService();

    public void registerManagers() {
        List<Manager> managers = new ArrayList<>();
        String message = "Do you want to register more managers? (Y/N): ";
        do {
            Optional<Manager> manager = addManager();
            manager.ifPresent(managers::add);
        } while(verifyRepeating(message));

        Map<Manager.Location, List<Manager>> managersByLocation = managers.stream()
                .collect(Collectors.groupingBy(Manager::getLocation));

        printManagers(managersByLocation);
    }

    private void printManagers(Map<Manager.Location, List<Manager>> managersByLocation) {
        for (Map.Entry<Manager.Location, List<Manager>> managers : managersByLocation.entrySet()) {
            String content = "\nLocation: " + managers.getKey()
                    + "\nManagers (" + managers.getValue().size() + "):"
                    + "\n\t" + managers.getValue();
            System.out.println(content);
        }
    }

    private Optional<Manager> addManager() {
        Optional<Manager> manager = managerService.registerNewManager();

        manager.ifPresent(this::registerOrders);

        return manager;
    }

    private void registerOrders(Manager manager) {
        String message = "Do you want to add more orders for current manager? (Y/N): ";
        do {
            addOrder(manager);
            System.out.println(manager);
        } while(verifyRepeating(message));
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

    private boolean verifyRepeating(String message) {
        System.out.print(message);
        String answer = Main.SCANNER.nextLine();

        if (answer.toLowerCase().startsWith("y")) {
            return true;
        } else if (answer.toLowerCase().startsWith("n")) {
            return false;
        } else {
            System.out.println("Incorrect answer. Try again.");
            return verifyRepeating(message);
        }
    }
}
