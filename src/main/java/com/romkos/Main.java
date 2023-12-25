package main.java.com.romkos;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    static String PASSWORD = "romkos";
    static Scanner SCANNER = new Scanner(System.in);
    static String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    static String NAME_PATTERN = "^[a-zA-Z]+-[a-zA-Z]+$";

    public static void main(String[] args) {
        run();
    }

    static void run() {
        if (auth()) {
            registerNewClient();
        }
    }

    static boolean auth() {
        boolean accepted = false;
        // Three prompts for entering the password
        for(int i = 0; i < 3; i++) {
            System.out.print("Password: ");
            String input = SCANNER.nextLine();
            if (PASSWORD.equals(input)) {
                accepted = true;
                break;
            } else {
                System.out.println("Wrong password. Try again.");
            }
        }
        System.out.println(
                accepted ?
                        "Welcome to RK-order!" :
                        "Wrong password. Application has been stopped."
        );
        return accepted;
    }

    static void registerNewClient() {
        System.out.println("Please sign in.");
        System.out.print("Email: ");
        String email = SCANNER.nextLine();
        if (isEmailNotValid(email)) {
            System.out.println("Invalid email. Application has been stopped.");
            return;
        }
        System.out.print("First name: ");
        String firstName = SCANNER.nextLine();
        if (isNameNotValid(firstName)) {
            System.out.println("Invalid First name. Application has been stopped.");
            return;
        }
        System.out.print("Last name: ");
        String lastName = SCANNER.nextLine();
        if (isNameNotValid(lastName)) {
            System.out.println("Invalid Last name. Application has been stopped.");
            return;
        }
        Client client = buildClient(email, firstName, lastName);
        System.out.println("New client registered: "
                + client.firstName
                + " "
                + client.lastName
                + " ("
                + client.email
                + ")");
    }

    static boolean isEmailNotValid(String email) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return !matcher.matches();
    }

    static boolean isNameNotValid(String name) {
        Pattern pattern = Pattern.compile(NAME_PATTERN);
        Matcher matcher = pattern.matcher(name);
        return !matcher.matches();
    }

    static Client buildClient(String email, String firstName, String lastName) {
        Client client = new Client();
        client.email = email;
        client.firstName = firstName;
        client.lastName = lastName;
        return client;
    }

}