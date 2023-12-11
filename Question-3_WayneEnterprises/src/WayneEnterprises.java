import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class WayneEnterprises {
    public static void main(String[] args) {
        LinkedBlockingQueue<Order> Ordered_queue = new LinkedBlockingQueue<>();
        ExecutorService executorService = Executors.newFixedThreadPool(12); // 7 customers + 5 ships
        // Create customer threads
        int i=0;
        while(i<7) {
            executorService.submit(new Customer(Ordered_queue));
            i++;
        }
        i=0;
        // Create ship threads
        while(i<5) {
            executorService.submit(new Ship(Ordered_queue));
            i++;
        }
        executorService.shutdown();    }
}
