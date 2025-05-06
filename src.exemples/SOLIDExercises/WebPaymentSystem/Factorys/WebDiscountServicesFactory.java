package SOLIDExercises.WebPaymentSystem.Factorys;

import SOLIDExercises.WebPaymentSystem.Interfaces.WebDiscountInterface;

public interface WebDiscountServicesFactory {

    WebDiscountInterface createCouponDiscounter();
    WebDiscountInterface createQuantityDiscounter();
    WebDiscountInterface createVIPClientDiscounter();

}
