package SOLIDExercises.WebPaymentSystem;

import SOLIDExercises.WebPaymentSystem.Enums.PaymentMethod;
import SOLIDExercises.WebPaymentSystem.Factorys.WebDiscountServicesFactory;
import SOLIDExercises.WebPaymentSystem.Factorys.WebPaymentServicesFactory;

import SOLIDExercises.WebPaymentSystem.Interfaces.WebDiscountInterface;
import SOLIDExercises.WebPaymentSystem.Interfaces.WebPaymentInterface;
import SOLIDExercises.WebPaymentSystem.Model.Request;

import java.util.Map;
import java.util.Scanner;

public class WebApplication {
    private final WebDiscountInterface couponDiscounter;
    private final WebDiscountInterface quantityDiscounter;
    private final WebDiscountInterface vipDiscounter;

    private final Map<PaymentMethod, WebPaymentInterface> paymentMethods;

    private final Scanner scan;

    public WebApplication(WebDiscountServicesFactory discounterFactory, WebPaymentServicesFactory paymentFactory, Scanner scan){
        this.couponDiscounter = discounterFactory.createCouponDiscounter();
        this.quantityDiscounter = discounterFactory.createQuantityDiscounter();
        this.vipDiscounter = discounterFactory.createVIPClientDiscounter();

        this.paymentMethods = Map.of(
                PaymentMethod.PIX, paymentFactory.createPixForm(),
                PaymentMethod.CASH, paymentFactory.createCashForm(),
                PaymentMethod.CREDIT_CARD, paymentFactory.createCardForm()
        );

        this.scan = scan;
    }

    public void run(Request request) {

        applyDiscounts(request);
        processPayment(request.getRequestValue());

    }

    private void processPayment(double value){

        boolean paymentProcessed = false;

        while(!paymentProcessed){

            PaymentMethod.displayOptions();
            System.out.println("Digite o código do método de pagamento: ");

            try{
                int option = scan.nextInt();
                PaymentMethod method = PaymentMethod.searchCode(option);

                WebPaymentInterface paymentProcessor = paymentMethods.get(method);
                if(paymentProcessor != null){
                    paymentProcessor.processPayment(value);
                    paymentProcessed = true;
                } else {
                    System.out.println("Método inválido.");
                }
            } catch(IllegalArgumentException e){
                System.out.println("ERRO: " + e.getMessage());
                scan.nextLine();
            }
        }
    }

    private void applyDiscounts(Request request) {
        boolean applyingDiscounts = true;

        while (applyingDiscounts) {
            System.out.println("\nValor atual: " + request.getRequestValue());
            System.out.println("Opções de desconto:");
            System.out.println("1 - Cupom (10%)");
            System.out.println("2 - Quantidade (15%)");
            System.out.println("3 - Cliente VIP (20%)");
            System.out.println("0 - Finalizar descontos");
            System.out.print("Escolha uma opção: ");

            int option = scan.nextInt();

            switch (option) {
                case 1:
                    request.setRequestValue(couponDiscounter.discountedValue(request.getRequestValue()));
                    break;
                case 2:
                    request.setRequestValue(quantityDiscounter.discountedValue(request.getRequestValue()));
                    break;
                case 3:
                    request.setRequestValue(vipDiscounter.discountedValue(request.getRequestValue()));
                    break;
                case 0:
                    applyingDiscounts = false;
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
