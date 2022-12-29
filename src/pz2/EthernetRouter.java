package pz2;

import pz4.TypesOfRouters;

public class EthernetRouter extends AdslRouter{
    int minSpeed = 100;
    public EthernetRouter(int RouterID, int type, int maxSpeed, double wifiFrequency, int numberOfAntennas, String color, int weight,
            int power, Protection protection, String brand, double price, String cable, int minSpeed) {
        super(RouterID, type, maxSpeed, wifiFrequency, numberOfAntennas, color, weight, power, protection, brand, price, cable);
        this.minSpeed = minSpeed;
    }
    public EthernetRouter(int RouterID, int type, int maxSpeed, double wifiFrequency, int numberOfAntennas, String color, int weight,
                          int power, Protection protection, String brand, double price, String cable) {
        super(RouterID, type, maxSpeed, wifiFrequency, numberOfAntennas, color, weight, power, protection, brand, price, cable);
    }
}
