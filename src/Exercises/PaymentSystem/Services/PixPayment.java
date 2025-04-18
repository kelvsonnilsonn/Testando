package Exercises.PaymentSystem.Services;

import Exercises.PaymentSystem.Interfaces.PaymentInterface;

public class PixPayment implements PaymentInterface {

    @Override
    public void processPayment(double amount){
        System.out.printf("[PAGAMENTO VIA PIX] Valor : R$ %.2f", amount);
    }

}
