package lesson7;

import lesson7.client.Client;
import lesson7.server.MServer;
import javafx.application.Application;

public class HomeWork {
    public static void main(String[] args) {
        new Thread(() -> new MServer()).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        new Thread(() -> Application.launch(Client.class, args)).start();
    }
}
