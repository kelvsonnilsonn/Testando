package Exercises.PaymentSystem.Factorys;

import Exercises.PaymentSystem.Interfaces.PaymentInterface;
import Exercises.PaymentSystem.Services.BoletoPayment;
import Exercises.PaymentSystem.Services.CardPayment;
import Exercises.PaymentSystem.Services.CashPayment;
import Exercises.PaymentSystem.Services.PixPayment;

public class DefaultPaymentFactory implements PaymentFactory {

    @Override
    public PaymentInterface createBoletoPayment(){
        return new BoletoPayment();
    }

    @Override
    public PaymentInterface createPixPayment(){
        return new PixPayment();
    }

    @Override
    public PaymentInterface createCashPayment(){
        return new CashPayment();
    }

    @Override
    public PaymentInterface createCardPayment(){
        return new CardPayment();
    }

}
