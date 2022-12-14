package pz2;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Router[] arr = new Router[7];
        arr[0] = new MobileRouter(10,2.4,2,"black",180,
                100, Protection.WPA3,"D-Link", 1400, "LTE");
        arr[1] = new AdslRouter
                (11, 3.7, 3, "pink", 700, 200,
                        Protection.WPA2,"ASUS",899.99,"telephone");
        arr[2] = new AdslRouter
                (20, 3.5, 3, "green", 750, 100,
                        Protection.WEP, "Tenda",500,"telephone");
        arr[3] = new MobileRouter
                (15, 2.4, 1, "red", 650, 200,
                        Protection.WPA2,"Intel",2499.99,"3G");
        arr[4] = new MobileRouter
                (12, 4.4, 3, "gray", 750, 200,
                        Protection.WPA3,"ASUS",1800,"LTE");
        arr[5] = new EthernetRouter
                (23, 4.9, 1, "blue", 300, 100,
                        Protection.WEP,"D-Link", 2400,"fiber optic",150);
        arr[6] = new EthernetRouter
                (16, 5, 1, "blue", 400, 200,
                        Protection.WPA3,"Intel",2000,"fiber optic");

        System.out.println("\tBeginning array of routers:");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i].toString());
        }
        System.out.println("\tSorting by maxSpeed DESC:");
        Arrays.sort(arr);           //default sorting by maxSpeed DESC
        for (Router a : arr) {
            System.out.println(a);
        }
        System.out.println("\tSorting by numberOfAntennas DESC:");
        Arrays.sort(arr, new SortByNumberOfAntennasDESC());
        for (Router a : arr) {
            System.out.println(a);
        }
        System.out.println("\tSorting by brand ASC:");
        Arrays.sort(arr, new SortByBrandASC());
        for (Router a : arr) {
            System.out.println(a);
        }
        System.out.println("\tSorting by color and weight ASC:");
        Arrays.sort(arr, new SortByColorAndWeightASC());
        for (Router a : arr) {
            System.out.println(a);
        }
        System.out.println("\tSorting by wifiFrequency ASC for ADSL-Router(and child Ethernet router) " +
                "and DESC for others :");
        Arrays.sort(arr, new SortByWifiFrequency());
        for (Router a : arr) {
            System.out.println(a);
        }
        System.out.println("\tSorting by price ASC:");
        Arrays.sort(arr,new SortByPriceASC());
        for (Router a : arr) {
            System.out.println(a);
        }
    }
}


