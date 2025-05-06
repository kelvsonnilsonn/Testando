package SOLIDExercises.WebPaymentSystem.Services.DiscountForms;

import SOLIDExercises.WebPaymentSystem.Constants.WebDiscountRates;
import SOLIDExercises.WebPaymentSystem.Interfaces.WebDiscountInterface;

public class WebDiscountByQuantity implements WebDiscountInterface {

    @Override
    public double discountedValue(double value) {
        return WebDiscountRates.QUANTITY * value;
    }

}
