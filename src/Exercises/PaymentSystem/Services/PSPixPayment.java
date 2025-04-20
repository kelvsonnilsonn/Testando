package Exercises.PaymentSystem.Services;

import Exercises.PaymentSystem.Interfaces.PSPaymentInterface;

public class PSPixPayment implements PSPaymentInterface {

    @Override
    public void processPayment(double amount){
        System.out.printf("[PAGAMENTO VIA PIX] Valor : R$ %.2f", amount);
    }

}
