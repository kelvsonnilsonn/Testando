package SOLIDExercises.WebPaymentSystem.Enums;

public enum PaymentMethod {

    PIX(1, "Pix"),
    CREDIT_CARD(2, "Cartão de Crédito"),
    CASH(4, "Dinheiro");

    private final int code;
    private final String description;

    PaymentMethod(int code, String description){
        this.code = code;
        this.description = description;
    }

    public int getCode(){ return this.code; }
    public String getDescription() { return this.description; }

    public static PaymentMethod searchCode(int code){
        for(PaymentMethod method : values()){
            if(method.code == code){
                return method;
            }
        }
        throw new IllegalArgumentException("Código de pagamento inválido.");
    }

    public static void displayOptions(){
        System.out.println("\nMétodos disponíveis:");
        for(PaymentMethod method : values()){
            System.out.printf("%d - %s\n", method.getCode(), method.getDescription());
        }
    }
}
