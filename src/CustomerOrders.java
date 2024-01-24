
public class CustomerOrders implements Runnable {

    private final String size;
    private final Boolean withDesign;
    private final Boolean withHoodie;
    private final String payment;



    public CustomerOrders(String size, Boolean withDesign, Boolean withHoodie, String payment) {


        this.size = size;
        this.withDesign = withDesign;
        this.withHoodie = withHoodie;
        this.payment = payment;
    }



    public String getSize(){
        return size;
    }

    public Boolean getWithDesign(){
        return withDesign;
    }

    public Boolean getWithHoodie() {
        return withHoodie;
    }

    public String getPayment() {
        return payment;
    }

    @Override
    public void run() {

        double eComCost = 14;
        if (withDesign){
            eComCost+=2;
        }
        if (withHoodie){
            eComCost+=3;
        }



            if ("wallet".equals(payment)) {
                WalletPaymentStrategy temp = new WalletPaymentStrategy();
                eComCost += temp.getFee(40.0);
            } else if ("bankcard".equals(payment)) {
                BankCardPaymentStrategy temp = new BankCardPaymentStrategy();
                eComCost += temp.getFee(40.0);

            } else if ("visa".equals(payment)) {
                VisaPaymentStrategy temp = new VisaPaymentStrategy();
                eComCost += temp.getFee(40.0);

            } else if ("mastercard".equals(payment)) {
                MastercardPaymentStrategy temp = new MastercardPaymentStrategy();
                eComCost += temp.getFee(40.0);
            } else {
                OtherPaymentStrategy temp = new OtherPaymentStrategy();
                eComCost += temp.getFee(40.0);

            }

            Main.eCommStore.addToRevenue(40);
            Main.eCommStore.addToProfits(40 - eComCost);
            Main.eCommStore.addToProfitsPerShirtSize(size, 40 - eComCost);




    }
}
