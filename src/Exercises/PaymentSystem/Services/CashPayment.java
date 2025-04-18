package Exercises.PaymentSystem.Services;

import Exercises.PaymentSystem.Interfaces.PaymentInterface;

public class CashPayment implements PaymentInterface {

    @Override
    public void processPayment(double amount){
        System.out.printf("[PAGAMENTO VIA DINHEIRO] Valor : R$ %.2f", amount);
    }

}
