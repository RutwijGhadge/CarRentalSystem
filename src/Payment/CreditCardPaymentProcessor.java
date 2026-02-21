package Payment;

public class CreditCardPaymentProcessor implements PaymentProcessor{
    @Override
    public boolean processPayment(double amount) {
        return true;
    }
}
