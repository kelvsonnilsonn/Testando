package Exercises.PaymentSystem.Factorys;

import Exercises.PaymentSystem.Interfaces.PSPaymentInterface;

public interface PSPaymentFactory {
    PSPaymentInterface createBoletoPayment();
    PSPaymentInterface createPixPayment();
    PSPaymentInterface createCardPayment();
    PSPaymentInterface createCashPayment();
}
