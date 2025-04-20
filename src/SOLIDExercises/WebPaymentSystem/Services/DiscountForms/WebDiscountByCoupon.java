package SOLIDExercises.WebPaymentSystem.Services.DiscountForms;

import SOLIDExercises.WebPaymentSystem.Interfaces.WebDiscountInterface;

public class WebDiscountByCoupon implements WebDiscountInterface {

    private static final double COUPON_DISCOUNT = 0.9;

    @Override
    public double discountedValue(double value) {
        return COUPON_DISCOUNT * value;
    }

}
