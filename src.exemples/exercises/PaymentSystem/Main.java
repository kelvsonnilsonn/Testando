package exercises.PaymentSystem;

import exercises.PaymentSystem.Factorys.DefaultPaymentFactory;
import exercises.PaymentSystem.Factorys.PSPaymentFactory;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PSPaymentFactory factory = new DefaultPaymentFactory();
        ECommerceApp app = new ECommerceApp(factory);

        Scanner scan = new Scanner(System.in);
        app.run(scan);
    }
}
