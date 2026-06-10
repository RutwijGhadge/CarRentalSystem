package Payment;

public class PayPalPaymentProcessor implements PaymentStrategy {

    @Override
    public void pay(double amount) {
        System.out.println("Paid "+amount+" with the PayPal Payment Processor");
    }
}
