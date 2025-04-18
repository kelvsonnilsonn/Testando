package Exercises.PaymentSystem.Services;

import Exercises.PaymentSystem.Interfaces.PaymentInterface;

public class CardPayment implements PaymentInterface {

    @Override
    public void processPayment(double amount){
        System.out.printf("[PAGAMENTO VIA CARTÃO] Valor : R$ %.2f", amount);
    }

}
