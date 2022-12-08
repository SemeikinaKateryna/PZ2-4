package pz3;

import pz2.AdslRouter;
import pz2.EthernetRouter;
import pz2.MobileRouter;
import pz2.Router;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        MyList<Router> list = new MyList<>();
        MobileRouter e1 =  new MobileRouter
                (12, 3, 2, "black", 200, "4G");
        AdslRouter e3 =  new AdslRouter
                (12, 3, 2, "black", 200, "fiber-optic");
        EthernetRouter e2 = new EthernetRouter
                (23, 4.9, 1, "blue", 300, "fiber optic");
        MobileRouter e4 = new MobileRouter
                (15, 2.4, 1, "red", 650, "3G");
        MobileRouter e5 = new MobileRouter
                (17, 3.1, 2, "white", 260, "4G");

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
