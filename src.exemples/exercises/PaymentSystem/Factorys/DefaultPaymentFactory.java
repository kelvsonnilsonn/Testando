package exercises.PaymentSystem.Factorys;

import exercises.PaymentSystem.Interfaces.PSPaymentInterface;
import exercises.PaymentSystem.Services.PSBoletoPayment;
import exercises.PaymentSystem.Services.PSCardPayment;
import exercises.PaymentSystem.Services.PSCashPayment;
import exercises.PaymentSystem.Services.PSPixPayment;

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
