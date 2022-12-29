package pz3;

import pz2.*;
import pz4.TypesOfRouters;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        MyList<Router> list = new MyList<>();
        MobileRouter e1 = new MobileRouter(1,3,10,2.4,2,"black",180,
                100, Protection.WPA3,"D-Link", 1400, "LTE");
        AdslRouter e2 = new AdslRouter
                (2,1,11, 3.7, 3, "pink", 700, 200,
                        Protection.WPA2,"ASUS",899.99,"telephone");
        MobileRouter e3 = new MobileRouter
                (3,3,15, 2.4, 1, "red", 650, 200,
                        Protection.WPA2,"Intel",2499.99,"3G");
        MobileRouter e4 = new MobileRouter
                (4,2,12, 4.4, 3, "gray", 750, 200,
                        Protection.WPA3,"ASUS",1800,"LTE");
        EthernetRouter e5 = new EthernetRouter
                (5,2,23, 4.9, 1, "blue", 300, 100,
                        Protection.WEP,"D-Link", 2400,"fiber optic",150);

        list.addFirst(e1);
        list.add(e2,1);
        list.addLast(e3);
        Iterator<Router> it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        list.add(e4,0);
        list.add(e5,5);
        list.remove(e2);
        System.out.println(list.contains(e4));
        System.out.println(list + "\nSize: " + list.size() + "\nHead " + list.getHead()
                + "\nTail " + list.getTail());

        Object[]array =  list.toArray();
        for (Object temp: array) {
            System.out.println(temp);
        }

        list.clear();
        for (Object o : list) {
            System.out.println(o);
        }
    }
}
