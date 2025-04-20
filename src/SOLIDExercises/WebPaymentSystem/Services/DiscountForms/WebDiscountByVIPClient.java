package SOLIDExercises.WebPaymentSystem.Services.DiscountForms;

import SOLIDExercises.WebPaymentSystem.Interfaces.WebDiscountInterface;

public class WebDiscountByVIPClient implements WebDiscountInterface {

    private static final double COUPON_DISCOUNT = 0.8;

    @Override
    public double discountedValue(double value) {
        return COUPON_DISCOUNT * value;
    }
    
}
