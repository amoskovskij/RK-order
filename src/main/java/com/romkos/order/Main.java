package main.java.com.romkos.order;

import main.java.com.romkos.order.comonent.ApplicationRunner;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static Scanner SCANNER = new Scanner(System.in).useLocale(Locale.ENGLISH);

    public static void main(String[] args) {
        ApplicationRunner runner = new ApplicationRunner();
        runner.run();
    }

}