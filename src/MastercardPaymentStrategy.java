public class MastercardPaymentStrategy implements PaymentStrategy{

    @Override
    public double getFee(Double cost){
        return cost*0.03;
    }
}
