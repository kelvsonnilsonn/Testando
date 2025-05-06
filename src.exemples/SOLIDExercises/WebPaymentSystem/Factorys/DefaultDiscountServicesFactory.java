package SOLIDExercises.WebPaymentSystem.Factorys;

import SOLIDExercises.WebPaymentSystem.Interfaces.WebDiscountInterface;
import SOLIDExercises.WebPaymentSystem.Services.DiscountForms.WebDiscountByCoupon;
import SOLIDExercises.WebPaymentSystem.Services.DiscountForms.WebDiscountByQuantity;
import SOLIDExercises.WebPaymentSystem.Services.DiscountForms.WebDiscountByVIPClient;

public class DefaultDiscountServicesFactory implements WebDiscountServicesFactory {

    @Override
    public WebDiscountInterface createCouponDiscounter() { return new WebDiscountByCoupon(); }

    @Override
    public WebDiscountInterface createQuantityDiscounter() { return new WebDiscountByQuantity(); }

    @Override
    public WebDiscountInterface createVIPClientDiscounter() { return new WebDiscountByVIPClient(); }
}
