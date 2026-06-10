package Payment;

public class DebitCardPaymentProcessor implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Paid "+amount+" with the Debit Card.");
    }
}
