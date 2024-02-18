package main.java.com.romkos.order.comonent;

public class ApplicationRunner {

private final EntityRegister register = new EntityRegister();

    public void run() {
        if (Authenticator.auth()) {
            register.registerManagers();
        }
    }
}
