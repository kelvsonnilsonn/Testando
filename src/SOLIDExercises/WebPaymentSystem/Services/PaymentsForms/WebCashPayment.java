package SOLIDExercises.WebPaymentSystem.Services.PaymentsForms;

import SOLIDExercises.WebPaymentSystem.Interfaces.WebPaymentInterface;

public class WebCashPayment implements WebPaymentInterface {

    @Override
    public void processPayment(double amount) {
        System.out.println("[CASH] " + amount);
    }

}
