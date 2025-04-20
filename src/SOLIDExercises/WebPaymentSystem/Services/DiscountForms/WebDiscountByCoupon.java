package SOLIDExercises.WebPaymentSystem.Services.DiscountForms;

import SOLIDExercises.WebPaymentSystem.Constants.WebDiscountRates;
import SOLIDExercises.WebPaymentSystem.Interfaces.WebDiscountInterface;

public class WebDiscountByCoupon implements WebDiscountInterface {

    @Override
    public double discountedValue(double value) {
        return WebDiscountRates.COUPON * value;
    }

}
