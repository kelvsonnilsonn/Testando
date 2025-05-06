package exercises.PaymentSystem.Services;

import exercises.PaymentSystem.Interfaces.PSPaymentInterface;

public class PSCardPayment implements PSPaymentInterface {

    @Override
    public void processPayment(double amount){
        System.out.printf("[PAGAMENTO VIA CARTÃO] Valor : R$ %.2f", amount);
    }

}
