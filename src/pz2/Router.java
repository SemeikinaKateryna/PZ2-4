package pz2;

public abstract class Router implements Comparable<Router> {
    int maxSpeed;
    double wifiFrequency;
    int numberOfAntennas;
    String color;
    int weight;
    public String toString(){
        return "Type: " + this.getClass().getSimpleName() + " maxSpeed: "+maxSpeed +" wifiFrequency: " + wifiFrequency + " numberOfAntennas: " +
                numberOfAntennas+ " color: " + color + " weight: " + weight ;
    }
    public Router(int maxSpeed, double wifiFrequency, int numberOfAntennas,
                  String color, int weight) {
        this.maxSpeed = maxSpeed;
        this.wifiFrequency = wifiFrequency;
        this.numberOfAntennas = numberOfAntennas;
        this.color = color;
        this.weight = weight;
    }
    //default sorting will be happening by this algorithm
    public int compareTo(Router other){
        return this.maxSpeed - other.maxSpeed;
    }

}
