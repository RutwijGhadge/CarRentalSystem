package Payment;

public class CreditCardPaymentProcessor implements PaymentStrategy {

    @Override
    public void pay(double amount) {
        System.out.println("Paid "+amount+" with CreditCard");
    }
}
