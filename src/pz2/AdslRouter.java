package pz2;

public class AdslRouter extends Router{
    String cable ;
    public AdslRouter(int maxSpeed, double wifiFrequency, int numberOfAntennas,
                      String color, int weight,  String cable) {
        super(maxSpeed, wifiFrequency, numberOfAntennas, color, weight);
        this.cable = cable;
    }
    @Override
    public String toString(){
        return super.toString() + " cable: " + cable;
    }

}
