package Exercises.PaymentSystem.Services;

import Exercises.PaymentSystem.Interfaces.PSPaymentInterface;

public class PSCashPayment implements PSPaymentInterface {

    @Override
    public void processPayment(double amount){
        System.out.printf("[PAGAMENTO VIA DINHEIRO] Valor : R$ %.2f", amount);
    }

}
