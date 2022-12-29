package pz2;

public class Router implements Comparable<Router> {
    int RouterID;
    int typeOfRouterID;
    int maxSpeed;
    double wifiFrequency;
    int numberOfAntennas;
    String color;
    int weight;
    int power;
    Protection protection;
    String brand;
    double price;
    public String toString(){
        return  "ID: " + RouterID + " Type: " + typeOfRouterID + " maxSpeed: "+maxSpeed
                +" wifiFrequency: " + wifiFrequency + " numberOfAntennas: " + numberOfAntennas
                + " color: " + color + " weight: " + weight  + " power: " + power
                + " protection: " + protection + " brand: " + brand  + " price: " + price;
    }
    public Router(int RouterID, int type, int maxSpeed, double wifiFrequency, int numberOfAntennas, String color,
                  int weight, int power, Protection protection, String brand, double price) {
        this.RouterID = RouterID;
        this.typeOfRouterID = type;
        this.maxSpeed = maxSpeed;
        this.wifiFrequency = wifiFrequency;
        this.numberOfAntennas = numberOfAntennas;
        this.color = color;
        this.weight = weight;
        this.power = power;
        this.protection = protection;
        this.brand = brand;
        this.price = price;
    }
    //default sorting will be happening by this algorithm
    public int compareTo(Router other){
        return other.maxSpeed - this.maxSpeed;
    }

}
