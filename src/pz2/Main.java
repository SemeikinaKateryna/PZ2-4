package pz2;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Router[] arr = new Router[7];
        arr[0] = new MobileRouter
                (12, 3, 2, "black", 200, "4G");
        arr[1] = new AdslRouter
                (10, 3.7, 3, "pink", 700, "telephone");
        arr[2] = new AdslRouter
                (20, 3.5, 3, "green", 750, "telephone");
        arr[3] = new MobileRouter
                (15, 2.4, 1, "red", 650, "3G");
        arr[4] = new MobileRouter
                (12, 4.4, 3, "gray", 750, "LTE");
        arr[5] = new EthernetRouter
                (23, 4.9, 1, "blue", 300, "fiber optic");
        arr[6] = new EthernetRouter
                (16, 5, 1, "blue", 400, "fiber optic");

        System.out.println("\tBeginning array of routers:");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i].toString());
        }
        System.out.println("\tSorting by maxSpeed ASC:");
        Arrays.sort(arr); //default sorting by maxSpeed
        for (Router a : arr) {
            System.out.println(a);
        }
        System.out.println("\tSorting by numberOfAntennas DESC:");
        Arrays.sort(arr, new SortByNumberOfAntennasDESC());
        for (Router a : arr) {
            System.out.println(a);
        }
        System.out.println("\tSorting by numberOfAntennas ASC:");
        Arrays.sort(arr, new SortByNumberOfAntennasASC());
        for (Router a : arr) {
            System.out.println(a);
        }
        System.out.println("\tSorting by color and weight ASC:");
        Arrays.sort(arr, new SortByColorAndWeightASC());
        for (Router a : arr) {
            System.out.println(a);
        }
        System.out.println("\tSorting by wifiFrequency ASC for ADSL Router(and child Ethernet router)  and DESC for others :");
        Arrays.sort(arr, new SortByWifiFrequency());
        for (Router a : arr) {
            System.out.println(a);
        }
    }
}


