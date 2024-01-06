package main.java.com.romkos.order.comonent;

import main.java.com.romkos.order.Main;

public class Authenticator {

    private static final String PASSWORD = "romkos";

    public static boolean auth() {
        boolean accepted = false;
        // Three prompts for entering the password
        for(int i = 0; i < 3; i++) {
            System.out.print("Password: ");
            String input = Main.SCANNER.nextLine();
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
}
