package Exercises.PaymentSystem;

import Exercises.PaymentSystem.Factorys.PaymentFactory;
import Exercises.PaymentSystem.Interfaces.PaymentInterface;

import java.util.Scanner;

public class ECommerceApp {
    private final PaymentInterface boletoPayer;
    private final PaymentInterface cashPayer;
    private final PaymentInterface cardPayer;
    private final PaymentInterface pixPayer;

    public ECommerceApp(PaymentFactory factory){
        this.boletoPayer = factory.createBoletoPayment();
        this.cashPayer = factory.createCashPayment();
        this.cardPayer = factory.createCardPayment();
        this.pixPayer = factory.createPixPayment();
    }

    public void run(Scanner scan){

        int option = scan.nextInt();

        switch (option){
            case 1 :
                cardPayer.processPayment(200);
                break;

            case 2 :
                pixPayer.processPayment(200);
                break;

            case 3 :
                boletoPayer.processPayment(200);
                break;

            case 4 :
                cashPayer.processPayment(200);
                break;

            default:
                break;
        }
    }
}
