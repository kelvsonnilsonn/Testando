package SOLIDExercises.WebPaymentSystem.Services.PaymentsForms;

import SOLIDExercises.WebPaymentSystem.Interfaces.WebPaymentInterface;

public class WebCardPayment implements WebPaymentInterface {

    @Override
    public void processPayment(double amount) {
        System.out.println("[CARD] " + amount);
    }

}
