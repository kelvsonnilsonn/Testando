package SOLIDExercises.WebPaymentSystem;

import SOLIDExercises.WebPaymentSystem.Factorys.DefaultDiscountServicesFactory;
import SOLIDExercises.WebPaymentSystem.Factorys.DefaultPaymentServicesFactory;
import SOLIDExercises.WebPaymentSystem.Factorys.WebDiscountServicesFactory;
import SOLIDExercises.WebPaymentSystem.Factorys.WebPaymentServicesFactory;
import SOLIDExercises.WebPaymentSystem.Model.Request;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        WebPaymentServicesFactory paymentFactory = new DefaultPaymentServicesFactory();
        WebDiscountServicesFactory discountFactory = new DefaultDiscountServicesFactory();
        Scanner scan = new Scanner(System.in);
        WebApplication app = new WebApplication(discountFactory, paymentFactory, scan);
        app.run(new Request("Panela", 135.20, 1)); // Criar método para definir novos objetos. Simples.
    }
}
