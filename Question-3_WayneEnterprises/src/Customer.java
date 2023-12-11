

import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

public class Customer implements Runnable {
    private final LinkedBlockingQueue<Order> Ordered_queue
;
    private final Random random = new Random();
    public Customer(LinkedBlockingQueue<Order> Ordered_queue
) {
        this.Ordered_queue
 = Ordered_queue
;
    }
    @Override
    public void run() {
        while (true) {
            try {
                int cargoWeight = random.nextInt(41) + 10; // Random cargo between 10 and 50 tonnes
                String destination = random.nextBoolean() ? "Gotham" : "Atlanta";
                Order order = new Order(cargoWeight, destination);
                Ordered_queue.put(order);

                // time between new orders somewhere around 5 seconds is optimal

                Thread.sleep(5000); // Adjust the wait time as needed
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
