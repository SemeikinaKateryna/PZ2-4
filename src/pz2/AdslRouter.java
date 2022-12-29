package pz2;

import pz4.TypesOfRouters;

public class AdslRouter extends Router{
    String cable;    //ТСОП, ТфОП - telephoneNetwork
    public AdslRouter(int RouterID, int type, int maxSpeed, double wifiFrequency, int numberOfAntennas, String color, int weight,
                      int power, Protection protection, String brand, double price, String cable) {
        super(RouterID, type, maxSpeed, wifiFrequency, numberOfAntennas, color, weight, power, protection, brand, price);
        this.cable = cable;
    }
    @Override
    public String toString(){
        return super.toString() + " cable: " + cable;
    }

}
