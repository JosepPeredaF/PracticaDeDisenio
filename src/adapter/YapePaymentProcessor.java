package adapter;

public class YapePaymentProcessor implements PaymentProcessor{
    private String phoneNumber;

    public YapePaymentProcessor(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.printf("Pago realizado por Yape del numero: "+phoneNumber + "por: "+amount);
    }
}
