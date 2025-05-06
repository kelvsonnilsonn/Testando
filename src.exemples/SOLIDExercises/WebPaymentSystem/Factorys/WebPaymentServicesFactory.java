package SOLIDExercises.WebPaymentSystem.Factorys;

import SOLIDExercises.WebPaymentSystem.Interfaces.WebPaymentInterface;

public interface WebPaymentServicesFactory {

    WebPaymentInterface createPixForm();
    WebPaymentInterface createCardForm();
    WebPaymentInterface createCashForm();

}
