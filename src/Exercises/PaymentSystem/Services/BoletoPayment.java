package Exercises.PaymentSystem.Services;

import Exercises.PaymentSystem.Interfaces.PaymentInterface;

public class BoletoPayment implements PaymentInterface {

    @Override
    public void processPayment(double amount){
        System.out.printf("[PAGAMENTO VIA BOLETO] Valor : R$ %.2f", amount);
    }

}
