package main.java.com.romkos.order.comonent;

import main.java.com.romkos.order.Main;
import main.java.com.romkos.order.model.Manager;
import main.java.com.romkos.order.model.Order;
import main.java.com.romkos.order.service.ManagerService;
import main.java.com.romkos.order.service.OrderService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EntityRegister {

    private final ManagerService managerService = new ManagerService();
    private final OrderService orderService = new OrderService();

    public void registerManagers() {
        List<Manager> managers = new ArrayList<>();
        String message = "Do you want to register more managers? (Y/N): ";
        do {
            Manager manager = addManager();
            if (manager != null) {
                managers.add(manager);
            }
        } while(verifyRepeating(message));

        Map<Manager.Location, List<Manager>> managersByLocation = groupManagers(managers);
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

    private Map<Manager.Location, List<Manager>> groupManagers(List<Manager> managers) {
        List<Manager> fromKyiv = new ArrayList<>();
        List<Manager> fromKharkiv = new ArrayList<>();
        List<Manager> fromOdesa = new ArrayList<>();
        for (Manager manager : managers) {
            switch (manager.getLocation()) {
                case KYIV -> fromKyiv.add(manager);
                case KHARKIV -> fromKharkiv.add(manager);
                case ODESA -> fromOdesa.add(manager);
            }
        }
        Map<Manager.Location, List<Manager>> managersByLocation = new HashMap<>();
        managersByLocation.put(Manager.Location.KYIV, fromKyiv);
        managersByLocation.put(Manager.Location.KHARKIV, fromKharkiv);
        managersByLocation.put(Manager.Location.ODESA, fromOdesa);
        return managersByLocation;
    }


    private Manager addManager() {
        Manager manager = managerService.registerNewManager();

        if (manager != null) {
            registerOrders(manager);
            System.out.println(manager);
        }
        return manager;
    }

    private void registerOrders(Manager manager) {
        String message = "Do you want to add more orders for current manager? (Y/N): ";
        do {
            addOrder(manager);
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
