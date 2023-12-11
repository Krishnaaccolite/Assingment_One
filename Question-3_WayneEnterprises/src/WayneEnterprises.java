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
        for (int i = 0; i < 7; i++) {
            executorService.submit(new Customer(Ordered_queue
));
        }
        // Create ship threads
        for (int i = 0; i < 5; i++) {
            executorService.submit(new Ship(Ordered_queue
));
        }
        executorService.shutdown();
    }
}