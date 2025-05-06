package exercises.PaymentSystem.Services;

import exercises.PaymentSystem.Interfaces.PSPaymentInterface;

public class PSBoletoPayment implements PSPaymentInterface {

    @Override
    public void processPayment(double amount){
        System.out.printf("[PAGAMENTO VIA BOLETO] Valor : R$ %.2f", amount);
    }

}
