package main.java.com.romkos;

import java.util.Scanner;

public class Main {

    static String PASSWORD = "romkos";
    static Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        run();
    }

    static void run() {
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
    }
}