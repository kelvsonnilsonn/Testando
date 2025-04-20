package Exercises.PaymentSystem.Factorys;

import Exercises.PaymentSystem.Interfaces.PSPaymentInterface;
import Exercises.PaymentSystem.Services.PSBoletoPayment;
import Exercises.PaymentSystem.Services.PSCardPayment;
import Exercises.PaymentSystem.Services.PSCashPayment;
import Exercises.PaymentSystem.Services.PSPixPayment;

public class DefaultPaymentFactory implements PSPaymentFactory {

    @Override
    public PSPaymentInterface createBoletoPayment(){
        return new PSBoletoPayment();
    }

    @Override
    public PSPaymentInterface createPixPayment(){
        return new PSPixPayment();
    }

    @Override
    public PSPaymentInterface createCashPayment(){
        return new PSCashPayment();
    }

    @Override
    public PSPaymentInterface createCardPayment(){
        return new PSCardPayment();
    }

}
