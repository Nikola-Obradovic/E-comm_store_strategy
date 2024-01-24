public class OtherPaymentStrategy implements PaymentStrategy {

    @Override
    public double getFee(Double cost){
        return cost*0.1;
    }
}
