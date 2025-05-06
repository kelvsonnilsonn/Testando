package exercises.PaymentSystem;

import exercises.PaymentSystem.Factorys.PSPaymentFactory;
import exercises.PaymentSystem.Interfaces.PSPaymentInterface;

import java.util.Scanner;

public class ECommerceApp {
    private final PSPaymentInterface boletoPayer;
    private final PSPaymentInterface cashPayer;
    private final PSPaymentInterface cardPayer;
    private final PSPaymentInterface pixPayer;

    public ECommerceApp(PSPaymentFactory factory){
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
