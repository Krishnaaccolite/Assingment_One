
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Ship implements Runnable {
    private final LinkedBlockingQueue<Order> Ordered_queue
;
    private int totalTrips = 0;
    private static int totalRevenue = 0;
    private int succesiveCanceledOrders = 0;
    private static final int Max_CargoWeight = 300;
    private static final int Min_CargoWeight = 50;
    public Ship(LinkedBlockingQueue<Order> Ordered_queue
) {
        this.Ordered_queue
 = Ordered_queue
;
    }
    @Override
    public void run() {
        try {
            while (totalRevenue < 1000000) {
                Order order = Ordered_queue.poll(1, TimeUnit.MINUTES);
                if (order != null) {
                    int cargoWeight = Math.min(order.getCargoWeight(), Max_CargoWeight);
                    cargoWeight = Math.max(cargoWeight, Min_CargoWeight);
                    if (order.getDestination().equals("Gotham")) {
                        // Process the order (calculate revenue, etc.)
                        int revenue = cargoWeight * 1000;
                        totalRevenue += revenue;
                        totalTrips++;
                        // Simulate ship going back
                        Ordered_queue.put(new Order(cargoWeight, "Atlanta"));
                    } else {
                        // Process the return order
                        Ordered_queue.put(new Order(cargoWeight, "Gotham"));
                    }
                    succesiveCanceledOrders = 0; // Reset consecutive canceled orders
                } else {
                    succesiveCanceledOrders++;
                    if (succesiveCanceledOrders == 3) {
                        // Customer leaves if 3 orders are canceled continuously
                        System.out.println("Customer leaving due to continuous cancellations");
                        break;
                    }
                }
                System.out.println("Shipped Revenue = "+totalRevenue);

                //Maintenance
                if (totalTrips % 5 == 0) {
                    System.out.println("Ship going for maintenance...");
                    Thread.sleep(60000);
                }
            }
            System.out.println("Reached target.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
