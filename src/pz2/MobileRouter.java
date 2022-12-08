package pz2;

public class MobileRouter extends Router{
    String mobileModem;     //покоління зв'язку через інтернет-модем: 3G, 4G, LTE
    public MobileRouter(int maxSpeed, double wifiFrequency, int numberOfAntennas, String color,
                        int weight, String mobileModem) {
        super(maxSpeed, wifiFrequency, numberOfAntennas, color, weight);
        this.mobileModem = mobileModem;
    }
    @Override
    public String toString(){
        return super.toString() + " mobileModem: " + mobileModem;
    }
}
