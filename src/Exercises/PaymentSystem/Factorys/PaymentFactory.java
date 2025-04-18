package Exercises.PaymentSystem.Factorys;

import Exercises.PaymentSystem.Interfaces.PaymentInterface;

public interface PaymentFactory {
    PaymentInterface createBoletoPayment();
    PaymentInterface createPixPayment();
    PaymentInterface createCardPayment();
    PaymentInterface createCashPayment();
}
