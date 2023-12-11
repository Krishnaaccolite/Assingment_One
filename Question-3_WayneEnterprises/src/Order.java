

public class Order {
    private final int cargoWeight;
    private final String destination;
    public Order(int cargoWeight, String destination) {
        this.cargoWeight = cargoWeight;
        this.destination = destination;
    }
    public int getCargoWeight() {
        return cargoWeight;
    }

    @Override
    public String toString() {
        return "Order{" +
                "cargoWeight=" + cargoWeight +
                ", destination='" + destination + '\'' +
                '}';
    }

    public String getDestination() {
        return destination;
    }
}
