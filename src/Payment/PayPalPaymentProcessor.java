package Payment;

public class PayPalPaymentProcessor implements PaymentProcessor{
    @Override
    public boolean processPayment(double amount) {
        return true;
    }
}
