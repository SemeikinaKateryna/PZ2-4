package pz2;

public class EthernetRouter extends AdslRouter{
    int minSpeed = 100;
    public EthernetRouter(int maxSpeed, double wifiFrequency, int numberOfAntennas, String color, int weight,
            int power, Protection protection, String brand, double price, String cable, int minSpeed) {
        super(maxSpeed, wifiFrequency, numberOfAntennas, color, weight, power, protection, brand, price, cable);
        this.minSpeed = minSpeed;
    }
    public EthernetRouter(int maxSpeed, double wifiFrequency, int numberOfAntennas, String color, int weight,
                          int power, Protection protection, String brand, double price, String cable) {
        super(maxSpeed, wifiFrequency, numberOfAntennas, color, weight, power, protection, brand, price, cable);
    }
}
