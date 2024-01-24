public class VisaPaymentStrategy implements PaymentStrategy {
    @Override
    public double getFee(Double cost){
        return cost*0.02;
    }
}
