package Exercises.PaymentSystem;

import Exercises.PaymentSystem.Factorys.DefaultPaymentFactory;
import Exercises.PaymentSystem.Factorys.PSPaymentFactory;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PSPaymentFactory factory = new DefaultPaymentFactory();
        ECommerceApp app = new ECommerceApp(factory);

        Scanner scan = new Scanner(System.in);
        app.run(scan);
    }
}
