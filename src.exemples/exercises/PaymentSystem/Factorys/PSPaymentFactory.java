package exercises.PaymentSystem.Factorys;

import exercises.PaymentSystem.Interfaces.PSPaymentInterface;

public interface PSPaymentFactory {
    PSPaymentInterface createBoletoPayment();
    PSPaymentInterface createPixPayment();
    PSPaymentInterface createCardPayment();
    PSPaymentInterface createCashPayment();
}
