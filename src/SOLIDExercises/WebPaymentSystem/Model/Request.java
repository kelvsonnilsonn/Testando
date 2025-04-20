package SOLIDExercises.WebPaymentSystem.Model;

public class Request {
    private String name;
    private double value;
    private int qtd;

    public Request(String name, double value, int qtd){
        this.name = name;
        this.value = value;
        this.qtd = qtd;
    }

    public String getRequestName() { return this.name; }
    public double getRequestValue() { return this.value; }
    public int getRequestQtd() { return this.qtd; }

    public void setRequestName(String name) { this.name = name; }
    public void setRequestQtd(int qtd) { this.qtd = qtd; }
    public void setRequestValue(double value) { this.value = value; }
}
