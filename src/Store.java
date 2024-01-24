import java.util.HashMap;
import java.util.Map;

public class Store {

    private Double revenue;
    private Double profit;

    Map<String, Double> profitPerShirtSize = new HashMap<>();

    public Store (){
    this.revenue = 0.0;
    this.profit = 0.0;

    }


    public synchronized void addToRevenue(int costPayed) {

        revenue+=costPayed;

    }


    public synchronized void addToProfits(double newProfit) {
        profit+=newProfit;
    }


    public synchronized void addToProfitsPerShirtSize(String size, double newProfit) {


        profitPerShirtSize.put(size, profitPerShirtSize.getOrDefault(size, 0.0) + newProfit);


    }

    public double getProfit() {
        return profit;
    }

    public double getRevenue() {
        return revenue;
    }

    public Map<String, Double> getMap() {
        return profitPerShirtSize;
    }
}
