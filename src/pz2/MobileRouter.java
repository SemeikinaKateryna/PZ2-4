package pz2;

import pz4.TypesOfRouters;

public class MobileRouter extends Router{
    String mobileModem;     //покоління зв'язку через інтернет-модем: 3G, 4G, LTE
    public MobileRouter(int RouterID, int type, int maxSpeed, double wifiFrequency, int numberOfAntennas, String color,
                        int weight, int power, Protection protection, String brand, double price, String mobileModem) {
        super(RouterID, type, maxSpeed, wifiFrequency, numberOfAntennas, color, weight, power, protection, brand, price);
        this.mobileModem = mobileModem;
    }
    @Override
    public String toString(){
        return super.toString() + " mobileModem: " + mobileModem;
    }
}
