package SOLIDExercises.WebPaymentSystem.Factorys;

import SOLIDExercises.WebPaymentSystem.Interfaces.WebPaymentInterface;

import SOLIDExercises.WebPaymentSystem.Services.PaymentsForms.WebCardPayment;
import SOLIDExercises.WebPaymentSystem.Services.PaymentsForms.WebCashPayment;
import SOLIDExercises.WebPaymentSystem.Services.PaymentsForms.WebPixPayment;

public class DefaultPaymentServicesFactory implements WebPaymentServicesFactory {

    @Override
    public WebPaymentInterface createPixForm() {
        return new WebPixPayment();
    }

    @Override
    public WebPaymentInterface createCardForm() {
        return new WebCardPayment();
    }

    @Override
    public WebPaymentInterface createCashForm() {
        return new WebCashPayment();
    }

}
