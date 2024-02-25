package main.java.com.romkos.order.service;

import main.java.com.romkos.order.Main;
import main.java.com.romkos.order.model.Manager;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ManagerService {

    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    private static final String NAME_PATTERN = "^[a-zA-Z]+-?[a-zA-Z]+$";

    public Optional<Manager> registerNewManager() {
        Manager manager = null;

        System.out.println("Please sign in.");
        System.out.print("Email: ");
        String email = Main.SCANNER.nextLine();
        if (isEmailNotValid(email)) {
            System.out.println("Invalid email. Application has been stopped.");
            return Optional.ofNullable(manager);
        }
        System.out.print("First name: ");
        String firstName = Main.SCANNER.nextLine();
        if (isNameNotValid(firstName)) {
            System.out.println("Invalid First name. Application has been stopped.");
            return Optional.ofNullable(manager);
        }
        System.out.print("Last name: ");
        String lastName = Main.SCANNER.nextLine();
        if (isNameNotValid(lastName)) {
            System.out.println("Invalid Last name. Application has been stopped.");
            return Optional.ofNullable(manager);
        }
        System.out.print("Location: ");
        Manager.Location location;
        String locationInput = Main.SCANNER.nextLine();
        try {
            location = Manager.Location.valueOf(locationInput);
        } catch (IllegalArgumentException e) {
            location = Manager.Location.UNKNOWN;
            System.out.println("Unable to parse value '" + locationInput
                    + "'. Using default value: " + Manager.Location.UNKNOWN);
        }

        manager = buildManager(email, firstName, lastName, location);

        System.out.println("New manager registered: "
                + manager.getFirstName()
                + " "
                + manager.getLastName()
                + " ("
                + manager.getEmail()
                + ") from "
                + manager.getLocation());

        return Optional.ofNullable(manager);
    }

    private static boolean isEmailNotValid(String email) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return !matcher.matches();
    }

    private static boolean isNameNotValid(String name) {
        Pattern pattern = Pattern.compile(NAME_PATTERN);
        Matcher matcher = pattern.matcher(name);
        return !matcher.matches();
    }

    private static Manager buildManager(String email, String firstName, String lastName,
                                        Manager.Location location) {
        Manager manager = new Manager();
        manager.setEmail(email);
        manager.setFirstName(firstName);
        manager.setLastName(lastName);
        manager.setLocation(location);
        return manager;
    }

}
