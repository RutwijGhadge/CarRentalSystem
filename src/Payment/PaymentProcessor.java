package Payment;

public class PaymentProcessor {
    private PaymentStrategy paymentStrategy;

    public PaymentProcessor(PaymentStrategy paymentStrategy){
        this.paymentStrategy=paymentStrategy;
    }

    public boolean processPayment(double amount){
        paymentStrategy.pay(amount);
        return true;
    }
}
