import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;




public class Main {

    public static Store eCommStore = new Store();
    public static void main(String[] args) throws FileNotFoundException {



ArrayList<CustomerOrders> customerOrders = new ArrayList<>();

Scanner s = new Scanner(new File("src/customer_orders.csv"));

try{
    if (s.hasNextLine()){
        s.nextLine();
    }
    while(s.hasNextLine()){

        try{

        String line = s.nextLine();
        String[] lineParts = line.split(",");
        String size = lineParts[1].strip();
        Boolean withDesign = Boolean.parseBoolean(lineParts[2].strip());
        Boolean withHoodie = Boolean.parseBoolean(lineParts[3].strip());
        String payment = lineParts[4].strip();


        customerOrders.add(new CustomerOrders(size, withDesign, withHoodie, payment));

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }


    s.close();
    }catch(Exception e){
    System.out.println(e.getMessage());
    }




        ArrayList<Thread> threads = new ArrayList<>();
        for(CustomerOrders customer : customerOrders) {
            threads.add(new Thread(customer));
        }

        for(Thread t : threads) {
            t.start();
        }

        for(Thread t : threads) {
            try {
                t.join();
            }catch (Exception e){
                System.out.println(e.getMessage());
            }

        }


        try {
            FileWriter fw = new FileWriter("Total Revenue.txt");
            fw.write("Total Revenue: " + eCommStore.getRevenue());
            fw.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            FileWriter fw = new FileWriter("Total Profits.txt");
            fw.write("Total Profits: " + eCommStore.getProfit());
            fw.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            FileWriter fw = new FileWriter("Profits Per Shirt Size.txt");
            fw.write("Size - Profits\n");
            for (Map.Entry<String, Double> entry : eCommStore.getMap().entrySet()){
                fw.write(entry.getKey()+ " - "+ entry.getValue()+ "\n");

            }

            fw.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}