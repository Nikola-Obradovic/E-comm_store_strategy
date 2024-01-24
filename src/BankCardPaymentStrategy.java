public class BankCardPaymentStrategy implements PaymentStrategy {

    @Override
    public double getFee(Double cost){
        return cost*0.05;
    }
}
