package SOLIDExercises.WebPaymentSystem;

import SOLIDExercises.WebPaymentSystem.Factorys.WebDiscountServicesFactory;
import SOLIDExercises.WebPaymentSystem.Factorys.WebPaymentServicesFactory;

import SOLIDExercises.WebPaymentSystem.Interfaces.WebDiscountInterface;
import SOLIDExercises.WebPaymentSystem.Interfaces.WebPaymentInterface;
import SOLIDExercises.WebPaymentSystem.Model.Request;

import java.util.Scanner;

public class WebApplication {
    private final WebDiscountInterface couponDiscounter;
    private final WebDiscountInterface quantityDiscounter;
    private final WebDiscountInterface vipDiscounter;

    private final WebPaymentInterface cardForm;
    private final WebPaymentInterface cashForm;
    private final WebPaymentInterface pixForm;

    private final Scanner scan;

    public WebApplication(WebDiscountServicesFactory discounterFactory, WebPaymentServicesFactory paymentFactory, Scanner scan){
        this.couponDiscounter = discounterFactory.createCouponDiscounter();
        this.quantityDiscounter = discounterFactory.createQuantityDiscounter();
        this.vipDiscounter = discounterFactory.createVIPClientDiscounter();

        this.cardForm = paymentFactory.createCardForm();
        this.cashForm = paymentFactory.createCashForm();
        this.pixForm = paymentFactory.createPixForm();

        this.scan = scan;
    }

    public void run(Request request) {

        setDiscount(request);
        paymentForm(request.getRequestValue());

    }

    private void paymentForm(double value){
        System.out.println("Digite a forma de pagament [1, 2, 3] : "); // não precisa de mais texto. Só funcionalidade por hora.
        int option = scan.nextInt();
        switch(option){
            case 1 :
                cardForm.processPayment(value);
                break;
            case 2 :
                cashForm.processPayment(value);
                break;
            case 3 :
                pixForm.processPayment(value);
                break;
            default:
                break;
        }
    }

    private void setDiscount(Request request){
        while(true){
            System.out.println("Se tem desconto, escolha para aplicar [1, 2, 3]: "); // mais textos é desnecessário por hora. Vamos focar na funcionalidade.
            int option = scan.nextInt();
            switch(option){
                case 1 :
                    request.setRequestValue(couponDiscounter.discountedValue(request.getRequestValue()));
                    break;
                case 2 :
                    request.setRequestValue(quantityDiscounter.discountedValue(request.getRequestValue()));
                    break;
                case 3 :
                    request.setRequestValue(vipDiscounter.discountedValue(request.getRequestValue()));
                    break;
                default :
                    break;
            }
            System.out.println("Valor total com desconto : " + request.getRequestValue());
            if(option == 0) break;
        }
    }
}
