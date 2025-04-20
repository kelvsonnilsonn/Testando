package SOLIDExercises.WebPaymentSystem.Services.PaymentsForms;

import SOLIDExercises.WebPaymentSystem.Interfaces.WebPaymentInterface;

public class WebPixPayment implements WebPaymentInterface {

    @Override
    public void processPayment(double amount) {
        System.out.println("[PIX] " + amount);
    }

}
